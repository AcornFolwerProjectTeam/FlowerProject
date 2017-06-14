package com.flower.client.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.flower.client.component.StyleButton;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel{
	
	private JLabel jlbId, jlbPw;
	private JTextField jtfId;
	private JPasswordField jtfPw; // 패스워드 입력하면 검은 동그라미로 보여준다.
	private JLabel imgbox;
	private StyleButton sbtnLogin, sbtnReg;

	// --- Constructor ---
	public LoginPanel() {
		// 패널 기본 Layout 해제한다. 배경색은 흰색으로 한다.
		setLayout(null);
		setBackground(Color.WHITE);
		
		jlbId = new JLabel("ID");	// ID 라벨
		jlbPw = new JLabel("PASSWORD");	//PW 라벨
		jtfId = new JTextField();	// ID 입력
		jtfPw = new JPasswordField();	// PW 입력
		sbtnLogin = new StyleButton("로그인");	// 로그인버튼: 기본 버튼
		sbtnReg = new StyleButton("회원가입");		// 회원가입버튼: 강조 버튼
		imgbox = new JLabel(new ImageIcon("imgs/logosample.png"));	// J라벨에 로고 이미지 부착
		
		// font 설정
		Font flb = new Font("맑은 고딕", Font.BOLD, 17); // JLabel 폰트
		Font ftf = new Font("맑은 고딕", Font.PLAIN, 17); // ID, PW 입력 폰트
		jlbId.setFont(flb);
		jlbPw.setFont(flb);
		jtfId.setFont(ftf);
		jtfPw.setFont(ftf);
	
		// 크기 위치
		imgbox.setBounds(170, 205, 260, 100); // 로고 이미지
		jlbId.setBounds(100, 360, 50, 20);	// ID 라벨
		jlbPw.setBounds(100, 411, 100, 20);	// PW 라벨
		jtfId.setBounds(240, 355, 250, 35);	// ID 입력
		jtfPw.setBounds(240, 405, 250, 35);	// PW 입력
		sbtnLogin.setBounds(150, 505, 140, 40);	// 로그인 버튼
		sbtnReg.setBounds(310, 505, 140, 40);	// 회원가입 버튼 
		
		// 패널 부착
		add(imgbox);
		add(jlbId);
		add(jlbPw);
		add(jtfId);
		add(jtfPw);
		add(sbtnLogin);
		add(sbtnReg);
	}
	
}
