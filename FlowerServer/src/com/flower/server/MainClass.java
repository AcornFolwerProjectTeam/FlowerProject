package com.flower.server;

import com.flower.server.DAO.MainServer;

public class MainClass {
	public static void main(String[] args) {
		// 로그인, 회원가입, 제품정보, 주문 서버 호출
		new MainServer();
	}
}
