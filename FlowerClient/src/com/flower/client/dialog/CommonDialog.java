package com.flower.client.dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.flower.client.component.StyleButton;
import com.flower.client.config.EnVal;

/**
 * <p>커스텀 다이얼로그 클래스.</p>
 * 
 * JDialog 상속받아 추가 구현한 커스텀 다이얼로그 클래스로 기본적으로 모달모드로 동작하며
 * 윈도우에서 자체적으로 제공하는 제목표시줄 같은 테마를 사용하지 않는다.
 * */
@SuppressWarnings("serial") // 시리얼 넘버는 사용하지 않으므로 경고 무시처리
public class CommonDialog extends JDialog implements ActionListener {
	private JLabel jlbMsg; // 메시지 출력용 레이블
	private StyleButton sbtnOk; // 확인버튼
	private JPanel jpnBack; // 메시지와 확인버튼을 담을 백패널 
	
	/**
	 * 다이얼 로그 기본생성자로 이 다이얼로그를 소유하는 프레임과 출력할 메시지를 매개로 받는다.
	 * 
	 * @param jframe 이 다이얼로그를 소유할 프레임(메인프레임)
	 * @param msg 다이얼로그에 표기할 메시지
	 * */
	public CommonDialog(JFrame jframe, String msg) {
		super(jframe, true); // 부모 클래스 생성자 호출(프레임 지정 및 모달 모드로 설정)
		
		// 기본설정
		setLayout(null); // 기본 배치관리자 해제
		getContentPane().setBackground(Color.WHITE); // 배경색은 흰색
		setSize(350, 250); // 윈도우 크기 설정
		setLocationRelativeTo(jframe); // 초기 위치는 프레임 중앙
		setResizable(false); // 윈도우 크기조정 불가
		setUndecorated(true); // 제목표시줄 사용 안함
		
		// 컴포넌트 설정
		jpnBack = new JPanel(); // 패널 생성
		jpnBack.setLayout(null); // 기본 배치 관리자 해제
		jpnBack.setBackground(Color.WHITE); // 배경색은 흰색
		jpnBack.setSize(this.getSize()); // 패널 크기는 이 다이얼로그 크기로
		jpnBack.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 지정
		add(jpnBack); // 다이얼로그에 패널 추가.
		
		// 경고메시지 레이블
		jlbMsg = new JLabel(msg); // 레이블 생성 및 메시지 지정
		jlbMsg.setBounds(45, 25, 250, 100); // 위치 및 크기 설정
		jlbMsg.setHorizontalAlignment(SwingConstants.CENTER); // 좌우 가운데 정렬
		jlbMsg.setVerticalAlignment(SwingConstants.CENTER); // 상하 가운데 정렬
		jlbMsg.setFont(EnVal.LABLEFONT); // 폰트 설정
		jpnBack.add(jlbMsg); // 패널에 메시지 추가.
		
		// 확인버튼
		sbtnOk = new StyleButton("확인"); // 버튼 생성 및 텍스트 지정
		sbtnOk.setBounds(125, 140, 100, 40); // 위치 및 크기 설정
		sbtnOk.addActionListener(this); // 이벤트 추가.
		jpnBack.add(sbtnOk); // 패널에 버튼 추가.
		
		setVisible(true); // 윈도우를 활성화한다.
	}

	// actionPerformed override method : 버튼 누를시 처리하는 이벤트 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false); // 윈도우를 비활성화 한다.
	} // actionPerformed override method end
} // CommonDialog end
