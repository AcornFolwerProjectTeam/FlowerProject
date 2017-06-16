package com.flower.client.register;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;
import com.flower.client.model.RegisterModule;

@SuppressWarnings("serial")
public class RegisterPanel extends JPanel implements ActionListener, CaretListener{
	// TODO: 공백일 때 db 연결 안되도록 조건 걸기
	
	// GUI 변수
	private MainClass mc;
	private JScrollPane jspAgreement;
	private JTextArea jtaAgreement;
	private JLabel jlbId, jlbPw, jlbPwConfirm, jlbName, jlbPhone;	
	private JLabel jlbIdMsg, jlbPwMsg, jlbPwConfirmMsg; 
	private JTextField jtfId, jtfName, jtfPhone;
	private JPasswordField jtfPwConfirm, jtfPw;
	private StyleButton sbtnCancel;
	private EmphasisButton ebtnEnter;
	private JCheckBox jcbAgree;
	private Font flb;
	private Font flbmsg;
	// 약관동의 내용 변수
	private BufferedReader br;
	private StringBuffer term;
	// 서버 연결
	private RegisterModule rm;
	
	
	// ------- Constructor ---------
	public RegisterPanel(MainClass mc) {
		this.mc = mc;
		flb = new Font("맑은 고딕", Font.BOLD, 13); // JLabel 폰트
		flbmsg = new Font("맑은 고딕", Font.PLAIN, 11);	// 경고 메세지, 체크박스 폰트
		
		// 패널 초기 설정
		setLayout(null);
		setBackground(Color.WHITE);
		
		// 약관동의 내용 가지고 오기
		term = new StringBuffer();
		
		try {
			br = new BufferedReader(new FileReader(new File("src/File/terms.txt")));	// BufferedReader를 이용하여 약관 동의 내용을 읽어온다.
			while(br.readLine()!=null){	// 파일이 끝날 때까지 약관 동의 내용을 읽어온다.
				term.append(br.readLine()+"\n");	// 기존 내용에 1줄씩 읽어온 내용을 추가한다.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		jtaAgreement = new JTextArea(term.toString()); // 약관동의 내용이 담긴 JTextArea 생성
		jtaAgreement.setLineWrap(true);	// JTextArea의 가로 크기에 따라 자동 줄바꿈
		jspAgreement = new JScrollPane(jtaAgreement, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 약관동의 내용 스크롤
		jspAgreement.setBounds(30, 160, 250, 330); // 약관동의 내용 크기, 위치 지정
		
		
		
		add(jspAgreement);	// 약관동의 내용 부착
		
		// 약관동의 체크박스
		jcbAgree = new JCheckBox("약관에 동의합니다."); // 체크박스 생성
		jcbAgree.setFont(flbmsg);	// 체크박스 폰트 설정
		jcbAgree.setBounds(30, 490, 250, 20);	// 체크박스 크기, 위치 지정
		jcbAgree.setBackground(Color.WHITE);	// 체크박스 배경
		add(jcbAgree);	// 체크박스 부착
		
		// ID 라벨
		jlbId = new JLabel("ID");	//ID 라벨 생성
		jlbId.setFont(flb); // 영문 글씨가 다른 라벨에 비해 작게 보이므로 font 설정한다.
		jlbId.setBounds(310, 178, 40, 20); // ID 라벨 크기, 위치 지정
		add(jlbId);	// ID 라벨 부착
		
		// PW 라벨
		jlbPw = new JLabel("비밀번호"); // PW 라벨 생성
		jlbPw.setBounds(310, 247, 60, 20);	// PW 라벨 크기, 위치 지정
		add(jlbPw);	// PW 라벨 부착
	
		// PW 확인 라벨
		jlbPwConfirm = new JLabel("<html> 비밀번호<br>확인</html>"); // PW 확인 라벨 생성
		jlbPwConfirm.setBounds(310, 305, 60, 35); // 비밀번호 확인 라벨: 줄바꿈 때문에 크기 다르다.
		add(jlbPwConfirm);	// PW 확인 라벨 부착
		
		// 이름 라벨
		jlbName = new JLabel("이름");	// 이름 라벨 생성
		jlbName.setBounds(310, 377, 40, 20);	// 이름 라벨 크기, 위치 지정
		add(jlbName);	// 이름 라벨 부착
		
		// 핸드폰 번호 라벨
		jlbPhone = new JLabel("핸드폰번호");	// 핸드폰 번호 라벨 생성
		jlbPhone.setBounds(310, 432, 70, 20);	// 핸드폰 번호 라벨 크기, 위치 지정
		add(jlbPhone);	// 핸드폰번호 라벨 부착
		
		// ID 중복 메시지
		jlbIdMsg = new JLabel();	// ID 중복 메시지 라벨 생성
		jlbIdMsg.setFont(flbmsg);	// ID 중복 메시지 폰트 설정	
		jlbIdMsg.setBounds(400, 205, 200, 20);	// ID 중복 메시지 크기, 위치 지정
		add(jlbIdMsg);	// ID 중복 메시지 라벨 부착
		
		// PW 경고 메시지
		jlbPwMsg = new JLabel();	// PW 경고 메시지 라벨 생성
		jlbPwMsg.setFont(flbmsg);	// PW 경고 메시지 폰트 설정
		jlbPwMsg.setBounds(400, 270, 200, 20);	// PW 경고 메시지 크기, 위치 지정
		add(jlbPwMsg);	// PW 경고 메시지 라벨 부착
		
		// PW 재입력
		jtfPwConfirm = new JPasswordField();	// PW 재입력칸 생성
		jtfPwConfirm.setBounds(400, 305, 160, 30);	// PW 재입력칸 크기, 위치 지정
		jtfPwConfirm.addCaretListener(this);
		add(jtfPwConfirm);	// PW 재입력칸 부착
		
		// PW 확인 경고 메시지
		jlbPwConfirmMsg = new JLabel();	// PW 확인 경고 메시지 라벨 생성
		jlbPwConfirmMsg.setFont(flbmsg);	// PW 확인 경고	 메시지 라벨 폰트 설정
		jlbPwConfirmMsg.setBounds(400, 335, 200, 20);	// PW 확인 경고 메시지 크기, 위치 지정
		add(jlbPwConfirmMsg);	// PW 확인 경고 메시지 라벨 부착
		
		// ID 입력
		jtfId = new JTextField();	// ID 입력칸 생성
		jtfId.setBounds(400, 175, 160, 30);	// ID 입력칸 크기, 위치 지정
		jtfId.addCaretListener(this); // ID 입력할 때 경고 메시지 입력
		add(jtfId);	// ID 입력칸 부착
		
		// PW 입력
		jtfPw = new JPasswordField(); // PW 입력칸 생성
		jtfPw.setBounds(400, 240, 160, 30); // PW 입력칸 크기, 위치 지정
		jtfPw.addCaretListener(this);
		add(jtfPw); // PW 입력칸 부착
		
		
		// 이름 입력
		jtfName = new JTextField();	// 이름 입력칸 생성
		jtfName.setBounds(400, 370, 160, 30);	// 이름 입력칸 크기, 위치 지정
		add(jtfName);	// 이름 입력칸 부착
		
		// 핸드폰번호 입력
		jtfPhone = new JTextField();	// 핸드폰번호 입력칸 생성
		jtfPhone.setBounds(400, 425, 160, 30);	// 핸드폰번호 입력칸 크기, 위치 지정
		add(jtfPhone);	// 핸드폰번호 입력칸 부착
				
		// 취소 버튼
		sbtnCancel = new StyleButton("취소");	// 취소버튼 생성: 기본버튼
		sbtnCancel.setBounds(180, 560, 120, 40);	// 취소버튼 크기, 위치 지정
		sbtnCancel.addActionListener(this);	// 취소버튼에 ActionListener 부착
		add(sbtnCancel);	// 취소버튼 부착
		
		
		// 확인 버튼
		ebtnEnter = new EmphasisButton("가입 완료");	// 확인버튼 생성: 강조버튼
		ebtnEnter.setBounds(310, 560, 120, 40);	// 확인버튼 크기, 위치 지정
		ebtnEnter.addActionListener(this); // 확인 버튼에 ActionListener 부착
		add(ebtnEnter); // 확인버튼 부착

	} // Constructor End

	@Override
	public void caretUpdate(CaretEvent e) {	// ID, PW, PW 동일한지 확인
		if (e.getSource()==jtfId){	// ID 입력할 때
			if(jtfId.getText().length()>15 || jtfId.getText().length()<8){	// 8자 이상 15자 이하 경고
				jlbIdMsg.setForeground(Color.RED);	// 빨간색 글씨로 출력
				jlbIdMsg.setText("8자 이상~15자 이하를 입력하세요.");	// 메시지 변경
			} else {
				jlbIdMsg.setText("");	// 8자 이상 15자 이하면 경고 메시지 없애기
			}
			
		}  else if (e.getSource()==jtfPw){	// PW 입력할 때
			if(String.valueOf(jtfPw.getPassword()).length()>15 || String.valueOf(jtfPw.getPassword()).length()<8){	// 8자 이상 15자 이하 경고
				jlbPwMsg.setForeground(Color.RED);	// 빨간색 글씨로 출력
				jlbPwMsg.setText("8자 이상~15자 이하를 입력하세요.");	// 메시지 변경
			} else {
				jlbPwMsg.setText("");	// 8자 이상 15자 이하면 경고 메시지 없애기
			}
		} else if (e.getSource()==jtfPwConfirm){	// PW 확인창 입력할 때
			if(!String.valueOf(jtfPwConfirm.getPassword()).equals(String.valueOf(jtfPw.getPassword()))){	// 비밀번호와 비밀번호 확인칸이 일치하지 않으면 경고
				jlbPwConfirmMsg.setForeground(Color.RED);	// 빨간색 글씨로 출력
				jlbPwConfirmMsg.setText("비밀번호가 일치하지 않습니다.");	// 메시지 변경
			} else {
				jlbPwConfirmMsg.setText("");	// 비밀번호와 비밀번호 확인칸이 일치하면 경고 메시지 없애기
			}
		}
	}	// Override end

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnCancel){	// 취소버튼 클릭
			mc.changeCardLayout("login");	//  로그인 패널로 돌아가기
		} else if(e.getSource()==ebtnEnter){	// 가입완료 버튼 클릭
			
			if(jtfId.getText().length()<=15 && jtfId.getText().length()>=8 &&
					String.valueOf(jtfPw.getPassword()).length()<=15 && String.valueOf(jtfPw.getPassword()).length()>=8 &&
					String.valueOf(jtfPwConfirm.getPassword()).equals(String.valueOf(jtfPw.getPassword()))){ // 회원가입 조건 전부 만족하면
				
				rm = new RegisterModule();	// 서버 연결 객체 설정
				Boolean flag = rm.register(jtfId.getText(), String.valueOf(jtfPw.getPassword()), jtfName.getText(), jtfPhone.getText());
				rm.close();
				
				System.out.println("객체 연결");
				
				if((flag==true) && (jcbAgree.isSelected()==true)){
					mc.changeCardLayout("product");
				}
			}
		}
	}

}
	

