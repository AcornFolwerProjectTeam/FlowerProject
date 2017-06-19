package com.flower.client.productlist;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class productPanel extends JPanel{
	JFrame jfr;
	productPanel(JFrame jfr){
		setPreferredSize(new Dimension(600, 800));//기본 패널사이즈
		setLayout(new BorderLayout());//보더 레이아웃
		TopProdPane tpp=new TopProdPane();
		
		add(tpp,BorderLayout.NORTH);
		
		Resize2 rs2=new Resize2(jfr);
		add(rs2, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame fr1= new JFrame("테스트");
		productPanel pp= new productPanel(fr1);
		
		fr1.setBounds(150, 150, 600,800);
		fr1.add(pp);
		
		fr1.setVisible(true);
	}

}
