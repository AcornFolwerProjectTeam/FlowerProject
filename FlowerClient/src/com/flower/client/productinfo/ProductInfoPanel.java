package com.flower.client.productinfo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;
import com.flower.client.config.EnVal;
import com.flower.vo.ProductVO;

@SuppressWarnings("serial")
public class ProductInfoPanel extends JPanel implements ActionListener{
	private JLabel jlbImg, jlbProduct;
	private ImageIcon imgicon;
	private StyleButton sbtnReview;
	private EmphasisButton ebtnBuy;
	private JScrollPane jsp;
	private MainClass mc;
	private ProductVO fvo;
	private ArrayList<ProductVO> list;
	// ------- Constructor ---------
	public ProductInfoPanel(MainClass mc,ArrayList<ProductVO> list, int index) {
		// �ʱ⼳��
		this.mc = mc;
		this.list=list;
		setLayout(null);
		setBackground(Color.WHITE);
		//�ش���ǰ�� ��ġ�ϴ� vo������ü�� �޴´�.
		fvo=list.get(index);
		
		//����� �̹��� ��θ� �޴� String ��ü ����
		String ThumbUrl=fvo.getImgUrl();
		
		//��ǰ Thumbnail�̹��� ���� ������ ����
		imgicon= new ImageIcon(ThumbUrl);
		// ���� ��� ��ǰ ����
		jlbImg = new JLabel();	// ��ǰ���� ��ư ����
		jlbImg.setBounds(50, 50, 200, 200);	// ��ǰ���� ��ư ũ��, ��ġ ����
		jlbImg.setBorder(new LineBorder(EnVal.MAINCOLOR));	// �׽�Ʈ�� ���� �׵θ� ����
		jlbImg.setEnabled(false);	// ��ǰ���� ��ư Ŭ�� ��Ȱ��ȭ
		jlbImg.setIcon(imgicon); //�󺧿� �̹��� �߰��Ѵ�.
		add(jlbImg);	// ��ǰ���� ��ư ����
		
		// ���� ��� ��ǰ ����
		jlbProduct = new JLabel();	// ��ǰ���� ��ư ����	
		jlbProduct.setBounds(290, 50, 250, 140);	// ��ǰ���� ��ư ũ��, ��ġ ����
		jlbProduct.setBorder(new LineBorder(EnVal.MAINCOLOR));	// �׽�Ʈ�� ���� �׵θ� ����
		jlbProduct.setEnabled(false);	// ��ǰ���� ��ư Ŭ�� ��Ȱ��ȭ
		add(jlbProduct);	// ��ǰ���� ��ư ����
		
		// ���� ��� ���亸�� ��ư
		sbtnReview = new StyleButton("���亸��");	// ���亸�� ��ư ����
		sbtnReview.setBounds(290, 210, 120, 40);	// ���亸�� ��ư ũ��, ��ġ ����
		sbtnReview.addActionListener(this);	// Listener ����: Ŭ�� �� �Խ��� �гη� ��ũ�� ��ġ �̵�
		add(sbtnReview);	// ���亸�� ��ư ����
		
		
		// ���� ��� �ٷα��� ��ư
		ebtnBuy = new EmphasisButton("�ٷα���");	// �ٷα��� ��ư ����
		ebtnBuy.setBounds(420, 210, 120, 40);	// �ٷα��� ��ư ũ��, ��ġ ����
		ebtnBuy.addActionListener(this);	// Listener ����: Ŭ���� �ֹ� �гη� ��ȯ
		add(ebtnBuy);	// �ٷα��� ��ư ����
		
		// ������ ������ �Խ��� �г��� �� ��ũ�� �г�
		jsp = new JScrollPane();	// TODO: �������� �Խ��� �г� �����ϰ� ��ũ�ѹ�
		jsp.setBounds(50, 290, 490, 430);	// ��ũ���г� ũ��, ��ġ ����
		add(jsp);	// ��ũ�� �г� ����
		
		setVisible(true);	// �г� ���̵���
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnReview){
			// TODO: �Խ��� �гη� ��ũ�� �̵�
		} else if (e.getSource()==ebtnBuy){
			mc.changeCardLayout("order"); // OrderPanel�� ��ȯ�Ѵ�.
		}
		
	}
	
}
