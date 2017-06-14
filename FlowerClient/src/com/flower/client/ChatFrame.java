package com.flower.client;

import javax.swing.JFrame;

import com.flower.client.chat.ChatPanel;

@SuppressWarnings("serial")
public class ChatFrame extends JFrame{
	ChatPanel cp = new ChatPanel();
	
	// ----- Constuctor ----------
	public ChatFrame() {
		// �ʱ⼳��
		setTitle("1:1 ä��");
		setSize(450, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(cp);	// ä��â�� ���� �뵵�̹Ƿ� cardLayout ���� �ʴ´�.
		setVisible(true);
		
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new ChatFrame();
	}
}
