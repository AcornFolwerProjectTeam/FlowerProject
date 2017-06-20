package com.flower.client.dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.flower.client.component.StyleButton;
import com.flower.client.config.EnVal;

/**
 * <p>Ŀ���� ���̾�α� Ŭ����.</p>
 * 
 * JDialog ��ӹ޾� �߰� ������ Ŀ���� ���̾�α� Ŭ������ �⺻������ ��޸��� �����ϸ�
 * �����쿡�� ��ü������ �����ϴ� ����ǥ���� ���� �׸��� ������� �ʴ´�.
 * */
@SuppressWarnings("serial") // �ø��� �ѹ��� ������� �����Ƿ� ��� ����ó��
public class CommonDialog extends JDialog implements ActionListener {
	private JLabel jlbMsg; // �޽��� ��¿� ���̺�
	private StyleButton sbtnOk; // Ȯ�ι�ư
	private JPanel jpnBack; // �޽����� Ȯ�ι�ư�� ���� ���г� 
	
	/**
	 * ���̾� �α� �⺻�����ڷ� �� ���̾�α׸� �����ϴ� �����Ӱ� ����� �޽����� �Ű��� �޴´�.
	 * 
	 * @param jframe �� ���̾�α׸� ������ ������(����������)
	 * @param msg ���̾�α׿� ǥ���� �޽���
	 * */
	public CommonDialog(JFrame jframe, String msg) {
		super(jframe, true); // �θ� Ŭ���� ������ ȣ��(������ ���� �� ��� ���� ����)
		
		// �⺻����
		setLayout(null); // �⺻ ��ġ������ ����
		getContentPane().setBackground(Color.WHITE); // ������ ���
		setSize(350, 250); // ������ ũ�� ����
		setLocationRelativeTo(jframe); // �ʱ� ��ġ�� ������ �߾�
		setResizable(false); // ������ ũ������ �Ұ�
		setUndecorated(true); // ����ǥ���� ��� ����
		
		// ������Ʈ ����
		jpnBack = new JPanel(); // �г� ����
		jpnBack.setLayout(null); // �⺻ ��ġ ������ ����
		jpnBack.setBackground(Color.WHITE); // ������ ���
		jpnBack.setSize(this.getSize()); // �г� ũ��� �� ���̾�α� ũ���
		jpnBack.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		add(jpnBack); // ���̾�α׿� �г� �߰�.
		
		// ���޽��� ���̺�
		jlbMsg = new JLabel(msg); // ���̺� ���� �� �޽��� ����
		jlbMsg.setBounds(45, 25, 250, 100); // ��ġ �� ũ�� ����
		jlbMsg.setHorizontalAlignment(SwingConstants.CENTER); // �¿� ��� ����
		jlbMsg.setVerticalAlignment(SwingConstants.CENTER); // ���� ��� ����
		jlbMsg.setFont(EnVal.LABLEFONT); // ��Ʈ ����
		jpnBack.add(jlbMsg); // �гο� �޽��� �߰�.
		
		// Ȯ�ι�ư
		sbtnOk = new StyleButton("Ȯ��"); // ��ư ���� �� �ؽ�Ʈ ����
		sbtnOk.setBounds(125, 140, 100, 40); // ��ġ �� ũ�� ����
		sbtnOk.addActionListener(this); // �̺�Ʈ �߰�.
		jpnBack.add(sbtnOk); // �гο� ��ư �߰�.
		
		setVisible(true); // �����츦 Ȱ��ȭ�Ѵ�.
	}

	// actionPerformed override method : ��ư ������ ó���ϴ� �̺�Ʈ �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false); // �����츦 ��Ȱ��ȭ �Ѵ�.
	} // actionPerformed override method end
} // CommonDialog end
