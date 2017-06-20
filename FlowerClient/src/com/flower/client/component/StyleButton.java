package com.flower.client.component;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.flower.client.config.EnVal;

@SuppressWarnings("serial")
public class StyleButton extends JButton {
	// --- Constructor ---
	public StyleButton() {
		super();
		// JButton Ŭ������ �⺻ �������� �����Ѵ�.
		//setContentAreaFilled(false); // ���� �׶��̼� ����
		setFocusPainted(false); // ��Ŀ�� ����(���ڿ� �ܰ��� ���ſ�)
		//setOpaque(true);
		
		// ������Ʈ ��ü ��Ÿ�Ϸ� ��ư�� �����Ѵ�.
		setBorder(new LineBorder(EnVal.MAINCOLOR, 2)); // �ܰ��� ����
		setForeground(EnVal.MAINCOLOR); // ���ڻ� ����
		setFont(EnVal.BUTTONFONT); // ��Ʈ ����
		setBackground(Color.white); // ��ư ���� ����
	}
	
	public StyleButton(String text) {
		this();
		setText(text);
	}
	// --- Constructor end ---
}
