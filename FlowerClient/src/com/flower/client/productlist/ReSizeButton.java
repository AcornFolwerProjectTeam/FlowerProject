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

	ArrayList<ProductVO> list;//flowerVO를 담은  list 객체를 받는다.
	int index;//이 버튼이 몇번째로 생성되었는지 저장=> 몇번째 list에서 가져왔는지
	ReSizeButton(MainClass mc, ArrayList<ProductVO> list, int index, ImageIcon arg0){
		//생성자 오버로딩
		super(arg0);//이미지 아이콘 생성자
		this.mc = mc;
		
		this.list=list;
		this.index=index ;
		addActionListener(this);//버튼 액션리스너 추가
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mc.getProductInfoPanel().setProduct(list.get(index));
		mc.changeCardLayout("productInfo");
		
	    //DetailTop dt = new DetailTop(list, index);
	}

}
