package com.flower.server.DAO;

import java.sql.SQLException;

public class OrderDAO extends Connect {
	/*
	 * private int orderCode; private int customerCode; private String revTime;
	 * 실제 db에서는 date private String revTel; private String message;
	 */

	// 생성자 호출 시 오라클 서버에 접속
	public OrderDAO() {
		new Connect();
	}

	public Object[][] order(){
		// sql문 초기화
		sb.setLength(0);
		
		// sql문 작성
		sb.append("SELECT orderCode, customerCode, revTime, revTel, message ");
		sb.append("FROM orderlist ");
		// object 준비
		Object[][] obj = null;
		
		try {
			// 쿼리 실행
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			// 커서를 결과의 제일 마지막 행으로 이동
			rs.last();
			// 해당 행의 index를 가져옴(즉, 전체 rowCound 도출)
			int rowCount = rs.getRow();
			for(int i = 0; i <rowCount; i++){
				obj = new Object[i][];
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Object[][] obj = new Object[][5];
		
		
		
		return null;
	}

}
