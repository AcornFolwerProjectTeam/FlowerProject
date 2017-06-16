package com.flower.client.orderconfirm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;

@SuppressWarnings("serial")
public class OrderConfirmPanel extends JPanel implements ActionListener, MouseListener{

	MainClass mc;
	JLabel jlbDate, jlbPrice, jlbGet, jlbProductName;
	JButton jbtnProduct;
	EmphasisButton ebtnBoard;
	Font f;
	Boolean flag;
	
	OrderConfirmPanel(MainClass mc, String productName, String productPrice, Boolean flag) {
		this.mc = mc;
		
		// �ʱ� ����
		setLayout(null);
		setBackground(Color.white);
		setSize(500,150);
		
		this.flag = flag; // ������Ȳ�� �ٲ��ֱ� ���� flag
		f = new Font("���� ���", Font.BOLD, 12);	// �� ��Ʈ
		
		// ��¥��
		jlbDate = new JLabel("���� ��¥");	// ��¥ �� ����
		// TODO: DB���� ���� ��¥ ������ �ͼ� setText
		jlbDate.setFont(f);	// ��¥�� ��Ʈ ����
		jlbDate.setBounds(30, 55, 80, 40);	// ��¥ �� ũ��, ��ġ ����	
		add(jlbDate);	// ��¥ �� ����
		
		// �̹�����ư
		jbtnProduct = new JButton();	// �̹��� ��ư ����
		// TODO: DB���� ���� ������ �ͼ� �ش��ϴ� �̹��� SET
		jbtnProduct.setBounds(110, 35, 80, 80);	// �̹��� ��ư ũ��, ��ġ ����
		jbtnProduct.setEnabled(false);	// �̹��� ��ư ������ �ʰ� ����
		add(jbtnProduct);	// �̹��� ��ư ����
		
		// ��ǰ���
		jlbProductName = new JLabel(productName);	// ��ǰ�� �� ����
		// TODO: DB���� ��ǰ�� ������ �ͼ� setText
		jlbProductName.setFont(f);	// ��ǰ�� �� ��Ʈ ����
		jlbProductName.setBounds(220,55,100,40);	// ��ǰ�� �� ũ��, ��ġ ����
		jlbProductName.addMouseListener(this);	// ���콺 Ŭ�� Listener ����
		add(jlbProductName);	// ��ǰ�� �� ����
		
		// ��ǰ���ݶ�
		jlbPrice = new JLabel(productPrice);	// ��ǰ���� �� ����
		// TODO: DB���� ��ǰ���� ������ �ͼ� setText
		jlbPrice.setFont(f);	// ��ǰ���� �� ��Ʈ ����
		jlbPrice.setBounds(330, 55, 60, 40);	// ��ǰ���� �� ũ��, ��ġ ����
		add(jlbPrice);	// ��ǰ���ݶ� ����
		
		// ������Ȳ��
		jlbGet = new JLabel();	// ������Ȳ �� ����
		
		
		jlbGet.setFont(f);	// ������Ȳ �� ��Ʈ ����
		jlbGet.setBounds(410, 55, 60, 40);	//������Ȳ �� ũ��, ��ġ ����
		add(jlbGet);	// ������Ȳ �� ����
		
		// �ı� �ۼ���ư
		ebtnBoard = new EmphasisButton("�ı� �ۼ�");	// �ı� �ۼ���ư ����
		ebtnBoard.setFont(f);	// �ı� �ۼ���ư ��Ʈ ����	
		ebtnBoard.setBounds(480, 35, 80, 80);	// �ı� �ۼ���ư ũ��, ��ġ ����
		ebtnBoard.addActionListener(this);	// �ı� �ۼ���ư Listener ����
		add(ebtnBoard);	// �ı� �ۼ���ư ����
		
		if(flag == true){
			jlbGet.setText("���� �Ϸ�");	// ��ǰ ���������� ������Ȳ�� ���ɿϷ�� �����Ѵ�.
		}else {
			jlbGet.setText("�غ���");	// ��ǰ �������� ������ ������Ȳ�� �غ������� �����Ѵ�.
			ebtnBoard.setEnabled(false); // ��ǰ �������� ������ �ı� �ۼ� ��ư ��Ȱ��ȭ�Ѵ�.
		}
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ebtnBoard){	// �ı� �ۼ���ư Ŭ���ϸ�
			mc.changeCardLayout("board");	// �ı� �ۼ� �гη� ��ȯ
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==jlbProductName){	// ��ǰ�� �� Ŭ���ϸ�
			mc.changeCardLayout("productInfo");	// ��ǰ �� ���� �г� ��ȯ
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
