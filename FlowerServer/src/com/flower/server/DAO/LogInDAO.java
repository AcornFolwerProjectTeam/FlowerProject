package com.flower.server.DAO;

import java.sql.SQLException;
import java.util.HashMap;

public class LogInDAO extends Connect {
	HashMap<String, String> hm = null;
	String userId;
	String userPw;
	// fields

	public LogInDAO(HashMap<String, String> hm) {
		super();
		this.hm = hm;
		userId = hm.get("id");
		userPw = hm.get("password");

		new Connect();
	} // constructor with HashMap field ends

	public HashMap<String, String> check() {
		sb.setLength(0);
		sb.append("SELECT id, pw, name, tel ");
		sb.append("FROM ACCOUNT ");
		sb.append("WHERE id = ? and pw = ? ");
		HashMap<String, String> accountMap = new HashMap<String, String>();

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				accountMap.put("respond", "okay");
				accountMap.put("id", rs.getString("id"));
				accountMap.put("name", rs.getString("name"));
				accountMap.put("tel", rs.getString("tel"));
			} else {
				accountMap.put("respond", "error");
			}

		} catch (SQLException e) {
			System.out.println("SQL error");
			e.printStackTrace();
		} // try - catch ends

		return accountMap;
	} // check method ends

}// class ends
