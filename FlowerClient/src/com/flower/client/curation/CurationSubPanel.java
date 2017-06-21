package com.flower.client.curation;
//큐레이션 질문의 부속패널
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CurationSubPanel  extends JPanel {
	public JButton jbtnMe;
	public JButton jbtnYou;
	public JButton jbtnMe1QT; //내게 주는꽃 첫 번째질문 위쪽 선택버튼
	public JButton jbtnMe1QB;//내게 주는꽃 첫 번째질문 아래쪽 선택버튼
	public JButton jbtnMe2QT;
	public JButton jbtnMe2QB;
	public JButton jbtnYou1QT;
	public JButton jbtnYou1QB;
	public JButton jbtnYou2QT;//상대에게 주는 꽃 두 번째질문 위쪽 선택버튼
	public JButton jbtnYou2QB;//상대에게 주는 꽃 두 번째질문 아래쪽 선택버튼
	public JButton jbtnColorQT;//색상 선택 위쪽 선택버튼
	public JButton jbtnColorQB;//색상 선택 아래쪽 선택버튼
	//질문 emageIcon
	
	//1. 나에게 주는 꽃, 상대에게 주는 꽃 선택
	private ImageIcon imgMe=new ImageIcon("imgs/curationimg/1_0.png");
	private ImageIcon imgYou=new ImageIcon("imgs/curationimg/1_1.png");
	
	//2. 나에게 주는 꽃 질문이미지
	private ImageIcon imgMe1QT=new ImageIcon("imgs/curationimg/4_0.png");
	private ImageIcon imgMe1QB=new ImageIcon("imgs/curationimg/4_1.png");
	private ImageIcon imgMe2QT=new ImageIcon("imgs/curationimg/5_0.png");
	private ImageIcon imgMe2QB=new ImageIcon("imgs/curationimg/5_1.png");
	
	//3. 상대에게 주는 꽃 질문이미지
	private ImageIcon imgYou1QT=new ImageIcon("imgs/curationimg/2_0.png");
	private ImageIcon imgYou1QB=new ImageIcon("imgs/curationimg/2_1.png");
	private ImageIcon imgYou2QT=new ImageIcon("imgs/curationimg/3_0.png");
	private ImageIcon imgYou2QB=new ImageIcon("imgs/curationimg/3_1.png");
	
	
	//4. 색상 질문이미지
	private ImageIcon imgColorQT=new ImageIcon("imgs/curationimg/6_0.png");
	private ImageIcon imgColorQB=new ImageIcon("imgs/curationimg/6_1.png");

	
	
	public JPanel paneMeYou;
	public JPanel paneMe1;   
	public JPanel paneMe2;  
	public JPanel paneYou1;  
	public JPanel paneYou2;  
	public JPanel color;  
	
	public CurationSubPanel(){
		
		
		// 버튼을 붙일패널 생성 및 설정
		paneMeYou=new JPanel();
		paneMeYou.setLayout(null);//레이아웃  null
		paneMeYou.setSize(new Dimension(450, 600));//크기설정
		paneMeYou.setBackground(Color.white);
		
		
		paneMe1=new JPanel();
		paneMe1.setLayout(null);//레이아웃  null
		paneMe1.setSize(new Dimension(450, 600));//크기설정
		paneMe1.setBackground(Color.white);
		
		paneMe2=new JPanel();
		paneMe2.setLayout(null);//레이아웃  null
		paneMe2.setSize(new Dimension(450, 600));//크기설정
		paneMe2.setBackground(Color.white);
		
		paneYou1=new JPanel();
		paneYou1.setLayout(null);//레이아웃  null
		paneYou1.setSize(new Dimension(450, 600));//크기설정
		paneYou1.setBackground(Color.white);
		
		paneYou2=new JPanel();
		paneYou2.setLayout(null);//레이아웃  null
		paneYou2.setSize(new Dimension(450, 600));//크기설정
		paneYou2.setBackground(Color.white);
		
		color=new JPanel();
		color.setLayout(null);//레이아웃  null
		color.setSize(new Dimension(450, 600));//크기설정
		color.setBackground(Color.white);
		
		//버튼생성 및 설정
		jbtnMe = new JButton(imgMe);
		jbtnMe.setBounds(70, 100, 450, 280);//버튼위치설정
		
		jbtnYou = new JButton(imgYou);
		jbtnYou.setBounds(70,400, 450, 280);//버튼위치설정
		
		jbtnMe1QT = new JButton(imgMe1QT);
		jbtnMe1QT.setBounds(70, 100, 450, 280);//버튼위치설정
		
		jbtnMe1QB = new JButton(imgMe1QB);
		jbtnMe1QB.setBounds(70,400, 450, 280);//버튼위치설정
		
		jbtnMe2QT = new JButton(imgMe2QT);
		jbtnMe2QT.setBounds(70, 100, 450, 280);//버튼위치설정
		
		jbtnMe2QB = new JButton(imgMe2QB);
		jbtnMe2QB.setBounds(70,400, 450, 280);//버튼위치설정
		
		jbtnYou1QT = new JButton(imgYou1QT);
		jbtnYou1QT.setBounds(70, 100, 450, 280);//버튼위치설정
		
		jbtnYou1QB = new JButton(imgYou1QB);
		jbtnYou1QB.setBounds(70,400, 450, 280);//버튼위치설정
		
		jbtnYou2QT = new JButton(imgYou2QT);
		jbtnYou2QT.setBounds(70, 100, 450, 280);//버튼위치설정
		
		jbtnYou2QB = new JButton(imgYou2QB);
		jbtnYou2QB.setBounds(70,400, 450, 280);//버튼위치설정
		
		jbtnColorQT = new JButton(imgColorQT);
		jbtnColorQT.setBounds(70, 100, 450, 280);//버튼위치설정
		
		jbtnColorQB = new JButton(imgColorQB);
		jbtnColorQB.setBounds(70,400, 450, 280);//버튼위치설정
		
		
		//jpanel에 버튼추가
		
		
		paneMeYou.add(jbtnYou);
		paneMeYou.add(jbtnMe);
		
		
		paneMe1.add(jbtnMe1QT);
		paneMe1.add(jbtnMe1QB);
		paneMe2.add(jbtnMe2QT);
		paneMe2.add(jbtnMe2QB);

		
		paneYou1.add(jbtnYou1QT);
		paneYou1.add(jbtnYou1QB);
		paneYou2.add(jbtnYou2QT);
		paneYou2.add(jbtnYou2QB);
		
		
		color.add(jbtnColorQT);
		color.add(jbtnColorQB);
		
		
	}
	
	
	
}
