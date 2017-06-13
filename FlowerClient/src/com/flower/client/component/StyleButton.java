package com.flower.client.component;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.flower.clinet.config.EnVal;

@SuppressWarnings("serial")
public class StyleButton extends JButton implements MouseListener {
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
	
	// mousePressed Override method : ���콺�� ���� �����϶�
	@Override
	public void mousePressed(MouseEvent e) {
		// ���ڻ��� ������ �����Ѵ�.
		setForeground(Color.white); // ���ڻ� ����
		setBackground(EnVal.MAINCOLOR); // ��ư ���� ����
	} // mousePressed Override method end
	
	// mouseReleased Override method : ���콺�� ������
	@Override
	public void mouseReleased(MouseEvent e) {
		// ������ ���ڻ��� ������ ������.
		setForeground(EnVal.MAINCOLOR); // ���ڻ� ����
		setBackground(Color.white); // ��ư ���� ����
	} // mouseReleased Override method end

	// ������� �ʴ� �������̵� �޼���
	@Override
	public void mouseClicked(MouseEvent e) {}


	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
