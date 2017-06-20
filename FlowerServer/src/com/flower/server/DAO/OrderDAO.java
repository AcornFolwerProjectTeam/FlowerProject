package com.flower.server.DAO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.OrderListVO;

public class OrderDAO extends Connect {
	private HashMap<String, String> hm;
	
	public OrderDAO() {} // �⺻ ������

	public ArrayList<OrderListVO> selectAll() {
		ArrayList<OrderListVO> list = null;
		sb.setLength(0);

		sb.append("SELECT ordercode, customercode, revtime, revtel, message, fname, (select FPRICE from PRODUCT where FNAME = orderlist.fname) as FPRICE, receive ");
		sb.append("FROM orderlist ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<OrderListVO>();
			while (rs.next()) {
				OrderListVO ovo = new OrderListVO();
				ovo.setOrderCode(rs.getInt(1));
				ovo.setCustomerCode(rs.getInt(2));
				ovo.setRevTime(rs.getString(3));
				ovo.setRevTel(rs.getString(4));
				ovo.setMessage(rs.getString(5));
				ovo.setfName(rs.getString(6));
				ovo.setfPrice(rs.getInt(7));
				ovo.setReceive(rs.getInt(8));
				
				list.add(ovo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<OrderListVO> selectUser() {
		ArrayList<OrderListVO> list = null;
		sb.setLength(0);
		
		sb.append("SELECT ordercode ");
		sb.append("     , customercode ");
		sb.append("     , revtime ");
		sb.append("     , revtel ");
		sb.append("     , message ");
		sb.append("     , fname ");
		sb.append("     , (select FPRICE from PRODUCT where FNAME = orderlist.fname) as FPRICE ");
		sb.append("     , (select imgurl from PRODUCT where FNAME = orderlist.fname) as imgurl ");
		sb.append("     , receive ");
		sb.append("     , orderdate ");
		sb.append("FROM orderlist ");
		sb.append("WHERE customercode = (select customercode ");
		sb.append("                      FROM account ");
		sb.append("                      WHERE id =?)");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, hm.get("id"));
			rs = pstmt.executeQuery();
			list = new ArrayList<OrderListVO>();
			while (rs.next()) {
				OrderListVO ovo = new OrderListVO();
				ovo.setOrderCode(rs.getInt(1));
				ovo.setCustomerCode(rs.getInt(2));
				ovo.setRevTime(rs.getString(3));
				ovo.setRevTel(rs.getString(4));
				ovo.setMessage(rs.getString(5));
				ovo.setfName(rs.getString(6));
				ovo.setfPrice(rs.getInt(7));
				ovo.setImgUrl(rs.getString(8));
				ovo.setReceive(rs.getInt(9));
				ovo.setOrderDate(rs.getString(10));
				
				list.add(ovo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	// �ֹ� method
	public HashMap<String, String> order() {
		// sql�� �ʱ�ȭ
		sb.setLength(0);
		// sql�� �ۼ�
		sb.append("INSERT INTO orderlist ");
		sb.append("values (ordercode.nextval, ");
		sb.append("(SELECT customercode ");
		sb.append("FROM account ");
		sb.append("WHERE id =?), ");
		sb.append("?, ?, ?, ?, ?, 1, sysdate) ");
		HashMap<String, String> orderMap = new HashMap<String, String>();
		int result = 0;
		try {
			// sql�� �ν��Ͻ� �� ����
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, hm.get("id"));
			pstmt.setString(2, hm.get("revtime"));
			pstmt.setString(3, hm.get("revtel"));
			pstmt.setString(4, hm.get("revname"));
			pstmt.setString(5, hm.get("message"));
			pstmt.setString(6, hm.get("fname"));
			// sql�� ����
			result = pstmt.executeUpdate();
			
		// insert query�� �������� ��
		} catch (SQLIntegrityConstraintViolationException e) {
			orderMap.put("respond", "error");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Insert query�� �������� ��
		if (result > 0) {
			orderMap.put("respond", "okay");
		}
		return orderMap;
	} // order method ends

	public Object[][] getObject() {
		ArrayList<OrderListVO> list = selectAll();

		if (list == null) {
			return null;
		}
		// object �غ�
		Object[][] obj = new Object[list.size()][8];

		for (int i = 0; i < obj.length; i++) {
			obj[i][0] = list.get(i).getOrderCode();
			obj[i][1] = list.get(i).getCustomerCode();
			obj[i][2] = list.get(i).getRevTime();
			obj[i][3] = list.get(i).getRevTel();
			obj[i][4] = list.get(i).getMessage();
			obj[i][5] = list.get(i).getfName();
			obj[i][6] = list.get(i).getfPrice();
			obj[i][7] = list.get(i).getReceive();
		}
		return obj;
	}

	// hashMap setter�� getter
	public HashMap<String, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}
	
	
}
