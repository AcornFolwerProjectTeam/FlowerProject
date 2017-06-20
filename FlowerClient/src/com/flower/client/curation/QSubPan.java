package com.flower.client.curation;
//큐레이션 질문의 부속패널
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class QSubPan  extends JFrame {
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
	private ImageIcon imgMe=new ImageIcon("src/sample/me.jpg");
	private ImageIcon imgYou=new ImageIcon("src/sample/you.jpg");
	
	//2. 나에게 주는 꽃 질문이미지
	private ImageIcon imgMe1QT=new ImageIcon("src/sample/sul.jpg");
	private ImageIcon imgMe1QB=new ImageIcon("src/sample/romantic.jpg");
	private ImageIcon imgMe2QT=new ImageIcon("src/sample/simple.jpg");
	private ImageIcon imgMe2QB=new ImageIcon("src/sample/go.jpg");
	
	//3. 상대에게 주는 꽃 질문이미지
	private ImageIcon imgYou1QT=new ImageIcon("src/sample/sul.jpg");
	private ImageIcon imgYou1QB=new ImageIcon("src/sample/romantic.jpg");
	private ImageIcon imgYou2QT=new ImageIcon("src/sample/simple.jpg");
	private ImageIcon imgYou2QB=new ImageIcon("src/sample/go.jpg");
	
	
	//4. 색상 질문이미지
	private ImageIcon imgColorQT=new ImageIcon("src/sample/cool.jpg");
	private ImageIcon imgColorQB=new ImageIcon("src/sample/warm.jpg");

	
	
	public JPanel paneMeYou;
	public JPanel paneMe1;   
	public JPanel paneMe2;  
	public JPanel paneYou1;  
	public JPanel paneYou2;  
	public JPanel color;  
	
	public QSubPan(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jbtnMe = new JButton(imgMe);
		jbtnYou = new JButton(imgYou);
		
		jbtnMe1QT = new JButton(imgMe1QT);
		jbtnMe1QB = new JButton(imgMe1QB);
		jbtnMe2QT = new JButton(imgMe2QT);
		jbtnMe2QB = new JButton(imgMe2QB);
		
		jbtnYou1QT = new JButton(imgYou1QT);
		jbtnYou1QB = new JButton(imgYou1QB);
		jbtnYou2QT = new JButton(imgYou2QT);
		jbtnYou2QB = new JButton(imgYou2QB);
		
		jbtnColorQT = new JButton(imgColorQT);
		jbtnColorQB = new JButton(imgColorQB);
		
		// 버튼을 붙일패널 생성
		paneMeYou=new JPanel();
		paneMe1=new JPanel();
		paneMe2=new JPanel();
		paneYou1=new JPanel();
		paneYou2=new JPanel();
		color=new JPanel();
		
		//jpanel에 버튼추가
		paneMeYou.add(jbtnMe, BorderLayout.NORTH);
		paneMeYou.add(jbtnYou, BorderLayout.SOUTH);
		
		
		paneMe1.add(jbtnMe1QT, BorderLayout.NORTH);
		paneMe1.add(jbtnMe1QB, BorderLayout.SOUTH);
		paneMe2.add(jbtnMe2QT, BorderLayout.NORTH);
		paneMe2.add(jbtnMe2QB, BorderLayout.SOUTH);

		
		paneYou1.add(jbtnYou1QT, BorderLayout.NORTH);
		paneYou1.add(jbtnYou1QB, BorderLayout.SOUTH);
		paneYou2.add(jbtnYou2QT, BorderLayout.NORTH);
		paneYou2.add(jbtnYou2QB, BorderLayout.SOUTH);
		
		
		color.add(jbtnColorQT, BorderLayout.NORTH);
		color.add(jbtnColorQB, BorderLayout.SOUTH);
		
		
	}
	
	
	
}
