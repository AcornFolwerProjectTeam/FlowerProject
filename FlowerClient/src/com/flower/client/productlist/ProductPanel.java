package com.flower.client.productlist;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.MainClass;

@SuppressWarnings("serial")
public class ProductPanel extends JPanel implements ComponentListener {
	private MainClass mc;
	private TopProdPane tpp;
	private JScrollPane jsp; // ��ǰ ��ũ�� �г�
	private Resize2 rs2;
	
	public ProductPanel(MainClass mc) throws ConnectException, UnknownHostException, IOException{
		this.mc = mc;
		// �⺻ ����
		setSize(600, 800); // ũ�� ����//�⺻ �гλ�����
		setBackground(Color.WHITE);
		setLayout(null);//���� ���̾ƿ�
		addComponentListener(this);
		
		// �г� �߰�.
		tpp = new TopProdPane(mc); // ��� �г� �߰�.
		tpp.setBounds(25, 80, 540, 220);
		//tpp.setBorder(new LineBorder(Color.BLACK));
		add(tpp); // �г� ��ܿ� �߰�.
		
		// �ϴ� ��ǰ ��� �г� �߰�.
		rs2 = new Resize2(mc); // 
		rs2.setProductItemAll(); // ��� ��ǰ�� �����ش�.
		
		// ��ũ�� �г� �����ϰ� ���� �����Ѵ�.
		jsp = new JScrollPane(rs2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(25, 300, 540, 450);
		jsp.getVerticalScrollBar().setUnitIncrement(16); // ��ũ�ѹ� �ӵ�
		add(jsp); // �г� �߾ӿ� �߰�.
	}

	public Resize2 getRs2() {
		return rs2;
	}

	public void setRs2(Resize2 rs2) {
		this.rs2 = rs2;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		tpp.setSize(getWidth()-75, tpp.getHeight()); // ��� �޴� �¿� �ʺ� ����
		jsp.setSize(getWidth()-75, getHeight()-388);
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
}
