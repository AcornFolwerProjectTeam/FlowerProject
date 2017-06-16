package com.flower.client.order;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener , ItemListener{
	private JButton jbtnImg;
	private JLabel jlbTime, jlbBuyerName, jlbBuyerPhone, jlbName, jlbPhone, jlbMsg;
	private JTextField jtfBuyerName, jtfBuyerPhone, jtfName, jtfPhone, jtfTime;
	private JCheckBox jcbInfo;
	private JTextArea jtaMsg;
	private StyleButton sbtnCancel;
	private EmphasisButton ebtnBuy;
	private Font flb, fcb;
	private JScrollPane jspMsg;
	private MainClass mc;
	
	// ------- Constructor ---------
	public OrderPanel(MainClass mc) {
		this.mc = mc;
		// 초기 설정
		setLayout(null);
		setBackground(Color.WHITE);
		
		flb = new Font("맑은 고딕", Font.BOLD, 13); // JLabel 폰트
		fcb = new Font("맑은 고딕", Font.PLAIN, 12);	// 체크박스 폰트
		
		// 상품 이미지 버튼
		jbtnImg = new JButton();	// 이미지가 들어갈 버튼 생성
									// TODO 이미지 붙이기
		jbtnImg.setBounds(30, 150, 170, 245);	// 이미지 크기, 위치 지정
		jbtnImg.setEnabled(false);
		add(jbtnImg);	// 이미지 부착
		
		// 예약 시간 라벨
		jlbTime = new JLabel("예약 시간");	// 예약시간 라벨 생성
		jlbTime.setBounds(235, 155, 100, 20);	// 예약시간 라벨 크기, 위치 지정
		jlbTime.setFont(flb);	// 예약시간 라벨 폰트 설정
		add(jlbTime);	// 예약시간 라벨 부착
		
		// 시간 설정 입력칸
		jtfTime = new JTextField();	// 시간 설정 입력칸 생성
		jtfTime.setBounds(360, 150, 190, 30);	// 시간 설정 크기, 위치 지정
		add(jtfTime);	// 시간설정 콤보박스 부착
		
		// 주문자 이름 라벨
		jlbBuyerName = new JLabel("주문자 이름"); // 주문자 이름 라벨 생성
		jlbBuyerName.setBounds(235, 205, 100, 20);	// 주문자 이름 크기, 위치 지정
		jlbBuyerName.setFont(flb);	// 주문자 이름 라벨 폰트 설정
		add(jlbBuyerName);	// 주문자 이름 라벨 부착
		
		// 주문자 핸드폰번호 라벨
		jlbBuyerPhone = new JLabel("주문자 핸드폰번호");	// 주문자 핸드폰번호 라벨 생성
		jlbBuyerPhone.setBounds(235, 240, 110, 35); // 주문자 핸드폰번호 크기, 위치 지정
		jlbBuyerPhone.setFont(flb);	// 주문자 핸드폰번호 폰트 설정
		add(jlbBuyerPhone);	// 주문자 팬드폰번호 라벨 부착
		
		// 찾는 사람 이름 라벨
		jlbName = new JLabel("찾는사람 이름");	// 찾는사람 이름 라벨 생성
		jlbName.setBounds(235, 330, 100, 20);	// 찾는사람 이름 라벨 크기, 위치 지정
		jlbName.setFont(flb);	// 찾는사람 이름 라벨 폰트 설정
		add(jlbName);	// 찾는사람 이름 라벨 부착
		
		// 핸드폰 번호 라벨
		jlbPhone = new JLabel("핸드폰번호 ");	// 핸드폰 번호 라벨 생성
		jlbPhone.setBounds(235, 370, 100, 20);	// 핸드폰 번호 라벨 크기, 위치 지정
		jlbPhone.setFont(flb);	// 핸드폰 번호 라벨 폰트 설정
		add(jlbPhone);	// 핸드폰 번호 라벨 부착
		
		// 메시지 입력 라벨
		jlbMsg = new JLabel("메시지 입력");		// 메시지 입력 라벨 생성
		jlbMsg.setBounds(30, 420, 100, 20);	// 메시지 입력 라벨 크기, 위치 지정
		jlbMsg.setFont(flb);	// 메시지 입력 라벨 폰트 설정
		add(jlbMsg);	// 메시지 입력 라벨 부착
		
		// 메시지 입력창
		jtaMsg = new JTextArea();	// 메시지 입력창 생성
		jtaMsg.setLineWrap(true);	// JTextArea의 가로 크기에 따라 자동 줄바꿈
		jspMsg = new JScrollPane(jtaMsg, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	// 메시지 입력 스크롤 패널 부착
		jspMsg.setBounds(30, 450, 520, 100);	// 메시지 입력창 크기, 위치 지정
		add(jspMsg);	// 메시지 입력창 부착
		
		// 구매자 이름 입력칸
		jtfBuyerName = new JTextField();	// 구매자 이름 입력칸 생성
		jtfBuyerName.setBounds(360, 200, 190, 30); // 구매자 이름 입력칸 크기, 위치 지정
		add(jtfBuyerName);	// 구매자 이름 입력칸 부착
		
		// 구매자 핸드폰 입력칸
		jtfBuyerPhone = new JTextField();	// 구매자 핸드폰 입력칸 생성
		jtfBuyerPhone.setBounds(360, 240, 190, 30);	// 구매자 핸드폰 입력칸 크기, 위치 지정
		add(jtfBuyerPhone); // 구매자 핸드폰 입력칸 부착
		
		// 주문자 정보와 동일한지 체크
		jcbInfo = new JCheckBox("주문자 정보와 동일");		// 체크박스 생성
		jcbInfo.setBounds(235, 290, 190, 20);	// 체크박스 크기, 위치 지정
		jcbInfo.setFont(fcb);	// 체크박스 폰트 지정
		jcbInfo.setBackground(Color.WHITE);	// 체크박스 배경색 변경
		jcbInfo.addItemListener(this);
		add(jcbInfo);	// 체크박스 부착
		
		// 찾는 사람 이름 입력
		jtfName = new JTextField();	// 찾는 사람 이름 입력칸 생성
		jtfName.setBounds(360, 325, 190, 30);	// 이름 입력칸 크기, 위치 지정
		add(jtfName);	// 찾는 사람 이름 입력칸 부착
		
		// 찾는 사람 이름 입력
		jtfPhone = new JTextField();	// 찾는 사람 핸드폰 입력칸 생성
		jtfPhone.setBounds(360, 365, 190, 30);	// 핸드폰번호 입력칸 크기, 위치 지정
		add(jtfPhone);	// 찾는 사람 핸드폰 입력칸 부착
		
		// 주문 취소 버튼
		sbtnCancel = new StyleButton("주문 취소");	// 주문취소 버튼 생성
		sbtnCancel.setBounds(180, 580, 120, 40);	// 취소버튼 크기, 위치 지정
		sbtnCancel.addActionListener(this);	// 취소버튼에 ActionListener 부착
		add(sbtnCancel);	// 취소버튼 부착
		
		// 주문 버튼
		ebtnBuy = new EmphasisButton("주문 완료");	// 주문버튼 생성
		ebtnBuy.setBounds(310, 580, 120, 40);	// 주문버튼 크기, 위치 지정
		ebtnBuy.addActionListener(this); // 주문 버튼에 ActionListener 부착
		add(ebtnBuy); // 주문버튼 부착
	
		setVisible(true);
		
	}
	
		

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnCancel){
			mc.changeCardLayout("productInfo");	// 주문취소 버튼을 누르면 상품 상세페이지로 이동
		}else if (e.getSource()==ebtnBuy){
			mc.changeCardLayout("orderConfirm"); 	// 주문 버튼을 누르면 주문 확인 페이지로 이동
		}
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		if(jcbInfo.isSelected()==true){
			jtfName.setText(jtfBuyerName.getText());
			jtfPhone.setText(jtfBuyerPhone.getText());			
		};
		
	}
	
	
}
