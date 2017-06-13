package com.flower.client;

import java.awt.Dimension;

import javax.swing.JFrame;

// MainFrame class : 프로그램 시작점 클래스.
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	// --- Constructor ---
	public MainFrame() {
		// 초기 설정
		setTitle("La Fleur"); // 제목 표시줄의 제목.
		setLocation(150, 150); // 윈도우의 화면상 초기위치
		getContentPane().setPreferredSize(new Dimension(600, 800)); // 초기 컨덴츠 패널 크기
		pack(); // 컨텐츠 패널을 패키지화 한다.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 제목 표시줄 종료버튼의 기본 동작을 프로그램 종료로 한다.
		// 초기설정 끝
		
		// TODO : 패널 추가 코드 를 넣을 영역
		
		// 화면 띄우기
		setVisible(true); // 화면에 윈도우를 띄운다.
		setMinimumSize(getSize()); // 초기 띄워진 윈도우 크기를 기준으로 윈도우 최소 크기를 고정한다.
	}
	// --- Constructor end ---
	
	// main method : 프로그램 시작점 메인메서드
	public static void main(String[] args) {
		new MainFrame(); // 윈도우를 띄운다.
	}
	// main method end

} // MainFrame class end
