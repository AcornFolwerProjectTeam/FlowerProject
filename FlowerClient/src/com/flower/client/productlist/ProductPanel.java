package com.flower.client.productlist;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.flower.client.MainClass;



@SuppressWarnings("serial")
public class ProductPanel extends JPanel{
	private MainClass mc;
	private TopProdPane tpp;
	
	public ProductPanel(MainClass mc){
		this.mc = mc;
		// 기본 설정
		setPreferredSize(new Dimension(600, 800));//기본 패널사이즈
		setLayout(new BorderLayout());//보더 레이아웃
		
		// 패널 추가.
		tpp = new TopProdPane(); // 상단 패널 추가.
		add(tpp, BorderLayout.NORTH); // 패널 상단에 추가.
		
		Resize2 rs2 = new Resize2(mc); // 
		add(rs2, BorderLayout.CENTER); // 패널 중앙에 추가.
	}

}
