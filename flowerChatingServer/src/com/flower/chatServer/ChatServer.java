package com.flower.chatServer;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChatServer extends JFrame implements ActionListener, KeyListener {

	CardLayout c;
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;

	JTextArea jtaMain;
	JTextArea jtaWait;
	JTextArea jtaOrder;

	JLabel jlWait;
	JTextField jtf;
	JTextField jtfSetNick;
	JScrollPane jsp;

	JButton jbtnExit;
	JButton jbtnSend;
	JButton jbtnOrder;
	JButton jbtnStart;

	ServerSocket ss;
	Socket client;
	PrintWriter pw;
	BufferedReader br;

	HashMap<String, ChatThreadServer> clientMap;
	LinkedList<String> waiterList;
	ChatThreadServer targetClient;

	public ChatServer() {
		super("채팅서버");
		setLayout(null);
		setBounds(200, 200, 700, 700);

		jp1 = new JPanel();
		jp2 = new JPanel();
		// panel

		jtaMain = new JTextArea();
		jsp = new JScrollPane(jtaMain, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jtf = new JTextField();
		jbtnSend = new JButton("전송");
		// panel 1 components

		jbtnOrder = new JButton("주문내역확인");
		jtaOrder = new JTextArea();
		jlWait = new JLabel("대기자 목록", 0); // 가운데 정렬
		jtaWait = new JTextArea();
		jtaWait.setEditable(false);
		jbtnExit = new JButton("종료");
		jbtnStart = new JButton("시작");
		// panel 2 components

		clientMap = new HashMap<String, ChatThreadServer>();
		waiterList = new LinkedList<String>();
		createP1();
		createP2();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		startServer();
	} // constructor ends

	private void createP1() {
		// TODO : panel 1의 규격을 정하고, component의 규격을 정해서 add 한다
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

		jtf.addKeyListener(this);
	}

	private void createP2() {
		// TODO : panel 2의 규격을 정하고, component의 규격을 정해서 add 한다
		jp2.setLayout(null);
		jp2.setBounds(450, 30, 225, 600);
		jp2.setBackground(Color.ORANGE);
		add(jp2);

		jbtnOrder.setBounds(20, 20, 200, 50);
		jtaOrder.setBounds(20, 80, 200, 100);

		jlWait.setBounds(20, 180, 200, 50);
		jtaWait.setBounds(20, 230, 200, 200);

		jbtnExit.setBounds(20, 550, 200, 50);
		jbtnStart.setBounds(50, 500, 100, 50);

		jp2.add(jbtnOrder);
		jp2.add(jtaOrder);
		jp2.add(jlWait);
		jp2.add(jtaWait);
		jp2.add(jbtnExit);
		jp2.add(jbtnStart);

		jbtnStart.addActionListener(this);
		jbtnExit.addActionListener(this);
	}

	private void startServer() {

		try {
			ss = new ServerSocket(5001);
			while (true) {
				System.out.println("대기 중");
				Socket client = ss.accept();
				String ip = client.getInetAddress().getHostAddress();

				if (clientMap.containsKey(ip)) {
					System.out.println("이미 접속중인 사용자 입니다. IP : " + ip);
					client.close();
					continue;
				}

				waiterList.offer(ip);
				jtaWait.append(ip + "\n");

				ChatThreadServer cmts = new ChatThreadServer(client, jtaMain);
				System.out.println("접속 : " + cmts);
				clientMap.put(ip, cmts);
				cmts.setClientMap(clientMap);
				cmts.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // 서버소켓을 연다

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtnExit) {
			System.exit(0);
		} else if (e.getSource() == jbtnStart) {
			if (waiterList.peek() != null) {
				String ip = waiterList.poll();
				if (clientMap.containsKey(ip)) {
					clientMap.get(ip).setFlag(true);
					targetClient = clientMap.get(ip);
				} else {
					pw.println(ip + "는 접속이 끊어져 있습니다");
					pw.flush();
				}
			}
		} // else - if ends
	} // actionPerformed method ends

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String msg = "";
			msg = jtf.getText();
			targetClient.pushMessage(msg);
			jtf.setText("");
			jtf.requestFocusInWindow();
		}

	} // keyPressed method ends

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new ChatServer();

	}

} // class ends
