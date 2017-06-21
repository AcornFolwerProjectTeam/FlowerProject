package com.flower.client.orderconfirm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;

@SuppressWarnings("serial")
public class OrderConfirmPanel extends JPanel implements ActionListener{

	private MainClass mc;
	private JLabel jlbProduct, jlbDate, jlbPrice, jlbGet, jlbProductName;
	private EmphasisButton ebtnBoard;
	private Font f;
	private int flag;
	private String productName;
	
	public OrderConfirmPanel(MainClass mc , String productName, String img, String date, String productPrice, int flag) {
		this.mc = mc;
		this.productName = productName;
		
		// �ʱ� ����
		setLayout(null);
		setBackground(Color.white);
		setSize(500,150);
		
		this.flag = flag; // ������Ȳ�� �ٲ��ֱ� ���� flag
		f = new Font("���� ���", Font.BOLD, 12);	// �� ��Ʈ
		
		// ��¥��
		jlbDate = new JLabel(date);	// ��¥ �� ����
		// TODO: DB���� ���� ��¥ ������ �ͼ� setText
		jlbDate.setFont(f);	// ��¥�� ��Ʈ ����
		jlbDate.setBounds(20, 60, 80, 20);	// ��¥ �� ũ��, ��ġ ����	
		add(jlbDate);	// ��¥ �� ����
		
		// �̹�����ư
		jlbProduct = new JLabel(new ImageIcon(img));	// �̹��� ��ư ����
		// TODO: DB���� ���� ������ �ͼ� �ش��ϴ� �̹��� SET
		jlbProduct.setBounds(100, 35, 80, 80);	// �̹��� ��ư ũ��, ��ġ ����
		add(jlbProduct);	// �̹��� ��ư ����
		
		// ��ǰ���
		
		jlbProductName = new JLabel(productName);	// ��ǰ�� �� ����
		// TODO: DB���� ��ǰ�� ������ �ͼ� setText
		jlbProductName.setFont(f);	// ��ǰ�� �� ��Ʈ ����
		jlbProductName.setBounds(200,55,100,20);	// ��ǰ�� �� ũ��, ��ġ ����
		jlbProductName.setHorizontalAlignment(SwingConstants.CENTER);	// ��� ����
		add(jlbProductName);	// ��ǰ�� �� ����
		
		// ��ǰ���ݶ�
		jlbPrice = new JLabel(productPrice);	// ��ǰ���� �� ����
		// TODO: DB���� ��ǰ���� ������ �ͼ� setText
		jlbPrice.setFont(f);	// ��ǰ���� �� ��Ʈ ����
		jlbPrice.setBounds(200, 75, 100, 20);	// ��ǰ���� �� ũ��, ��ġ ����
		jlbPrice.setHorizontalAlignment(SwingConstants.CENTER);	// ��� ����
		add(jlbPrice);	// ��ǰ���ݶ� ����

		// ������Ȳ��
		jlbGet = new JLabel();	// ������Ȳ �� ����
		jlbGet.setFont(f);	// ������Ȳ �� ��Ʈ ����
		jlbGet.setBounds(315, 45, 100, 40);	//������Ȳ �� ũ��, ��ġ ����
		add(jlbGet);	// ������Ȳ �� ����
		
		// �ı� �ۼ���ư
		ebtnBoard = new EmphasisButton("�ı� �ۼ�");	// �ı� �ۼ���ư ����
		ebtnBoard.setFont(f);	// �ı� �ۼ���ư ��Ʈ ����	
		ebtnBoard.setBounds(390, 45, 70, 40);	// �ı� �ۼ���ư ũ��, ��ġ ����
		ebtnBoard.addActionListener(this);	// �ı� �ۼ���ư Listener ����
		
		if(flag==0){
			jlbGet.setText("�غ���");	// ��ǰ �������� ������ ������Ȳ�� �غ������� �����Ѵ�.
			ebtnBoard.setEnabled(false); // ��ǰ �������� ������ �ı� �ۼ� ��ư ��Ȱ��ȭ�Ѵ�.
		}else if(flag==1){
			jlbGet.setText("���� �Ϸ�");	// ��ǰ ���������� ������Ȳ�� ���ɿϷ�� �����Ѵ�.
			add(ebtnBoard);	// �ı� �ۼ���ư ����
		}else if(flag==2){
			jlbGet.setText("�ۼ� �Ϸ�");
			ebtnBoard.setEnabled(false);
		}
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ebtnBoard){	// �ı� �ۼ���ư Ŭ���ϸ�
			mc.changeCardLayout("postscript");	// �ı� �ۼ� �гη� ��ȯ
			mc.getBoardWritePanel().setFname(this.productName);
		}
		
	}
}
