package com.flower.client.component;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.client.chat.ChatDialog;
import com.flower.client.dialog.CommonDialog;
import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class TopMenuBar extends JPanel implements ActionListener{
	// TopMenuBar는 상품검색, 상품상세, 상품주문, 주문확인, 게시판 작성에 부착

	private MainClass mc;
	private EmphasisButton jbtnOrder, jbtnChat, jbtnLogout;
	private JButton jbtnLogo;
	private Image img, newimg;
	private ImageIcon imgicon;
	private Font f;

	public TopMenuBar(MainClass mc, Boolean flag){	// flag가 true 값이면 메뉴버튼이 생성되고 로고버튼 ActionListener 붙는다.
		this.mc = mc;
		f = new Font("맑은 고딕", Font.BOLD, 15); // 메뉴 버튼을 위한 폰트
		
		// 초기설정
		setSize(550, 50);	
		setLayout(null);	
		setBackground(EnVal.MAINCOLOR); // 메인컬러 사용
		
		// 로고 버튼 생성
		imgicon = new ImageIcon("imgs/menubarlogo.png");	// 버튼에 부착할 ImageIcon에 로고사진을 넣는다.	
															// 추후에 메인컬러 배경인 로고 사진으로 대체
		img = imgicon.getImage();  // ImageIcon으로부터 이미지를 가져와 Image 객체에 넣는다.
		newimg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH );  // 이미지 사이즈를 조절해서  새로운 Image 객체에 넣는다.
		imgicon = new ImageIcon(newimg);	// 새로운 Image 객체 받아와서 ImageIcon 객체에 다시 넣는다.
		
		jbtnLogo = new JButton(imgicon); // 로고이미지 버튼 생성
		jbtnLogo.setBounds(10, 10, 30, 30);	// 로고버튼 위치, 크기 설정
		jbtnLogo.setBorder(null); // 로고버튼 테두리 삭제
		add(jbtnLogo); 	// 로고 버튼 부착
		
		// 주문확인 버튼 생성
		jbtnOrder = new EmphasisButton("주문확인"); // 주문확인
		jbtnOrder.setBounds(240, 10, 100, 30);	// 주문확인 위치, 크기 설정
		jbtnOrder.setFont(f);	// 주문확인 폰트 설정
		
		// 1:1 채팅 버튼 생성
		jbtnChat = new EmphasisButton("1:1 채팅");		// 1:1 채팅
		jbtnChat.setBounds(340, 10, 100, 30);	// 1:1 채팅
		jbtnChat.setFont(f);		// 1:1 채팅 폰트 설정
		
		// 로그아웃 버튼 생성
		jbtnLogout = new EmphasisButton("로그아웃");	// 로그아웃
		jbtnLogout.setBounds(440, 10, 100, 30);	// 로그아웃
		jbtnLogout.setFont(f);	// 로그아웃 폰트 설정
		
		if(flag == true){
			// 패널 부착
			add(jbtnOrder); // 주문확인 부착
			add(jbtnChat);	// 1:1 채팅 부착
			add(jbtnLogout);	// 로그아웃 부착
			
			// 이벤트 처리
			jbtnLogo.addActionListener(this);	// 로고 버튼 누르면 상품검색으로 이동한다.
			jbtnOrder.addActionListener(this);	// 주문확인 버튼 누르면 주문확인으로 이동한다.
			jbtnChat.addActionListener(this);	// 1:1 채팅 버튼 누르면 채팅 프레임을 띄운다.
			jbtnLogout.addActionListener(this);	// 로그아웃 버튼 누르면 로그아웃 처리한다.
		}
		
		setVisible(true);
	}
	
	// JButton ActionListener Event
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnLogo){
			// TO-DO: 상품목록 패널로 전환
		}else if(e.getSource()==jbtnOrder){
			// TO-DO: 주문확인 패널로 전환
		}else if(e.getSource()==jbtnChat){
			ChatDialog cd;
			try {
				// 채팅패널을 생성하며 채팅서버 연결객체를 넘긴다.
				cd = new ChatDialog(mc.getMf());
				cd.setVisible(true);
			} catch (ConnectException e1) {
				new CommonDialog(mc.getMf(), "채팅 서버에 접속할 수 없습니다."); // 에러 다이얼 로그 출력
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==jbtnLogout){
			// TO-DO: 로그아웃 처리
		}
		
	}

	public void moveOrderBtnLocationX(int x) {
		jbtnOrder.setLocation(x, jbtnOrder.getY());
	}

	public void moveChatBtnLocationX(int x) {
		jbtnChat.setLocation(x, jbtnChat.getY());
	}

	public void moveLogoutBtnLocationX(int x) {
		jbtnLogout.setLocation(x, jbtnLogout.getY());
	}
	
}
