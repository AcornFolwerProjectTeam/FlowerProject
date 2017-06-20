package com.flower.server.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.ProductVO;

public class ProductDAO extends Connect {
	// 1. Client를 통해서 request 정보가 담긴 HashMap을 생성자를 통해서 가져온다
	private int me1;
	private int me2;
	private int you1;
	private int you2;
	private int color;

	public ProductDAO() {
	}

	public ProductDAO(HashMap<String, String> hm) {
		// 해쉬맵 자체의 정보를 가져오고, int parseInt 후 필드변수로 저장
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
		// 2. 오라클 원격지에 접속한다
	}

	// 3. selectAll, selectMe, selectYou method를 각각 만든다
	// 4. 쿼리의 결과를 서버는 ArrayList를 통해서 반환한다

	/*
	 * sb 초기화 쿼리문
	 */
	public ArrayList<ProductVO> selectAll() {
		sb.setLength(0); // sb 초기화
		// 쿼리문 작성
		sb.append("SELECT fName, fPrice, imgUrl, textUrl ");
		sb.append("FROM product");
		// 결과를 보내기 위해 값을 저장한 list
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		try {
			// sql문 실행
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) { // 쿼리에 대한 결과가 있는 만큼 반복
				// 각 행의 값을 잠시 지역변수에 저장
				String fName = rs.getString("fName");
				int fPrice = rs.getInt("fPrice");
				String imgUrl = rs.getString("imgUrl");
				String textUrl = rs.getString("textUrl");

				// VO의 생성자를 호출하여 VO에 값을 전달
				ProductVO pvo = new ProductVO(fName, fPrice, imgUrl, textUrl);
				// 이 VO의 참조변수를 arrayList에 저장
				list.add(pvo);
			}
		} catch (SQLException e) {
			System.out.println("selectAll sql error");
			e.printStackTrace();
		}
		// arrayList의 참조값을 리턴
		return list;
	}// selectAll method ends

	public ArrayList<ProductVO> selectMe() {
		sb.setLength(0); // sb 초기화
		// 쿼리문 작성
		sb.append("SELECT fName, fPrice, imgUrl, textUrl ");
		sb.append("FROM product ");
		sb.append("WHERE me1 =?  AND me2=? AND color=? ");
		// 결과를 저장하기 위한 arrayList

		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		try {
			// 쿼리문을 conn 객체에 연결
			pstmt = conn.prepareStatement(sb.toString());
			// 조건문의 ? 를 정의한다
			pstmt.setInt(1, me1);
			pstmt.setInt(2, me2);
			pstmt.setInt(3, color);

			// 결과를 resultSet에 return
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 각 테이블의 행을 지역변수에 저장하고
				String fName = rs.getString("fName");
				int fPrice = rs.getInt("fPrice");
				String imgUrl = rs.getString("imgUrl");
				String textUrl = rs.getString("textUrl");
				// 그 변수를 VO 생성자를 통해서 VO 객체에 전달하고
				ProductVO pvo = new ProductVO(fName, fPrice, imgUrl, textUrl);
				// 이를 arrayList에 저장한다
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
		// sb 초기화
		sb.setLength(0);
		// 쿼리문 작성
		sb.append("SELECT fName, fPrice, imgUrl, textUrl ");
		sb.append("FROM product ");
		sb.append("WHERE you1=? AND you2=? AND color=? ");
		// 결과를 담을 arrayList
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		try {
			// 쿼리문 db 연결
			pstmt = conn.prepareStatement(sb.toString());

			// 쿼리문의 ?를 정의하고
			pstmt.setInt(1, you1);
			pstmt.setInt(2, you2);
			pstmt.setInt(3, color);

			// 쿼리문을 실행한 결과를 resultSet에 담는다
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 테이블의 행을 지역변수에 담고
				String fName = rs.getString("fName");
				int fPrice = rs.getInt("fPrice");
				String imgUrl = rs.getString("imgUrl");
				String textUrl = rs.getString("textUrl");

				// VO객체에 매개변수로 전달하고
				ProductVO pvo = new ProductVO(fName, fPrice, imgUrl, textUrl);

				// arrayList에 VO객체를 담는다
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
		// object 준비
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
