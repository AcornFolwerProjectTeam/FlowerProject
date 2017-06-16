package com.flower.clinet.config;

import java.awt.Color;
import java.awt.Font;

/**
 * 환경변수 클래스로 테마색상, 공통변수 등 저장해두는 전역 변수 클래스이다.
 * */
public class EnVal {
	/**
	 * 프로젝트 테마 메인컬러. (RGB : 34, 41, 68)
	 * */
	public static Color MAINCOLOR = new Color(34, 41, 68);
	
	/**
	 * 버튼 폰트 (맑은고딕/굵게/크기14)
	 * */
	public static Font BUTTONFONT = new Font("맑은 고딕", Font.BOLD, 14);
	
	/**
	 * 레이블 강조 폰트 (맑은고딕/굵게/크기14)
	 * */
	public static Font LABLEFONT = new Font("맑은 고딕", Font.BOLD, 13);
	
	/**
	 * 게시판 한페이지에 보여줄 게시물수
	 * */
	public static int BOARDVIEWNUM = 10;
	
	/**
	 * 게시판 한페이지에 보여줄 페이지수
	 * */
	public static int BOARDPAGENUM = 5;
	
	/**
	 * 서버 IP
	 * */
	public static String SERVERIP = "192.168.0.201";
	
	/**
	 * 서버 포트번호
	 * */
	public static int SERVERPORT = 5000;
	
	/**
	 * 채팅 포트번호
	 * */
	public static int CHATPORT = 5001;
}
