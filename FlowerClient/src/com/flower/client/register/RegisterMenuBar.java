package com.flower.client.register;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class RegisterMenuBar extends JPanel{
	// RegisterMenuBar�� ������ �̵��� ���� �޴��� ���� ���·� ȸ������ ���������� �����Ѵ�.
	
	Toolkit tool = Toolkit.getDefaultToolkit();
	Image img = tool.getImage("imgs/menubarlogo.png"); //�ΰ� �̹���(�����÷� ����� �ΰ� �̹��� ����� ���� ��ü)

	RegisterMenuBar(){
		setSize(550, 50);
		setBackground(EnVal.MAINCOLOR); // �����÷� ���
		setVisible(true);
	}
	
	// �̹��� ���� method
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 10, 10, 30, 30,this);
	}
}
