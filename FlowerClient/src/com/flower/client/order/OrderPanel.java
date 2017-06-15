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
	private JScrollPane jspMsg; // �޽���
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
		
		// �ֹ����� �Է� ��
		jlbName = new JLabel("�ֹ����̸�");
		jlbPhone = new JLabel("�ֹ��� �ڵ���"); // �ٹٲ� �ʿ�
		jlbReceiverName = new JLabel("ã�»���̸�");
		jlbReceiverPhone = new JLabel("�ڵ�����ȣ");
				
		// Font ����
		Font flb = new Font("���� ���", Font.BOLD, 13); // JLabel ��Ʈ
		Font flbmsg = new Font("���� ���", Font.PLAIN, 11);	// ��� �޼��� ��Ʈ
	
		// �ֹ����� �Է� ĭ

		jtfName = new JTextField();
		jtfPhone = new JTextField();
		jtfReceiverName = new JTextField();
		jtfReceiverPhone = new JTextField();
	
		// ��ư
		sbtnCancel = new StyleButton("���");
		ebtnEnter = new EmphasisButton("����");
		
		// ũ�� ����
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
