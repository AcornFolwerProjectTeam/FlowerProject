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
		// �ʱ� ����
		setLayout(null);
		setBackground(Color.WHITE);
		
		flb = new Font("���� ���", Font.BOLD, 13); // JLabel ��Ʈ
		fcb = new Font("���� ���", Font.PLAIN, 12);	// üũ�ڽ� ��Ʈ
		
		// ��ǰ �̹��� ��ư
		jbtnImg = new JButton();	// �̹����� �� ��ư ����
									// TODO �̹��� ���̱�
		jbtnImg.setBounds(30, 150, 170, 245);	// �̹��� ũ��, ��ġ ����
		jbtnImg.setEnabled(false);
		add(jbtnImg);	// �̹��� ����
		
		// ���� �ð� ��
		jlbTime = new JLabel("���� �ð�");	// ����ð� �� ����
		jlbTime.setBounds(235, 155, 100, 20);	// ����ð� �� ũ��, ��ġ ����
		jlbTime.setFont(flb);	// ����ð� �� ��Ʈ ����
		add(jlbTime);	// ����ð� �� ����
		
		// �ð� ���� �Է�ĭ
		jtfTime = new JTextField();	// �ð� ���� �Է�ĭ ����
		jtfTime.setBounds(360, 150, 190, 30);	// �ð� ���� ũ��, ��ġ ����
		add(jtfTime);	// �ð����� �޺��ڽ� ����
		
		// �ֹ��� �̸� ��
		jlbBuyerName = new JLabel("�ֹ��� �̸�"); // �ֹ��� �̸� �� ����
		jlbBuyerName.setBounds(235, 205, 100, 20);	// �ֹ��� �̸� ũ��, ��ġ ����
		jlbBuyerName.setFont(flb);	// �ֹ��� �̸� �� ��Ʈ ����
		add(jlbBuyerName);	// �ֹ��� �̸� �� ����
		
		// �ֹ��� �ڵ�����ȣ ��
		jlbBuyerPhone = new JLabel("�ֹ��� �ڵ�����ȣ");	// �ֹ��� �ڵ�����ȣ �� ����
		jlbBuyerPhone.setBounds(235, 240, 110, 35); // �ֹ��� �ڵ�����ȣ ũ��, ��ġ ����
		jlbBuyerPhone.setFont(flb);	// �ֹ��� �ڵ�����ȣ ��Ʈ ����
		add(jlbBuyerPhone);	// �ֹ��� �ҵ�����ȣ �� ����
		
		// ã�� ��� �̸� ��
		jlbName = new JLabel("ã�»�� �̸�");	// ã�»�� �̸� �� ����
		jlbName.setBounds(235, 330, 100, 20);	// ã�»�� �̸� �� ũ��, ��ġ ����
		jlbName.setFont(flb);	// ã�»�� �̸� �� ��Ʈ ����
		add(jlbName);	// ã�»�� �̸� �� ����
		
		// �ڵ��� ��ȣ ��
		jlbPhone = new JLabel("�ڵ�����ȣ ");	// �ڵ��� ��ȣ �� ����
		jlbPhone.setBounds(235, 370, 100, 20);	// �ڵ��� ��ȣ �� ũ��, ��ġ ����
		jlbPhone.setFont(flb);	// �ڵ��� ��ȣ �� ��Ʈ ����
		add(jlbPhone);	// �ڵ��� ��ȣ �� ����
		
		// �޽��� �Է� ��
		jlbMsg = new JLabel("�޽��� �Է�");		// �޽��� �Է� �� ����
		jlbMsg.setBounds(30, 420, 100, 20);	// �޽��� �Է� �� ũ��, ��ġ ����
		jlbMsg.setFont(flb);	// �޽��� �Է� �� ��Ʈ ����
		add(jlbMsg);	// �޽��� �Է� �� ����
		
		// �޽��� �Է�â
		jtaMsg = new JTextArea();	// �޽��� �Է�â ����
		jtaMsg.setLineWrap(true);	// JTextArea�� ���� ũ�⿡ ���� �ڵ� �ٹٲ�
		jspMsg = new JScrollPane(jtaMsg, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	// �޽��� �Է� ��ũ�� �г� ����
		jspMsg.setBounds(30, 450, 520, 100);	// �޽��� �Է�â ũ��, ��ġ ����
		add(jspMsg);	// �޽��� �Է�â ����
		
		// ������ �̸� �Է�ĭ
		jtfBuyerName = new JTextField();	// ������ �̸� �Է�ĭ ����
		jtfBuyerName.setBounds(360, 200, 190, 30); // ������ �̸� �Է�ĭ ũ��, ��ġ ����
		add(jtfBuyerName);	// ������ �̸� �Է�ĭ ����
		
		// ������ �ڵ��� �Է�ĭ
		jtfBuyerPhone = new JTextField();	// ������ �ڵ��� �Է�ĭ ����
		jtfBuyerPhone.setBounds(360, 240, 190, 30);	// ������ �ڵ��� �Է�ĭ ũ��, ��ġ ����
		add(jtfBuyerPhone); // ������ �ڵ��� �Է�ĭ ����
		
		// �ֹ��� ������ �������� üũ
		jcbInfo = new JCheckBox("�ֹ��� ������ ����");		// üũ�ڽ� ����
		jcbInfo.setBounds(235, 290, 190, 20);	// üũ�ڽ� ũ��, ��ġ ����
		jcbInfo.setFont(fcb);	// üũ�ڽ� ��Ʈ ����
		jcbInfo.setBackground(Color.WHITE);	// üũ�ڽ� ���� ����
		jcbInfo.addItemListener(this);
		add(jcbInfo);	// üũ�ڽ� ����
		
		// ã�� ��� �̸� �Է�
		jtfName = new JTextField();	// ã�� ��� �̸� �Է�ĭ ����
		jtfName.setBounds(360, 325, 190, 30);	// �̸� �Է�ĭ ũ��, ��ġ ����
		add(jtfName);	// ã�� ��� �̸� �Է�ĭ ����
		
		// ã�� ��� �̸� �Է�
		jtfPhone = new JTextField();	// ã�� ��� �ڵ��� �Է�ĭ ����
		jtfPhone.setBounds(360, 365, 190, 30);	// �ڵ�����ȣ �Է�ĭ ũ��, ��ġ ����
		add(jtfPhone);	// ã�� ��� �ڵ��� �Է�ĭ ����
		
		// �ֹ� ��� ��ư
		sbtnCancel = new StyleButton("�ֹ� ���");	// �ֹ���� ��ư ����
		sbtnCancel.setBounds(180, 580, 120, 40);	// ��ҹ�ư ũ��, ��ġ ����
		sbtnCancel.addActionListener(this);	// ��ҹ�ư�� ActionListener ����
		add(sbtnCancel);	// ��ҹ�ư ����
		
		// �ֹ� ��ư
		ebtnBuy = new EmphasisButton("�ֹ� �Ϸ�");	// �ֹ���ư ����
		ebtnBuy.setBounds(310, 580, 120, 40);	// �ֹ���ư ũ��, ��ġ ����
		ebtnBuy.addActionListener(this); // �ֹ� ��ư�� ActionListener ����
		add(ebtnBuy); // �ֹ���ư ����
	
		setVisible(true);
		
	}
	
		

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnCancel){
			mc.changeCardLayout("productInfo");	// �ֹ���� ��ư�� ������ ��ǰ ���������� �̵�
		}else if (e.getSource()==ebtnBuy){
			mc.changeCardLayout("orderConfirm"); 	// �ֹ� ��ư�� ������ �ֹ� Ȯ�� �������� �̵�
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
