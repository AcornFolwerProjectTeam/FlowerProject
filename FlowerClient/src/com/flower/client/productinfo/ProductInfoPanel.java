package com.flower.client.productinfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.flower.client.MainClass;
import com.flower.client.board.OpenBoardPanel;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;
import com.flower.client.config.EnMethod;
import com.flower.client.config.EnVal;
import com.flower.client.model.BoardModule;
import com.flower.vo.BoardDataVO;
import com.flower.vo.ProductVO;

@SuppressWarnings("serial")
public class ProductInfoPanel extends JPanel implements ActionListener{
	private JLabel jlbImg, jlbProduct;
	private StyleButton sbtnReview;
	private EmphasisButton ebtnBuy;
	private JScrollPane jsp;
	private MainClass mc;
	private JPanel backPanel;
	private JLabel jlbTextImg;
	private OpenBoardPanel obp;
	private ProductVO pvo;
	private Font f;
	// ------- Constructor ---------
	public ProductInfoPanel(MainClass mc) {
		// �ʱ⼳��
		this.mc = mc;
		setLayout(null);
		setBackground(Color.WHITE);
		f = new Font("���� ���", Font.BOLD, 17);
		
		// ���� ��� ��ǰ ����
		jlbImg = new JLabel();	// ��ǰ���� ��ư ����
		jlbImg.setBounds(50, 50, 200, 200);	// ��ǰ���� ��ư ũ��, ��ġ ����
		jlbImg.setBorder(new LineBorder(EnVal.MAINCOLOR));	// �׽�Ʈ�� ���� �׵θ� ����
		//jlbImg.setEnabled(false);	// ��ǰ���� ��ư Ŭ�� ��Ȱ��ȭ
		jlbImg.setIcon(null); //�󺧿� �̹��� �߰��Ѵ�.
		add(jlbImg);	// ��ǰ���� ��ư ����
		
		// ���� ��� ��ǰ ����
		jlbProduct = new JLabel();	// ��ǰ���� ���̺� ����	
		jlbProduct.setBounds(290, 50, 250, 140);	// ��ǰ���� ���̺� ũ��, ��ġ ����
		//jlbProduct.setBorder(new LineBorder(EnVal.MAINCOLOR));	// �׽�Ʈ�� ���� �׵θ� ����
		//jlbProduct.setEnabled(false);	// ��ǰ���� �̺�Ʈ Ŭ�� ��Ȱ��ȭ
		jlbProduct.setHorizontalAlignment(SwingConstants.CENTER);
		jlbProduct.setFont(f);
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
		
		// ��ǰ������ ��ġ�� �г�
		backPanel = new JPanel(); // �г� ����
		backPanel.setPreferredSize(new Dimension(490, 900)); // ũ�� ����
		backPanel.setBackground(Color.WHITE); // ������ ���
		backPanel.setLayout(null); // �⺻ ��ġ������ ����
		
		// ��ǰ �� ���� ���� �̹��� ��ġ�� ���̺�
		jlbTextImg = new JLabel("");
		jlbTextImg.setLocation(0, 0);
		jlbTextImg.setSize(490,500);
		backPanel.add(jlbTextImg, BorderLayout.NORTH);
		
		// ȸ�� ���� ������ �Խ���
		obp = new OpenBoardPanel();
		obp.setLocation(0, 500);
		obp.setPreferredSize(new Dimension(470, 400));
		obp.setSize(470,400);
		backPanel.add(obp, BorderLayout.CENTER);
		
		backPanel.setPreferredSize(new Dimension(490, jlbTextImg.getHeight()+obp.getHeight())); // ũ�� ����
		
		// ������ ������ �Խ��� �г��� �� ��ũ�� �г�
		jsp = new JScrollPane(backPanel);	// TODO: �������� �Խ��� �г� �����ϰ� ��ũ�ѹ�
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBounds(50, 290, 490, 430);	// ��ũ���г� ũ��, ��ġ ����
		add(jsp);	// ��ũ�� �г� ����
		
		setVisible(true);	// �г� ���̵���
	}
	
	public void setProduct(ProductVO pvo) {
		this.pvo = pvo;
		jlbImg.setIcon(new ImageIcon(pvo.getThumbNail())); // ����� �̹��� ����
		jlbProduct.setText("<html>" + pvo.getfName() + "<br><br>" + pvo.getfPrice() + "</html>"); // ��ǰ�� & ����
		
		
		
		// �̹����� �����ͼ� ȭ�� ũ�⿡ �°� �ٿ� ��ġ�Ѵ�.
		ImageIcon img = new ImageIcon(pvo.getTextUrl());
		double resizepoint = ((double)((backPanel.getPreferredSize().getWidth()-20)/img.getIconWidth())); // �̹����� ȭ�� ������ ���Ѵ�.
		ImageIcon resizeimg = EnMethod.scaleImage(img, (int)(img.getIconWidth()*resizepoint),
														(int)(img.getIconHeight()*resizepoint)); // �̹����� ������ �°� ���δ�.
		jlbTextImg.setIcon(resizeimg); // ũ�⸦ ���� �̹��� ����
		jlbTextImg.setSize(resizeimg.getIconWidth(), resizeimg.getIconHeight());
		
		obp.setLocation(0, resizeimg.getIconHeight());
		backPanel.setPreferredSize(new Dimension(490, resizeimg.getIconHeight()+obp.getHeight())); // ũ�� ����
		
		setBoard(pvo.getImgUrl(), pvo.getfName()); // �Խ��� �����͸� �����Ѵ�.
	}
	
	private void setBoard(String imgPath, String fname) {
		BoardModule bm;
		try {
			bm = new BoardModule();
			ArrayList<BoardDataVO> list = bm.getPostList(fname);
			bm.close();
			
			if (list.size() > 0)
				obp.setBoard(list, imgPath);
			else
				obp.resetBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnReview){
			mc.changeCardLayout("productList");
		} else if (e.getSource()==ebtnBuy){
			mc.getOrderPanel().setProductData(pvo);
			mc.changeCardLayout("order"); // OrderPanel�� ��ȯ�Ѵ�.
		}
		
	}
	
}
