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
	
	JScrollPane jsp; // ��ǰ ��ũ�� �г�
	JPanel jfrBorder; // �׵θ� �г�, �׸��� �г��� ũ�⸦ �����Ѵ�.
	JPanel jfrGrid=new JPanel(); //�׵θ� �г����� �ٴ´�. ��ǰ����
	ReSizeButton[] jbtn; //ArrayList<ProductVO> ����Ʈ�� �����ϴ� ��ư
	ImageIcon [] prodImg;//��ǰ�� �̹����� ����
	JFrame jfr;//��������  width(), height() ���� �� ũ�� �����ϱ� ���� �ʿ�
	ArrayList<ProductVO> list;//Ư�� ���ǿ� �´� �������� ������ �ִ� ����Ʈ ��ü
	ProductVO fvo; //����Ʈ���� ���� VO�� ���޹޴� ��ü
	ProductModule pdm;//������ �����ؼ� VOlist�� �ޱ����� ���
	
	int listLength;//ArrayList�� size �޴´�.
	int firstHeight;// �ʱ� ��ǰ��� ������ ���� �ʱ� �г� ����.
	int changeHeight;// â ũ�⿡ ���� �޶����� �г��� ����.
	
	public Resize2(JFrame jfr){//�α��� ���� ��� ��ǰ �����ִ� ������
		ProductModule pdm;
		try {
			pdm = new ProductModule();//��� �����Ѵ�.
			list= pdm.allFlower(); //����Ʈ�� ��� ��ǰ ��´�.
		} catch (ConnectException e) {
			
			e.printStackTrace();
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
		
		this.setLayout(new BorderLayout()); //�г��� layout��Ÿ���� BorderLayout()���� ����
		    this.jfr=jfr;// �г��� ���̴� frame�� ���� �޴´�.
			listLength=list.size();//����Ʈ���̸� ���� �޴´�.
			this.setBounds(150, 150, 500, 600);	
			
			jsp = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			//��ũ�� �г� �����ϰ� ���� �����Ѵ�.
			
			//jsp.setPreferredSize(new Dimension(500, 600));
			jsp.getViewport().add(this);
			jsp.getVerticalScrollBar().setUnitIncrement(16);//��ũ�ѹ� �ӵ�
			
			
			
			
			firstHeight=setFirstHeigth(listLength);//�ʱ� borderPanel ���̸� �޾ƿ´�.
			this.setPreferredSize(new Dimension(600, firstHeight));//�ʱ� ���̸� �����Ѵ�.
			this.setBorder(BorderFactory.createEmptyBorder(50 , 30 ,50 , 50));//���ο��� �����Ѵ�.
			
			
			
			jfrGrid=new JPanel();// �г� �����Ѵ�.
			jfrGrid.setLayout(new GridLayout(4,3,15,25));//�г� ���̾ƿ��� �׸���� �����Ѵ�.
			jbtn =new ReSizeButton[listLength]; //��ư ��ü �������� �����Ѵ�.
			
			prodImg=new ImageIcon[listLength]; //prodImg ��ü �������� ����
			for(int i=0; i<listLength; i++){
				fvo=list.get(i);//����Ʈ���� i��° vo�� �����´�.
				prodImg[i]=new ImageIcon(fvo.getImgUrl());//vo�� �ּҸ� �����ͼ� imgicon�� ������.
				jbtn[i]=new ReSizeButton(list,i,prodImg[i]);//��ư�� ����� �̹����� �ִ´�.
				jfrGrid.add(jbtn[i]);//�׸��� �гο� ��ư�� �߰��Ѵ�.
			}
			
			
			 add(jfrGrid);//���� �гο� �׸��带 �߰��Ѵ�. 
			this.addComponentListener(this);//������Ʈ ������ �߰��Ѵ�.
		
	}
	
	public Resize2(JFrame jfr ,ArrayList<ProductVO> list) {
		//ť���̼� ���� �ް��� ���õ� ��ǰ�� �����ִ� ������.
		this.jfr=jfr;
		
		this.list=list; //����Ʈ ���� ��� arraylist�� �޴´�.
		listLength=list.size();
		
		
		
		this.setLayout(new BorderLayout());
			
		jsp = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//jsp.setPreferredSize(new Dimension(500, 600));
		jsp.getViewport().add(this);
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		
		//setLayout(null);
		this.setBounds(150, 150, 500, 600);
		
		firstHeight=setFirstHeigth(listLength);//�ʱ� borderPanel ���� ����
		this.setPreferredSize(new Dimension(600, firstHeight));
		this.setBorder(BorderFactory.createEmptyBorder(50 , 30 ,50 , 50));
		
		
		
		jfrGrid=new JPanel();
		jfrGrid.setLayout(new GridLayout(4,3,15,25));
		jbtn =new ReSizeButton[listLength];
		
		prodImg=new ImageIcon[listLength]; //prodImg ����
		for(int i=0; i<listLength; i++){
			fvo=list.get(i);
			prodImg[i]=new ImageIcon(fvo.getImgUrl());
			jbtn[i]=new ReSizeButton(list,i,prodImg[i]);
			jfrGrid.add(jbtn[i]);
		}
		
		
		 add(jfrGrid);
		this.addComponentListener(this);
		
	}
	
	public int setFirstHeigth(int listLength){//�ʱ�  �г� ���� ����
		int rst;
		int k=(int)listLength/3;
		rst=k*250+(k-1)*25+100; //3���� �迭 �⺻����*360(��ư����)+100(�Ʒ��� ����)
		if(listLength%3 !=0) rst=rst+275;
		
		return rst;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		jfrGrid.removeAll();//�׸��� ������  �ٲ� �� ���� ���� �׸���.
		int column=(int)(jfr.getWidth()-120)/165;//�÷��� ���� ����, ��ư1���� width() 165 
		if(column<3) column=3;//�ּ��÷��� =3 
		int row=(int)(listLength/column);// row�� ���� ����
		if(listLength%column !=0) row++; // ���� ���� ����
		if(row<3)row=3;//�ּ� ��� =3
		jfrGrid.setLayout(new GridLayout(row,column,15,25));//���Ӱ� �׸��巹�̾ƿ��� ����
		
		jbtn =new ReSizeButton[listLength];//��ư ����
		prodImg=new ImageIcon[listLength]; //prodImg ����
		for(int i=0; i<listLength; i++){
			fvo=list.get(i);
			prodImg[i]=new ImageIcon(fvo.getImgUrl());//�̹��������� ����
			jbtn[i]=new ReSizeButton(list,i,prodImg[i]);//�̹��� ���� ��ư ����

		    jbtn[i].setBorderPainted(false); //��ư������ ����
		    jbtn[i].setContentAreaFilled(false);//��ư�� ���λ� ����
			jfrGrid.add(jbtn[i]);//��ư �߰�
		}
		
		int temp=column*row-listLength;//��ġ�� ���� ������ ��ư�� �߰�, �߰��ϴ� ��ư�� ������ grid�� �Ѱ���-���� ��ư ����
		JButton[] tempBtn = new JButton[temp];
		for(int i=0; i<temp; i++){
			//tempBtn[i]= new JButton("temp"+i);
			tempBtn[i].setBorderPainted(false);
			tempBtn[i].setContentAreaFilled(false);
			jfrGrid.add(tempBtn[i]);//�����ư �߰�.
			
		}
		
		int borderWidthSet=(column-3)*178;	
		
		int borderWidth=(int) ((jfr.getWidth()-540-borderWidthSet)/2);
		//int borderHeightSet=(column-3)*260;};
		changeHeight= (row*275)-25;
		this.setPreferredSize(new Dimension(600, (row*275)-25));//�����г��� ���̸� �缳�� �Ѵ�.
			
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

