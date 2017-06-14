package com.flower.client.chat;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.flower.client.component.EmphasisButton;

public class ChatPanel extends JPanel {
	
	// Chat은 팝업?
	private JScrollPane jspShow, jspMsg;
	private JTextArea jtaShow, jtaMsg;
	private EmphasisButton ebtnSend;
	
	// --- Constructor ---
	public ChatPanel(){
		// 패널 기본 Layout 해제, color: white
		setLayout(null);
		setBackground(Color.WHITE);
		
		jtaShow = new JTextArea(); // 확인창
		jtaMsg = new JTextArea();	// 전송창
		jspShow = new JScrollPane(jtaShow, jspShow.VERTICAL_SCROLLBAR_AS_NEEDED, jspShow.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 확인창 스크롤
		jspMsg = new JScrollPane(jtaMsg, jspShow.VERTICAL_SCROLLBAR_AS_NEEDED, jspShow.HORIZONTAL_SCROLLBAR_AS_NEEDED);	// 전송창 스크롤
		ebtnSend = new EmphasisButton ("전송"); // 전송버튼: 강조버튼으로
		
		// font 설정
		Font fta = new Font("맑은 고딕", Font.PLAIN, 15);
		jtaShow.setFont(fta);
		jtaMsg.setFont(fta);
		
		// components 위치, 크기
		jspShow.setBounds(40, 30, 510, 550);
		jspMsg.setBounds(40, 600, 380, 120);
		ebtnSend.setBounds(430, 600, 120, 120);
		
		// 패널 부착
		add(jspShow);
		add(jspMsg);
		add(ebtnSend);
	 }
}
