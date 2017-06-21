package com.flower.server.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.flower.server.DAO.AccountDAO;
import com.flower.server.DAO.MainServer;
import com.flower.server.DAO.OrderDAO;
import com.flower.server.DAO.ProductDAO;

@SuppressWarnings("serial")
public class ServerView extends JFrame implements MouseListener, ActionListener {

	JTable jtOrder;
	JTable jtAccount;
	JTable jtProduct;

	JScrollPane jspOrder;
	JScrollPane jspAccount;
	JScrollPane jspProduct;
	
	JButton jbtnRefresh;

	public ServerView() {
		setBounds(150, 150, 800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 주문 정보 조회
		Object[][] order = new OrderDAO().getObject();
		String[] title = { "주문코드", "주문회원", "예약시간", "전화번호", "메세지", "제품명", "제품가격", "수령확인" };
		// 주문 정보 콤포넌트 생성
		jtOrder = new JTable(order, title);
		jtOrder.addMouseListener(this);
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
		
		// 새로고침 버튼 생성
		jbtnRefresh = new JButton("새로고침");
		jbtnRefresh.addActionListener(this);
		add(jbtnRefresh, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new ServerView();
		new MainServer();
	}
	
	private void dataRefresh() {
		jtOrder.setModel(new OrderDataModel());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int selIndex = -1;		
		selIndex = jtOrder.getSelectionModel().getMinSelectionIndex();
		
		if (selIndex > -1 && (int) jtOrder.getValueAt(selIndex, 7) < 1 ) {
			int orderCode = (int) jtOrder.getValueAt(selIndex, 0);
			int customerCode = (int) jtOrder.getValueAt(selIndex, 1);
			new OrderViewDialog(this, orderCode, customerCode);
			
			dataRefresh();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
		dataRefresh();
	}
}
