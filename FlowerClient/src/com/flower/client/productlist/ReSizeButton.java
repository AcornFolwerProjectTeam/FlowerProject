package com.flower.client.productlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.flower.client.productdetail.DetailTop;

import com.flower.vo.ProductVO;



public class ReSizeButton extends JButton implements ActionListener{

	
	ArrayList<ProductVO> list;//flowerVO�� ����  list ��ü�� �޴´�.
	int index;//�� ��ư�� ���°�� �����Ǿ����� ����=> ���° list���� �����Դ���
	ReSizeButton(ArrayList<ProductVO> list, int index, ImageIcon arg0){
		//������ �����ε�
		super(arg0);//�̹��� ������ ������
		
		this.list=list;
		this.index=index ;
		addActionListener(this);//��ư �׼Ǹ����� �߰�
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    DetailTop dt = new DetailTop(list, index);
	    
	}

}
