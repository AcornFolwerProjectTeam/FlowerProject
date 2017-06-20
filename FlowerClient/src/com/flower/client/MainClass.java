package com.flower.client;

import java.awt.CardLayout;
import java.io.IOException;

import com.flower.client.container.SingleContainPanal;
import com.flower.client.board.BoardWritePanel;
import com.flower.client.container.MenuContainPanal;
import com.flower.client.login.LoginPanel;
import com.flower.client.orderconfirm.OrderListPanel;
import com.flower.client.productlist.ProductPanel;
import com.flower.client.register.RegisterPanel;
import com.flower.vo.AccountVO;

public class MainClass {
	// 필드변수
	private CardLayout cly; // 카드레이아웃
	private MainFrame mf; // 메인프레임
	private LoginPanel loginPanel; // 로그인 패널
	private SingleContainPanal loginScp; // 로그인패널 가운데 정렬 컨테인 패널
	private RegisterPanel registerPanel; // 회원가입 패널
	private MenuContainPanal registerMcp; // 회원가입 패널 가운데 정렬 컨테인 패널
	private ProductPanel productPanel; // 상품 리스트 패널
	private MenuContainPanal productMcp; // 상품 리스트 패널 가운데 정렬 컨테인 패널
	private OrderListPanel orderListPanel; // 주문 목록 패널
	private MenuContainPanal orderListMcp; // 주문 목록 패널 가운데 정렬 컨테인 패널
	private BoardWritePanel boardWritePanel; // 상품 후기 쓰기 패널(게시판 쓰기모듈)
	private MenuContainPanal boardWriteMcp; // 상품 후기 쓰기 패널 가운데 정렬 컨테인 패널
	private Boolean chatFlag;	// 채팅창이 켜져 있는지를 판별하는 변수
	
	// 필드VO
	private AccountVO avo;

	// --- Constructors ---
	// 기본생성자 : 필드 변수 초기화 및 객체 생성
	public MainClass() {
		// 설정값
		cly = new CardLayout(); // 컨테이너를 스위칭해줄 카드 레이아웃
		chatFlag = false; // ChatDialog 실행 판별
		
		// 로그인 컨테이너 및 컴포넌트
		mf = new MainFrame(); // 메인 프레임 생성 및 화면을 띄움.
		loginPanel = new LoginPanel(this); // 로그인 패널 생성
		loginScp = new SingleContainPanal(mf, loginPanel); // 로그인용 중앙정렬 컨테이너 생성 및 매개값 전달.
		// 회원가입 컨테이너 및 컴포넌트
		registerPanel = new RegisterPanel(this); // 회원가입 패널 생성
		registerMcp = new MenuContainPanal(mf, registerPanel, this, false); // 회원가입용 주앙정렬 컨테이너 생성 및 매개값 전달.
		// 주문 목록 컨테이너 및 컴포넌트
		orderListPanel = new OrderListPanel(this); // 주문 목록 패널 생성
		orderListMcp = new MenuContainPanal(mf, orderListPanel, this, true); // 주문목록용 중앙정렬 컨테이너 생성 및 매개값 전달
		// 상품후기 컨테이너 및 컴포넌트
		boardWritePanel = new BoardWritePanel(this); // 상품 후기 패널 생성
		boardWriteMcp = new MenuContainPanal(mf, boardWritePanel, this, true); // 회원가입용 주앙정렬 컨테이너 생성 및 매개값 전달.
	}
	// --- Constructors end ---

	// 생성하는 순간부터 서버에 접속하는 패널들은 타이밍 조절을 위해 별도 메서드로 분리한다.
	public void loginPass() {
		// 상품 목록 컨테이너 및 컴포넌트
		try {
			productPanel = new ProductPanel(this);
			productMcp = new MenuContainPanal(mf, productPanel, this, true); // 상품목록용 중앙정렬 컨테이너 생성 및 매개값 전달
			mf.add(productMcp, "productList"); // 상품 리스트.
			changeCardLayout("productList"); // 로그인이 끝났으므로 화면을 상품 리스트로 전환한다.
		} catch (IOException e) {
			// TODO : 에러 페이지 이동 코드 필요
			e.printStackTrace();
		} // 상품 목록 패널 생성
	} // end loginPass method
	
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
		
		// 화면 추가.
		mc.mf.add(mc.loginScp, "login"); // 프레임에 로그인 패널 추가.
		mc.mf.add(mc.registerMcp, "register"); // 프레임에 회원가입 패널 추가.
		mc.mf.add(mc.orderListMcp, "orderList"); // 주문 목록 패널 추가.
		mc.mf.add(mc.boardWriteMcp, "postscript"); // 구매 후기 쓰기 패널 추가.
		
		// 화면 처리
		mc.mf.setVisible(true); // 프레임윈도우를 화면에 띄운다.
		
		
	} // main method end

	
	// --- Getter and Setter ---
	public AccountVO getAvo() {
		return avo;
	}

	public void setAvo(AccountVO avo) {
		this.avo = avo;
	}

	public Boolean getChatFlag() {
		return chatFlag;
	}

	public void setChatFlag(Boolean chatFlag) {
		this.chatFlag = chatFlag;
	}
	
	
	// --- Getter and Setter end ---
}
