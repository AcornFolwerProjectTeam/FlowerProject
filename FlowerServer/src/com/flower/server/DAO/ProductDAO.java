package com.flower.server.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.ProductVO;

public class ProductDAO extends Connect {
	// 1. Client�� ���ؼ� request ������ ��� HashMap�� �����ڸ� ���ؼ� �����´�
	private int me1;
	private int me2;
	private int you1;
	private int you2;
	private int color;

	public ProductDAO() {
	}

	public ProductDAO(HashMap<String, String> hm) {
		// �ؽ��� ��ü�� ������ ��������, int parseInt �� �ʵ庯���� ����
		if (hm.get("me1") != null) {
			this.me1 = Integer.parseInt(hm.get("me1"));
		}
		if (hm.get("me2") != null) {
			this.me2 = Integer.parseInt(hm.get("me2"));
		}
		if (hm.get("you1") != null) {
			this.you1 = Integer.parseInt("you1");
		}
		if (hm.get("you2") != null) {
			this.you2 = Integer.parseInt(hm.get("you2"));
		}
		if (hm.get("color") != null) {
			this.color = Integer.parseInt(hm.get("color"));
		}
		// 2. ����Ŭ �������� �����Ѵ�
	}

	// 3. selectAll, selectMe, selectYou method�� ���� �����
	// 4. ������ ����� ������ ArrayList�� ���ؼ� ��ȯ�Ѵ�

	/*
	 * sb �ʱ�ȭ ������
	 */
	public ArrayList<ProductVO> selectAll() {
		sb.setLength(0); // sb �ʱ�ȭ
		// ������ �ۼ�
		sb.append("SELECT fName, fPrice, imgUrl, textUrl ");
		sb.append("FROM product");
		// ����� ������ ���� ���� ������ list
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			// sql�� ����
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) { // ������ ���� ����� �ִ� ��ŭ �ݺ�
				// �� ���� ���� ��� ���������� ����
				String fName = rs.getString("fName");
				int fPrice = rs.getInt("fPrice");
				String imgUrl = rs.getString("imgUrl");
				String textUrl = rs.getString("textUrl");

				// VO�� �����ڸ� ȣ���Ͽ� VO�� ���� ����
				ProductVO pvo = new ProductVO(fName, fPrice, imgUrl, textUrl);
				// �� VO�� ���������� arrayList�� ����
				list.add(pvo);
			}
		} catch (SQLException e) {
			System.out.println("selectAll sql error");
			e.printStackTrace();
		}
		// arrayList�� �������� ����
		return list;
	}// selectAll method ends

	public ArrayList<ProductVO> selectMe() {
		sb.setLength(0); // sb �ʱ�ȭ
		// ������ �ۼ�
		sb.append("SELECT fName, fPrice, imgUrl, textUrl ");
		sb.append("FROM product ");
		sb.append("WHERE me1 =?  AND me2=? AND color=? ");
		// ����� �����ϱ� ���� arrayList

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		try {
			// �������� conn ��ü�� ����
			pstmt = conn.prepareStatement(sb.toString());
			// ���ǹ��� ? �� �����Ѵ�
			pstmt.setInt(1, me1);
			pstmt.setInt(2, me2);
			pstmt.setInt(3, color);

			// ����� resultSet�� return
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// �� ���̺��� ���� ���������� �����ϰ�
				String fName = rs.getString("fName");
				int fPrice = rs.getInt("fPrice");
				String imgUrl = rs.getString("imgUrl");
				String textUrl = rs.getString("textUrl");
				// �� ������ VO �����ڸ� ���ؼ� VO ��ü�� �����ϰ�
				ProductVO pvo = new ProductVO(fName, fPrice, imgUrl, textUrl);
				// �̸� arrayList�� �����Ѵ�
				System.out.println("pvo :" + pvo);
				list.add(pvo);
			}

		} catch (SQLException e) {
			System.out.println("selectMe sql error");
			e.printStackTrace();
		}
		// list return
		return list;
	} // selectMe method ends

	public ArrayList<ProductVO> selectYou() {
		// sb �ʱ�ȭ
		sb.setLength(0);
		// ������ �ۼ�
		sb.append("SELECT fName, fPrice, imgUrl, textUrl ");
		sb.append("FROM product ");
		sb.append("WHERE you1=? AND you2=? AND color=? ");
		// ����� ���� arrayList
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		try {
			// ������ db ����
			pstmt = conn.prepareStatement(sb.toString());

			// �������� ?�� �����ϰ�
			pstmt.setInt(1, you1);
			pstmt.setInt(2, you2);
			pstmt.setInt(3, color);

			// �������� ������ ����� resultSet�� ��´�
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// ���̺��� ���� ���������� ���
				String fName = rs.getString("fName");
				int fPrice = rs.getInt("fPrice");
				String imgUrl = rs.getString("imgUrl");
				String textUrl = rs.getString("textUrl");

				// VO��ü�� �Ű������� �����ϰ�
				ProductVO pvo = new ProductVO(fName, fPrice, imgUrl, textUrl);

				// arrayList�� VO��ü�� ��´�
				list.add(pvo);
			}

		} catch (SQLException e) {
			System.out.println("selectYou sql error");
			e.printStackTrace();
		}
		// return list
		return list;
	} // selectYou method ends

	public Object[][] getObject() {
		ArrayList<ProductVO> list = selectAll();

		if (list == null) {
			return null;
		}
		// object �غ�
		Object[][] obj = new Object[list.size()][4];

		for (int i = 0; i < obj.length; i++) {
			obj[i][0] = list.get(i).getfName();
			obj[i][1] = list.get(i).getfPrice();
			obj[i][2] = list.get(i).getImgUrl();
			obj[i][3] = list.get(i).getTextUrl();

		}

		return obj;
	}

}// class ends
