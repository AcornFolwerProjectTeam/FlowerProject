package com.flower.client.chat;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.flower.client.component.EmphasisButton;

public class ChatPanel extends JPanel {
	
	// Chat�� �˾�?
	private JScrollPane jspShow, jspMsg;
	private JTextArea jtaShow, jtaMsg;
	private EmphasisButton ebtnSend;
	
	// --- Constructor ---
	public ChatPanel(){
		// �г� �⺻ Layout ����, color: white
		setLayout(null);
		setBackground(Color.WHITE);
		
		jtaShow = new JTextArea(); // Ȯ��â
		jtaMsg = new JTextArea();	// ����â
		jspShow = new JScrollPane(jtaShow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Ȯ��â ��ũ��
		jspMsg = new JScrollPane(jtaMsg, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	// ����â ��ũ��
		ebtnSend = new EmphasisButton ("����"); // ���۹�ư: ������ư����
		
		// font ����
		Font fta = new Font("���� ���", Font.PLAIN, 15);
		jtaShow.setFont(fta);
		jtaMsg.setFont(fta);
		
		// components ��ġ, ũ��
		jspShow.setBounds(20, 20, 395, 400);
		jspMsg.setBounds(20, 435, 300, 115);
		ebtnSend.setBounds(330, 435, 85, 115);
		
		// �г� ����
		add(jspShow);
		add(jspMsg);
		add(ebtnSend);
	 }
}
