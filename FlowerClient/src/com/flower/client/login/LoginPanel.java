package com.flower.client.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.flower.client.MainClass;
import com.flower.client.component.StyleButton;
import com.flower.client.dialog.CommonDialog;
import com.flower.client.model.LoginModule;
import com.flower.vo.AccountVO;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel implements ActionListener, CaretListener{
	private MainClass mc;
	private JLabel jlbId, jlbPw;
	private JTextField jtfId;
	private JPasswordField jtfPw; // �н����� �Է��ϸ� ���� ���׶�̷� �����ش�.
	private JLabel imgbox;
	private StyleButton sbtnLogin, sbtnReg;


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
		
		sbtnLogin.setEnabled(false);
		
		// �г� ����
		add(imgbox); // �ΰ� �̹��� �߰�
		add(jlbId); // ID �� �߰�
		add(jlbPw); // PW �� �߰�
		add(jtfId); // Id �ʵ� �߰�
		add(jtfPw); // PW �ʵ� �߰�
		add(sbtnLogin); // �α��� ��ư �߰�
		add(sbtnReg); // ȸ������ ��ư �߰�
	
		// �̺�Ʈ ó��
		jtfId.addCaretListener(this);	// �α��� �Է�â �̺�Ʈ �߰� (���� ����)
		jtfPw.addCaretListener(this);	// ��й�ȣ �Է�â �̺�Ʈ �߰� (���� ����)
		sbtnLogin.addActionListener(this); // �α��� ��ư �̺�Ʈ �߰�
		sbtnReg.addActionListener(this); // ȸ������ ��ư �̺�Ʈ �߰�
		
	}

	// actionPerformed override method
	// ��ư �׼� ������ �ڵ鷯 �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sbtnLogin) { // �α��� ��ư�� ��������
			try {
				LoginModule lm = new LoginModule(); // �α��� ��� ����
				/*
				 * �α��� ����� �α��� �޼��带 ȣ���Ѵ�.
				 * �Ű������� id�� �н����带 �ְ� ������� AccountVO�� ������
				 * �α��� ������ AccountVO�� �����Ͱ� �����ϸ� ����������� null�� �޴´�.
				 * */
				AccountVO avo = lm.login(jtfId.getText(), String.valueOf(jtfPw.getPassword())); // �α��� �õ�.
				lm.close(); // �α����� �������Ƿ� �α��θ���� �����Ѵ�.
				
				// AccountVO�������� ���� ���ΰ� �α��� ���� �����̹Ƿ� ���Ǻб��Ѵ�.
				if (avo != null){ // �α��� ������
					mc.setAvo(avo); // VO�� �Ѱ��ϴ� MainClass�� VO�� �̰��Ѵ�.
					mc.changeCardLayout("productList"); // �α����� �������Ƿ� ȭ���� ��ǰ ����Ʈ�� ��ȯ�Ѵ�.
				} else { // �α��� ���н�
					new CommonDialog(mc.getMf(), "�α��ο� �����߽��ϴ�."); // �α��� ���� ���� ���̾� �α� ���
				} // if end
			}
			catch (ConnectException e1) { // ���� ���� �ð��� �ʰ��Ǿ��� ��� 
				new CommonDialog(mc.getMf(), "������ ������ �� �����ϴ�."); // ���� ���̾� �α� ���
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // try end
		} else if (e.getSource() == sbtnReg) { // ȸ������ ��ư�� ��������
				mc.changeCardLayout("register"); // ȸ������ �гη� ��ȯ.
		} 
	} // actionPerformed override method end

	@Override
	public void caretUpdate(CaretEvent e) {
		if(e.getSource()==jtfId || e.getSource()==jtfPw){	// ID �Է�â�� ��й�ȣ �Է�â�� �۾��� �Է��� ������ ���� �˻�
			if(jtfId.getText().length()>0 && String.valueOf(jtfPw.getPassword()).length()>0){ // ID�� PW �Է�ĭ �������� ����� �α��� ��ư�� Ȱ��ȭ
				sbtnLogin.setEnabled(true);
			} else {	
				sbtnLogin.setEnabled(false);	// ������ ������ �α��� ��ư ��Ȱ��ȭ
			}
		}
	}

}
