package com.flower.client.component;

import javax.swing.JPanel;

import com.flower.client.config.EnVal;

@SuppressWarnings("serial")
public class BottomBar extends JPanel{
	// BottomBar�� ȸ������, ��ǰ�˻�, ��ǰ��, ��ǰ�ֹ�, �ֹ�Ȯ��, �Խ��� �ۼ��� �����Ѵ�.
	public BottomBar(){
		setSize(550, 10);
		setBackground(EnVal.MAINCOLOR); // MainColor ����Ѵ�.
		setVisible(true);
	}
}
