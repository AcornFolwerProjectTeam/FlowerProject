package com.flower.client.test;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.flower.client.model.ProductModule;
import com.flower.vo.ProductVO;

public class FQuerytest2 {
	public static void main(String[] args) {
		//FlowerVO fvo = new FlowerVO(0,0,1);
		
		/*FlowerVO fvo=new FlowerVO();
		fvo.youFlower(1, 1, 0);//��� ������ ��� ����
		
		System.out.println(fvo.getYou1()+":"
				+fvo.getYou2()+":"+fvo.getColor());//��� Ȯ�� ok
*/		
		//FlowerDAO fdao = new FlowerDAO();//������ ��ü
		
		//selectYouQ �޼ҵ��  select��� ������ list ��ü�� �����Ѵ�.
		//ArrayList<FlowerVO> list = fdao.selectYouQ(fvo);
		ProductModule promodule = null;
		try {
			promodule = new ProductModule();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String me1="1";
		String me2="1";
		String color="0";
		ArrayList<ProductVO> list=promodule.meFlower(me1, me2, color);
		for(ProductVO vo: list){
			System.out.println(
					"�̸� : "+vo.getfName()+"url : "+vo.getfPrice()+" ����: "
			+vo.getImgUrl());
			
		}
		promodule.close();
	}
}
//aws �Ƹ��� ������