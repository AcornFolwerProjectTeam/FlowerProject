package com.flower.client.register;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;

@SuppressWarnings("serial")
public class RegisterPanel extends JPanel{
	
	private JScrollPane jspAgreement;
	private JTextArea jtaAgreement;
	private JLabel jlbId, jlbPw, jlbPwConfirm, jlbName, jlbPhone;	
	private JLabel jlbIdMsg, jlbPwMsg, jlbPwConfirmMsg; 
	private JTextField jtfId, jtfName, jtfPhone;
	private JPasswordField jtfPw, jtfPwConfirm;
	private StyleButton sbtnCancel;
	private EmphasisButton ebtnEnter;
	private JCheckBox jcbAgree;
	private RegisterMenuBar menuBar;
	private BottomBar bottomBar;
	
	// ------- Constructor ---------
	public RegisterPanel() {
		setLayout(null);
		setBackground(Color.WHITE);
		
		// �޴� �� & �ϴ� ��
		menuBar = new RegisterMenuBar();
		bottomBar = new BottomBar();
		
		// �������
		jtaAgreement = new JTextArea();
		jspAgreement = new JScrollPane(jtaAgreement, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jcbAgree = new JCheckBox("����� �����մϴ�."); // ��� ���� üũ�ڽ�
		
		// �������� �Է� ��
		jlbId = new JLabel("ID");
		jlbPw = new JLabel("��й�ȣ");
		jlbPwConfirm = new JLabel("<html> ��й�ȣ<br>Ȯ��</html>"); // �ٹٲ� �ʿ�
		jlbName = new JLabel("�̸�");
		jlbPhone = new JLabel("�ڵ�����ȣ");
		jlbIdMsg = new JLabel("�ߺ��� ID�� �����մϴ�.");
		jlbPwMsg = new JLabel("�ùٸ� ��й�ȣ�� �Է����ּ���.");
		jlbPwConfirmMsg = new JLabel("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		
		// Font ����
		Font flb = new Font("���� ���", Font.BOLD, 13); // JLabel ��Ʈ
		Font flbmsg = new Font("���� ���", Font.PLAIN, 11);	// ��� �޼���, üũ�ڽ� ��Ʈ
		jlbId.setFont(flb); // ���� �۾��� �ٸ� �󺧿� ���� �۰� ������ font ����
		jlbIdMsg.setFont(flbmsg);	// ID ���
		jlbPwMsg.setFont(flbmsg);	// PW ���
		jlbPwConfirmMsg.setFont(flbmsg);	// PW Ȯ�� ���
		jcbAgree.setFont(flbmsg);	// üũ�ڽ�
		
		// �������� �Է� ĭ
		jtfId = new JTextField();
		jtfPw = new JPasswordField();
		jtfPwConfirm = new JPasswordField();
		jtfName = new JTextField();
		jtfPhone = new JTextField();
				
		// ��ư
		sbtnCancel = new StyleButton("�Է� ���");
		ebtnEnter = new EmphasisButton("Ȯ��");
		
		// ũ�� ��ġ:��� ����
		jspAgreement.setBounds(30, 160, 250, 330);
		jcbAgree.setBounds(30, 490, 250, 20);
		jcbAgree.setBackground(Color.WHITE);
		
		// ũ�� ��ġ:�������� �Է� �� 
		jlbId.setBounds(310, 178, 40, 20);
		jlbPw.setBounds(310, 247, 60, 20);
		jlbPwConfirm.setBounds(310, 305, 60, 35); // ��й�ȣ Ȯ�� ��: �ٹٲ� ������ ũ�� �ٸ���.
		jlbName.setBounds(310, 377, 40, 20);
		jlbPhone.setBounds(310, 432, 70, 20);
		
		// ũ�� ��ġ: �������� �Է� �� , ��� �޽���
		jtfId.setBounds(400, 175, 160, 30);
		jlbIdMsg.setBounds(400, 205, 200, 20);;
		jtfPw.setBounds(400, 240, 160, 30);
		jlbPwMsg.setBounds(400, 270, 200, 20);
		jtfPwConfirm.setBounds(400, 305, 160, 30);
		jlbPwConfirmMsg.setBounds(400, 335, 200, 20);
		jtfName.setBounds(400, 370, 160, 30);
		jtfPhone.setBounds(400, 425, 160, 30);
		
		// ũ�� ��ġ: ��ư
		sbtnCancel.setBounds(180, 560, 120, 40);
		ebtnEnter.setBounds(310, 560, 120, 40);
		
		// ũ�� ��ġ: �޴���&�ϴܹ�
		menuBar.setLocation(15, 10);
		bottomBar.setLocation(15,735);
		
		// ������Ʈ ����
		add(jspAgreement);
		add(jlbId);
		add(jlbPw);
		add(jlbPwConfirm);
		add(jlbName);
		add(jlbPhone);
		add(jtfId);
		add(jtfPw);
		add(jtfPwConfirm);
		add(jtfName);
		add(jtfPhone);
		add(jlbIdMsg);
		add(jlbPwMsg);
		add(jlbPwConfirmMsg);
		add(sbtnCancel);
		add(ebtnEnter);
		add(jcbAgree);
		add(menuBar);
		add(bottomBar);
		
	}
	
	
}
