package com.flower.client;

import javax.swing.JFrame;

import com.flower.client.chat.ChatPanel;

@SuppressWarnings("serial")
public class ChatFrame extends JFrame{
	ChatPanel cp = new ChatPanel();
	
	// ----- Constructor ----------
	public ChatFrame() {
		// 초기설정
		setTitle("1:1 채팅");
		setSize(450, 600);
		//exitDefaultCloseOperation(EXIT_ON_CLOSE);
		add(cp);	// 채팅창만 띄우는 용도이므로 cardLayout 쓰지 않는다.
		setVisible(false);
		
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new ChatFrame();
	}
}
