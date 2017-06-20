package com.flower.server.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.flower.server.DAO.AccountDAO;
import com.flower.server.DAO.MainServer;
import com.flower.server.DAO.OrderDAO;
import com.flower.server.DAO.ProductDAO;

@SuppressWarnings("serial")
public class ServerView extends JFrame {

	JTable jtOrder;
	JTable jtAccount;
	JTable jtProduct;

	JScrollPane jspOrder;
	JScrollPane jspAccount;
	JScrollPane jspProduct;

	public ServerView() {
		setBounds(150, 150, 800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 주문 정보 조회
		Object[][] order = new OrderDAO().getObject();
		String[] title = { "주문코드", "주문회원", "예약시간", "전화번호", "메세지", "제품명", "제품가격", "수령확인" };
		// 주문 정보 콤포넌트 생성
		jtOrder = new JTable(order, title);
		jspOrder = new JScrollPane(jtOrder);
		add(jspOrder, BorderLayout.NORTH);

		// 회원 정보 조회
		Object[][] account = new AccountDAO().getObject();
		String[] accountTitle = { "회원코드", "아이디", "이름", "전화번호" };

		// 회원 정보 콤포넌트 생성
		jtAccount = new JTable(account, accountTitle);
		jspAccount = new JScrollPane(jtAccount);
		add(jspAccount, BorderLayout.WEST);

		// 상품 정보 조회
		Object[][] product = new ProductDAO().getObject();
		String[] productTitle = { "제품명", "가격", "제품이미지", "내용" };
		
		//상품 정보 콤포넌트 생성
		jtProduct = new JTable(product, productTitle);
		jspProduct = new JScrollPane(jtProduct);
		add(jspProduct, BorderLayout.CENTER);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ServerView();
		new MainServer();
	}
}
