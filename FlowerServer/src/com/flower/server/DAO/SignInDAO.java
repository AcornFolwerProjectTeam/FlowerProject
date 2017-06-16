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
		super();
		this.hm = hm;
		userId = hm.get("id");
		userPw = hm.get("pw");
		userName = hm.get("name");
		userTel = hm.get("phone");

		new Connect();
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
			System.out.println("실패");
			signInMap.put("respond", "error");
			signInMap.put("message", "id_error");
		} catch (SQLException e) {
			e.printStackTrace();
		} // try - catch ends
		
		if(result > 0){
			System.out.println("성공");
			signInMap.put("respond", "okay");
			signInMap.put("message", "success");
			
		} else {
			System.out.println("실패");
			signInMap.put("respond", "error");
			signInMap.put("message", "id_error");
		}
		
		return signInMap;
	}

}
