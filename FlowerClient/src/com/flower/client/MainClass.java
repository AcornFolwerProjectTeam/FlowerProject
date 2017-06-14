package com.flower.client;

import java.awt.CardLayout;

import com.flower.client.container.SingleContainPanal;
import com.flower.client.login.LoginPanel;

public class MainClass {
	// �ʵ庯��
	CardLayout cly; // ī�巹�̾ƿ�
	SingleContainPanal loginScp; // �г��� �߾� ���� �����ִ� ���г�
	LoginPanel lp; // �α��� �г�
	MainFrame mf; // ����������

	// --- Constructors ---
	// �⺻������ : �ʵ� ���� �ʱ�ȭ �� ��ü ����
	public MainClass() {
		// ������
		cly = new CardLayout(); // �����̳ʸ� ����Ī���� ī�� ���̾ƿ�
		// �α��� �����̳� �� ������Ʈ
		mf = new MainFrame(); // ���� ������ ���� �� ȭ���� ���.
		lp = new LoginPanel(); // �α��� �г�
		loginScp = new SingleContainPanal(mf, lp); // �α��ο� �߾����� �����̳� ���� �� �Ű��� ����.
		// ȸ������ �����̳� �� ������Ʈ
	}
	// --- Constructors end ---
	
	// changeCardLayout method
	/**
	 * ���������ӿ��� ������ �г��� �����Ѵ�.
	 * 
	 * @param ������ �г��� �̸� ���ڿ�
	 * */
	public void changeCardLayout(String taget) {
		cly.show(mf.getContentPane(), taget); // ���������� �г� �̵�
	} // changeCardLayout method end
	
	// main method : ���α׷� ������ ���θ޼���
	public static void main(String[] args) {
		MainClass mc = new MainClass(); // ���� ��ü ����
		
		// �����̳� ����
		// �⺻����
		mc.mf.setLayout(mc.cly); // ���������� ��ġ�����ڸ� ī�巹�̾ƿ�����
		// �α���
		mc.mf.add(mc.loginScp, "login"); // �����ӿ� �α��� �г� �߰�.
		
		// ȸ������
		
		// ȭ�� ó��
		mc.mf.setVisible(true); // �����������츦 ȭ�鿡 ����.
		
		
	} // main method end

}
