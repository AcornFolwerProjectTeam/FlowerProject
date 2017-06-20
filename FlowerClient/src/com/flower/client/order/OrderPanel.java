package com.flower.client.order;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;
import com.flower.client.dialog.CommonDialog;
import com.flower.client.model.OrderModule;
import com.flower.vo.ProductVO;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel implements ActionListener , ItemListener, CaretListener{
	private JLabel jlbImg, jlbTime, jlbBuyerName, jlbBuyerPhone, jlbName, jlbPhone, jlbMsg;
	private JTextField jtfBuyerName, jtfBuyerPhone, jtfName, jtfPhone, jtfTime;
	private JCheckBox jcbInfo;
	private JTextArea jtaMsg;
	private StyleButton sbtnCancel;
	private EmphasisButton ebtnBuy;
	private Font flb, fcb, ftf;
	private JScrollPane jspMsg;
	private MainClass mc;
	private String pName;
	private OrderModule om;
	
	// ------- Constructor ---------
	public OrderPanel(MainClass mc) {
		this.mc = mc;
		// 초기 설정
		setLayout(null);
		setBackground(Color.WHITE);
		
		flb = new Font("맑은 고딕", Font.BOLD, 13); // JLabel 폰트
		ftf = new Font("맑은 고딕", Font.PLAIN, 13); // 텍스트필드 폰트
		fcb = new Font("맑은 고딕", Font.PLAIN, 12);	// 체크박스 폰트
		
		// 상품 이미지 버튼
		jlbImg = new JLabel();	// 이미지가 들어갈 버튼 생성
									// TODO 이미지 붙이기
		jlbImg.setBounds(30, 150, 170, 245);	// 이미지 크기, 위치 지정
		add(jlbImg);	// 이미지 부착
		
		// 예약 시간 라벨
		jlbTime = new JLabel("예약 시간");	// 예약시간 라벨 생성
		jlbTime.setBounds(235, 155, 100, 20);	// 예약시간 라벨 크기, 위치 지정
		jlbTime.setFont(flb);	// 예약시간 라벨 폰트 설정
		add(jlbTime);	// 예약시간 라벨 부착
		
		// 시간 설정 입력칸
		jtfTime = new JTextField();	// 시간 설정 입력칸 생성
		jtfTime.setBounds(360, 150, 190, 30);	// 시간 설정 크기, 위치 지정
		jtfTime.setFont(ftf);	// 시간 설정 폰트 설정
		jtfTime.addCaretListener(this);
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
		add(jlbBuyerPhone);	// 주문자 핸드폰번호 라벨 부착
		
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
		jspMsg.setFont(ftf);	// 메시지 입력창 폰트 설정
		add(jspMsg);	// 메시지 입력창 부착
		
		// 구매자 이름 입력칸
		jtfBuyerName = new JTextField(mc.getAvo().getName());	// 구매자 이름 입력칸 생성, 로그인한 유저의 이름으로 초기화
		jtfBuyerName.setBounds(360, 200, 190, 30); // 구매자 이름 입력칸 크기, 위치 지정
		jtfBuyerName.setFont(ftf);	// 구매자 이름 입력칸 폰트 설정
		jtfBuyerName.setEnabled(false);	// 구매자 이름 수정할 수 없게 설정
		add(jtfBuyerName);	// 구매자 이름 입력칸 부착
		
		// 구매자 핸드폰 입력칸
		jtfBuyerPhone = new JTextField(mc.getAvo().getTel());	// 구매자 핸드폰 입력칸 생성, 로그인한 유저의 핸드폰 번호로 초기화
		jtfBuyerPhone.setBounds(360, 240, 190, 30);	// 구매자 핸드폰 입력칸 크기, 위치 지정
		jtfBuyerPhone.setFont(ftf);	// 구매자 핸드폰 입력칸 폰트 설정
		jtfBuyerPhone.setEnabled(false);	// 구매자 핸드폰 입력칸 수정할 수 없게 설정
		add(jtfBuyerPhone); // 구매자 핸드폰 입력칸 부착
		
		// 주문자 정보와 동일한지 체크
		jcbInfo = new JCheckBox("주문자 정보와 동일");		// 체크박스 생성
		jcbInfo.setBounds(235, 290, 190, 20);	// 체크박스 크기, 위치 지정
		jcbInfo.setFont(fcb);	// 체크박스 폰트 지정
		jcbInfo.setBackground(Color.WHITE);	// 체크박스 배경색 변경
		jcbInfo.addItemListener(this);	// 체크박스 입력했을 때 찾는사람 정보 set 하기 위한 Listener 부착
		add(jcbInfo);	// 체크박스 부착
		
		// 찾는 사람 이름 입력
		jtfName = new JTextField();	// 찾는 사람 이름 입력칸 생성
		jtfName.setBounds(360, 325, 190, 30);	// 이름 입력칸 크기, 위치 지정
		jtfName.setFont(ftf);	// 찾는 사람 이름 입력칸 폰트 설정
		jtfName.addCaretListener(this);	// 공백 검사 위한 Listener
		add(jtfName);	// 찾는 사람 이름 입력칸 부착
		
		// 찾는 사람 핸드폰 입력
		jtfPhone = new JTextField();	// 찾는 사람 핸드폰 입력칸 생성
		jtfPhone.setBounds(360, 365, 190, 30);	// 핸드폰번호 입력칸 크기, 위치 지정
		jtfPhone.setFont(ftf);	// 찾는 사람 핸드폰 입력칸 폰트 설정
		jtfName.addCaretListener(this);	// 공백 검사 위한 Listener
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
		ebtnBuy.setEnabled(false);
		add(ebtnBuy); // 주문버튼 부착
	
		setVisible(true);
		
	}
	
	public void setProductData(ProductVO pvo){
		pName = pvo.getfName();
		jlbImg.setIcon(new ImageIcon(pvo.getImgUrl()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnCancel){
			mc.changeCardLayout("productInfo");	// 주문취소 버튼을 누르면 상품 상세페이지로 이동
		}else if (e.getSource()==ebtnBuy){
			//System.out.println(mc.getAvo().getId() + " + " + jtfTime.getText() + " + " + jtfName.getText() + " + " + jtfPhone.getText() + " + " + jtaMsg.getText() + " + " + pName);
			try {
				
				om = new OrderModule();
				Boolean flag = om.order(mc.getAvo().getId(), jtfTime.getText(), jtfName.getText(), jtfPhone.getText(), jtaMsg.getText(), pName);
				om.close();
				if(flag==true){
					new CommonDialog(mc.getMf(), "구매해주셔서 감사합니다.");
					mc.changeCardLayout("productList");
				}else {
					new CommonDialog(mc.getMf(), "모든 정보를 입력해주세요.");
				}
			} catch (ConnectException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}
	}

	private void okbtnck() {
		if(jtfTime.getText().length()>0 && jtfName.getText().length()>0 && jtfPhone.getText().length()>0){ // ID와 PW 입력칸 에공백이 없어야 로그인 버튼을 활성화
			ebtnBuy.setEnabled(true);
		} else {	
			ebtnBuy.setEnabled(false);	// 공백이 있으면 구매 버튼 비활성화
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(jcbInfo.isSelected()==true){	// 체크박스 체크 하면
			jtfName.setText(jtfBuyerName.getText());	// 찾는 사람 이름에 주문자 이름 가지고 오기
			jtfPhone.setText(jtfBuyerPhone.getText());	// 찾는사람 핸드폰번호에 주문자 핸드폰번호 가지고 오기
			
			okbtnck();
		};
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource()== jtfTime|| e.getSource()==jtfName || e.getSource()==jtfPhone || e.getSource() == jcbInfo){	// ID 입력창과 비밀번호 입력창에 글씨를 입력할 때마다 조건 검사
			okbtnck();
		}
		
	}
	
	
}
