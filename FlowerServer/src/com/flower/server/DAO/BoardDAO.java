package com.flower.server.DAO;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.BoardDataVO;

public class BoardDAO extends Connect {
	HashMap<String, String> hm;

	// 게시판 내용 select method
	// hashMap의 request가 "boardselect" 일때 작동한다
	public ArrayList<BoardDataVO> select() {
		// 1.초기화
		sb.setLength(0);
		// 2. sql문 작성
		sb.append("SELECT b.postnumber, b.posttitle, b.postcomment, a.name, ");
		sb.append("b.grade, b.postdate ");
		sb.append("FROM boarddata b, account a, product p ");
		sb.append("WHERE b.customercode = a.customercode ");
		sb.append("AND p.productcode = b.productcode ");
		sb.append("AND p.fName = ? ");

		System.out.println(sb.toString());
		// 3. 결과를 담을 list
		ArrayList<BoardDataVO> list = new ArrayList<BoardDataVO>();

		try {
			// 4. sql문 실행
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, hm.get("fname"));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// 5. sql문 결과 불러오기
				int postNumber = rs.getInt(1);
				String postTitle = rs.getString(2);
				String postComment = rs.getString(3);
				String name = rs.getString(4);
				int grade = rs.getInt(5);
				String postDate = rs.getString(6);

				// 6. vo object instance
				BoardDataVO bdvo = new BoardDataVO();

				// 7. vo 객체에 결과 저장
				bdvo.setPostNumber(postNumber);
				bdvo.setPostTitle(postTitle);
				bdvo.setPostComment(postComment);
				bdvo.setName(name);
				bdvo.setGrade(grade);
				bdvo.setPostDate(postDate);

				// 8. vo객체를 list에 저장
				list.add(bdvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} // select method ends

	// insert method
	public HashMap<String, String> boardInsert() {
		sb.setLength(0);
		sb.append("INSERT INTO boarddata ");
		sb.append("values (postcode.nextval, ");
		sb.append("       (SELECT customercode FROM account WHERE id = ? ), ");
		sb.append("		  (SELECT productcode FROM product WHERE fname = ? ), ");
		sb.append("		   postnumber.nextval, ?, ?, ?, sysdate) ");
		
		HashMap<String, String> hmBoardInsert = new HashMap<String, String>();
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, hm.get("id"));
			pstmt.setString(2, hm.get("fname"));
			pstmt.setString(3, hm.get("posttitle"));
			pstmt.setString(4, hm.get("postcomment"));
			pstmt.setInt(5, Integer.parseInt(hm.get("grade")));

			result = pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			hmBoardInsert.put("respond", "error");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			hmBoardInsert.put("respond", "okay");
		}

		return hmBoardInsert;
	}

	// hm setter and getter
	public HashMap<String, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}

} // class ends
