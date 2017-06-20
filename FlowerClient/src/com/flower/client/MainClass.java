package com.flower.client;

import java.awt.CardLayout;
import java.io.IOException;

import com.flower.client.container.SingleContainPanal;
import com.flower.client.board.BoardWritePanel;
import com.flower.client.container.MenuContainPanal;
import com.flower.client.login.LoginPanel;
import com.flower.client.orderconfirm.OrderListPanel;
import com.flower.client.productlist.ProductPanel;
import com.flower.client.register.RegisterPanel;
import com.flower.vo.AccountVO;

public class MainClass {
	// �ʵ庯��
	private CardLayout cly; // ī�巹�̾ƿ�
	private MainFrame mf; // ����������
	private LoginPanel loginPanel; // �α��� �г�
	private SingleContainPanal loginScp; // �α����г� ��� ���� ������ �г�
	private RegisterPanel registerPanel; // ȸ������ �г�
	private MenuContainPanal registerMcp; // ȸ������ �г� ��� ���� ������ �г�
	private ProductPanel productPanel; // ��ǰ ����Ʈ �г�
	private MenuContainPanal productMcp; // ��ǰ ����Ʈ �г� ��� ���� ������ �г�
	private OrderListPanel orderListPanel; // �ֹ� ��� �г�
	private MenuContainPanal orderListMcp; // �ֹ� ��� �г� ��� ���� ������ �г�
	private BoardWritePanel boardWritePanel; // ��ǰ �ı� ���� �г�(�Խ��� ������)
	private MenuContainPanal boardWriteMcp; // ��ǰ �ı� ���� �г� ��� ���� ������ �г�
	private Boolean chatFlag;	// ä��â�� ���� �ִ����� �Ǻ��ϴ� ����
	
	// �ʵ�VO
	private AccountVO avo;

	// --- Constructors ---
	// �⺻������ : �ʵ� ���� �ʱ�ȭ �� ��ü ����
	public MainClass() {
		// ������
		cly = new CardLayout(); // �����̳ʸ� ����Ī���� ī�� ���̾ƿ�
		chatFlag = false; // ChatDialog ���� �Ǻ�
		
		// �α��� �����̳� �� ������Ʈ
		mf = new MainFrame(); // ���� ������ ���� �� ȭ���� ���.
		loginPanel = new LoginPanel(this); // �α��� �г� ����
		loginScp = new SingleContainPanal(mf, loginPanel); // �α��ο� �߾����� �����̳� ���� �� �Ű��� ����.
		// ȸ������ �����̳� �� ������Ʈ
		registerPanel = new RegisterPanel(this); // ȸ������ �г� ����
		registerMcp = new MenuContainPanal(mf, registerPanel, this, false); // ȸ�����Կ� �־����� �����̳� ���� �� �Ű��� ����.
		// �ֹ� ��� �����̳� �� ������Ʈ
		orderListPanel = new OrderListPanel(this); // �ֹ� ��� �г� ����
		orderListMcp = new MenuContainPanal(mf, orderListPanel, this, true); // �ֹ���Ͽ� �߾����� �����̳� ���� �� �Ű��� ����
		// ��ǰ�ı� �����̳� �� ������Ʈ
		boardWritePanel = new BoardWritePanel(this); // ��ǰ �ı� �г� ����
		boardWriteMcp = new MenuContainPanal(mf, boardWritePanel, this, true); // ȸ�����Կ� �־����� �����̳� ���� �� �Ű��� ����.
	}
	// --- Constructors end ---

	// �����ϴ� �������� ������ �����ϴ� �гε��� Ÿ�̹� ������ ���� ���� �޼���� �и��Ѵ�.
	public void loginPass() {
		// ��ǰ ��� �����̳� �� ������Ʈ
		try {
			productPanel = new ProductPanel(this);
			productMcp = new MenuContainPanal(mf, productPanel, this, true); // ��ǰ��Ͽ� �߾����� �����̳� ���� �� �Ű��� ����
			mf.add(productMcp, "productList"); // ��ǰ ����Ʈ.
			changeCardLayout("productList"); // �α����� �������Ƿ� ȭ���� ��ǰ ����Ʈ�� ��ȯ�Ѵ�.
		} catch (IOException e) {
			// TODO : ���� ������ �̵� �ڵ� �ʿ�
			e.printStackTrace();
		} // ��ǰ ��� �г� ����
	} // end loginPass method
	
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
		
		// ȭ�� �߰�.
		mc.mf.add(mc.loginScp, "login"); // �����ӿ� �α��� �г� �߰�.
		mc.mf.add(mc.registerMcp, "register"); // �����ӿ� ȸ������ �г� �߰�.
		mc.mf.add(mc.orderListMcp, "orderList"); // �ֹ� ��� �г� �߰�.
		mc.mf.add(mc.boardWriteMcp, "postscript"); // ���� �ı� ���� �г� �߰�.
		
		// ȭ�� ó��
		mc.mf.setVisible(true); // �����������츦 ȭ�鿡 ����.
		
		
	} // main method end

	
	// --- Getter and Setter ---
	public AccountVO getAvo() {
		return avo;
	}

	public void setAvo(AccountVO avo) {
		this.avo = avo;
	}

	public Boolean getChatFlag() {
		return chatFlag;
	}

	public void setChatFlag(Boolean chatFlag) {
		this.chatFlag = chatFlag;
	}
	
	
	// --- Getter and Setter end ---
}
