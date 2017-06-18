package com.flower.client.component;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.client.chat.ChatDialog;
import com.flower.client.dialog.CommonDialog;
import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class TopMenuBar extends JPanel implements ActionListener{
	// TopMenuBar�� ��ǰ�˻�, ��ǰ��, ��ǰ�ֹ�, �ֹ�Ȯ��, �Խ��� �ۼ��� ����

	private MainClass mc;
	private EmphasisButton jbtnOrder, jbtnChat, jbtnLogout;
	private JButton jbtnLogo;
	private Image img, newimg;
	private ImageIcon imgicon;
	private Font f;

	public TopMenuBar(MainClass mc, Boolean flag){	// flag�� true ���̸� �޴���ư�� �����ǰ� �ΰ��ư ActionListener �ٴ´�.
		this.mc = mc;
		f = new Font("���� ���", Font.BOLD, 15); // �޴� ��ư�� ���� ��Ʈ
		
		// �ʱ⼳��
		setSize(550, 50);	
		setLayout(null);	
		setBackground(EnVal.MAINCOLOR); // �����÷� ���
		
		// �ΰ� ��ư ����
		imgicon = new ImageIcon("imgs/menubarlogo.png");	// ��ư�� ������ ImageIcon�� �ΰ������ �ִ´�.	
															// ���Ŀ� �����÷� ����� �ΰ� �������� ��ü
		img = imgicon.getImage();  // ImageIcon���κ��� �̹����� ������ Image ��ü�� �ִ´�.
		newimg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH );  // �̹��� ����� �����ؼ�  ���ο� Image ��ü�� �ִ´�.
		imgicon = new ImageIcon(newimg);	// ���ο� Image ��ü �޾ƿͼ� ImageIcon ��ü�� �ٽ� �ִ´�.
		
		jbtnLogo = new JButton(imgicon); // �ΰ��̹��� ��ư ����
		jbtnLogo.setBounds(10, 10, 30, 30);	// �ΰ��ư ��ġ, ũ�� ����
		jbtnLogo.setBorder(null); // �ΰ��ư �׵θ� ����
		add(jbtnLogo); 	// �ΰ� ��ư ����
		
		// �ֹ�Ȯ�� ��ư ����
		jbtnOrder = new EmphasisButton("�ֹ�Ȯ��"); // �ֹ�Ȯ��
		jbtnOrder.setBounds(240, 10, 100, 30);	// �ֹ�Ȯ�� ��ġ, ũ�� ����
		jbtnOrder.setFont(f);	// �ֹ�Ȯ�� ��Ʈ ����
		
		// 1:1 ä�� ��ư ����
		jbtnChat = new EmphasisButton("1:1 ä��");		// 1:1 ä��
		jbtnChat.setBounds(340, 10, 100, 30);	// 1:1 ä��
		jbtnChat.setFont(f);		// 1:1 ä�� ��Ʈ ����
		
		// �α׾ƿ� ��ư ����
		jbtnLogout = new EmphasisButton("�α׾ƿ�");	// �α׾ƿ�
		jbtnLogout.setBounds(440, 10, 100, 30);	// �α׾ƿ�
		jbtnLogout.setFont(f);	// �α׾ƿ� ��Ʈ ����
		
		if(flag == true){
			// �г� ����
			add(jbtnOrder); // �ֹ�Ȯ�� ����
			add(jbtnChat);	// 1:1 ä�� ����
			add(jbtnLogout);	// �α׾ƿ� ����
			
			// �̺�Ʈ ó��
			jbtnLogo.addActionListener(this);	// �ΰ� ��ư ������ ��ǰ�˻����� �̵��Ѵ�.
			jbtnOrder.addActionListener(this);	// �ֹ�Ȯ�� ��ư ������ �ֹ�Ȯ������ �̵��Ѵ�.
			jbtnChat.addActionListener(this);	// 1:1 ä�� ��ư ������ ä�� �������� ����.
			jbtnLogout.addActionListener(this);	// �α׾ƿ� ��ư ������ �α׾ƿ� ó���Ѵ�.
		}
		
		setVisible(true);
	}
	
	// JButton ActionListener Event
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtnLogo){
			// TO-DO: ��ǰ��� �гη� ��ȯ
		}else if(e.getSource()==jbtnOrder){
			// TO-DO: �ֹ�Ȯ�� �гη� ��ȯ
		}else if(e.getSource()==jbtnChat){
			ChatDialog cd;
			try {
				// ä���г��� �����ϸ� ä�ü��� ���ᰴü�� �ѱ��.
				cd = new ChatDialog(mc.getMf());
				cd.setVisible(true);
			} catch (ConnectException e1) {
				new CommonDialog(mc.getMf(), "ä�� ������ ������ �� �����ϴ�."); // ���� ���̾� �α� ���
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==jbtnLogout){
			// TO-DO: �α׾ƿ� ó��
		}
		
	}

	public void moveOrderBtnLocationX(int x) {
		jbtnOrder.setLocation(x, jbtnOrder.getY());
	}

	public void moveChatBtnLocationX(int x) {
		jbtnChat.setLocation(x, jbtnChat.getY());
	}

	public void moveLogoutBtnLocationX(int x) {
		jbtnLogout.setLocation(x, jbtnLogout.getY());
	}
	
}
