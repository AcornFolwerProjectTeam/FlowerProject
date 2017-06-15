package com.flower.client;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

// MainFrame class : 프로그램 시작점 클래스.
@SuppressWarnings("serial") // 시리얼 번호는 쓰지않는다.
public class MainFrame extends JFrame {

	// --- Constructor ---
	// 기본 생성자
	public MainFrame() {
		// 초기 설정
		setTitle("La Fleur"); // 제목 표시줄의 제목.
		setLocation(150, 150); // 윈도우의 화면상 초기위치
		getContentPane().setPreferredSize(new Dimension(600, 800)); // 초기 컨덴츠 패널 크기
		pack(); // 컨텐츠 패널을 패키지화 한다.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 제목 표시줄 종료버튼의 기본 동작을 프로그램 종료로 한다.
		Image img = Toolkit.getDefaultToolkit().getImage("imgs/menubarlogo.png"); // 아이콘을 가져온다.
		setIconImage(img); // 제목표시줄 아이콘 변경
		// 초기설정 끝
		
		// TODO : 패널 추가 코드 를 넣을 영역
		
		setMinimumSize(getSize()); // 초기 띄워진 윈도우 크기를 기준으로 윈도우 최소 크기를 고정한다.
	}
	// --- Constructor end ---

} // MainFrame class end
