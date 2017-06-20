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
		// �ֹ� ���� ��ȸ
		Object[][] order = new OrderDAO().getObject();
		String[] title = { "�ֹ��ڵ�", "�ֹ�ȸ��", "����ð�", "��ȭ��ȣ", "�޼���", "��ǰ��", "��ǰ����", "����Ȯ��" };
		// �ֹ� ���� ������Ʈ ����
		jtOrder = new JTable(order, title);
		jspOrder = new JScrollPane(jtOrder);
		add(jspOrder, BorderLayout.NORTH);

		// ȸ�� ���� ��ȸ
		Object[][] account = new AccountDAO().getObject();
		String[] accountTitle = { "ȸ���ڵ�", "���̵�", "�̸�", "��ȭ��ȣ" };

		// ȸ�� ���� ������Ʈ ����
		jtAccount = new JTable(account, accountTitle);
		jspAccount = new JScrollPane(jtAccount);
		add(jspAccount, BorderLayout.WEST);

		// ��ǰ ���� ��ȸ
		Object[][] product = new ProductDAO().getObject();
		String[] productTitle = { "��ǰ��", "����", "��ǰ�̹���", "����" };
		
		//��ǰ ���� ������Ʈ ����
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
