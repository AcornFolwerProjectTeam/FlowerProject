package com.flower.client;

import java.awt.CardLayout;

import com.flower.client.container.SingleContainPanal;
import com.flower.client.login.LoginPanel;

public class MainClass {
	// 필드변수
	CardLayout cly; // 카드레이아웃
	SingleContainPanal loginScp; // 패널을 중앙 정렬 시켜주는 백패널
	LoginPanel lp; // 로그인 패널
	MainFrame mf; // 메인프레임

	// --- Constructors ---
	// 기본생성자 : 필드 변수 초기화 및 객체 생성
	public MainClass() {
		// 설정값
		cly = new CardLayout(); // 컨테이너를 스위칭해줄 카드 레이아웃
		// 로그인 컨테이너 및 컴포넌트
		mf = new MainFrame(); // 메인 프레임 생성 및 화면을 띄움.
		lp = new LoginPanel(); // 로그인 패널
		loginScp = new SingleContainPanal(mf, lp); // 로그인용 중앙정렬 컨테이너 생성 및 매개값 전달.
		// 회원가입 컨테이너 및 컴포넌트
	}
	// --- Constructors end ---
	
	// changeCardLayout method
	/**
	 * 메인프레임에서 보여줄 패널을 변경한다.
	 * 
	 * @param 보여줄 패널의 이름 문자열
	 * */
	public void changeCardLayout(String taget) {
		cly.show(mf.getContentPane(), taget); // 메인프레임 패널 이동
	} // changeCardLayout method end
	
	// main method : 프로그램 시작점 메인메서드
	public static void main(String[] args) {
		MainClass mc = new MainClass(); // 메인 객체 생성
		
		// 컨테이너 구축
		// 기본설정
		mc.mf.setLayout(mc.cly); // 메인프레임 배치관리자를 카드레이아웃으로
		// 로그인
		mc.mf.add(mc.loginScp, "login"); // 프레임에 로그인 패널 추가.
		
		// 회원가입
		
		// 화면 처리
		mc.mf.setVisible(true); // 프레임윈도우를 화면에 띄운다.
		
		
	} // main method end

}
