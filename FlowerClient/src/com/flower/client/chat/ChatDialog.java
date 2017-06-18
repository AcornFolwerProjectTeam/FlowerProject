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

import com.flower.client.MainFrame;
import com.flower.client.component.EmphasisButton;
import com.flower.client.model.ChatModule;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog implements ActionListener, KeyListener, WindowListener{
	
	// MainFrame ��� �޴��ٿ��� 1:1 ä�� ��ư ������ ChatFrame�� ���.
	private JScrollPane jspShow;
	private JTextArea jtaShow;
	private JTextField jtaMsg;
	private EmphasisButton ebtnSend;
	private Font fta; 
	private ChatModule cm;
	
	// --- Constructor ---
	public ChatDialog(MainFrame mf) throws UnknownHostException, ConnectException, IOException {
		super(mf, true); // ������������ �������������� �ΰ� ��޷� �����Ѵ�.
		
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
		jtaShow = new JTextArea();	// Ȯ��â ����
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
	 }

	private void chatsend(){
		cm.send(jtaMsg.getText());	// ������ �޽����� �����Ѵ�. 
		jtaMsg.setText("");	// �޽��� �Է� â�� ����.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ebtnSend){
			chatsend();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
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
