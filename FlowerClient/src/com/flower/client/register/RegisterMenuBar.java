package com.flower.client.register;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class RegisterMenuBar extends JPanel{
	// RegisterMenuBar는 페이지 이동을 위한 메뉴가 없는 형태로 회원가입 페이지에만 부착한다.
	
	Toolkit tool = Toolkit.getDefaultToolkit();
	Image img = tool.getImage("imgs/menubarlogo.png"); //로고 이미지(메인컬러 배경인 로고 이미지 만들고 나면 대체)

	RegisterMenuBar(){
		setSize(550, 50);
		setBackground(EnVal.MAINCOLOR); // 메인컬러 사용
		setVisible(true);
	}
	
	// 이미지 부착 method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 10, 10, 30, 30,this);
	}
}
