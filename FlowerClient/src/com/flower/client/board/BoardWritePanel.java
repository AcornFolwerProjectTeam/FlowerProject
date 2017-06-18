package com.flower.client.board;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.flower.client.MainClass;
import com.flower.client.component.StyleButton;
import com.flower.clinet.config.EnVal;

/*
 * 2x4 테이블 형태의 인터페이스를 다수의 컨테이너/컴포넌트를 배치하고 보더값을 주어
 * 유사하게 그리는것으로 구현한다.
 * */


// BoardWritePanel class
@SuppressWarnings("serial") // 시리얼 번호는 쓰지 않으므로 경고 무시처리.
public class BoardWritePanel extends JPanel {
	private MainClass mc;
	private JLabel jlabProductName; // 구매 상품명 제목 칸
	private JLabel jlabProductNameVal; // 구매 상품명 표기 칸
	private JLabel jlabGrade; // 평점 제목칸
	private JPanel jpanGrade; // 평점 라디오버튼 격납 컨테이너
	private JRadioButton[] jrbGrade; // 1~5점 라디오 버튼 배열 
	private ButtonGroup bgGrade; // 평점 버튼 그룹 객체
	private JLabel jlabTitle; // 게시글 제목 입력 제목 칸
	private JPanel jpanTitle; // 게시글 제목 텍스트필드 격납용 패널
	private JTextField jtfTitle; // 게시글 제목 기입용 텍스트필드
	private JLabel jlabComment; // 게시글 내용 제목 칸
	private JPanel jpanComment; // 게시글 내용 텍스트 에어리어 격납용 패널
	private JTextArea jtaComment; // 게시글 내용 기입용 텍스트에어리어
	private StyleButton sbtnCancel; // 등록 취소 버튼
	private StyleButton sbtnPost; // 등록(게시글 게시) 버튼
	
	// --- Constructor ---
	public BoardWritePanel(MainClass mc) {
		this.mc = mc; // 컨터롤러 헨들링을 위한 메인클레스를 받는다.
		// 기본설정
		setSize(600, 800); // 크기 설정
		setLayout(null); // 기본 배치관리자 해제
		setBackground(Color.WHITE); // 배경색은 흰색으로
		
		// -- 구매상품명행 --
		// 제목칸
		jlabProductName = new JLabel("구매 상품명"); // 레이블 생성
		jlabProductName.setBounds(30, 60, 101, 41); // 위치 및 크기 설정
		jlabProductName.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		jlabProductName.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		jlabProductName.setFont(EnVal.LABLEFONT); // 폰트 설정
		add(jlabProductName); // 패널에 추가.
		
		// 제목 표기칸
		jlabProductNameVal = new JLabel("  "); // 레이블 생성
		jlabProductNameVal.setBounds(130, 60, 400, 41); // 위치 및 크기 설정
		jlabProductNameVal.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		jlabProductNameVal.setFont(EnVal.LABLEFONT); // 폰트 설정
		add(jlabProductNameVal); // 패널에 추가.
		
		// -- 평점행 --
		// 평점칸
		jlabGrade = new JLabel("평점"); // 레이블 생성
		jlabGrade.setBounds(30, 100, 101, 41); // 위치 및 크기 설정
		jlabGrade.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		jlabGrade.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		jlabGrade.setFont(EnVal.LABLEFONT); // 폰트 설정
		add(jlabGrade); // 패널에 추가.
		
		// 라디오 버튼 생성
		jrbGrade = new JRadioButton[5]; // 배열 개수는 5개(1~5점)
		bgGrade = new ButtonGroup(); // 라디오 버튼을 그룹으로 묶어줄 그룹객체 생성
		// 반복문으로 버튼 생성 및 텍스트에 별 추가 하고 그룹으로 묶는다.
		String star = "";
		for (int i = 0; i < jrbGrade.length; i++) {
			star += "★"; // 별 개수는 반복 한 회수만큼 누적시킴
			jrbGrade[i] = new JRadioButton(star); // 텍스트에 별추가.
			jrbGrade[i].setBackground(Color.WHITE); // 배경색 수정
			jrbGrade[i].setForeground(Color.MAGENTA); // 별 색 수정
			jrbGrade[i].setFocusPainted(false); // 마우스 선택시 뜨는 테두리 제거
			bgGrade.add(jrbGrade[i]); // 그룹에 버튼추가.
		}
		
		// 평점 라디오버튼 격납 컨테이너
		jpanGrade = new JPanel(); // 패널 생성
		jpanGrade.setBounds(130, 100, 400, 41); // 위치 및 크기 설정
		jpanGrade.setBackground(Color.WHITE); // 배경색은 흰색
		jpanGrade.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		// 반복문으로 라디오 버튼을 격납 컨테이너 패널에 추가.
		for (int i = (bgGrade.getButtonCount()-1); i >= 0; i--) {
			jpanGrade.add(jrbGrade[i]);
		}
		jrbGrade[bgGrade.getButtonCount()-1].setSelected(true);
		add(jpanGrade); // 패널에 추가.
		
		// -- 게시글 제목 --
		// 게시글 제목 입력 제목 칸
		jlabTitle = new JLabel("제목"); // 레이블 생성
		jlabTitle.setBounds(30, 140, 101, 41); // 위치 및 크기 설정
		jlabTitle.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		jlabTitle.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		jlabTitle.setFont(EnVal.LABLEFONT); // 폰트 설정
		add(jlabTitle); // 패널에 추가.

		// 게시글 제목 기입용 텍스트필드
		jtfTitle = new JTextField(); // 텍스트 필드 생성
		jtfTitle.setFont(EnVal.LABLEFONT);
		
		// 게시글 제목 텍스트필드 격납용 패널
		jpanTitle = new JPanel(); // 패널 생성
		jpanTitle.setBounds(130, 140, 400, 41); // 위치 및 크기 설정
		jpanTitle.setBackground(Color.WHITE); // 배경색은 흰색
		jpanTitle.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		jpanTitle.setLayout(null); // 기본 배치관리자 해제
		jtfTitle.setBounds(5, 5, jpanTitle.getWidth()-10, jpanTitle.getHeight()-9); // 텍스트 필드 위치 및 크기를 동적지정
		jpanTitle.add(jtfTitle); // 텍스트필드를 격납 컨테이너 패널에 추가.
		add(jpanTitle); // 패널에 추가.
		
		// -- 게시글 내용 --
		jlabComment = new JLabel("내용"); // 레이블 생성
		jlabComment.setBounds(30, 180, 101, 500); // 위치 및 크기 설정
		jlabComment.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
		jlabComment.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		jlabComment.setFont(EnVal.LABLEFONT); // 폰트 설정
		add(jlabComment); // 패널에 추가.

		// 게시글 제목 기입용 텍스트필드
		jtaComment = new JTextArea(); // 텍스트 필드 생성
		jtaComment.setFont(EnVal.LABLEFONT);
		jtaComment.setBorder(new LineBorder(Color.LIGHT_GRAY)); // 테두리 설정
		jtaComment.setLineWrap(true); // 자동 줄바꿈
		
		// 게시글 내용 텍스트필드 격납용 패널
		jpanComment = new JPanel(); // 패널 생성
		jpanComment.setBounds(130, 180, 400, 500); // 위치 및 크기 설정
		jpanComment.setBackground(Color.WHITE); // 배경색은 흰색
		jpanComment.setBorder(new LineBorder(EnVal.MAINCOLOR)); // 테두리 설정
		jpanComment.setLayout(null); // 기본 배치관리자 해제
		jtaComment.setBounds(5, 5, jpanComment.getWidth()-10, jpanComment.getHeight()-9); // 텍스트 필드 위치 및 크기를 동적지정
		jpanComment.add(jtaComment); // 텍스트필드를 격납 컨테이너 패널에 추가.
		add(jpanComment); // 패널에 추가.
		
		// -- 버튼 --
		// 등록 취소 버튼
		sbtnCancel = new StyleButton("등록 취소");
		sbtnCancel.setBounds(150, 695, 140, 40);	// 위치 및 크기 지정
		add(sbtnCancel);
		
		// 등록 버튼
		sbtnPost = new StyleButton("등록");
		sbtnPost.setBounds(310, 695, 140, 40);	// 위치 및 크기 지정 
		add(sbtnPost);
	}
	// --- Constructor end---

	public void setProductName(String productName) {
		jlabProductNameVal.setText("  " + productName); // 상품명 설정
	}
	
} // BoardWritePanel class end
