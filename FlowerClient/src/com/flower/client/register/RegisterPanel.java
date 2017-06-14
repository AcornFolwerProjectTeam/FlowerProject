package com.flower.client.register;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;

@SuppressWarnings("serial")
public class RegisterPanel extends JPanel{
	
	private JScrollPane jspAgreement;
	private JTextArea jtaAgreement;
	private JLabel jlbId, jlbPw, jlbPwConfirm, jlbName, jlbPhone;	
	private JLabel jlbIdMsg, jlbPwMsg, jlbPwConfirmMsg; 
	private JTextField jtfId, jtfName, jtfPhone;
	private JPasswordField jtfPw, jtfPwConfirm;
	private StyleButton sbtnCancel;
	private EmphasisButton ebtnEnter;
	private JCheckBox jcbAgree;
	private RegisterMenuBar menuBar;
	private BottomBar bottomBar;
	
	// ------- Constructor ---------
	public RegisterPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		
		// 메뉴 바 & 하단 바
		menuBar = new RegisterMenuBar();
		bottomBar = new BottomBar();
		
		// 약관동의
		jtaAgreement = new JTextArea();
		jspAgreement = new JScrollPane(jtaAgreement, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jcbAgree = new JCheckBox("약관에 동의합니다."); // 약관 동의 체크박스
		
		// 개인정보 입력 라벨
		jlbId = new JLabel("ID");
		jlbPw = new JLabel("비밀번호");
		jlbPwConfirm = new JLabel("<html> 비밀번호<br>확인</html>"); // 줄바꿈 필요
		jlbName = new JLabel("이름");
		jlbPhone = new JLabel("핸드폰번호");
		jlbIdMsg = new JLabel("중복된 ID가 존재합니다.");
		jlbPwMsg = new JLabel("올바른 비밀번호를 입력해주세요.");
		jlbPwConfirmMsg = new JLabel("비밀번호가 일치하지 않습니다.");
		
		// Font 설정
		Font flb = new Font("맑은 고딕", Font.BOLD, 13); // JLabel 폰트
		Font flbmsg = new Font("맑은 고딕", Font.PLAIN, 11);	// 경고 메세지, 체크박스 폰트
		jlbId.setFont(flb); // 영문 글씨가 다른 라벨에 비해 작게 보여서 font 설정
		jlbIdMsg.setFont(flbmsg);	// ID 경고
		jlbPwMsg.setFont(flbmsg);	// PW 경고
		jlbPwConfirmMsg.setFont(flbmsg);	// PW 확인 경고
		jcbAgree.setFont(flbmsg);	// 체크박스
		
		// 개인정보 입력 칸
		jtfId = new JTextField();
		jtfPw = new JPasswordField();
		jtfPwConfirm = new JPasswordField();
		jtfName = new JTextField();
		jtfPhone = new JTextField();
				
		// 버튼
		sbtnCancel = new StyleButton("입력 취소");
		ebtnEnter = new EmphasisButton("확인");
		
		// 크기 위치:약관 동의
		jspAgreement.setBounds(30, 160, 250, 330);
		jcbAgree.setBounds(30, 490, 250, 20);
		jcbAgree.setBackground(Color.WHITE);
		
		// 크기 위치:개인정보 입력 라벨 
		jlbId.setBounds(310, 178, 40, 20);
		jlbPw.setBounds(310, 247, 60, 20);
		jlbPwConfirm.setBounds(310, 305, 60, 35); // 비밀번호 확인 라벨: 줄바꿈 때문에 크기 다르다.
		jlbName.setBounds(310, 377, 40, 20);
		jlbPhone.setBounds(310, 432, 70, 20);
		
		// 크기 위치: 개인정보 입력 라벨 , 경고 메시지
		jtfId.setBounds(400, 175, 160, 30);
		jlbIdMsg.setBounds(400, 205, 200, 20);;
		jtfPw.setBounds(400, 240, 160, 30);
		jlbPwMsg.setBounds(400, 270, 200, 20);
		jtfPwConfirm.setBounds(400, 305, 160, 30);
		jlbPwConfirmMsg.setBounds(400, 335, 200, 20);
		jtfName.setBounds(400, 370, 160, 30);
		jtfPhone.setBounds(400, 425, 160, 30);
		
		// 크기 위치: 버튼
		sbtnCancel.setBounds(180, 560, 120, 40);
		ebtnEnter.setBounds(310, 560, 120, 40);
		
		// 크기 위치: 메뉴바&하단바
		menuBar.setLocation(15, 10);
		bottomBar.setLocation(15,735);
		
		// 컴포넌트 부착
		add(jspAgreement);
		add(jlbId);
		add(jlbPw);
		add(jlbPwConfirm);
		add(jlbName);
		add(jlbPhone);
		add(jtfId);
		add(jtfPw);
		add(jtfPwConfirm);
		add(jtfName);
		add(jtfPhone);
		add(jlbIdMsg);
		add(jlbPwMsg);
		add(jlbPwConfirmMsg);
		add(sbtnCancel);
		add(ebtnEnter);
		add(jcbAgree);
		add(menuBar);
		add(bottomBar);
		
	}
	
	
}
