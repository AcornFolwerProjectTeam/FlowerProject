package com.flower.client;

import java.awt.Dimension;

import javax.swing.JFrame;

// MainFrame class : ���α׷� ������ Ŭ����.
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	// --- Constructor ---
	public MainFrame() {
		// �ʱ� ����
		setTitle("La Fleur"); // ���� ǥ������ ����.
		setLocation(150, 150); // �������� ȭ��� �ʱ���ġ
		getContentPane().setPreferredSize(new Dimension(600, 800)); // �ʱ� ������ �г� ũ��
		pack(); // ������ �г��� ��Ű��ȭ �Ѵ�.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ���� ǥ���� �����ư�� �⺻ ������ ���α׷� ����� �Ѵ�.
		// �ʱ⼳�� ��
		
		// TODO : �г� �߰� �ڵ� �� ���� ����
		
		// ȭ�� ����
		setVisible(true); // ȭ�鿡 �����츦 ����.
		setMinimumSize(getSize()); // �ʱ� ����� ������ ũ�⸦ �������� ������ �ּ� ũ�⸦ �����Ѵ�.
	}
	// --- Constructor end ---
	
	// main method : ���α׷� ������ ���θ޼���
	public static void main(String[] args) {
		new MainFrame(); // �����츦 ����.
	}
	// main method end

} // MainFrame class end
