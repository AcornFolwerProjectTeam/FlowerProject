package com.flower.client.component;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class TopMenuBar extends JPanel implements ActionListener{
	// TopMenuBar는 상품검색, 상품상세, 상품주문, 주문확인, 게시판 작성에 부착

	private EmphasisButton jbtnOrder, jbtnChat, jbtnLogout;
	private JButton jbtnLogo;
	private Image img, newimg;
	private ImageIcon imgicon;

	TopMenuBar(MainClass mc){
		// 초기설정
		setSize(550, 50);	
		setLayout(null);	
		setBackground(EnVal.MAINCOLOR); // 메인컬러 사용
		
		// Logo 버튼 생성
		imgicon = new ImageIcon("imgs/menubarlogo.png");	// 버튼에 부착할 ImageIcon에 로고사진을 넣는다.	
															// 추후에 메인컬러 배경인 로고 사진으로 대체
		img = imgicon.getImage() ;  // ImageIcon으로부터 이미지를 가져와 Image 객체에 넣는다.
		newimg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH ) ;  // 이미지 사이즈를 조절해서  새로운 Image 객체에 넣는다.
		imgicon = new ImageIcon(newimg);	// 새로운 Image 객체 받아와서 ImageIcon 객체에 다시 넣는다.
		
		// 메뉴 버튼 생성
		jbtnLogo = new JButton(imgicon); // 로고이미지 버튼
		jbtnOrder = new EmphasisButton("주문확인"); // 주문확인
		jbtnChat = new EmphasisButton("1:1 채팅");		// 1:1 채팅
		jbtnLogout = new EmphasisButton("로그아웃");	// 로그아웃
		
		// JButton 위치, 크기
		jbtnLogo.setBounds(10, 10, 30, 30);	// 로고
		jbtnOrder.setBounds(240, 10, 100, 30);	// 주문확인
		jbtnChat.setBounds(340, 10, 100, 30);	// 1:1 채팅
		jbtnLogout.setBounds(440, 10, 100, 30);	// 로그아웃
		
		// 로고 테두리 삭제
		jbtnLogo.setBorder(null);
	
		// 폰트설정
		Font f = new Font("맑은 고딕", Font.BOLD, 15);
		jbtnOrder.setFont(f);	// 주문확인 폰트
		jbtnChat.setFont(f);		// 1:1 채팅 폰트
		jbtnLogout.setFont(f);	// 로그아웃 폰트
				
		// 패널 부착
		add(jbtnLogo); 	// 로고 버튼 부착
		add(jbtnOrder); // 주문확인 부착
		add(jbtnChat);	// 1:1 채팅 부착
		add(jbtnLogout);	// 로그아웃 부착
		
		// 이벤트 처리
		jbtnLogo.addActionListener(this);	// 로고 버튼 누르면 상품검색으로 이동한다.
		jbtnOrder.addActionListener(this);	// 주문확인 버튼 누르면 주문확인으로 이동한다.
		jbtnChat.addActionListener(this);	// 1:1 채팅 버튼 누르면 채팅 프레임을 띄운다.
		jbtnLogout.addActionListener(this);	// 로그아웃 버튼 누르면 로그아웃 처리한다.
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
