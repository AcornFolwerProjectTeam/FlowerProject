package com.flower.server.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.flower.server.DAO.OrderDAO;

@SuppressWarnings("serial")
public class OrderViewDialog extends JDialog implements ActionListener {
	private JLabel jlbOC;
	private JLabel jlbCC;
	private JButton jbtnOK;
	
	private int orderCode;
	
	public OrderViewDialog(JFrame fm, int orderCode, int customerCode) {
		super(fm);
		setLocationRelativeTo(fm);
		this.orderCode = orderCode;
		
		setSize(300, 350);
		setLayout(null);
		
		jlbOC = new JLabel("주문번호 : " + orderCode);
		jlbOC.setBounds(50, 50, 200, 40);
		add(jlbOC);
		
		jlbCC = new JLabel("회원번호 : " + customerCode);
		jlbCC.setBounds(50, 130, 200, 40);
		add(jlbCC);
		
		jbtnOK = new JButton("수령확인");
		jbtnOK.setBounds(100, 200, 100, 40);
		jbtnOK.addActionListener(this);
		add(jbtnOK);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OrderDAO odo = new OrderDAO();
		odo.updateReceive(orderCode, 1);
		odo.close();
		setVisible(false);
	}
}
