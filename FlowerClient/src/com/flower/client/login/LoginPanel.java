package com.flower.client.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.flower.client.MainClass;
import com.flower.client.component.StyleButton;
import com.flower.client.dialog.CommonDialog;
import com.flower.client.model.LoginModule;
import com.flower.vo.AccountVO;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel implements ActionListener, CaretListener{
	private MainClass mc;
	private JLabel jlbId, jlbPw;
	private JTextField jtfId;
	private JPasswordField jtfPw; // 패스워드 입력하면 검은 동그라미로 보여준다.
	private JLabel imgbox;
	private StyleButton sbtnLogin, sbtnReg;


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
		
		sbtnLogin.setEnabled(false);
		
		// 패널 부착
		add(imgbox); // 로고 이미지 추가
		add(jlbId); // ID 라벨 추가
		add(jlbPw); // PW 라벨 추가
		add(jtfId); // Id 필드 추가
		add(jtfPw); // PW 필드 추가
		add(sbtnLogin); // 로그인 버튼 추가
		add(sbtnReg); // 회원가입 버튼 추가
	
		// 이벤트 처리
		jtfId.addCaretListener(this);	// 로그인 입력창 이벤트 추가 (공백 제한)
		jtfPw.addCaretListener(this);	// 비밀번호 입력창 이벤트 추가 (공백 제한)
		sbtnLogin.addActionListener(this); // 로그인 버튼 이벤트 추가
		sbtnReg.addActionListener(this); // 회원가입 버튼 이벤트 추가
		
	}

	// actionPerformed override method
	// 버튼 액션 리스너 핸들러 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbtnLogin) { // 로그인 버튼을 눌렀을시
			try {
				LoginModule lm = new LoginModule(); // 로그인 모듈 생성
				/*
				 * 로그인 모듈의 로그인 메서드를 호출한다.
				 * 매개변수로 id와 패스워드를 주고 결과값을 AccountVO로 받으며
				 * 로그인 성공시 AccountVO의 데이터가 존재하며 실패했을경우 null을 받는다.
				 * */
				AccountVO avo = lm.login(jtfId.getText(), String.valueOf(jtfPw.getPassword())); // 로그인 시도.
				lm.close(); // 로그인이 끝났으므로 로그인모듈을 종료한다.
				
				// AccountVO데이터의 존재 여부가 로그인 성공 여부이므로 조건분기한다.
				if (avo != null){ // 로그인 성공시
					mc.setAvo(avo); // VO를 총괄하는 MainClass에 VO를 이관한다.
					mc.changeCardLayout("productList"); // 로그인이 끝났으므로 화면을 상품 리스트로 전환한다.
				} else { // 로그인 실패시
					new CommonDialog(mc.getMf(), "로그인에 실패했습니다."); // 로그인 실패 에러 다이얼 로그 출력
				} // if end
			}
			catch (ConnectException e1) { // 서버 접속 시간이 초과되었을 경우 
				new CommonDialog(mc.getMf(), "서버에 접속할 수 없습니다."); // 에러 다이얼 로그 출력
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // try end
		} else if (e.getSource() == sbtnReg) { // 회원가입 버튼을 눌렀을시
				mc.changeCardLayout("register"); // 회원가입 패널로 전환.
		} 
	} // actionPerformed override method end

	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource()==jtfId || e.getSource()==jtfPw){	// ID 입력창과 비밀번호 입력창에 글씨를 입력할 때마다 조건 검사
			if(jtfId.getText().length()>0 && String.valueOf(jtfPw.getPassword()).length()>0){ // ID와 PW 입력칸 에공백이 없어야 로그인 버튼을 활성화
				sbtnLogin.setEnabled(true);
			} else {	
				sbtnLogin.setEnabled(false);	// 공백이 있으면 로그인 버튼 비활성화
			}
		}
	}

}
