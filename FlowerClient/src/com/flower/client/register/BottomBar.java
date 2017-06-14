package com.flower.client.register;

import javax.swing.JPanel;

import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class BottomBar extends JPanel{
	// BottomBar는 회원가입, 상품검색, 상품상세, 상품주문, 주문확인, 게시판 작성에 부착한다.
	public BottomBar(){
		setSize(550, 10);
		setBackground(EnVal.MAINCOLOR); // MainColor 사용한다.
		setVisible(true);
	}
}
