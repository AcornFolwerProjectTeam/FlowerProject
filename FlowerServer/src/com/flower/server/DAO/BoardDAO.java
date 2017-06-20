package com.flower.server.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.AccountVO;
import com.flower.vo.BoardDataVO;

public class BoardDAO extends Connect {
	HashMap<String, String> hm;

	// �Խ��� ���� select method
	// hashMap�� request�� "boardselect" �϶� �۵��Ѵ�
	public ArrayList<BoardDataVO> select() {
		// 1.�ʱ�ȭ
		sb.setLength(0);
		// 2. sql�� �ۼ�
		sb.append("SELECT b.postnumber, b.posttitle, b.postcomment, a.name, ");
		sb.append("b.grade, b.postdate ");
		sb.append("FROM boarddata b, account a, product p ");
		sb.append("WHERE p.customercode = a.customercode ");
		sb.append("AND p.productcode = b.productcode ");
		sb.append("AND p.name = ? ");

		System.out.println(sb.toString());
		// 3. ����� ���� list
		ArrayList<BoardDataVO> list = new ArrayList<BoardDataVO>();

		try {
			// 4. sql�� ����
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, hm.get("name"));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// 5. sql�� ��� �ҷ�����
				int postNumber = rs.getInt(1);
				String postTitle = rs.getString(2);
				String postComment = rs.getString(3);
				String name = rs.getString(4);
				int grade = rs.getInt(5);
				String postDate = rs.getString(6);
				
				// 6. vo object instance
				BoardDataVO bdvo = new BoardDataVO();
				
				// 7. vo ��ü�� ��� ����
				bdvo.setPostNumber(postNumber);
				bdvo.setPostTitle(postTitle);
				bdvo.setPostComment(postComment);
				bdvo.setName(name);
				bdvo.setGrade(grade);
				bdvo.setPostDate(postDate);
				
				//8. vo��ü�� list�� ����
				list.add(bdvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	} // select method ends
	
	public HashMap<String, String> boardInsert(){
		
		return null;
	}
	
	// hm setter and getter
	public HashMap<String, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}

} // class ends
