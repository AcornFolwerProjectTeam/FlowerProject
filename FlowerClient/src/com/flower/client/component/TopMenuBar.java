package com.flower.client.component;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class TopMenuBar extends JPanel implements ActionListener{
	// TopMenuBar�� ��ǰ�˻�, ��ǰ��, ��ǰ�ֹ�, �ֹ�Ȯ��, �Խ��� �ۼ��� ����

	private EmphasisButton jbtnOrder, jbtnChat, jbtnLogout;
	private JButton jbtnLogo;
	private Image img, newimg;
	private ImageIcon imgicon;

	TopMenuBar(MainClass mc){
		// �ʱ⼳��
		setSize(550, 50);	
		setLayout(null);	
		setBackground(EnVal.MAINCOLOR); // �����÷� ���
		
		// Logo ��ư ����
		imgicon = new ImageIcon("imgs/menubarlogo.png");	// ��ư�� ������ ImageIcon�� �ΰ������ �ִ´�.	
															// ���Ŀ� �����÷� ����� �ΰ� �������� ��ü
		img = imgicon.getImage() ;  // ImageIcon���κ��� �̹����� ������ Image ��ü�� �ִ´�.
		newimg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH ) ;  // �̹��� ����� �����ؼ�  ���ο� Image ��ü�� �ִ´�.
		imgicon = new ImageIcon(newimg);	// ���ο� Image ��ü �޾ƿͼ� ImageIcon ��ü�� �ٽ� �ִ´�.
		
		// �޴� ��ư ����
		jbtnLogo = new JButton(imgicon); // �ΰ��̹��� ��ư
		jbtnOrder = new EmphasisButton("�ֹ�Ȯ��"); // �ֹ�Ȯ��
		jbtnChat = new EmphasisButton("1:1 ä��");		// 1:1 ä��
		jbtnLogout = new EmphasisButton("�α׾ƿ�");	// �α׾ƿ�
		
		// JButton ��ġ, ũ��
		jbtnLogo.setBounds(10, 10, 30, 30);	// �ΰ�
		jbtnOrder.setBounds(240, 10, 100, 30);	// �ֹ�Ȯ��
		jbtnChat.setBounds(340, 10, 100, 30);	// 1:1 ä��
		jbtnLogout.setBounds(440, 10, 100, 30);	// �α׾ƿ�
		
		// �ΰ� �׵θ� ����
		jbtnLogo.setBorder(null);
	
		// ��Ʈ����
		Font f = new Font("���� ���", Font.BOLD, 15);
		jbtnOrder.setFont(f);	// �ֹ�Ȯ�� ��Ʈ
		jbtnChat.setFont(f);		// 1:1 ä�� ��Ʈ
		jbtnLogout.setFont(f);	// �α׾ƿ� ��Ʈ
				
		// �г� ����
		add(jbtnLogo); 	// �ΰ� ��ư ����
		add(jbtnOrder); // �ֹ�Ȯ�� ����
		add(jbtnChat);	// 1:1 ä�� ����
		add(jbtnLogout);	// �α׾ƿ� ����
		
		// �̺�Ʈ ó��
		jbtnLogo.addActionListener(this);	// �ΰ� ��ư ������ ��ǰ�˻����� �̵��Ѵ�.
		jbtnOrder.addActionListener(this);	// �ֹ�Ȯ�� ��ư ������ �ֹ�Ȯ������ �̵��Ѵ�.
		jbtnChat.addActionListener(this);	// 1:1 ä�� ��ư ������ ä�� �������� ����.
		jbtnLogout.addActionListener(this);	// �α׾ƿ� ��ư ������ �α׾ƿ� ó���Ѵ�.
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
