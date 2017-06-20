package com.flower.server.DAO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

public class SignInDAO extends Connect {
	HashMap<String, String> hm;
	String userId;
	String userPw;
	String userName;
	String userTel;


	public SignInDAO(HashMap<String, String> hm) {
		this.hm = hm;
		userId = hm.get("id");
		userPw = hm.get("pw");
		userName = hm.get("name");
		userTel = hm.get("phone");

	}

	public HashMap<String, String> check() {
		sb.setLength(0);
		sb.append("INSERT INTO ACCOUNT ");
		sb.append("VALUES (customerCode.nextval, ?, ?, ? ,?) ");
		
		HashMap<String, String> signInMap = new HashMap<String,String>();
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			pstmt.setString(3, userName);
			pstmt.setString(4, userTel);

			result = pstmt.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException e) {
			signInMap.put("respond", "error");
			signInMap.put("message", "please check id and password");
		} catch (SQLException e) {
			e.printStackTrace();
		} // try - catch ends
		
		if(result > 0){
			System.out.println("¼º°ø");
			signInMap.put("respond", "okay");
			signInMap.put("message", "success");
			
		} 
		
		return signInMap;
	}

}
