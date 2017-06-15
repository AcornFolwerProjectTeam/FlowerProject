package com.flower.client.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.flower.client.MainClass;
import com.flower.client.component.StyleButton;
import com.flower.client.model.LoginModule;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel implements ActionListener{
	private MainClass mc;
	private JLabel jlbId, jlbPw;
	private JTextField jtfId;
	private JPasswordField jtfPw; // �н����� �Է��ϸ� ���� ���׶�̷� �����ش�.
	private JLabel imgbox;
	private StyleButton sbtnLogin, sbtnReg;
	private LoginModule lm;


	// --- Constructor ---
	public LoginPanel(MainClass mc) {
		this.mc = mc;
		// �г� �⺻ Layout �����Ѵ�. ������ ������� �Ѵ�.
		setLayout(null);
		setBackground(Color.WHITE);
		
		jlbId = new JLabel("ID");	// ID ��
		jlbPw = new JLabel("PASSWORD");	//PW ��
		jtfId = new JTextField();	// ID �Է�
		jtfPw = new JPasswordField();	// PW �Է�
		sbtnLogin = new StyleButton("�α���");	// �α��ι�ư: �⺻ ��ư
		sbtnReg = new StyleButton("ȸ������");		// ȸ�����Թ�ư: ���� ��ư
		imgbox = new JLabel(new ImageIcon("imgs/logosample.png"));	// J�󺧿� �ΰ� �̹��� ����
		
		// font ����
		Font flb = new Font("���� ���", Font.BOLD, 17); // JLabel ��Ʈ
		Font ftf = new Font("���� ���", Font.PLAIN, 17); // ID, PW �Է� ��Ʈ
		jlbId.setFont(flb);
		jlbPw.setFont(flb);
		jtfId.setFont(ftf);
		jtfPw.setFont(ftf);
	
		// ũ�� ��ġ
		imgbox.setBounds(170, 205, 260, 100); // �ΰ� �̹���
		jlbId.setBounds(100, 360, 50, 20);	// ID ��
		jlbPw.setBounds(100, 411, 100, 20);	// PW ��
		jtfId.setBounds(240, 355, 250, 35);	// ID �Է�
		jtfPw.setBounds(240, 405, 250, 35);	// PW �Է�
		sbtnLogin.setBounds(150, 505, 140, 40);	// �α��� ��ư
		sbtnReg.setBounds(310, 505, 140, 40);	// ȸ������ ��ư 
		
		// �г� ����
		add(imgbox); // �ΰ� �̹��� �߰�
		add(jlbId); // ID �� �߰�
		add(jlbPw); // PW �� �߰�
		add(jtfId); // Id �ʵ� �߰�
		add(jtfPw); // PW �ʵ� �߰�
		add(sbtnLogin); // �α��� ��ư �߰�
		add(sbtnReg); // ȸ������ ��ư �߰�
		
		// �̺�Ʈ ó��
		sbtnLogin.addActionListener(this); // �α��� ��ư �̺�Ʈ �߰�.
		sbtnReg.addActionListener(this); // ȸ������ ��ư �̺�Ʈ �߰�.
	}

	// actionPerformed override method
	// ��ư �׼� ������ �ڵ鷯 �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbtnLogin) { // �α��� ��ư�� ��������
			lm = new LoginModule();
			Boolean flag = lm.login(jtfId.getText(), String.valueOf(jtfPw.getPassword()));
			lm.close();
			if(flag == true){
				mc.changeCardLayout("product");
			}
			// TODO : �α��� ó��. if�� �Ἥ ������, ���н� �и�
		} else if (e.getSource() == sbtnReg) { // ȸ������ ��ư�� ��������
			mc.changeCardLayout("register"); // ȸ������ �гη� ��ȯ.
		} 
	} // actionPerformed override method end
	
}
