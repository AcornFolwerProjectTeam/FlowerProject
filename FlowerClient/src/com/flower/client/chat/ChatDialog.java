package com.flower.client.chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;
import com.flower.client.model.ChatModule;
import com.flower.client.model.ChatThreadModule;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog implements ActionListener, KeyListener, WindowListener{
	
	// MainFrame ��� �޴��ٿ��� 1:1 ä�� ��ư ������ ChatFrame�� ���.
	private JScrollPane jspShow;
	private JTextArea jtaShow;
	private JTextField jtaMsg;
	private EmphasisButton ebtnSend;
	private Font fta; 
	private ChatModule cm;
	private ChatThreadModule ctm;
	private MainClass mc;
	
	// --- Constructor ---
	public ChatDialog(MainClass mc) throws UnknownHostException, ConnectException, IOException {
		super(mc.getMf(), false); // ������������ �������������� �ΰ� ��޷� �����Ѵ�.
		this.mc = mc;
		mc.setChatFlag(true);
		
		// �г� �⺻ ����: Layout ����, color: white, ��Ʈ ����
		setLayout(null);
		setBackground(Color.WHITE);
		fta= new Font("���� ���", Font.PLAIN, 15);
		setTitle("1:1 ä��"); // ����ǥ���� Ÿ��Ʋ ����
		setLocation(300, 300); // �ʱ���ġ
		setSize(450, 600); // ũ�� ����
		setResizable(false); // ũ�� ����
		
		// ä�� ��ü ����
		cm = new ChatModule(); // ä�� ��� �����Ͽ� ���� ��ü�� �����.
		
		// ä�� ���� Ȯ��â
		jtaShow = new JTextArea("�ູ�� ���ϴ� La Fleur" + "\n" + "1:1 ä���� ���� ���ϰ� ����ϼ���." +"\n" +"\n");	// Ȯ��â ����
		jspShow = new JScrollPane(jtaShow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Ȯ��â ��ũ�� ����
		jtaShow.setFont(fta);	// Ȯ��â ��Ʈ ����
		jspShow.setBounds(20, 30, 405, 462);	// Ȯ��â ũ�� �� ��ġ ����
		add(jspShow);	// �гο� Ȯ��â ����
		
		// ä�� ���� �Է�â
		jtaMsg = new JTextField();	// �Է�â ����
		jtaMsg.setFont(fta);	// �Է�â ��Ʈ ����
		jtaMsg.setBounds(20, 500, 310, 40); // �Է�â ũ�� �� ��ġ ����
		jtaMsg.addKeyListener(this);
		add(jtaMsg);	//�гο� �Է�â ����
		
		// ���� ��ư
		ebtnSend = new EmphasisButton ("����"); // ���۹�ư ����: ������ư
		ebtnSend.setBounds(340, 500, 85, 40);	// ���۹�ư ũ�� �� ��ġ ����
		ebtnSend.addActionListener(this);
		add(ebtnSend);	// �гο� ���۹�ư ����
		
		// ������ ������ �߰�.
		addWindowListener(this);
		
		// ä�� Thread��ü ����
		ctm = new ChatThreadModule(cm, jtaShow, jspShow);	// ChatModule, jtaShow, jspShow �ּҰ� �޾Ƽ� ChatThreadModule ����
		ctm.start();	// ä�� Thread�� ������ ����
	
	 }

	private void chatsend(){
		String msg = jtaMsg.getText();
		cm.send(msg);	// ������ �޽����� �����Ѵ�. 
		jtaShow.append("[" + mc.getAvo().getName() + "]: " +msg +"\n");	// [������ID] : �޽��� ������ ä�� ���� Ȯ��â�� ����.
		jtaMsg.setText("");	// �޽��� �Է� â�� ����.
		jtaMsg.requestFocus();	// �޽��� �Է� â���� Ŀ���� ��ġ�Ѵ�.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ebtnSend){	//  ���۹�ư ������ �� chatsend() �����ؼ� server�� �޽����� �����Ѵ�.
			chatsend();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){ //  ���͹�ư ������ �� chatsend() �����ؼ� server�� �޽����� �����Ѵ�.
			chatsend();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		cm.close();
		mc.setChatFlag(false);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
