package com.flower.client;

import java.awt.CardLayout;

import com.flower.client.container.SingleContainPanal;
import com.flower.client.board.BoardWritePanel;
import com.flower.client.container.MenuContainPanal;
import com.flower.client.login.LoginPanel;
import com.flower.client.register.RegisterPanel;

public class MainClass {
	// �ʵ庯��
	private CardLayout cly; // ī�巹�̾ƿ�
	private MainFrame mf; // ����������
	private LoginPanel loginPanel; // �α��� �г�
	private SingleContainPanal loginScp; // �α����г� ��� ���� ������ �г�
	private RegisterPanel registerPanel; // ȸ������ �г�
	private MenuContainPanal registerMcp; // ȸ������ �г� ��� ���� ������ �г�
	private BoardWritePanel boardWritePanel; // ��ǰ �ı� ���� �г�(�Խ��� ������)
	private MenuContainPanal boardWriteMcp; // ��ǰ �ı� ���� �г� ��� ���� ������ �г�
	

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
		registerPanel = new RegisterPanel(this); // ȸ������ �г�
		registerMcp = new MenuContainPanal(mf, registerPanel, this, false); // ȸ�����Կ� �־����� �����̳� ���� �� �Ű��� ����.
		// ��ǰ�ı� �����̳� �� ������Ʈ
		boardWritePanel = new BoardWritePanel(this);
		boardWriteMcp = new MenuContainPanal(mf, boardWritePanel, this, true); // ȸ�����Կ� �־����� �����̳� ���� �� �Ű��� ����.
	}
	// --- Constructors end ---
	
	// changeCardLayout method
	/**
	 * ���������ӿ��� ������ �г��� �����Ѵ�.
	 * 
	 * @param ������ �г��� �̸� ���ڿ�
	 * */
	public void changeCardLayout(String taget) {
		//System.out.println(taget);
		cly.show(mf.getContentPane(), taget); // ���������� �г� �̵�
	} // changeCardLayout method end
	
	
	public MainFrame getMf() {
		return mf;
	}

	// main method : ���α׷� ������ ���θ޼���
	public static void main(String[] args) {
		MainClass mc = new MainClass(); // ���� ��ü ����
		
		// �����̳� ����
		// �⺻����
		mc.mf.setLayout(mc.cly); // ���������� ��ġ�����ڸ� ī�巹�̾ƿ�����
		
		// �α���
		mc.mf.add(mc.loginScp, "login"); // �����ӿ� �α��� �г� �߰�.
		// ȸ������
		mc.mf.add(mc.registerMcp, "register"); // �����ӿ� ȸ������ �г� �߰�.
		// ��ǰ �ı� ����
		mc.mf.add(mc.boardWriteMcp, "postscript"); // ���� �ı� ���� �г� �߰�.
		
		// ȭ�� ó��
		mc.mf.setVisible(true); // �����������츦 ȭ�鿡 ����.
		
		
	} // main method end

}
