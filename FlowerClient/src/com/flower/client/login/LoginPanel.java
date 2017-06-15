package com.flower.client.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.flower.client.MainClass;
import com.flower.client.component.StyleButton;
import com.flower.client.model.LoginModule;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel implements ActionListener{
	private MainClass mc;
	private JLabel jlbId, jlbPw;
	private JTextField jtfId;
	private JPasswordField jtfPw; // 패스워드 입력하면 검은 동그라미로 보여준다.
	private JLabel imgbox;
	private StyleButton sbtnLogin, sbtnReg;
	private LoginModule lm;


	// --- Constructor ---
	public LoginPanel(MainClass mc) {
		this.mc = mc;
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
		add(imgbox); // 로고 이미지 추가
		add(jlbId); // ID 라벨 추가
		add(jlbPw); // PW 라벨 추가
		add(jtfId); // Id 필드 추가
		add(jtfPw); // PW 필드 추가
		add(sbtnLogin); // 로그인 버튼 추가
		add(sbtnReg); // 회원가입 버튼 추가
		
		// 이벤트 처리
		sbtnLogin.addActionListener(this); // 로그인 버튼 이벤트 추가.
		sbtnReg.addActionListener(this); // 회원가입 버튼 이벤트 추가.
	}

	// actionPerformed override method
	// 버튼 액션 리스너 핸들러 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbtnLogin) { // 로그인 버튼을 눌렀을시
			lm = new LoginModule();
			Boolean flag = lm.login(jtfId.getText(), String.valueOf(jtfPw.getPassword()));
			lm.close();
			if(flag == true){
				mc.changeCardLayout("product");
			}
			// TODO : 로그인 처리. if문 써서 성공시, 실패시 분리
		} else if (e.getSource() == sbtnReg) { // 회원가입 버튼을 눌렀을시
			mc.changeCardLayout("register"); // 회원가입 패널로 전환.
		} 
	} // actionPerformed override method end
	
}
