package com.flower.client.register;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.flower.client.MainClass;
import com.flower.client.component.EmphasisButton;
import com.flower.client.component.StyleButton;
import com.flower.client.model.RegisterModule;

@SuppressWarnings("serial")
public class RegisterPanel extends JPanel implements ActionListener, CaretListener{
	// TODO: ������ �� db ���� �ȵǵ��� ���� �ɱ�
	
	// GUI ����
	private MainClass mc;
	private JScrollPane jspAgreement;
	private JTextArea jtaAgreement;
	private JLabel jlbId, jlbPw, jlbPwConfirm, jlbName, jlbPhone;	
	private JLabel jlbIdMsg, jlbPwMsg, jlbPwConfirmMsg; 
	private JTextField jtfId, jtfName, jtfPhone;
	private JPasswordField jtfPwConfirm, jtfPw;
	private StyleButton sbtnCancel;
	private EmphasisButton ebtnEnter;
	private JCheckBox jcbAgree;
	private Font flb;
	private Font flbmsg;
	// ������� ���� ����
	private BufferedReader br;
	private StringBuffer term;
	// ���� ����
	private RegisterModule rm;
	
	
	// ------- Constructor ---------
	public RegisterPanel(MainClass mc) {
		this.mc = mc;
		flb = new Font("���� ���", Font.BOLD, 13); // JLabel ��Ʈ
		flbmsg = new Font("���� ���", Font.PLAIN, 11);	// ��� �޼���, üũ�ڽ� ��Ʈ
		
		// �г� �ʱ� ����
		setLayout(null);
		setBackground(Color.WHITE);
		
		// ������� ���� ������ ����
		term = new StringBuffer();
		
		try {
			br = new BufferedReader(new FileReader(new File("src/File/terms.txt")));	// BufferedReader�� �̿��Ͽ� ��� ���� ������ �о�´�.
			while(br.readLine()!=null){	// ������ ���� ������ ��� ���� ������ �о�´�.
				term.append(br.readLine()+"\n");	// ���� ���뿡 1�پ� �о�� ������ �߰��Ѵ�.
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		jtaAgreement = new JTextArea(term.toString()); // ������� ������ ��� JTextArea ����
		jtaAgreement.setLineWrap(true);	// JTextArea�� ���� ũ�⿡ ���� �ڵ� �ٹٲ�
		jspAgreement = new JScrollPane(jtaAgreement, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // ������� ���� ��ũ��
		jspAgreement.setBounds(30, 160, 250, 330); // ������� ���� ũ��, ��ġ ����
		
		
		
		add(jspAgreement);	// ������� ���� ����
		
		// ������� üũ�ڽ�
		jcbAgree = new JCheckBox("����� �����մϴ�."); // üũ�ڽ� ����
		jcbAgree.setFont(flbmsg);	// üũ�ڽ� ��Ʈ ����
		jcbAgree.setBounds(30, 490, 250, 20);	// üũ�ڽ� ũ��, ��ġ ����
		jcbAgree.setBackground(Color.WHITE);	// üũ�ڽ� ���
		add(jcbAgree);	// üũ�ڽ� ����
		
		// ID ��
		jlbId = new JLabel("ID");	//ID �� ����
		jlbId.setFont(flb); // ���� �۾��� �ٸ� �󺧿� ���� �۰� ���̹Ƿ� font �����Ѵ�.
		jlbId.setBounds(310, 178, 40, 20); // ID �� ũ��, ��ġ ����
		add(jlbId);	// ID �� ����
		
		// PW ��
		jlbPw = new JLabel("��й�ȣ"); // PW �� ����
		jlbPw.setBounds(310, 247, 60, 20);	// PW �� ũ��, ��ġ ����
		add(jlbPw);	// PW �� ����
	
		// PW Ȯ�� ��
		jlbPwConfirm = new JLabel("<html> ��й�ȣ<br>Ȯ��</html>"); // PW Ȯ�� �� ����
		jlbPwConfirm.setBounds(310, 305, 60, 35); // ��й�ȣ Ȯ�� ��: �ٹٲ� ������ ũ�� �ٸ���.
		add(jlbPwConfirm);	// PW Ȯ�� �� ����
		
		// �̸� ��
		jlbName = new JLabel("�̸�");	// �̸� �� ����
		jlbName.setBounds(310, 377, 40, 20);	// �̸� �� ũ��, ��ġ ����
		add(jlbName);	// �̸� �� ����
		
		// �ڵ��� ��ȣ ��
		jlbPhone = new JLabel("�ڵ�����ȣ");	// �ڵ��� ��ȣ �� ����
		jlbPhone.setBounds(310, 432, 70, 20);	// �ڵ��� ��ȣ �� ũ��, ��ġ ����
		add(jlbPhone);	// �ڵ�����ȣ �� ����
		
		// ID �ߺ� �޽���
		jlbIdMsg = new JLabel();	// ID �ߺ� �޽��� �� ����
		jlbIdMsg.setFont(flbmsg);	// ID �ߺ� �޽��� ��Ʈ ����	
		jlbIdMsg.setBounds(400, 205, 200, 20);	// ID �ߺ� �޽��� ũ��, ��ġ ����
		add(jlbIdMsg);	// ID �ߺ� �޽��� �� ����
		
		// PW ��� �޽���
		jlbPwMsg = new JLabel();	// PW ��� �޽��� �� ����
		jlbPwMsg.setFont(flbmsg);	// PW ��� �޽��� ��Ʈ ����
		jlbPwMsg.setBounds(400, 270, 200, 20);	// PW ��� �޽��� ũ��, ��ġ ����
		add(jlbPwMsg);	// PW ��� �޽��� �� ����
		
		// PW ���Է�
		jtfPwConfirm = new JPasswordField();	// PW ���Է�ĭ ����
		jtfPwConfirm.setBounds(400, 305, 160, 30);	// PW ���Է�ĭ ũ��, ��ġ ����
		jtfPwConfirm.addCaretListener(this);
		add(jtfPwConfirm);	// PW ���Է�ĭ ����
		
		// PW Ȯ�� ��� �޽���
		jlbPwConfirmMsg = new JLabel();	// PW Ȯ�� ��� �޽��� �� ����
		jlbPwConfirmMsg.setFont(flbmsg);	// PW Ȯ�� ���	 �޽��� �� ��Ʈ ����
		jlbPwConfirmMsg.setBounds(400, 335, 200, 20);	// PW Ȯ�� ��� �޽��� ũ��, ��ġ ����
		add(jlbPwConfirmMsg);	// PW Ȯ�� ��� �޽��� �� ����
		
		// ID �Է�
		jtfId = new JTextField();	// ID �Է�ĭ ����
		jtfId.setBounds(400, 175, 160, 30);	// ID �Է�ĭ ũ��, ��ġ ����
		jtfId.addCaretListener(this); // ID �Է��� �� ��� �޽��� �Է�
		add(jtfId);	// ID �Է�ĭ ����
		
		// PW �Է�
		jtfPw = new JPasswordField(); // PW �Է�ĭ ����
		jtfPw.setBounds(400, 240, 160, 30); // PW �Է�ĭ ũ��, ��ġ ����
		jtfPw.addCaretListener(this);
		add(jtfPw); // PW �Է�ĭ ����
		
		
		// �̸� �Է�
		jtfName = new JTextField();	// �̸� �Է�ĭ ����
		jtfName.setBounds(400, 370, 160, 30);	// �̸� �Է�ĭ ũ��, ��ġ ����
		add(jtfName);	// �̸� �Է�ĭ ����
		
		// �ڵ�����ȣ �Է�
		jtfPhone = new JTextField();	// �ڵ�����ȣ �Է�ĭ ����
		jtfPhone.setBounds(400, 425, 160, 30);	// �ڵ�����ȣ �Է�ĭ ũ��, ��ġ ����
		add(jtfPhone);	// �ڵ�����ȣ �Է�ĭ ����
				
		// ��� ��ư
		sbtnCancel = new StyleButton("���");	// ��ҹ�ư ����: �⺻��ư
		sbtnCancel.setBounds(180, 560, 120, 40);	// ��ҹ�ư ũ��, ��ġ ����
		sbtnCancel.addActionListener(this);	// ��ҹ�ư�� ActionListener ����
		add(sbtnCancel);	// ��ҹ�ư ����
		
		
		// Ȯ�� ��ư
		ebtnEnter = new EmphasisButton("���� �Ϸ�");	// Ȯ�ι�ư ����: ������ư
		ebtnEnter.setBounds(310, 560, 120, 40);	// Ȯ�ι�ư ũ��, ��ġ ����
		ebtnEnter.addActionListener(this); // Ȯ�� ��ư�� ActionListener ����
		add(ebtnEnter); // Ȯ�ι�ư ����

	} // Constructor End

	@Override
	public void caretUpdate(CaretEvent e) {	// ID, PW, PW �������� Ȯ��
		if (e.getSource()==jtfId){	// ID �Է��� ��
			if(jtfId.getText().length()>15 || jtfId.getText().length()<8){	// 8�� �̻� 15�� ���� ���
				jlbIdMsg.setForeground(Color.RED);	// ������ �۾��� ���
				jlbIdMsg.setText("8�� �̻�~15�� ���ϸ� �Է��ϼ���.");	// �޽��� ����
			} else {
				jlbIdMsg.setText("");	// 8�� �̻� 15�� ���ϸ� ��� �޽��� ���ֱ�
			}
			
		}  else if (e.getSource()==jtfPw){	// PW �Է��� ��
			if(String.valueOf(jtfPw.getPassword()).length()>15 || String.valueOf(jtfPw.getPassword()).length()<8){	// 8�� �̻� 15�� ���� ���
				jlbPwMsg.setForeground(Color.RED);	// ������ �۾��� ���
				jlbPwMsg.setText("8�� �̻�~15�� ���ϸ� �Է��ϼ���.");	// �޽��� ����
			} else {
				jlbPwMsg.setText("");	// 8�� �̻� 15�� ���ϸ� ��� �޽��� ���ֱ�
			}
		} else if (e.getSource()==jtfPwConfirm){	// PW Ȯ��â �Է��� ��
			if(!String.valueOf(jtfPwConfirm.getPassword()).equals(String.valueOf(jtfPw.getPassword()))){	// ��й�ȣ�� ��й�ȣ Ȯ��ĭ�� ��ġ���� ������ ���
				jlbPwConfirmMsg.setForeground(Color.RED);	// ������ �۾��� ���
				jlbPwConfirmMsg.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");	// �޽��� ����
			} else {
				jlbPwConfirmMsg.setText("");	// ��й�ȣ�� ��й�ȣ Ȯ��ĭ�� ��ġ�ϸ� ��� �޽��� ���ֱ�
			}
		}
	}	// Override end

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sbtnCancel){	// ��ҹ�ư Ŭ��
			mc.changeCardLayout("login");	//  �α��� �гη� ���ư���
		} else if(e.getSource()==ebtnEnter){	// ���ԿϷ� ��ư Ŭ��
			
			if(jtfId.getText().length()<=15 && jtfId.getText().length()>=8 &&
					String.valueOf(jtfPw.getPassword()).length()<=15 && String.valueOf(jtfPw.getPassword()).length()>=8 &&
					String.valueOf(jtfPwConfirm.getPassword()).equals(String.valueOf(jtfPw.getPassword()))){ // ȸ������ ���� ���� �����ϸ�
				
				rm = new RegisterModule();	// ���� ���� ��ü ����
				Boolean flag = rm.register(jtfId.getText(), String.valueOf(jtfPw.getPassword()), jtfName.getText(), jtfPhone.getText());
				rm.close();
				
				System.out.println("��ü ����");
				
				if((flag==true) && (jcbAgree.isSelected()==true)){
					mc.changeCardLayout("product");
				}
			}
		}
	}

}
	

