package com.flower.client.order;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;

public class OrderPanel extends JPanel{
	private JScrollPane jspMsg; // 메시지
	private JTextArea jtaMsg;
	
	private JLabel jlbName, jlbPhone, jlbReceiverName, jlbReceiverPhone;	
	private JTextField jtfName, jtfPhone, jtfReceiverName, jtfReceiverPhone;
	private StyleButton sbtnCancel;
	private EmphasisButton ebtnEnter;
	private JCheckBox jcbReceiver;
	
	// ------- Constructor ---------
	public OrderPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		
		// 주문정보 입력 라벨
		jlbName = new JLabel("주문자이름");
		jlbPhone = new JLabel("주문자 핸드폰"); // 줄바꿈 필요
		jlbReceiverName = new JLabel("찾는사람이름");
		jlbReceiverPhone = new JLabel("핸드폰번호");
				
		// Font 설정
		Font flb = new Font("맑은 고딕", Font.BOLD, 13); // JLabel 폰트
		Font flbmsg = new Font("맑은 고딕", Font.PLAIN, 11);	// 경고 메세지 폰트
	
		// 주문정보 입력 칸

		jtfName = new JTextField();
		jtfPhone = new JTextField();
		jtfReceiverName = new JTextField();
		jtfReceiverPhone = new JTextField();
	
		// 버튼
		sbtnCancel = new StyleButton("취소");
		ebtnEnter = new EmphasisButton("구매");
		
		// 크기 설정
		/*jspMsg.setBounds(30, 500, 570, 200);
		
		jlbId.setBounds(310, 81, 40, 20);
		jlbPw.setBounds(310, 150, 60, 20);
		jlbPwConfirm.setBounds(310, 210, 60, 20);
		jlbName.setBounds(310, 280, 40, 20);
		jlbPhone.setBounds(310, 335, 70, 20);
		
		jtfId.setBounds(400, 75, 160, 30);
		
		jtfPw.setBounds(400, 140, 160, 30);
		
		jtfPwConfirm.setBounds(400, 205, 160, 30);
		
		jtfName.setBounds(400, 270, 160, 30);
		jtfPhone.setBounds(400, 325, 160, 30);
		
		sbtnCancel.setBounds(180, 440, 120, 40);
		ebtnEnter.setBounds(310, 440, 120, 40);*/
		
		
		add(jspMsg);
		add(jlbName);
		add(jlbPhone);
		add(jlbReceiverName);
		add(jlbReceiverPhone);

		add(jtfName);
		add(jtfPhone);
		add(jlbReceiverName);
		add(jlbReceiverPhone);
		
		add(sbtnCancel);
		add(ebtnEnter);
		
		
	}
	
	
}
