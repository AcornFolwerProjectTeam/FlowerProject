package com.flower.client.chat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.flower.client.component.EmphasisButton;
import com.flower.client.model.ChatModule;

@SuppressWarnings("serial")
public class ChatPanel extends JPanel implements ActionListener, KeyListener{
	
	// MainFrame 상단 메뉴바에서 1:1 채팅 버튼 누르면 ChatFrame이 뜬다.
	private JScrollPane jspShow;
	private JTextArea jtaShow;
	private JTextField jtaMsg;
	private EmphasisButton ebtnSend;
	private Font fta; 
	private ChatModule cm;
	
	// --- Constructor ---
	public ChatPanel(){
		cm = new ChatModule();
		
		// 패널 기본 설정: Layout 해제, color: white, 폰트 설정
		setLayout(null);
		setBackground(Color.WHITE);
		fta= new Font("맑은 고딕", Font.PLAIN, 15);
		
		// 채팅 내용 확인창
		jtaShow = new JTextArea();	// 확인창 생성
		jspShow = new JScrollPane(jtaShow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 확인창 스크롤 생성
		jtaShow.setFont(fta);	// 확인창 폰트 설정
		jspShow.setBounds(20, 30, 405, 462);	// 확인창 크기 및 위치 설정
		add(jspShow);	// 패널에 확인창 부착
		
		// 채팅 내용 입력창
		jtaMsg = new JTextField();	// 입력창 생성
		jtaMsg.setFont(fta);	// 입력창 폰트 설정
		jtaMsg.setBounds(20, 500, 310, 40); // 입력창 크기 및 위치 설정
		jtaMsg.addKeyListener(this);
		add(jtaMsg);	//패널에 입력창 부착
		
		// 전송 버튼
		ebtnSend = new EmphasisButton ("전송"); // 전송버튼 생성: 강조버튼
		ebtnSend.setBounds(340, 500, 85, 40);	// 전송버튼 크기 및 위치 설정
		ebtnSend.addActionListener(this);
		add(ebtnSend);	// 패널에 전송버튼 부착
	 }

	private void chatsend(){
		cm.send(jtaMsg.getText());	// 서버로 메시지를 전송한다. 
		jtaMsg.setText("");	// 메시지 입력 창을 비운다.
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
}
