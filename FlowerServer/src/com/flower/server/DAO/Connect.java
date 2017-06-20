package com.flower.server.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	// 1. ȯ�� ����
	String driver = "oracle.jdbc.driver.OracleDriver";
	// test server
	// String url = "jdbc:oracle:thin:@192.168.0.201:1521:orcl";
	String url = "jdbc:oracle:thin:@orcl.ckjncc7mkeew.ap-northeast-2.rds.amazonaws.com:1521:orcl";
	String user = "scott";
	String pw = "tigertiger";

	Connection conn = null;
	StringBuffer sb = new StringBuffer();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Connect() {
		System.out.println("connect()");
		try {
			// 2. ����̹� �ε�
			Class.forName(driver);
			// 3. db ����
			conn = DriverManager.getConnection(url, user, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("db access error");
			e.printStackTrace();
		}
	} // constructor ends : db access

	// �ڿ��ݳ� �޼���
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}// class ends
