package com.flower.client.login;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.flower.client.component.StyleButton;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel{
	
	private JLabel jlbId, jlbPw;
	private JTextField jtfId;
	private JPasswordField jtfPw; // �н����� �Է��ϸ� ���� ���׶�̷� �����ش�.
	private JLabel imgbox;
	private StyleButton sbtnLogin, sbtnReg;

	// --- Constructor ---
	public LoginPanel() {
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
		add(imgbox);
		add(jlbId);
		add(jlbPw);
		add(jtfId);
		add(jtfPw);
		add(sbtnLogin);
		add(sbtnReg);
	}
	
}
