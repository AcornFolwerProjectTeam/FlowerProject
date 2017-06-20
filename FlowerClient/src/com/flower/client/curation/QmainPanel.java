package com.flower.client.curation;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.client.model.ProductModule;
import com.flower.vo.ProductVO;

public class QmainPanel extends JPanel implements ActionListener{
	
	CardLayout c1;
	QSubPan qsp;
	ProductModule pdao;
	ProductVO pvo;
	
	
	//jscroll1 jsp;
	private ArrayList<ProductVO> list;
	int flagYouMe=3; // 질문 선택지 변경 , 위가 0 아래가1
	int flagMe1=3;  //나를 위한꽃 '첫'번째 질문 결과값 저장
	int flagMe2=3; //나를 위한꽃 '두'번째 질문 결과값 저장
	int flagYou1=3;//당신을 위한 꽃 '첫'번째 질문 결과값 저장
	int flagYou2=3;//당신을 위한 꽃 '두'번째 질문 결과값 저장
	int flagColor =3; //색상 결과값 저장
	int flagWait=0;
	MainClass mc;
	QmainPanel(MainClass mc){
		this.mc=mc;
		qsp= new QSubPan();//버튼있는 패널
		c1=new CardLayout();//카드레이아웃
		setLayout(c1);
		list= new ArrayList<ProductVO>();
		//QmainPanel에 카드레이 아웃으로 추가 
		add(qsp.paneMeYou , "paneMeYou");
		add(qsp.paneMe1 , "paneMe1");
		add(qsp.paneMe2 , "paneMe2");
		add(qsp.paneYou1 , "paneYou1");
		add(qsp.paneYou2 , "paneYou2");
		add(qsp.color , "color");
		
		qsp.jbtnMe.addActionListener(this);
		qsp.jbtnYou.addActionListener(this);
		
		qsp.jbtnMe1QT.addActionListener(this);
		qsp.jbtnMe1QB.addActionListener(this);
		qsp.jbtnMe2QT.addActionListener(this);
		qsp.jbtnMe2QB.addActionListener(this);
		
		qsp.jbtnYou1QT.addActionListener(this);
		qsp.jbtnYou1QB.addActionListener(this);
		qsp.jbtnYou2QT.addActionListener(this);
		qsp.jbtnYou2QB.addActionListener(this);
	
		qsp.jbtnColorQT.addActionListener(this);
		qsp.jbtnColorQB.addActionListener(this);
		
		
		
		c1.show(this, "paneMeYou");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		try {
			pdao= new ProductModule();//모듈을 생성한다.
			
		} catch (ConnectException e1) {
			
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
	
	
		
		if(obj==qsp.jbtnMe){//me버튼 선택
			flagYouMe=0;
			c1.show(this,"paneMe1");
			flagWait++;
		}else if(obj==qsp.jbtnYou){//you버튼 선택
			flagYouMe=1;
			c1.show(this,"paneYou1");
			flagWait++;
		}else if(obj==qsp.jbtnMe1QT){//meQ1의 위 버튼 선택
			flagMe1=0;
			c1.show(this,"paneMe2");
			flagWait++;
		}else if(obj==qsp.jbtnMe1QB){//meQ1의 아래 버튼 선택
			flagMe1=1;
			c1.show(this,"paneMe2");
			flagWait++;
		}else if(obj==qsp.jbtnMe2QT){//meQ2의 위 버튼 선택
			flagMe2=0;
			c1.show(this,"color");
			flagWait++;
			
		}else if(obj==qsp.jbtnMe2QT){//meQ2의 위 버튼 선택
			flagMe2=1;
			c1.show(this,"color");//color패널로 이동
			flagWait++;
			
		}else if(obj==qsp.jbtnYou1QT){//youQ1의 위 버튼 선택
			flagYou1=0;
			c1.show(this,"paneYou2");
			flagWait++;
		}else if(obj==qsp.jbtnYou1QB){//youQ1의 아래 버튼 선택
			flagYou1=1;
			c1.show(this,"paneYou2");
			flagWait++;
		}else if(obj==qsp.jbtnYou2QT){//youQ2의 위 버튼 선택
			flagYou2=0;
			c1.show(this,"color");
			flagWait++;
		}else if(obj==qsp.jbtnYou2QB){//youQ2의 아래 버튼 선택
			flagYou2=1;
			c1.show(this,"color");
			flagWait++;
		}
		
		
		
		else if(obj==qsp.jbtnColorQT){//colorQ의 위 버튼 선택
			flagColor=0;
			
			if(flagYouMe==0){ //나에게 꽃 선택했을 때
				
				list=pdao.meFlower(String.valueOf(flagMe1), String.valueOf(flagMe2),String.valueOf(flagColor));
				//해당조건을 만족하는 list객체를 받는다.
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2의 setProductItem 메소드를 실행한다. 상품재배치
				mc.changeCardLayout("productList");//상품리스트 패널로 전환한다.
				c1.show(this,"paneMeYou");//큐래이션 패널을 맨처음으로 초기화 한다.
				pdao.close();//접속 중지
			}
			else if(flagYouMe==1){//상대에게 꽃 선택했을 때
				list=pdao.youFlower(String.valueOf(flagYou1),String.valueOf(flagYou2), String.valueOf(flagColor));
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2의 setProductItem 메소드를 실행한다. 상품재배치
				mc.changeCardLayout("productList");//상품리스트 패널로 전환한다.
				c1.show(this,"paneMeYou");//큐래이션 패널을 맨처음으로 초기화 한다.
				pdao.close();//접속 중지
			}
			
			
			
			flagWait++;
				//System.exit(0);
			
		}else if(obj==qsp.jbtnColorQB){//colorQ의 아래 버튼 선택
			flagColor=1;
			
			if(flagYouMe==0){ //나에게 꽃 선택했을 때
				list=pdao.meFlower(String.valueOf(flagMe1), String.valueOf(flagMe2), String.valueOf(flagColor));
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2의 setProductItem 메소드를 실행한다. 상품재배치
				mc.changeCardLayout("productList");//상품리스트 패널로 전환한다.
				c1.show(this,"paneMeYou");//큐래이션 패널을 맨처음으로 초기화 한다.
				pdao.close();//접속 중지
			}
			else if(flagYouMe==1){//상대에게 꽃 선택했을 때
				list =pdao.youFlower(String.valueOf(flagYou1), String.valueOf(flagYou2), String.valueOf(flagColor));
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2의 setProductItem 메소드를 실행한다. 상품재배치
				mc.changeCardLayout("productList");//상품리스트 패널로 전환한다.
				c1.show(this,"paneMeYou");//큐래이션 패널을 맨처음으로 초기화 한다.
				pdao.close();//접속 중지
			}
				
			//	System.exit(0);
				
				
			
			flagWait++;
		}
			
			
		
			
		}
			
/*				
	public void QWait(){
	
		int k=0;
		while ( k<4){
			 k=getFlagWait();
			System.out.println("확인 : "+flagWait);
			
		}
		System.out.println("빠져나왔습니다.");
	}
	


	public int getFlagWait(){
		return flagWait;
	}
	public void exit(){
		System.exit(0);
	}*/
	
}
