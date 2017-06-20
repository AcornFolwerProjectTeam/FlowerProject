package com.flower.client.productinfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.flower.client.MainClass;
import com.flower.client.board.OpenBoardPanel;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;
import com.flower.client.config.EnMethod;
import com.flower.client.config.EnVal;
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
	private ProductVO fvo;
	// ------- Constructor ---------
	public ProductInfoPanel(MainClass mc) {
		// 초기설정
		this.mc = mc;
		setLayout(null);
		setBackground(Color.WHITE);
		
		// 좌측 상단 제품 사진
		jlbImg = new JLabel();	// 제품사진 버튼 생성
		jlbImg.setBounds(50, 50, 200, 200);	// 제품사진 버튼 크기, 위치 지정
		jlbImg.setBorder(new LineBorder(EnVal.MAINCOLOR));	// 테스트를 위한 테두리 설정
		//jlbImg.setEnabled(false);	// 제품사진 버튼 클릭 비활성화
		jlbImg.setIcon(null); //라벨에 이미지 추가한다.
		add(jlbImg);	// 제품사진 버튼 부착
		
		// 우측 상단 제품 정보
		jlbProduct = new JLabel();	// 제품정보 레이블 생성	
		jlbProduct.setBounds(290, 50, 250, 140);	// 제품정보 레이블 크기, 위치 지정
		jlbProduct.setBorder(new LineBorder(EnVal.MAINCOLOR));	// 테스트를 위한 테두리 설정
		//jlbProduct.setEnabled(false);	// 제품정보 이벤트 클릭 비활성화
		add(jlbProduct);	// 제품정보 버튼 부착
		
		// 우측 상단 리뷰보기 버튼
		sbtnReview = new StyleButton("리뷰보기");	// 리뷰보기 버튼 생성
		sbtnReview.setBounds(290, 210, 120, 40);	// 리뷰보기 버튼 크기, 위치 지정
		sbtnReview.addActionListener(this);	// Listener 부착: 클릭 시 게시판 패널로 스크롤 위치 이동
		add(sbtnReview);	// 리뷰보기 버튼 부착
		
		// 우측 상단 바로구매 버튼
		ebtnBuy = new EmphasisButton("바로구매");	// 바로구매 버튼 생성
		ebtnBuy.setBounds(420, 210, 120, 40);	// 바로구매 버튼 크기, 위치 지정
		ebtnBuy.addActionListener(this);	// Listener 부착: 클릭시 주문 패널로 전환
		add(ebtnBuy);	// 바로구매 버튼 부착
		
		// 제품정보가 배치될 패널
		backPanel = new JPanel(); // 패널 생성
		backPanel.setPreferredSize(new Dimension(490, 900)); // 크기 설정
		backPanel.setBackground(Color.WHITE); // 배경색은 흰색
		backPanel.setLayout(null); // 기본 배치관리자 해제
		
		// 상품 상세 설명 대형 이미지 배치용 레이블
		jlbTextImg = new JLabel("");
		jlbTextImg.setLocation(0, 0);
		jlbTextImg.setSize(490,500);
		backPanel.add(jlbTextImg, BorderLayout.NORTH);
		
		// 회원 리뷰 열거형 게시판
		obp = new OpenBoardPanel();
		obp.setLocation(0, 500);
		obp.setSize(490, 400);
		backPanel.add(obp, BorderLayout.CENTER);
		
		backPanel.setPreferredSize(new Dimension(490, jlbTextImg.getHeight()+obp.getHeight())); // 크기 설정
		
		// 상세정보 사진과 게시판 패널이 들어갈 스크롤 패널
		jsp = new JScrollPane(backPanel);	// TODO: 상세정보와 게시판 패널 부착하고 스크롤바
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(50, 290, 490, 430);	// 스크롤패널 크기, 위치 지정
		add(jsp);	// 스크롤 패널 부착
		
		setVisible(true);	// 패널 보이도록
	}
	
	public void setProduct(ProductVO fvo) {
		this.fvo = fvo;
		jlbImg.setIcon(new ImageIcon(fvo.getImgUrl())); // 썸네일 이미지 설정
		jlbProduct.setText(fvo.getfName() + "\n" + fvo.getfPrice()); // 제품명 & 가격
		
		System.out.println(fvo.getTextUrl());
		
		// 이미지를 가져와서 화면 크기에 맞게 줄여 배치한다.
		ImageIcon img = new ImageIcon(fvo.getTextUrl());
		double resizepoint = ((double)(backPanel.getPreferredSize().getWidth()/img.getIconWidth())); // 이미지와 화면 비율을 구한다.
		ImageIcon resizeimg = EnMethod.scaleImage(img, (int)(img.getIconWidth()*resizepoint),
														(int)(img.getIconHeight()*resizepoint)); // 이미지를 비율에 맞게 줄인다.
		jlbTextImg.setIcon(resizeimg); // 크기를 줄인 이미지 대입
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnReview){
			// TODO: 게시판 패널로 스크롤 이동
		} else if (e.getSource()==ebtnBuy){
			mc.changeCardLayout("order"); // OrderPanel로 전환한다.
		}
		
	}
	
}
