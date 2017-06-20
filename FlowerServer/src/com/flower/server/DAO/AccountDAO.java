package com.flower.server.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.flower.vo.AccountVO;

public class AccountDAO extends Connect {
	// connect ��ü�� ��ӹ޾ұ⿡ ȣ�� �� �ٷ� db�� ����
	
	public AccountDAO() {
		
	} 

	public ArrayList<AccountVO> selectAll() {
		// sql�� �ʱ�ȭ
		sb.setLength(0);
		
		// sql�� �ۼ�
		sb.append("SELECT * ");
		sb.append("FROM ACCOUNT ");
		
		// vo�� arraylist ���� �� �ν��Ͻ�
		AccountVO avo = null;
		ArrayList<AccountVO> list = new ArrayList<AccountVO>();
		try {
			// sql�� ����
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			// vo�� ������ ����� ��´�
			while (rs.next()) {
				avo = new AccountVO(rs.getInt("customerCode"), rs.getString("id"), rs.getString("pw"),
						rs.getString("name"), rs.getString("tel"));
				// list�� vo ��ü�� ��´�
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
		// sql�� �ʱ�ȭ
		sb.setLength(0);
		
		// sql�� �ۼ�
		sb.append("SELECT * ");
		sb.append("FROM ACCOUNT ");
		sb.append("WHERE id = ? ");
		
		// ��� ���� �ϳ��̱⿡(id�� unique) vo�� ����
		AccountVO avo = null;

		try {
			// sql�� ����
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			// vo�� sql�� ����� ��´�
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
		// sql�� �ʱ�ȭ
		sb.setLength(0);
		// sql�� �ۼ�
		sb.append("DELETE ACCOUNT ");
		sb.append("WHERE id = ? ");
		
		// sql�� ����
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
	
	// selectAll()�� ����� object�� �迭�� return�ϱ� ���� �޼���
	public Object[][] getObject() {
		//selectAll�� ���(arrayList)�� ��� ���� arrayList ����
		ArrayList<AccountVO> list = selectAll();
		
		// list�� null�� ���(selectAll�� �ƹ��͵� return���� ���� ���), null�� return
		if (list == null) {
			return null;
		}
		
		// object �غ�
		Object[][] obj = new Object[list.size()][4];
		
		// object�� sql���� ����� ��´�
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
