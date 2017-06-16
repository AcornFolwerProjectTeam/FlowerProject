package com.flower.server.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	// 1. ȯ�� ����
	String driver = "oracle.jdbc.driver.OracleDriver"; 
	String url = "jdbc:oracle:thin:@192.168.0.201:1521:orcl"; 
	String user = "scott";
	String pw = "tiger";
	
	Connection conn = null;
	StringBuffer sb = new StringBuffer();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public DAO() {
		try {
			// 2. ����̹� �ε�
			Class.forName(driver);
			// 3. db ����
			conn = DriverManager.getConnection(url, user, pw);
			if(conn != null){
				System.out.println("db�� ����Ǿ����ϴ�");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("db access error");
			e.printStackTrace();
		} // try - catch end
			
	} // constructor ends : db access
	
}// class ends
