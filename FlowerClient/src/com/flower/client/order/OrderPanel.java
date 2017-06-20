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
		// �ʱ� ����
		setLayout(null);
		setBackground(Color.WHITE);
		
		flb = new Font("���� ���", Font.BOLD, 13); // JLabel ��Ʈ
		ftf = new Font("���� ���", Font.PLAIN, 13); // �ؽ�Ʈ�ʵ� ��Ʈ
		fcb = new Font("���� ���", Font.PLAIN, 12);	// üũ�ڽ� ��Ʈ
		
		// ��ǰ �̹��� ��ư
		jlbImg = new JLabel();	// �̹����� �� ��ư ����
									// TODO �̹��� ���̱�
		jlbImg.setBounds(30, 150, 170, 245);	// �̹��� ũ��, ��ġ ����
		add(jlbImg);	// �̹��� ����
		
		// ���� �ð� ��
		jlbTime = new JLabel("���� �ð�");	// ����ð� �� ����
		jlbTime.setBounds(235, 155, 100, 20);	// ����ð� �� ũ��, ��ġ ����
		jlbTime.setFont(flb);	// ����ð� �� ��Ʈ ����
		add(jlbTime);	// ����ð� �� ����
		
		// �ð� ���� �Է�ĭ
		jtfTime = new JTextField();	// �ð� ���� �Է�ĭ ����
		jtfTime.setBounds(360, 150, 190, 30);	// �ð� ���� ũ��, ��ġ ����
		jtfTime.setFont(ftf);	// �ð� ���� ��Ʈ ����
		jtfTime.addCaretListener(this);
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
		add(jlbBuyerPhone);	// �ֹ��� �ڵ�����ȣ �� ����
		
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
		jspMsg.setFont(ftf);	// �޽��� �Է�â ��Ʈ ����
		add(jspMsg);	// �޽��� �Է�â ����
		
		// ������ �̸� �Է�ĭ
		jtfBuyerName = new JTextField(mc.getAvo().getName());	// ������ �̸� �Է�ĭ ����, �α����� ������ �̸����� �ʱ�ȭ
		jtfBuyerName.setBounds(360, 200, 190, 30); // ������ �̸� �Է�ĭ ũ��, ��ġ ����
		jtfBuyerName.setFont(ftf);	// ������ �̸� �Է�ĭ ��Ʈ ����
		jtfBuyerName.setEnabled(false);	// ������ �̸� ������ �� ���� ����
		add(jtfBuyerName);	// ������ �̸� �Է�ĭ ����
		
		// ������ �ڵ��� �Է�ĭ
		jtfBuyerPhone = new JTextField(mc.getAvo().getTel());	// ������ �ڵ��� �Է�ĭ ����, �α����� ������ �ڵ��� ��ȣ�� �ʱ�ȭ
		jtfBuyerPhone.setBounds(360, 240, 190, 30);	// ������ �ڵ��� �Է�ĭ ũ��, ��ġ ����
		jtfBuyerPhone.setFont(ftf);	// ������ �ڵ��� �Է�ĭ ��Ʈ ����
		jtfBuyerPhone.setEnabled(false);	// ������ �ڵ��� �Է�ĭ ������ �� ���� ����
		add(jtfBuyerPhone); // ������ �ڵ��� �Է�ĭ ����
		
		// �ֹ��� ������ �������� üũ
		jcbInfo = new JCheckBox("�ֹ��� ������ ����");		// üũ�ڽ� ����
		jcbInfo.setBounds(235, 290, 190, 20);	// üũ�ڽ� ũ��, ��ġ ����
		jcbInfo.setFont(fcb);	// üũ�ڽ� ��Ʈ ����
		jcbInfo.setBackground(Color.WHITE);	// üũ�ڽ� ���� ����
		jcbInfo.addItemListener(this);	// üũ�ڽ� �Է����� �� ã�»�� ���� set �ϱ� ���� Listener ����
		add(jcbInfo);	// üũ�ڽ� ����
		
		// ã�� ��� �̸� �Է�
		jtfName = new JTextField();	// ã�� ��� �̸� �Է�ĭ ����
		jtfName.setBounds(360, 325, 190, 30);	// �̸� �Է�ĭ ũ��, ��ġ ����
		jtfName.setFont(ftf);	// ã�� ��� �̸� �Է�ĭ ��Ʈ ����
		jtfName.addCaretListener(this);	// ���� �˻� ���� Listener
		add(jtfName);	// ã�� ��� �̸� �Է�ĭ ����
		
		// ã�� ��� �ڵ��� �Է�
		jtfPhone = new JTextField();	// ã�� ��� �ڵ��� �Է�ĭ ����
		jtfPhone.setBounds(360, 365, 190, 30);	// �ڵ�����ȣ �Է�ĭ ũ��, ��ġ ����
		jtfPhone.setFont(ftf);	// ã�� ��� �ڵ��� �Է�ĭ ��Ʈ ����
		jtfName.addCaretListener(this);	// ���� �˻� ���� Listener
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
		ebtnBuy.setEnabled(false);
		add(ebtnBuy); // �ֹ���ư ����
	
		setVisible(true);
		
	}
	
	public void setProductData(ProductVO pvo){
		pName = pvo.getfName();
		jlbImg.setIcon(new ImageIcon(pvo.getImgUrl()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnCancel){
			mc.changeCardLayout("productInfo");	// �ֹ���� ��ư�� ������ ��ǰ ���������� �̵�
		}else if (e.getSource()==ebtnBuy){
			//System.out.println(mc.getAvo().getId() + " + " + jtfTime.getText() + " + " + jtfName.getText() + " + " + jtfPhone.getText() + " + " + jtaMsg.getText() + " + " + pName);
			try {
				
				om = new OrderModule();
				Boolean flag = om.order(mc.getAvo().getId(), jtfTime.getText(), jtfName.getText(), jtfPhone.getText(), jtaMsg.getText(), pName);
				om.close();
				if(flag==true){
					new CommonDialog(mc.getMf(), "�������ּż� �����մϴ�.");
					mc.changeCardLayout("productList");
				}else {
					new CommonDialog(mc.getMf(), "��� ������ �Է����ּ���.");
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
		if(jtfTime.getText().length()>0 && jtfName.getText().length()>0 && jtfPhone.getText().length()>0){ // ID�� PW �Է�ĭ �������� ����� �α��� ��ư�� Ȱ��ȭ
			ebtnBuy.setEnabled(true);
		} else {	
			ebtnBuy.setEnabled(false);	// ������ ������ ���� ��ư ��Ȱ��ȭ
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(jcbInfo.isSelected()==true){	// üũ�ڽ� üũ �ϸ�
			jtfName.setText(jtfBuyerName.getText());	// ã�� ��� �̸��� �ֹ��� �̸� ������ ����
			jtfPhone.setText(jtfBuyerPhone.getText());	// ã�»�� �ڵ�����ȣ�� �ֹ��� �ڵ�����ȣ ������ ����
			
			okbtnck();
		};
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource()== jtfTime|| e.getSource()==jtfName || e.getSource()==jtfPhone || e.getSource() == jcbInfo){	// ID �Է�â�� ��й�ȣ �Է�â�� �۾��� �Է��� ������ ���� �˻�
			okbtnck();
		}
		
	}
	
	
}
