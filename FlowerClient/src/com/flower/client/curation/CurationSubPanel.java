package com.flower.client.curation;
//ť���̼� ������ �μ��г�
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CurationSubPanel  extends JPanel {
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
	private ImageIcon imgMe=new ImageIcon("imgs/curationimg/me.jpg");
	private ImageIcon imgYou=new ImageIcon("imgs/curationimg/you.jpg");
	
	//2. ������ �ִ� �� �����̹���
	private ImageIcon imgMe1QT=new ImageIcon("imgs/curationimg/sul.jpg");
	private ImageIcon imgMe1QB=new ImageIcon("imgs/curationimg/romantic.jpg");
	private ImageIcon imgMe2QT=new ImageIcon("imgs/curationimg/simple.jpg");
	private ImageIcon imgMe2QB=new ImageIcon("imgs/curationimg/go.jpg");
	
	//3. ��뿡�� �ִ� �� �����̹���
	private ImageIcon imgYou1QT=new ImageIcon("imgs/curationimg/sul.jpg");
	private ImageIcon imgYou1QB=new ImageIcon("imgs/curationimg/romantic.jpg");
	private ImageIcon imgYou2QT=new ImageIcon("imgs/curationimg/simple.jpg");
	private ImageIcon imgYou2QB=new ImageIcon("imgs/curationimg/go.jpg");
	
	
	//4. ���� �����̹���
	private ImageIcon imgColorQT=new ImageIcon("imgs/curationimg/cool.jpg");
	private ImageIcon imgColorQB=new ImageIcon("imgs/curationimg/warm.jpg");

	
	
	public JPanel paneMeYou;
	public JPanel paneMe1;   
	public JPanel paneMe2;  
	public JPanel paneYou1;  
	public JPanel paneYou2;  
	public JPanel color;  
	
	public CurationSubPanel(){
		
		
		// ��ư�� �����г� ���� �� ����
		paneMeYou=new JPanel();
		paneMeYou.setLayout(null);//���̾ƿ�  null
		paneMeYou.setSize(new Dimension(450, 600));//ũ�⼳��
		
		
		paneMe1=new JPanel();
		paneMe1.setLayout(null);//���̾ƿ�  null
		paneMe1.setSize(new Dimension(450, 600));//ũ�⼳��
		
		paneMe2=new JPanel();
		paneMe2.setLayout(null);//���̾ƿ�  null
		paneMe2.setSize(new Dimension(450, 600));//ũ�⼳��
		
		paneYou1=new JPanel();
		paneYou1.setLayout(null);//���̾ƿ�  null
		paneYou1.setSize(new Dimension(450, 600));//ũ�⼳��
		
		paneYou2=new JPanel();
		paneYou2.setLayout(null);//���̾ƿ�  null
		paneYou2.setSize(new Dimension(450, 600));//ũ�⼳��
		
		color=new JPanel();
		color.setLayout(null);//���̾ƿ�  null
		color.setSize(new Dimension(450, 600));//ũ�⼳��
		
		//��ư���� �� ����
		jbtnMe = new JButton(imgMe);
		jbtnMe.setBounds(50, 50, 350, 250);//��ư��ġ����
		
		jbtnYou = new JButton(imgYou);
		jbtnYou.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnMe1QT = new JButton(imgMe1QT);
		jbtnMe1QT.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnMe1QB = new JButton(imgMe1QB);
		jbtnMe1QB.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnMe2QT = new JButton(imgMe2QT);
		jbtnMe2QT.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnMe2QB = new JButton(imgMe2QB);
		jbtnMe2QB.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnYou1QT = new JButton(imgYou1QT);
		jbtnYou1QT.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnYou1QB = new JButton(imgYou1QB);
		jbtnYou1QB.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnYou2QT = new JButton(imgYou2QT);
		jbtnYou2QT.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnYou2QB = new JButton(imgYou2QB);
		jbtnYou2QB.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnColorQT = new JButton(imgColorQT);
		jbtnColorQT.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		jbtnColorQB = new JButton(imgColorQB);
		jbtnColorQB.setBounds(50, 350, 350, 250);//��ư��ġ����
		
		
		//jpanel�� ��ư�߰�
		
		
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
