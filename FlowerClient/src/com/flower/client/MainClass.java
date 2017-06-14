package com.flower.client;

import java.awt.CardLayout;

import com.flower.client.container.SingleContainPanal;
import com.flower.client.container.MenuContainPanal;
import com.flower.client.login.LoginPanel;
import com.flower.client.register.RegisterPanel;

public class MainClass {
	// �ʵ庯��
	CardLayout cly; // ī�巹�̾ƿ�
	MainFrame mf; // ����������
	LoginPanel loginPanel; // �α��� �г�
	SingleContainPanal loginScp; // �α����г� ��� ���� ������ �г�
	RegisterPanel registerPanel; // ȸ������ �г�
	MenuContainPanal registerMcp; // ȸ������ �г� ��� ���� ������ �г�

	// --- Constructors ---
	// �⺻������ : �ʵ� ���� �ʱ�ȭ �� ��ü ����
	public MainClass() {
		// ������
		cly = new CardLayout(); // �����̳ʸ� ����Ī���� ī�� ���̾ƿ�
		// �α��� �����̳� �� ������Ʈ
		mf = new MainFrame(); // ���� ������ ���� �� ȭ���� ���.
		loginPanel = new LoginPanel(this); // �α��� �г�
		loginScp = new SingleContainPanal(mf, loginPanel); // �α��ο� �߾����� �����̳� ���� �� �Ű��� ����.
		// ȸ������ �����̳� �� ������Ʈ
		registerPanel = new RegisterPanel(); // ȸ������ �г�
		registerMcp = new MenuContainPanal(mf, registerPanel, this, false); // ȸ�����Կ� �־����� �����̳� ���� �� �Ű��� ����.
	}
	// --- Constructors end ---
	
	// changeCardLayout method
	/**
	 * ���������ӿ��� ������ �г��� �����Ѵ�.
	 * 
	 * @param ������ �г��� �̸� ���ڿ�
	 * */
	public void changeCardLayout(String taget) {
		System.out.println(taget);
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
		mc.mf.add(mc.registerMcp, "register"); // �����ӿ� ȸ������ �г� �߰�.
		
		// ȸ������
		
		// ȭ�� ó��
		mc.mf.setVisible(true); // �����������츦 ȭ�鿡 ����.
		
		
	} // main method end

}
