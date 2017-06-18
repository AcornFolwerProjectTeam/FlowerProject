package com.flower.client;

import java.awt.CardLayout;

import com.flower.client.container.SingleContainPanal;
import com.flower.client.board.BoardWritePanel;
import com.flower.client.container.MenuContainPanal;
import com.flower.client.login.LoginPanel;
import com.flower.client.register.RegisterPanel;

public class MainClass {
	// 필드변수
	private CardLayout cly; // 카드레이아웃
	private MainFrame mf; // 메인프레임
	private LoginPanel loginPanel; // 로그인 패널
	private SingleContainPanal loginScp; // 로그인패널 가운데 정렬 컨테인 패널
	private RegisterPanel registerPanel; // 회원가입 패널
	private MenuContainPanal registerMcp; // 회원가입 패널 가운데 정렬 컨테인 패널
	private BoardWritePanel boardWritePanel; // 상품 후기 쓰기 패널(게시판 쓰기모듈)
	private MenuContainPanal boardWriteMcp; // 상품 후기 쓰기 패널 가운데 정렬 컨테인 패널
	

	// --- Constructors ---
	// 기본생성자 : 필드 변수 초기화 및 객체 생성
	public MainClass() {
		// 설정값
		cly = new CardLayout(); // 컨테이너를 스위칭해줄 카드 레이아웃
		// 로그인 컨테이너 및 컴포넌트
		mf = new MainFrame(); // 메인 프레임 생성 및 화면을 띄움.
		loginPanel = new LoginPanel(this); // 로그인 패널
		loginScp = new SingleContainPanal(mf, loginPanel); // 로그인용 중앙정렬 컨테이너 생성 및 매개값 전달.
		// 회원가입 컨테이너 및 컴포넌트
		registerPanel = new RegisterPanel(this); // 회원가입 패널
		registerMcp = new MenuContainPanal(mf, registerPanel, this, false); // 회원가입용 주앙정렬 컨테이너 생성 및 매개값 전달.
		// 상품후기 컨테이너 및 컴포넌트
		boardWritePanel = new BoardWritePanel(this);
		boardWriteMcp = new MenuContainPanal(mf, boardWritePanel, this, true); // 회원가입용 주앙정렬 컨테이너 생성 및 매개값 전달.
	}
	// --- Constructors end ---
	
	// changeCardLayout method
	/**
	 * 메인프레임에서 보여줄 패널을 변경한다.
	 * 
	 * @param 보여줄 패널의 이름 문자열
	 * */
	public void changeCardLayout(String taget) {
		//System.out.println(taget);
		cly.show(mf.getContentPane(), taget); // 메인프레임 패널 이동
	} // changeCardLayout method end
	
	
	public MainFrame getMf() {
		return mf;
	}

	// main method : 프로그램 시작점 메인메서드
	public static void main(String[] args) {
		MainClass mc = new MainClass(); // 메인 객체 생성
		
		// 컨테이너 구축
		// 기본설정
		mc.mf.setLayout(mc.cly); // 메인프레임 배치관리자를 카드레이아웃으로
		
		// 로그인
		mc.mf.add(mc.loginScp, "login"); // 프레임에 로그인 패널 추가.
		// 회원가입
		mc.mf.add(mc.registerMcp, "register"); // 프레임에 회원가입 패널 추가.
		// 상품 후기 쓰기
		mc.mf.add(mc.boardWriteMcp, "postscript"); // 구매 후기 쓰기 패널 추가.
		
		// 화면 처리
		mc.mf.setVisible(true); // 프레임윈도우를 화면에 띄운다.
		
		
	} // main method end

}
