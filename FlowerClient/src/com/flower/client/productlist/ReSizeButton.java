package com.flower.client.productlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.flower.client.MainClass;
import com.flower.client.productdetail.DetailTop;

import com.flower.vo.ProductVO;



@SuppressWarnings("serial")
public class ReSizeButton extends JButton implements ActionListener{
	MainClass mc;

	ArrayList<ProductVO> list;//flowerVO�� ����  list ��ü�� �޴´�.
	int index;//�� ��ư�� ���°�� �����Ǿ����� ����=> ���° list���� �����Դ���
	ReSizeButton(MainClass mc, ArrayList<ProductVO> list, int index, ImageIcon arg0){
		//������ �����ε�
		super(arg0);//�̹��� ������ ������
		this.mc = mc;
		
		this.list=list;
		this.index=index ;
		addActionListener(this);//��ư �׼Ǹ����� �߰�
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mc.getProductInfoPanel().setProduct(list.get(index));
		mc.changeCardLayout("productInfo");
		
	    //DetailTop dt = new DetailTop(list, index);
	}

}
