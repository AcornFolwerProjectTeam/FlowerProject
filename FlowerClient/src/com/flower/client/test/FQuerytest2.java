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
		fvo.youFlower(1, 1, 0);//당신 선택지 결과 저장
		
		System.out.println(fvo.getYou1()+":"
				+fvo.getYou2()+":"+fvo.getColor());//결과 확인 ok
*/		
		//FlowerDAO fdao = new FlowerDAO();//쿼리문 객체
		
		//selectYouQ 메소드는  select결과 저장한 list 객체를 리턴한다.
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
					"이름 : "+vo.getfName()+"url : "+vo.getfPrice()+" 가격: "
			+vo.getImgUrl());
			
		}
		promodule.close();
	}
}
//aws 아마존 원격지