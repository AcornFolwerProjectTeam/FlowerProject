package com.flower.client.productlist;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.MainClass;

@SuppressWarnings("serial")
public class ProductPanel extends JPanel implements ComponentListener {
	private MainClass mc;
	private TopProdPane tpp;
	private JScrollPane jsp; // 상품 스크롤 패널
	private Resize2 rs2;
	
	public ProductPanel(MainClass mc) throws ConnectException, UnknownHostException, IOException{
		this.mc = mc;
		// 기본 설정
		setSize(600, 800); // 크기 설정//기본 패널사이즈
		setBackground(Color.WHITE);
		setLayout(null);//보더 레이아웃
		addComponentListener(this);
		
		// 패널 추가.
		tpp = new TopProdPane(mc); // 상단 패널 추가.
		tpp.setBounds(25, 80, 540, 220);
		//tpp.setBorder(new LineBorder(Color.BLACK));
		add(tpp); // 패널 상단에 추가.
		
		// 하단 제품 목록 패널 추가.
		rs2 = new Resize2(mc); // 
		rs2.setProductItemAll(); // 모든 상품을 보여준다.
		
		// 스크롤 패널 생성하고 조건 설정한다.
		jsp = new JScrollPane(rs2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(25, 300, 540, 450);
		jsp.getVerticalScrollBar().setUnitIncrement(16); // 스크롤바 속도
		add(jsp); // 패널 중앙에 추가.
	}

	public Resize2 getRs2() {
		return rs2;
	}

	public void setRs2(Resize2 rs2) {
		this.rs2 = rs2;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		tpp.setSize(getWidth()-75, tpp.getHeight()); // 상단 메뉴 좌우 너비만 벌림
		jsp.setSize(getWidth()-75, getHeight()-388);
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
}
