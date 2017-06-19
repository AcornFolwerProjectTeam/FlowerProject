package com.flower.client.productlist;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.model.ProductModule;
import com.flower.vo.ProductVO;


public class Resize2 extends JPanel implements ComponentListener{
	
	JScrollPane jsp; // 상품 스크롤 패널
	JPanel jfrBorder; // 테두리 패널, 그리드 패널의 크기를 결정한다.
	JPanel jfrGrid=new JPanel(); //테두리 패널위에 붙는다. 상품정렬
	ReSizeButton[] jbtn; //ArrayList<ProductVO> 리스트를 저장하는 버튼
	ImageIcon [] prodImg;//상품의 이미지를 저장
	JFrame jfr;//프레임의  width(), height() 값을 얻어서 크기 연동하기 위해 필요
	ArrayList<ProductVO> list;//특정 조건에 맞는 꽃정보를 가지고 있는 리스트 객체
	ProductVO fvo; //리스트에서 받은 VO를 전달받는 객체
	ProductModule pdm;//서버와 연결해서 VOlist를 받기위한 모듈
	
	int listLength;//ArrayList의 size 받는다.
	int firstHeight;// 초기 상품목록 개수에 따른 초기 패널 길이.
	int changeHeight;// 창 크기에 따라서 달라지는 패널의 길이.
	
	public Resize2(JFrame jfr){//로그인 직후 모든 상품 보여주는 생성자
		ProductModule pdm;
		try {
			pdm = new ProductModule();//모듈 생성한다.
			list= pdm.allFlower(); //리스트에 모든 상품 담는다.
		} catch (ConnectException e) {
			
			e.printStackTrace();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		
		this.setLayout(new BorderLayout()); //패널의 layout스타일을 BorderLayout()으로 변경
		    this.jfr=jfr;// 패널을 붙이는 frame을 전달 받는다.
			listLength=list.size();//리스트길이를 전달 받는다.
			this.setBounds(150, 150, 500, 600);	
			
			jsp = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			//스크롤 패널 생성하고 조건 설정한다.
			
			//jsp.setPreferredSize(new Dimension(500, 600));
			jsp.getViewport().add(this);
			jsp.getVerticalScrollBar().setUnitIncrement(16);//스크롤바 속도
			
			
			
			
			firstHeight=setFirstHeigth(listLength);//초기 borderPanel 높이를 받아온다.
			this.setPreferredSize(new Dimension(600, firstHeight));//초기 높이를 설정한다.
			this.setBorder(BorderFactory.createEmptyBorder(50 , 30 ,50 , 50));//내부여백 설정한다.
			
			
			
			jfrGrid=new JPanel();// 패널 생성한다.
			jfrGrid.setLayout(new GridLayout(4,3,15,25));//패널 레이아웃을 그리드로 설정한다.
			jbtn =new ReSizeButton[listLength]; //버튼 객체 참조변수 생성한다.
			
			prodImg=new ImageIcon[listLength]; //prodImg 객체 참조변수 생성
			for(int i=0; i<listLength; i++){
				fvo=list.get(i);//리스트에서 i번째 vo를 가져온다.
				prodImg[i]=new ImageIcon(fvo.getImgUrl());//vo의 주소를 가져와서 imgicon을 생성다.
				jbtn[i]=new ReSizeButton(list,i,prodImg[i]);//버튼을 만들고 이미지를 넣는다.
				jfrGrid.add(jbtn[i]);//그리드 패널에 버튼을 추가한다.
			}
			
			
			 add(jfrGrid);//현재 패널에 그리드를 추가한다. 
			this.addComponentListener(this);//컴포넌트 리스너 추가한다.
		
	}
	
	public Resize2(JFrame jfr ,ArrayList<ProductVO> list) {
		//큐레이션 서비스 받고나서 선택된 상품만 보여주는 생성자.
		this.jfr=jfr;
		
		this.list=list; //셀렉트 문이 담긴 arraylist를 받는다.
		listLength=list.size();
		
		
		
		this.setLayout(new BorderLayout());
			
		jsp = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//jsp.setPreferredSize(new Dimension(500, 600));
		jsp.getViewport().add(this);
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		
		//setLayout(null);
		this.setBounds(150, 150, 500, 600);
		
		firstHeight=setFirstHeigth(listLength);//초기 borderPanel 높이 설정
		this.setPreferredSize(new Dimension(600, firstHeight));
		this.setBorder(BorderFactory.createEmptyBorder(50 , 30 ,50 , 50));
		
		
		
		jfrGrid=new JPanel();
		jfrGrid.setLayout(new GridLayout(4,3,15,25));
		jbtn =new ReSizeButton[listLength];
		
		prodImg=new ImageIcon[listLength]; //prodImg 생성
		for(int i=0; i<listLength; i++){
			fvo=list.get(i);
			prodImg[i]=new ImageIcon(fvo.getImgUrl());
			jbtn[i]=new ReSizeButton(list,i,prodImg[i]);
			jfrGrid.add(jbtn[i]);
		}
		
		
		 add(jfrGrid);
		this.addComponentListener(this);
		
	}
	
	public int setFirstHeigth(int listLength){//초기  패널 높이 설정
		int rst;
		int k=(int)listLength/3;
		rst=k*250+(k-1)*25+100; //3열로 배열 기본설정*360(버튼높이)+100(아래위 여백)
		if(listLength%3 !=0) rst=rst+275;
		
		return rst;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		jfrGrid.removeAll();//그리드 형식이  바뀔 때 마다 새로 그린다.
		int column=(int)(jfr.getWidth()-120)/165;//컬럼의 개수 결정, 버튼1개의 width() 165 
		if(column<3) column=3;//최소컬럼수 =3 
		int row=(int)(listLength/column);// row의 수를 결정
		if(listLength%column !=0) row++; // 행의 개수 결정
		if(row<3)row=3;//최소 행수 =3
		jfrGrid.setLayout(new GridLayout(row,column,15,25));//새롭게 그리드레이아웃을 설정
		
		jbtn =new ReSizeButton[listLength];//버튼 생성
		prodImg=new ImageIcon[listLength]; //prodImg 생성
		for(int i=0; i<listLength; i++){
			fvo=list.get(i);
			prodImg[i]=new ImageIcon(fvo.getImgUrl());//이미지아이콘 생성
			jbtn[i]=new ReSizeButton(list,i,prodImg[i]);//이미지 넣은 버튼 생성

		    jbtn[i].setBorderPainted(false); //버튼윤곽선 투명
		    jbtn[i].setContentAreaFilled(false);//버튼의 내부색 투명
			jfrGrid.add(jbtn[i]);//버튼 추가
		}
		
		int temp=column*row-listLength;//배치를 위해 가상의 버튼을 추가, 추가하는 버튼의 갯수는 grid의 총갯수-실제 버튼 갯수
		JButton[] tempBtn = new JButton[temp];
		for(int i=0; i<temp; i++){
			//tempBtn[i]= new JButton("temp"+i);
			tempBtn[i].setBorderPainted(false);
			tempBtn[i].setContentAreaFilled(false);
			jfrGrid.add(tempBtn[i]);//가상버튼 추가.
			
		}
		
		int borderWidthSet=(column-3)*178;	
		
		int borderWidth=(int) ((jfr.getWidth()-540-borderWidthSet)/2);
		//int borderHeightSet=(column-3)*260;};
		changeHeight= (row*275)-25;
		this.setPreferredSize(new Dimension(600, (row*275)-25));//현재패널의 길이를 재설정 한다.
			
		this.setBorder(BorderFactory.createEmptyBorder(50 , borderWidth ,50  ,borderWidth+20 ));
		System.out.println("row : " +row+" column : "+column);
		System.out.println(jfr.getWidth());
		System.out.println("boder : "+borderWidth);
		this.setVisible(false);
		this.setVisible(true);
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

