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
		
		// 초기 설정
		setLayout(null);
		setBackground(Color.white);
		setSize(500,150);
		
		this.flag = flag; // 수령현황을 바꿔주기 위한 flag
		f = new Font("맑은 고딕", Font.BOLD, 12);	// 라벨 폰트
		
		// 날짜라벨
		jlbDate = new JLabel("오늘 날짜");	// 날짜 라벨 생성
		// TODO: DB에서 구매 날짜 가지고 와서 setText
		jlbDate.setFont(f);	// 날짜라벨 폰트 설정
		jlbDate.setBounds(30, 55, 80, 40);	// 날짜 라벨 크기, 위치 설정	
		add(jlbDate);	// 날짜 라벨 부착
		
		// 이미지버튼
		jbtnProduct = new JButton();	// 이미지 버튼 생성
		// TODO: DB에서 정보 가지고 와서 해당하는 이미지 SET
		jbtnProduct.setBounds(110, 35, 80, 80);	// 이미지 버튼 크기, 위치 설정
		jbtnProduct.setEnabled(false);	// 이미지 버튼 눌리지 않게 설정
		add(jbtnProduct);	// 이미지 버튼 부착
		
		// 상품명라벨
		jlbProductName = new JLabel(productName);	// 상품명 라벨 생성
		// TODO: DB에서 상품명 가지고 와서 setText
		jlbProductName.setFont(f);	// 상품명 라벨 폰트 설정
		jlbProductName.setBounds(220,55,100,40);	// 상품명 라벨 크기, 위치 설정
		jlbProductName.addMouseListener(this);	// 마우스 클릭 Listener 부착
		add(jlbProductName);	// 상품명 라벨 부착
		
		// 상품가격라벨
		jlbPrice = new JLabel(productPrice);	// 상품가격 라벨 생성
		// TODO: DB에서 상품가격 가지고 와서 setText
		jlbPrice.setFont(f);	// 상품가격 라벨 폰트 설정
		jlbPrice.setBounds(330, 55, 60, 40);	// 상품가격 라벨 크기, 위치 설정
		add(jlbPrice);	// 상품가격라벨 부착
		
		// 수령현황라벨
		jlbGet = new JLabel();	// 수령현황 라벨 생성
		
		
		jlbGet.setFont(f);	// 수령현황 라벨 폰트 설정
		jlbGet.setBounds(410, 55, 60, 40);	//수령현황 라벨 크기, 위치 설정
		add(jlbGet);	// 수령현황 라벨 부착
		
		// 후기 작성버튼
		ebtnBoard = new EmphasisButton("후기 작성");	// 후기 작성버튼 생성
		ebtnBoard.setFont(f);	// 후기 작성버튼 폰트 설정	
		ebtnBoard.setBounds(480, 35, 80, 80);	// 후기 작성버튼 크기, 위치 설정
		ebtnBoard.addActionListener(this);	// 후기 작성버튼 Listener 부착
		add(ebtnBoard);	// 후기 작성버튼 부착
		
		if(flag == true){
			jlbGet.setText("수령 완료");	// 상품 수령했으면 수령현황을 수령완료로 변경한다.
		}else {
			jlbGet.setText("준비중");	// 상품 수령하지 않으면 수령현황을 준비중으로 변경한다.
			ebtnBoard.setEnabled(false); // 상품 수령하지 않으면 후기 작성 버튼 비활성화한다.
		}
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ebtnBoard){	// 후기 작성버튼 클릭하면
			mc.changeCardLayout("board");	// 후기 작성 패널로 전환
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==jlbProductName){	// 상품명 라벨 클릭하면
			mc.changeCardLayout("productInfo");	// 상품 상세 정보 패널 전환
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
