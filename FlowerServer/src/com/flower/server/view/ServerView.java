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
		// �ֹ� ���� ��ȸ
		Object[][] order = new OrderDAO().getObject();
		String[] title = { "�ֹ��ڵ�", "�ֹ�ȸ��", "����ð�", "��ȭ��ȣ", "�޼���", "��ǰ��", "��ǰ����", "����Ȯ��" };
		// �ֹ� ���� ������Ʈ ����
		jtOrder = new JTable(order, title);
		jtOrder.addMouseListener(this);
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
		
		// ���ΰ�ħ ��ư ����
		jbtnRefresh = new JButton("���ΰ�ħ");
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
