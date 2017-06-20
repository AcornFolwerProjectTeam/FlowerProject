package com.flower.client.curation;
//ť���̼� ������ �μ��г�
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
	public JButton jbtnMe1QT; //���� �ִ²� ù ��°���� ���� ���ù�ư
	public JButton jbtnMe1QB;//���� �ִ²� ù ��°���� �Ʒ��� ���ù�ư
	public JButton jbtnMe2QT;
	public JButton jbtnMe2QB;
	public JButton jbtnYou1QT;
	public JButton jbtnYou1QB;
	public JButton jbtnYou2QT;//��뿡�� �ִ� �� �� ��°���� ���� ���ù�ư
	public JButton jbtnYou2QB;//��뿡�� �ִ� �� �� ��°���� �Ʒ��� ���ù�ư
	public JButton jbtnColorQT;//���� ���� ���� ���ù�ư
	public JButton jbtnColorQB;//���� ���� �Ʒ��� ���ù�ư
	//���� emageIcon
	
	//1. ������ �ִ� ��, ��뿡�� �ִ� �� ����
	private ImageIcon imgMe=new ImageIcon("src/sample/me.jpg");
	private ImageIcon imgYou=new ImageIcon("src/sample/you.jpg");
	
	//2. ������ �ִ� �� �����̹���
	private ImageIcon imgMe1QT=new ImageIcon("src/sample/sul.jpg");
	private ImageIcon imgMe1QB=new ImageIcon("src/sample/romantic.jpg");
	private ImageIcon imgMe2QT=new ImageIcon("src/sample/simple.jpg");
	private ImageIcon imgMe2QB=new ImageIcon("src/sample/go.jpg");
	
	//3. ��뿡�� �ִ� �� �����̹���
	private ImageIcon imgYou1QT=new ImageIcon("src/sample/sul.jpg");
	private ImageIcon imgYou1QB=new ImageIcon("src/sample/romantic.jpg");
	private ImageIcon imgYou2QT=new ImageIcon("src/sample/simple.jpg");
	private ImageIcon imgYou2QB=new ImageIcon("src/sample/go.jpg");
	
	
	//4. ���� �����̹���
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
		
		// ��ư�� �����г� ����
		paneMeYou=new JPanel();
		paneMe1=new JPanel();
		paneMe2=new JPanel();
		paneYou1=new JPanel();
		paneYou2=new JPanel();
		color=new JPanel();
		
		//jpanel�� ��ư�߰�
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
