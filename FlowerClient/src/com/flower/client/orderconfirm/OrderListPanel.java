package com.flower.client.orderconfirm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.MainClass;
import com.flower.client.component.BottomBar;
import com.flower.vo.OrderListVO;

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
		jspOrderScroll.setBounds(50, 100, 500, 600); // ��ġ �� ũ�� ����

		// ȭ�鿡 ��ġ
		add(jspOrderScroll); // �гο� �߰�.
		
		
	}
	// --- Constructor end ---
	
	public void setOrderList(ArrayList<OrderListVO> list) {
		// �ֹ������� �迭 ũ�⿡ �°� ����
		orderPanels = new OrderConfirmPanel[list.size()]; // �ֹ� ǰ��
		bbLine = new BottomBar[list.size()]; // ���м�
		
		// �׽�Ʈ�� �ֹ�����Ʈ
		for (int i = 0; i < list.size(); i++) {
			orderPanels[i] = new OrderConfirmPanel(mc, list.get(i).getOrderCode(), list.get(i).getfName(), list.get(i).getImgUrl(), list.get(i).getOrderDate(), String.valueOf(list.get(i).getfPrice()), list.get(i).getReceive());
			bbLine[i] = new BottomBar();
			jpnOrderItems.add(orderPanels[i]);
			jpnOrderItems.add(bbLine[i]);
			// TODO : VO���� ��ǰ������ OrderPanel�� �־��ִ� �ڵ� �ʿ�
		}
		
		// �ֹ� ����Ʈ �߰�.
		appendList(list.size());
	}
	
	// appendList method
	private void appendList(int page) {
		while (index < page) {
			orderPanels[index].setBounds(0, 0+160*index, 480, 150);
			bbLine[index].setBounds(15, 0+orderPanels[index].getY()+150, 470, 3);
			
			index++;
		}
		
		jpnOrderItems.setPreferredSize(new Dimension(jpnOrderItems.getWidth(), 0+160*index));
	} // appendList method end

	@Override
	public void componentResized(ComponentEvent e) {
		if (orderPanels != null) {
			jspOrderScroll.setSize(getWidth()-100, getHeight()-200);
			
			for (int i = 0; i < orderPanels.length; i++) {
				orderPanels[i].setLocation((getWidth()-120-480)/2, orderPanels[i].getY());
				bbLine[i].setSize(getWidth()-146, bbLine[i].getHeight());
			}
		}
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
	
} // OrderListPanel class end
