package com.flower.chatServer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChatMainServer extends JFrame implements ActionListener, KeyListener {

	private JPanel jp1; // ���� �г�
	private JPanel jp2; // ������ �г�

	private JTextArea jtaMain; // ���� ä��â
	private JTextArea jtaWait; // ����� ���

	private JLabel jlWait; // '����� ���' �� ǥ���ϴ� ��
	private JTextField jtf; // �޼��� �Է�â
	private JScrollPane jsp; // ��ũ�� �г�

	private JButton jbtnExit; // �����ư
	private JButton jbtnSend; // ���۹�ư
	private JButton jbtnStart; // ���۹�ư

	private ServerSocket ss; // ���� ����
	private PrintWriter pw; // �۽Ű�ü

	private HashMap<String, ChatThreadServer> clientMap; // ip�� key��, ChatThreadServer��
													// ���������� value�� ������ HashMap
	private LinkedList<String> waiterList; // queue �ڷ� ������ ������ LinkedList ��ü
	private ChatThreadServer targetClient; // ChatThreadServer�� ��������
	private String ip;

	public ChatMainServer() {
		super("ä�ü���"); // ���� â �̸�
		setLayout(null); // ���̾ƿ��� null
		setBounds(200, 200, 700, 700); // â ������ ����

		jp1 = new JPanel(); // ���� �г� �ν��Ͻ�
		jp2 = new JPanel(); // ������ �г� �ν��Ͻ�
		// panel

		jtaMain = new JTextArea(); // ���� ä��â �ν��Ͻ�
		jsp = new JScrollPane(jtaMain, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // ���� ä��â�� ��ũ�ѹٿ� ����
		jtf = new JTextField(); // �޼��� â �ν��Ͻ�
		jbtnSend = new JButton("����"); // ���۹�ư �ν��Ͻ�
		// panel 1 components

		jlWait = new JLabel("����� ���", 0); // ��� ����
		jtaWait = new JTextArea(); // ����� ��� �ν��Ͻ�
		jtaWait.setEditable(false); // ����� ����� ǥ�ø��� �ϱ� ���ؼ� ������� ����
		jbtnExit = new JButton("����"); // �����ư �ν��Ͻ�
		jbtnStart = new JButton("����"); // ���۹�ư �ν��Ͻ�
		// panel 2 components

		clientMap = new HashMap<String, ChatThreadServer>(); // Map �ν��Ͻ�
		waiterList = new LinkedList<String>(); // LinkedList �ν��Ͻ�
		createP1(); // p1�� ui�� �����ϴ� �޼���
		createP2(); // p2�� ui�� �����ϴ� �޼���

		setDefaultCloseOperation(EXIT_ON_CLOSE); // xŰ ������ ����
		setVisible(true);
		startServer(); // ������ ȣ��� ���ÿ� startServer �޼��� ȣ��
	} // constructor ends

	private void createP1() {
		// TODO : panel 1�� �԰��� ���ϰ�, component�� �԰��� ���ؼ� add �Ѵ�
		jp1.setLayout(null);
		jp1.setBounds(30, 30, 400, 600);
		jp1.setBackground(Color.WHITE);
		add(jp1);

		jsp.setBounds(20, 20, 350, 500);
		jtf.setBounds(20, 550, 290, 40);
		jbtnSend.setBounds(310, 550, 70, 40);

		jp1.add(jsp);
		jp1.add(jtf);
		jp1.add(jbtnSend);

		jtf.addKeyListener(this); // �޼��� �Է� â�� ������ ����
	}

	private void createP2() {
		// TODO : panel 2�� �԰��� ���ϰ�, component�� �԰��� ���ؼ� add �Ѵ�
		jp2.setLayout(null);
		jp2.setBounds(450, 30, 225, 600);
		jp2.setBackground(Color.ORANGE);
		add(jp2);

		jlWait.setBounds(20, 80, 200, 50);
		jtaWait.setBounds(20, 130, 200, 200);

		jbtnExit.setBounds(20, 550, 200, 50);
		jbtnStart.setBounds(20, 400, 200, 50);

		jp2.add(jlWait);
		jp2.add(jtaWait);
		jp2.add(jbtnExit);
		jp2.add(jbtnStart);

		jbtnStart.addActionListener(this); // ���۹�ư�� ������ ����
		jbtnExit.addActionListener(this); // �����ư�� ������ ����
	}

	private void startServer() {

		try {
			ss = new ServerSocket(5001); // ���� �� �� ����, port = 5001
			while (true) { // ���� �ݺ�
				System.out.println("��� ��"); // ���� ��� ��
				// �����ϴ� Ŭ���̾�Ʈ ���� ���ο� ������ �����Ͽ� ����Ų��
				Socket client = ss.accept(); 
				// ������ Ŭ���̾�Ʈ�� ip �ּҸ� �޾ƿ´�
				ip = client.getInetAddress().getHostAddress(); 
				if (clientMap.containsKey(ip)) { // Map�� �ش� ip�� �̹� �����ϸ�
					System.out.println("�̹� �������� ����� �Դϴ�. IP : " + ip); 
					client.close(); // ������ �ݾƹ�����
					continue; // if ������ ���ǹ��� ���� ��� �ش� �۾��� �����ϰ� �������� �Ѿ
				} // �� �̹� ������ ip�� �����Ű��, �׷��� ������ �Ʒ� �۾����� �Ѿ��

				waiterList.offer(ip); // LinkedList�� ip element�� �߰��Ѵ�
				jtaWait.append(ip + "\n"); // ����� ��Ͽ� �ش� ip�� ����Ѵ�

				// Socket, jtaMain, ip�� �Ű������� �޴� ������ ���� Ŭ������ ������
				ChatThreadServer cmts = new ChatThreadServer(client, jtaMain, ip); 
				
																					
				System.out.println("���� : " + cmts); // ��� �����尡 �����Ͽ����� ���
				clientMap.put(ip, cmts); // Map�� �ش� ip�� Thread�� ���������� �߰��Ѵ�
				cmts.setClientMap(clientMap); // ��Ƽ������ Ŭ������ ���� Map�� ������ �����Ѵ�
				cmts.setJtaWait(jtaWait); // ��Ƽ������ Ŭ������ ���� jtaWait�� ������ �����Ѵ�
				cmts.start(); // ������ �۾� ����
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // startServer method ends

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtnExit) {
			System.exit(0); // �����ư�� ������ �߰�
			// �ڿ� �ݳ�
				try {
				if (pw != null)
					pw.close();
				if (ss!= null)
					ss.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
		} else if (e.getSource() == jbtnStart) {
			if (waiterList.peek() != null) { // ����� ��Ͽ� ����� ���� ���
				String ip = waiterList.poll(); // �� ó�� ���� ����� ip ������ �޾ƿͼ�
				jtaMain.append(ip + "�԰� ����� �����մϴ�\n");
				if (clientMap.containsKey(ip)) { // Map�� �ش� ip�� �����ϸ�
					/* 
					 * get(ip)�� �ᱹ ChatTreadServer�� ��������setFlag method�� ���ؼ�
					 * �߾���� �ο�
					 */
					/* 
					 * ip�� �޾ƿ� ChatTreadServer��
					 * ���������� targetClient�� ����
					 */					
					targetClient = clientMap.get(ip); 
					clientMap.get(ip).setFlag(true); 
					targetClient.pushMessage("����� �����մϴ�.");								
				} else {
					// �ش� ip�� �������� ������, �ش� �޼����� ���
					pw.println(ip + "�� ������ ������ �ֽ��ϴ�"); 				
					pw.flush();
				}
			} // else if jbtnStart ends
		} else if(e.getSource() == jbtnSend){
			String msg = "";
			msg = jtf.getText(); // �޼��� �Է� â�� �ִ� �޼�����
			jtaMain.append("Admin :" + msg + "\n");// �� â�� �����ְ�
			targetClient.pushMessage(msg); // �۽Ű�ü�� ���ؼ� main ä��â�� �ø�����
			jtf.setText(""); // �׸��� �޼���â �ʱ�ȭ
		} // if- else if ends
	} // actionPerformed method ends

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { // enter Ű �Է½�
			String msg = "";
			msg = jtf.getText(); // �޼��� �Է� â�� �ִ� �޼�����
			jtaMain.append("Admin :" + msg + "\n");
			targetClient.pushMessage(msg); // �۽Ű�ü�� ���ؼ� main ä��â�� �ø�����
			jtf.setText(""); // �׸��� �޼���â �ʱ�ȭ
			jtf.requestFocusInWindow(); // window�� �ش� â�� focus�� �ֵ���
		}

	} // keyPressed method ends

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new ChatMainServer();

	}

} // class ends
