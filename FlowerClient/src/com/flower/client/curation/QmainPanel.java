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
	int flagYouMe=3; // ���� ������ ���� , ���� 0 �Ʒ���1
	int flagMe1=3;  //���� ���Ѳ� 'ù'��° ���� ����� ����
	int flagMe2=3; //���� ���Ѳ� '��'��° ���� ����� ����
	int flagYou1=3;//����� ���� �� 'ù'��° ���� ����� ����
	int flagYou2=3;//����� ���� �� '��'��° ���� ����� ����
	int flagColor =3; //���� ����� ����
	int flagWait=0;
	MainClass mc;
	QmainPanel(MainClass mc){
		this.mc=mc;
		qsp= new QSubPan();//��ư�ִ� �г�
		c1=new CardLayout();//ī�巹�̾ƿ�
		setLayout(c1);
		list= new ArrayList<ProductVO>();
		//QmainPanel�� ī�巹�� �ƿ����� �߰� 
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
			pdao= new ProductModule();//����� �����Ѵ�.
			
		} catch (ConnectException e1) {
			
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
	
	
		
		if(obj==qsp.jbtnMe){//me��ư ����
			flagYouMe=0;
			c1.show(this,"paneMe1");
			flagWait++;
		}else if(obj==qsp.jbtnYou){//you��ư ����
			flagYouMe=1;
			c1.show(this,"paneYou1");
			flagWait++;
		}else if(obj==qsp.jbtnMe1QT){//meQ1�� �� ��ư ����
			flagMe1=0;
			c1.show(this,"paneMe2");
			flagWait++;
		}else if(obj==qsp.jbtnMe1QB){//meQ1�� �Ʒ� ��ư ����
			flagMe1=1;
			c1.show(this,"paneMe2");
			flagWait++;
		}else if(obj==qsp.jbtnMe2QT){//meQ2�� �� ��ư ����
			flagMe2=0;
			c1.show(this,"color");
			flagWait++;
			
		}else if(obj==qsp.jbtnMe2QT){//meQ2�� �� ��ư ����
			flagMe2=1;
			c1.show(this,"color");//color�гη� �̵�
			flagWait++;
			
		}else if(obj==qsp.jbtnYou1QT){//youQ1�� �� ��ư ����
			flagYou1=0;
			c1.show(this,"paneYou2");
			flagWait++;
		}else if(obj==qsp.jbtnYou1QB){//youQ1�� �Ʒ� ��ư ����
			flagYou1=1;
			c1.show(this,"paneYou2");
			flagWait++;
		}else if(obj==qsp.jbtnYou2QT){//youQ2�� �� ��ư ����
			flagYou2=0;
			c1.show(this,"color");
			flagWait++;
		}else if(obj==qsp.jbtnYou2QB){//youQ2�� �Ʒ� ��ư ����
			flagYou2=1;
			c1.show(this,"color");
			flagWait++;
		}
		
		
		
		else if(obj==qsp.jbtnColorQT){//colorQ�� �� ��ư ����
			flagColor=0;
			
			if(flagYouMe==0){ //������ �� �������� ��
				
				list=pdao.meFlower(String.valueOf(flagMe1), String.valueOf(flagMe2),String.valueOf(flagColor));
				//�ش������� �����ϴ� list��ü�� �޴´�.
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2�� setProductItem �޼ҵ带 �����Ѵ�. ��ǰ���ġ
				mc.changeCardLayout("productList");//��ǰ����Ʈ �гη� ��ȯ�Ѵ�.
				c1.show(this,"paneMeYou");//ť���̼� �г��� ��ó������ �ʱ�ȭ �Ѵ�.
				pdao.close();//���� ����
			}
			else if(flagYouMe==1){//��뿡�� �� �������� ��
				list=pdao.youFlower(String.valueOf(flagYou1),String.valueOf(flagYou2), String.valueOf(flagColor));
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2�� setProductItem �޼ҵ带 �����Ѵ�. ��ǰ���ġ
				mc.changeCardLayout("productList");//��ǰ����Ʈ �гη� ��ȯ�Ѵ�.
				c1.show(this,"paneMeYou");//ť���̼� �г��� ��ó������ �ʱ�ȭ �Ѵ�.
				pdao.close();//���� ����
			}
			
			
			
			flagWait++;
				//System.exit(0);
			
		}else if(obj==qsp.jbtnColorQB){//colorQ�� �Ʒ� ��ư ����
			flagColor=1;
			
			if(flagYouMe==0){ //������ �� �������� ��
				list=pdao.meFlower(String.valueOf(flagMe1), String.valueOf(flagMe2), String.valueOf(flagColor));
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2�� setProductItem �޼ҵ带 �����Ѵ�. ��ǰ���ġ
				mc.changeCardLayout("productList");//��ǰ����Ʈ �гη� ��ȯ�Ѵ�.
				c1.show(this,"paneMeYou");//ť���̼� �г��� ��ó������ �ʱ�ȭ �Ѵ�.
				pdao.close();//���� ����
			}
			else if(flagYouMe==1){//��뿡�� �� �������� ��
				list =pdao.youFlower(String.valueOf(flagYou1), String.valueOf(flagYou2), String.valueOf(flagColor));
				mc.getProductPanel().getRs2().setProductItem(list);
				//resize2�� setProductItem �޼ҵ带 �����Ѵ�. ��ǰ���ġ
				mc.changeCardLayout("productList");//��ǰ����Ʈ �гη� ��ȯ�Ѵ�.
				c1.show(this,"paneMeYou");//ť���̼� �г��� ��ó������ �ʱ�ȭ �Ѵ�.
				pdao.close();//���� ����
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
			System.out.println("Ȯ�� : "+flagWait);
			
		}
		System.out.println("�������Խ��ϴ�.");
	}
	


	public int getFlagWait(){
		return flagWait;
	}
	public void exit(){
		System.exit(0);
	}*/
	
}
