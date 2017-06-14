package com.flower.client;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

// MainFrame class : ���α׷� ������ Ŭ����.
@SuppressWarnings("serial") // �ø��� ��ȣ�� �����ʴ´�.
public class MainFrame extends JFrame {

	// --- Constructor ---
	// �⺻ ������
	public MainFrame() {
		// �ʱ� ����
		setTitle("La Fleur"); // ���� ǥ������ ����.
		setLocation(150, 150); // �������� ȭ��� �ʱ���ġ
		getContentPane().setPreferredSize(new Dimension(600, 800)); // �ʱ� ������ �г� ũ��
		pack(); // ������ �г��� ��Ű��ȭ �Ѵ�.
		setDefaultCloseOperation(EXIT_ON_CLOSE); // ���� ǥ���� �����ư�� �⺻ ������ ���α׷� ����� �Ѵ�.
		Image img = Toolkit.getDefaultToolkit().getImage("imgs/menubarlogo.png"); // �������� �����´�.
		setIconImage(img); // ����ǥ���� ������ ����
		// �ʱ⼳�� ��
		
		// TODO : �г� �߰� �ڵ� �� ���� ����
		
		setMinimumSize(getSize()); // �ʱ� ����� ������ ũ�⸦ �������� ������ �ּ� ũ�⸦ �����Ѵ�.
	}
	// --- Constructor end ---

} // MainFrame class end
