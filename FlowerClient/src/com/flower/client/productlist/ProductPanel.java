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
		// �⺻ ����
		setPreferredSize(new Dimension(600, 800));//�⺻ �гλ�����
		setLayout(new BorderLayout());//���� ���̾ƿ�
		
		// �г� �߰�.
		tpp = new TopProdPane(); // ��� �г� �߰�.
		add(tpp, BorderLayout.NORTH); // �г� ��ܿ� �߰�.
		
		Resize2 rs2 = new Resize2(mc); // 
		add(rs2, BorderLayout.CENTER); // �г� �߾ӿ� �߰�.
	}

}
