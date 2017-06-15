package com.flower.client.container;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import com.flower.client.MainFrame;

// SingleContainPanal class
/**
 * Ư�� �����̳ʸ� �׻� ȭ�� ����� ��ġ��ų ���г� Ŭ����.
 * */
@SuppressWarnings("serial")
public class SingleContainPanal extends JPanel implements ComponentListener {
	private MainFrame mf; // ����������(������ ũ�� �� ������)
	private JPanel jp; // �߾� ���� ��ų �г�
	
	/**
	 * ���������Ӱ� �߾����Ľ�ų �г��� �޴� ������.
	 * ������Ʈ�̺�Ʈ�� ���� ������ ũ�Ⱑ ����ɶ����� �ǽð����� ��ǥ�� ����Ͽ�
	 * �г��� �߾� ���� ��Ų��.
	 * 
	 * @param ���������Ӱ� �߾������� �����̳ʸ� �޴´�. ���������ӿ��� ũ�⸦ �����ϰ� ���� �����̳ʿ� �������ش�.
	 * */
	public SingleContainPanal(MainFrame mf, JPanel jp) {
		this.mf = mf; // ���� �������ּҸ� �����Ѵ�.
		this.jp = jp;
		
		setLayout(null); // ��׶��� �г��� ��ġ�����ڸ� �����Ѵ�.
		setSize(mf.getSize()); // ��׶��� �г��� ������� �������� ũ����Ѵ�.
		setBackground(Color.WHITE); // ��׶��� �г� ������ �������
		
		jp.setSize(getWidth(), getHeight()); // �α��� �г� ũ��� ��׶��� �г� ũ��� ����.
		add(jp); // ��׶��� �гο� �α��� �г��� �߰��Ѵ�.
		
		addComponentListener(this);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		jp.setLocation(mf.getWidth() / 2 - 300, mf.getHeight() / 2 - 400);
	}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
} // SingleContainPanal class end
