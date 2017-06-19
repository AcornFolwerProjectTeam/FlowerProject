package com.flower.client.productdetail;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.flower.vo.ProductVO;



public class DetailTop extends JPanel{
	public ProductVO fvo;
	JPanel imgPane;
	JPanel InfoPane;
	JLabel imgLabel;
	Image img1;
	ImageIcon imgIcon1;
	
	
	public DetailTop(ArrayList<ProductVO> list, int index){
		
		setPreferredSize(new Dimension(500, 350));//전체 패널사이즈설정
		fvo = list.get(index);// 인덱스에서 해당하는 상품정보만 VO로 가져온다.
 		
		imgPane = new JPanel();
		String imgUrl=fvo.getImgUrl();
		/* Toolkit tool = Toolkit.getDefaultToolkit();
		img1=tool.getImage(imgUrl);*/
		imgLabel=new JLabel();
		imgIcon1=new ImageIcon(imgUrl);
		imgLabel.setIcon(imgIcon1);		//왼쪽패널 이미지 설정
		imgPane.add(imgLabel);
		add(imgPane);
		
		System.out.println(list.size()+"꽃이름:"+fvo.getfName());
	}
}
