package com.flower.client.orderconfirm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.MainClass;
import com.flower.client.component.BottomBar;

// OrderListPanel class
@SuppressWarnings("serial")
public class OrderListPanel extends JPanel implements ComponentListener {
	private MainClass mc;
	private JScrollPane jspOrderScroll;
	private JPanel jpnOrderItems;
	private OrderConfirmPanel[] orderPanels;
	private BottomBar[] bbLine;
	private int index;
	
	// --- Constructor ---
	// �⺻������
	public OrderListPanel(MainClass mc) {
		this.mc = mc; // ���ͷѷ� ��鸵�� ���� ����Ŭ������ �޴´�.
		// �⺻����
		setSize(600, 800); // ũ�� ����
		setLayout(null); // �⺻ ��ġ������ ����
		setBackground(Color.WHITE); // ������ �������
		addComponentListener(this);
		
		// ���� �ʱ�ȭ
		index = 0;
		
		// �����̳� & ������Ʈ ����
		// �ֹ� ����Ʈ�� ��ġ�� �г�
		jpnOrderItems = new JPanel(); // �г� ����
		jpnOrderItems.setBackground(Color.WHITE);
		jpnOrderItems.setLayout(null); // �⺻ ��ġ������ ����
		
		// ��ũ�� �г�
		// �¿� ��ũ�ѹٴ� ������, ���� ��ũ�ѹٴ� ���
		jspOrderScroll = new JScrollPane(jpnOrderItems, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspOrderScroll.setBounds(50, 60, 500, 680); // ��ġ �� ũ�� ����

		// ȭ�鿡 ��ġ
		add(jspOrderScroll); // �гο� �߰�.
		
		// �ֹ� ����Ʈ �߰�.
		// TODO : �������� �α��ε� ȸ���� �ֹ���� VO�� �������� �ڵ� �ۼ� �ʿ�

		// �ֹ������� �迭 ũ�⿡ �°� ����
		orderPanels = new OrderConfirmPanel[5]; // �ֹ� ǰ��
		bbLine = new BottomBar[5]; // ���м�
		
		// �׽�Ʈ�� �ֹ�����Ʈ
		for (int i = 0; i < orderPanels.length; i++) {
			orderPanels[i] = new OrderConfirmPanel(mc, "��ǰ", "50000", false);
			bbLine[i] = new BottomBar();
			jpnOrderItems.add(orderPanels[i]);
			jpnOrderItems.add(bbLine[i]);
			// TODO : VO���� ��ǰ������ OrderPanel�� �־��ִ� �ڵ� �ʿ�
		}
		
		appendList(5);
	}
	// --- Constructor end ---
	
	// appendList method
	private void appendList(int page) {
		while (index < page) {
			orderPanels[index].setBounds(0, 0+160*index, 480, 150);
			bbLine[index].setBounds(0, 0+orderPanels[index].getY()+150, 2000, 10);
			
			index++;
		}
		
		jpnOrderItems.setPreferredSize(new Dimension(jpnOrderItems.getWidth(), 0+160*index));
	} // appendList method end

	@Override
	public void componentResized(ComponentEvent e) {
		jspOrderScroll.setSize(getWidth()-100, getHeight()-120);
		
		for (int i = 0; i < orderPanels.length; i++) {
			orderPanels[i].setLocation((getWidth()-100-480)/2, orderPanels[i].getY());
		}
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
} // OrderListPanel class end
