package com.flower.client.board;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

// PostPanel class
@SuppressWarnings("serial")
public class PostPanel extends JPanel {
	private JLabel jlabGrade;// 등급 레이블
	private JLabel jlabName;// 닉네임 레이블
	private JLabel jlabDate;// 날자 레이블
	private JLabel jlabTitle;// 제목 레이블
	private JLabel jlabImg;// 이미지 레이블
	private JTextArea jtaComment;// 내용 텍스트 에어리어
	
	// --- Constructor ---
	/**
	 * 포스트패널의 기본생성자로 패널 크기 및 컴포넌트 초기 위치등을 설정한다.
	 * */
	public PostPanel() {
		// 기본 설정
		setBackground(Color.WHITE); // 배경색은 흰색으로
		setSize(new Dimension(550, 150)); // 초기 크기 설정
		setLayout(null); // 배치관리자 해제
		
		// 컴포넌트 배치
		// 등급
		jlabGrade = new JLabel(); // 등급 레이블 생성
		jlabGrade.setBounds(10, 10, 70, 20); // 초기위치&크기 설정
		jlabGrade.setForeground(Color.MAGENTA); // 텍스트 색상 변경
		add(jlabGrade); // 패널에 추가한다.
		
		// 닉네임
		jlabName = new JLabel(); // 닉네임 레이블 생성
		jlabName.setHorizontalAlignment(SwingConstants.RIGHT); // 오른쪽 정렬
		jlabName.setBounds(350, 10, 100, 20); // 초기위치&크기 설정
		add(jlabName); // 패널에 추가한다.
		
		// 날자
		jlabDate = new JLabel(); // 날자 레이블 생성
		jlabDate.setBounds(460, 10, 75, 20); // 초기위치&크기 설정
		add(jlabDate); // 패널에 추가한다.
		
		// 제목
		jlabTitle = new JLabel(); // 제목 레이블 생성
		jlabTitle.setBounds(10, 40, 525, 20); // 초기위치&크기 설정
		add(jlabTitle); // 패널에 추가한다.
		
		// 이미지
		jlabImg = new JLabel("N/A"); // 이미지 레이블 생성
		jlabImg.setBounds(10, 70, 70, 70); // 초기위치&크기 설정
		add(jlabImg); // 패널에 추가한다.
		
		// 내용
		jtaComment = new JTextArea(); // 내용 텍스트 에어리어 생성
		jtaComment.setBounds(90, 70, 445, 70); // 초기위치&크기 설정
		jtaComment.setLineWrap(true); // 자동줄바꿈 설정
		jtaComment.setEditable(false); // 편집 불가로 설정
		add(jtaComment); // 패널에 추가한다.
	}
	// --- Constructor end ---
	
	/**
	 * 등급 별 개수를 설정한다.
	 * 1~5값을 받으며 이 범위를 초과하는 값일경우 에러를 막기위해 1, 또는 5가 설정된다.
	 * 
	 * @param grade : 별 개수
	 * */
	public void setGrade(int grade) {
		// 에러를 막기위해 1~5 범위를 벗어난 값은강제로 맞춰버린다.
		if (grade < 1) // 1보다 작을경우 1로
			grade = 1;
		else if (grade > 5) // 5보다 작을경우 5로
			grade = 5;
		
		String star = ""; // 별 문자를 누적할 문자열
		
		// 요구받은 별 개수 만큼 반복하여 별 문자를 누적한다.
		for (int i = 1; i <= grade; i++) { // 1~grade
			star += "★";
		} // for end
		
		jlabGrade.setText(star); // 별 레이블에 누적한 별 문자열을 대입한다.
	} // setGrade method end
	
	/**
	 * 닉네임 레이블 텍스트를 변경한다.
	 * 
	 * @param name : 변경할 텍스트 내용
	 * */
	public void setName(String name) {
		jlabName.setText(name);
	} // setName method end
	
	/**
	 * 날자 레이블 텍스트를 변경한다.
	 * 
	 * @param date : 변경할 날자 텍스트
	 * */
	public void setDate(String date) {
		jlabDate.setText(date);
	} // setDate method end
	
	/**
	 * 제목 레이블 텍스트를 변경한다.
	 * 
	 * @param title : 변경할 제목 내용
	 * */
	public void setTitle(String title) {
		jlabTitle.setText(title);
	} // setTitle method end
	
	/**
	 * 아이콘 레이블의 이미지를 변경한다.
	 * 단순히 경로값만 받으면 내부에서 setIcon으로 처리한다.
	 * 
	 * @param imgPath : 이미지 경로
	 * */
	public void setImg(String imgPath) {
		jlabImg.setIcon(new ImageIcon(imgPath));
	} // setImg method end
	
	/**
	 * 게시글 내용 텍스트를 변경한다.
	 * 
	 * @param comment : 변경할 게시글 내용
	 * */
	public void setComment(String comment) {
		jtaComment.setText(comment);
	} // setComment method end
	
	/**
	 * 닉네임 레이블의 위치를 이동한다.
	 * 
	 * @param x : X좌표
	 * @param y : Y좌표
	 * */
	public void setNameLocation(int x, int y) {
		jlabName.setLocation(x, y); // 닉네임 레이블 위치 설정
	} // setNameLocation method end
	
	/**
	 * 날자 레이블의 위치를 이동한다.
	 * 
	 * @param x : X좌표
	 * @param y : Y좌표
	 * */
	public void setDateLocation(int x, int y) {
		jlabDate.setLocation(x, y); // 날자 레이블 위치 설정
	} // setDateLocation method end
	
	/**
	 * 내용 텍스트 에어리어의 크기를 변경한다.
	 * 
	 * @param width : 너비
	 * @param height : 높이
	 * */
	public void setCommentSize(int width, int height) {
		jtaComment.setSize(width, height); // 내용 텍스트 에어리어 크리 설정
	} // setCommentSize method end
}
// PostPanel class end
