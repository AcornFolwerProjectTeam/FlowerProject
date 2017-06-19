package com.flower.server.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flower.vo.AccountVO;

public class AccountDAO extends Connect {

	public AccountDAO() {
		new Connect();
	} // default constructor ends : db access

	public ArrayList<AccountVO> selectAll() {
		sb.setLength(0);

		sb.append("SELECT * ");
		sb.append("FROM ACCOUNT ");

		AccountVO avo = null;
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {

				avo = new AccountVO(rs.getInt("customerCode"), rs.getString("id"), rs.getString("pw"),
						rs.getString("name"), rs.getString("tel"));
				list.add(avo);
			}
		} catch (SQLException e) {
			System.out.println("sql error in selectAll method");
			e.printStackTrace();
		}

		return list;
	} // selectAll method ends

	public AccountVO selectById(String id) {
		sb.setLength(0);
		sb.append("SELECT * ");
		sb.append("FROM ACCOUNT ");
		sb.append("WHERE id = ? ");
		AccountVO avo = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
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
		return avo;
	} // selectById method ends 
	
	public void delete(String id){
		sb.setLength(0);
		sb.append("DELETE ACCOUNT ");
		sb.append("WHERE id = ? ");
		
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
		
}// class ends
