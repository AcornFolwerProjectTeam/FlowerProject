package com.flower.server.DAO;

import java.sql.SQLException;

public class OrderDAO extends Connect {
	/*
	 * private int orderCode; private int customerCode; private String revTime;
	 * ���� db������ date private String revTel; private String message;
	 */

	// ������ ȣ�� �� ����Ŭ ������ ����
	public OrderDAO() {
		new Connect();
	}

	public Object[][] order(){
		// sql�� �ʱ�ȭ
		sb.setLength(0);
		
		// sql�� �ۼ�
		sb.append("SELECT orderCode, customerCode, revTime, revTel, message ");
		sb.append("FROM orderlist ");
		// object �غ�
		Object[][] obj = null;
		
		try {
			// ���� ����
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			// Ŀ���� ����� ���� ������ ������ �̵�
			rs.last();
			// �ش� ���� index�� ������(��, ��ü rowCound ����)
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
