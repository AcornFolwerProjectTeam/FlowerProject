package com.flower.client.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.flower.client.component.StyleButton;

public class LoginPan extends JPanel{
	JLabel jlbid, jlbpw;
	JTextField jtfid, jtfpw;
	JLabel imgbox;
	ImageIcon imglogo;
	StyleButton sbtnlogin, sbtnreg;

	
	LoginPan() {
		setLayout(null);
		setBackground(Color.WHITE);
		
		jlbid = new JLabel("ID");
		jlbpw = new JLabel("PASSWORD");
		jtfid = new JTextField();
		jtfpw = new JTextField();
		sbtnlogin = new StyleButton();
		sbtnlogin.setText("로그인"); // 생성자가 바뀌면 수정
		sbtnreg = new StyleButton();
		sbtnreg.setText("회원가입"); // 생성자가 바뀌면 수정
		imgbox = new JLabel(new ImageIcon("imgs/logosample.png"));
		
		Font flb = new Font("맑은 고딕", Font.BOLD, 17); // JLabel Font
		Font ftf = new Font("맑은 고딕", Font.PLAIN, 17); // ID, PW 입력 TextField Font
		jlbid.setFont(flb);
		jlbpw.setFont(flb);
		jtfid.setFont(ftf);
		jtfpw.setFont(ftf);
	

		imgbox.setBounds(170, 205, 260, 100); // +80
		
		jlbid.setBounds(100, 355, 50, 20);
		jlbpw.setBounds(100, 405, 100, 20);
		jtfid.setBounds(240, 355, 250, 35);
		jtfpw.setBounds(240, 405, 250, 35);
		sbtnlogin.setBounds(150, 505, 140, 40);
		sbtnreg.setBounds(310, 505, 140, 40);
		
		add(imgbox);
		add(jlbid);
		add(jlbpw);
		add(jtfid);
		add(jtfpw);
		add(sbtnlogin);
		add(sbtnreg);
	}
	
	public static void main(String[] args) {
		new LoginPan();
	}
}
