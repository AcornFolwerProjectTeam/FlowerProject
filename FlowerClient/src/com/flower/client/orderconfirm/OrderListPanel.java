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
	// 기본생성자
	public OrderListPanel(MainClass mc) {
		this.mc = mc; // 컨터롤러 헨들링을 위한 메인클레스를 받는다.
		// 기본설정
		setSize(600, 800); // 크기 설정
		setLayout(null); // 기본 배치관리자 해제
		setBackground(Color.WHITE); // 배경색은 흰색으로
		addComponentListener(this);
		
		// 변수 초기화
		index = 0;
		
		// 컨테이너 & 컴포넌트 설정
		// 주문 리스트가 배치될 패널
		jpnOrderItems = new JPanel(); // 패널 생성
		jpnOrderItems.setBackground(Color.WHITE);
		jpnOrderItems.setLayout(null); // 기본 배치관리자 해제
		
		// 스크롤 패널
		// 좌우 스크롤바는 사용안함, 상하 스크롤바는 사용
		jspOrderScroll = new JScrollPane(jpnOrderItems, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspOrderScroll.setBounds(50, 100, 500, 600); // 위치 및 크기 지정

		// 화면에 배치
		add(jspOrderScroll); // 패널에 추가.
		
		
	}
	// --- Constructor end ---
	
	public void setOrderList(ArrayList<OrderListVO> list) {
		// 주문아이템 배열 크기에 맞게 생성
		orderPanels = new OrderConfirmPanel[list.size()]; // 주문 품목
		bbLine = new BottomBar[list.size()]; // 구분선
		
		// 테스트용 주문리스트
		for (int i = 0; i < list.size(); i++) {
			orderPanels[i] = new OrderConfirmPanel(mc, list.get(i).getOrderCode(), list.get(i).getfName(), list.get(i).getImgUrl(), list.get(i).getOrderDate(), String.valueOf(list.get(i).getfPrice()), list.get(i).getReceive());
			bbLine[i] = new BottomBar();
			jpnOrderItems.add(orderPanels[i]);
			jpnOrderItems.add(bbLine[i]);
			// TODO : VO에서 상품정보를 OrderPanel에 넣어주는 코드 필요
		}
		
		// 주문 리스트 추가.
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
