package com.flower.client.container;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.client.MainFrame;
import com.flower.client.component.BottomBar;
import com.flower.client.component.TopMenuBar;
import com.flower.client.config.EnVal;
import com.flower.client.orderconfirm.OrderListPanel;
import com.flower.client.productlist.ProductPanel;

// MenuContainPanal class
/**
 * Ư�� �����̳ʸ� �׻� ȭ�� ����� ��ġ��ų ���г� Ŭ����.
 * */
@SuppressWarnings("serial")
public class MenuContainPanal extends JPanel implements ComponentListener {
	private MainFrame mf; // ����������(������ ũ�� �� ������)
	private TopMenuBar topMenuBar; // ��� �޴���
	private JPanel jp; // �߾� ���� ��ų �г�
	private int earlyWidth, earlyHeight; // �г��� �ʱ� ũ��.
	private BottomBar bottomBar; // �ϴ� �׷��� ��
	
	/**
	 * ���������Ӱ� �߾����Ľ�ų �г��� �޴� ������.
	 * �����ڷ� �޴� �гΰ� ���Ҿ� ��� �޴��� �ϴ� �̹����ٸ� ����ϰ�
	 * ������Ʈ�̺�Ʈ�� ���� ������ ũ�Ⱑ ����ɶ����� �ǽð����� ��ǥ�� ����Ͽ�
	 * �г��� �߾� ���� �� �޴����� ũ�� �� ��ġ�� ���� �̵� �� ������ �ȴ�.
	 * 
	 * @param ������ ũ�Ⱚ�� ���� MainFrame�� �߾������� JPanel �����̳�, ī�巹�̾ƿ� ������ ����ִ� MainClass ��ܼ��� �޴� ��� ���� Boolean�� �޴´�.
	 * */
	public MenuContainPanal(MainFrame mf, JPanel jp, MainClass mc, Boolean flag) {
		this.mf = mf; // ���� �������ּҸ� �����Ѵ�.
		this.jp = jp; // �г� �ּҸ� �����Ѵ�.
		
		// �г��� �ʱ� ũ�⸦ �����Ѵ�.
		jp.setSize(600, 800); // ��׶��� �г� ũ�� ���� ����
		earlyWidth = jp.getWidth(); // �ʱ� �ʺ�
		earlyHeight = jp.getHeight(); // �ʱ� ����
		
		setLayout(null); // ��׶��� �г��� ��ġ�����ڸ� �����Ѵ�.
		setSize(mf.getSize()); // ��׶��� �г��� ������� �������� ũ����Ѵ�.
		setBackground(Color.WHITE); // ��׶��� �г� ������ �������
		
		// ��� �޴��� ��ġ
		topMenuBar = new TopMenuBar(mc, flag);
		topMenuBar.setLocation(15, 10); // ��ġ ����
		add(topMenuBar); // �гο� �޴��� �߰�.
		// �ϴ� �̹����� ��ġ
		bottomBar = new BottomBar();
		bottomBar.setLocation(15,735); // ��ġ ����
		add(bottomBar); // �гο� �̹����� �߰�.
		
		add(jp); // ��׶��� �гο� �г��� �߰��Ѵ�.
		
		
		addComponentListener(this);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		int increaseWidth = (int) (mf.getWidth() - mf.getMinimumSize().getWidth());
		int increaseHeight = (int) (mf.getHeight() - mf.getMinimumSize().getHeight());
		
		if (jp instanceof OrderListPanel || jp instanceof ProductPanel) {
			int width = earlyWidth+increaseWidth>EnVal.MAXCOMPONENTWIDTH?EnVal.MAXCOMPONENTWIDTH:earlyWidth+increaseWidth;
			width+=16;
			int height = earlyHeight+increaseHeight>EnVal.MAXCOMPONENTHEIGhT?EnVal.MAXCOMPONENTHEIGhT:earlyHeight+increaseHeight;
			height+=38;
			
			jp.setSize(width, height);
		}
		
		jp.setLocation(mf.getWidth() / 2 - jp.getWidth() / 2, mf.getHeight() / 2 - jp.getHeight() / 2); // �� �г� ��� ����
		topMenuBar.setSize(mf.getWidth()-50, topMenuBar.getHeight()); // �޴��� ũ�� ���� ����
		topMenuBar.moveOrderBtnLocationX(mf.getWidth()-410);
		topMenuBar.moveChatBtnLocationX(mf.getWidth()-310);
		topMenuBar.moveLogoutBtnLocationX(mf.getWidth()-210);
		
		bottomBar.setLocation(bottomBar.getX(), mf.getHeight()-65); // �̹����� �ϴ����� ��ġ ���� �̵�
		bottomBar.setSize(mf.getWidth()-50, bottomBar.getHeight()); // �̹����� ũ�� ���� ����
		
	}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
} // MenuContainPanal class end
