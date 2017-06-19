package com.flower.client.productinfo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;

@SuppressWarnings("serial")
public class ProductInfoPanel extends JPanel implements ActionListener{
	private JButton jbtnImg, jbtnProduct;
	private StyleButton sbtnReview;
	private EmphasisButton ebtnBuy;
	private JScrollPane jsp;
	private MainClass mc;
	
	// ------- Constructor ---------
	public ProductInfoPanel(MainClass mc) {
		// �ʱ⼳��
		this.mc = mc;
		setLayout(null);
		setBackground(Color.WHITE);
		
		// ���� ��� ��ǰ ����
		jbtnImg = new JButton();	// ��ǰ���� ��ư ����
		jbtnImg.setBounds(50, 50, 200, 200);	// ��ǰ���� ��ư ũ��, ��ġ ����
		jbtnImg.setEnabled(false);	// ��ǰ���� ��ư Ŭ�� ��Ȱ��ȭ
		add(jbtnImg);	// ��ǰ���� ��ư ����
		
		// ���� ��� ��ǰ ����
		jbtnProduct = new JButton();	// ��ǰ���� ��ư ����	
		jbtnProduct.setBounds(290, 50, 250, 140);	// ��ǰ���� ��ư ũ��, ��ġ ����
		jbtnImg.setEnabled(false);	// ��ǰ���� ��ư Ŭ�� ��Ȱ��ȭ
		add(jbtnProduct);	// ��ǰ���� ��ư ����
		
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
