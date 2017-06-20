package com.flower.server.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flower.vo.AccountVO;

public class AccountDAO extends Connect {
	// connect 객체를 상속받았기에 호출 시 바로 db에 연결
	
	public AccountDAO() {
		
	} 

	public ArrayList<AccountVO> selectAll() {
		// sql문 초기화
		sb.setLength(0);
		
		// sql문 작성
		sb.append("SELECT * ");
		sb.append("FROM ACCOUNT ");
		
		// vo와 arraylist 생성 및 인스턴스
		AccountVO avo = null;
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		try {
			// sql문 실행
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			// vo에 쿼리문 결과를 담는다
			while (rs.next()) {
				avo = new AccountVO(rs.getInt("customerCode"), rs.getString("id"), rs.getString("pw"),
						rs.getString("name"), rs.getString("tel"));
				// list에 vo 객체를 담는다
				list.add(avo);
			}
		} catch (SQLException e) {
			System.out.println("sql error in selectAll method");
			e.printStackTrace();
		} 
		// return list
		return list;
	} // selectAll method ends

	public AccountVO selectById(String id) {
		// sql문 초기화
		sb.setLength(0);
		
		// sql문 작성
		sb.append("SELECT * ");
		sb.append("FROM ACCOUNT ");
		sb.append("WHERE id = ? ");
		
		// 결과 값이 하나이기에(id는 unique) vo만 생성
		AccountVO avo = null;

		try {
			// sql문 실행
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			// vo에 sql문 결과를 담는다
			while (rs.next()) {
				avo = new AccountVO();
				avo.setCustomerCode(rs.getInt("customercode"));
				avo.setId(rs.getString("id"));
				avo.setName(rs.getString("name"));
				avo.setPw(rs.getString("pw"));
				avo.setTel(rs.getString("tel"));
			}

		} catch (SQLException e) {
			System.out.println("sql error in selectOne method");
			e.printStackTrace();
		} 
		//return vo
		return avo;
	} // selectById method ends 
	
	public void delete(String id){
		// sql문 초기화
		sb.setLength(0);
		// sql문 작성
		sb.append("DELETE ACCOUNT ");
		sb.append("WHERE id = ? ");
		
		// sql문 실행
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql error in delete method");
			e.printStackTrace();
		}
	} // delete method ends
	
	
	public void insert(AccountVO avo){
		sb.setLength(0);
		sb.append("INSERT INTO ACCOUNT ");
		sb.append("values (ACCOUNT_SEQ.NEXTVAL, ? , ? , ? , ?) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, avo.getId());
			pstmt.setString(2, avo.getPw());
			pstmt.setString(3, avo.getName());
			pstmt.setString(4, avo.getTel());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql error in insert method");
			e.printStackTrace();
		}
	} // insert method ends
	
	// selectAll()의 결과를 object의 배열로 return하기 위한 메서드
	public Object[][] getObject() {
		//selectAll의 결과(arrayList)를 담기 위한 arrayList 생성
		ArrayList<AccountVO> list = selectAll();
		
		// list가 null일 경우(selectAll이 아무것도 return하지 않을 경우), null을 return
		if (list == null) {
			return null;
		}
		
		// object 준비
		Object[][] obj = new Object[list.size()][4];
		
		// object에 sql문의 결과를 담는다
		for (int i = 0; i < obj.length; i++) {
			obj[i][0] = list.get(i).getCustomerCode();
			obj[i][1] = list.get(i).getId();
			obj[i][2] = list.get(i).getName();
			obj[i][3] = list.get(i).getTel();
		}
		// return obj
		return obj;
	}
		
}// class ends
