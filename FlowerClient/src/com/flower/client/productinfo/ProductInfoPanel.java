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
		// 초기설정
		this.mc = mc;
		this.list=list;
		setLayout(null);
		setBackground(Color.WHITE);
		//해당제품과 일치하는 vo정보객체를 받는다.
		fvo=list.get(index);
		
		//썸네일 이미지 경로를 받는 String 객체 생성
		String ThumbUrl=fvo.getImgUrl();
		
		//제품 Thumbnail이미지 들어가는 아이콘 생성
		imgicon= new ImageIcon(ThumbUrl);
		// 좌측 상단 제품 사진
		jlbImg = new JLabel();	// 제품사진 버튼 생성
		jlbImg.setBounds(50, 50, 200, 200);	// 제품사진 버튼 크기, 위치 지정
		jlbImg.setBorder(new LineBorder(EnVal.MAINCOLOR));	// 테스트를 위한 테두리 설정
		jlbImg.setEnabled(false);	// 제품사진 버튼 클릭 비활성화
		jlbImg.setIcon(imgicon); //라벨에 이미지 추가한다.
		add(jlbImg);	// 제품사진 버튼 부착
		
		// 우측 상단 제품 정보
		jlbProduct = new JLabel();	// 제품정보 버튼 생성	
		jlbProduct.setBounds(290, 50, 250, 140);	// 제품정보 버튼 크기, 위치 지정
		jlbProduct.setBorder(new LineBorder(EnVal.MAINCOLOR));	// 테스트를 위한 테두리 설정
		jlbProduct.setEnabled(false);	// 제품정보 버튼 클릭 비활성화
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
		
		// 상세정보 사진과 게시판 패널이 들어갈 스크롤 패널
		jsp = new JScrollPane();	// TODO: 상세정보와 게시판 패널 부착하고 스크롤바
		jsp.setBounds(50, 290, 490, 430);	// 스크롤패널 크기, 위치 지정
		add(jsp);	// 스크롤 패널 부착
		
		setVisible(true);	// 패널 보이도록
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
