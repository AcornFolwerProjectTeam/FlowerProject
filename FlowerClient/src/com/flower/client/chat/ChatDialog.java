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
	
	// MainFrame 상단 메뉴바에서 1:1 채팅 버튼 누르면 ChatFrame이 뜬다.
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
		super(mc.getMf(), false); // 메인프레임을 상위프레임으로 두고 모달로 동작한다.
		this.mc = mc;
		mc.setChatFlag(true);
		
		// 패널 기본 설정: Layout 해제, color: white, 폰트 설정
		setLayout(null);
		setBackground(Color.WHITE);
		fta= new Font("맑은 고딕", Font.PLAIN, 15);
		setTitle("1:1 채팅"); // 제목표시줄 타이틀 설정
		setLocation(300, 300); // 초기위치
		setSize(450, 600); // 크기 설정
		setResizable(false); // 크기 고정
		
		// 채팅 객체 생성
		cm = new ChatModule(); // 채팅 모듈 생성하여 연결 객체를 만든다.
		
		// 채팅 내용 확인창
		jtaShow = new JTextArea("행복을 전하는 La Fleur" + "\n" + "1:1 채팅을 통해 편하게 상담하세요." +"\n" +"\n");	// 확인창 생성
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
		
		// 윈도우 리스너 추가.
		addWindowListener(this);
		
		// 채팅 Thread객체 생성
		ctm = new ChatThreadModule(cm, jtaShow, jspShow);	// ChatModule, jtaShow, jspShow 주소값 받아서 ChatThreadModule 생성
		ctm.start();	// 채팅 Thread를 돌리기 시작
	
	 }

	private void chatsend(){
		String msg = jtaMsg.getText();
		cm.send(msg);	// 서버로 메시지를 전송한다. 
		jtaShow.append("[" + mc.getAvo().getName() + "]: " +msg +"\n");	// [접속한ID] : 메시지 내용을 채팅 내용 확인창에 띄운다.
		jtaMsg.setText("");	// 메시지 입력 창을 비운다.
		jtaMsg.requestFocus();	// 메시지 입력 창으로 커서를 위치한다.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ebtnSend){	//  전송버튼 눌렀을 때 chatsend() 실행해서 server로 메시지를 전송한다.
			chatsend();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){ //  엔터버튼 눌렀을 때 chatsend() 실행해서 server로 메시지를 전송한다.
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
