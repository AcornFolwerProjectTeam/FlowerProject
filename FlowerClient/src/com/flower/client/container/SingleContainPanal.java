package com.flower.client.container;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import com.flower.client.MainFrame;

// SingleContainPanal class
/**
 * 특정 컨테이너를 항상 화면 가운데로 위치시킬 백패널 클래스.
 * */
@SuppressWarnings("serial")
public class SingleContainPanal extends JPanel implements ComponentListener {
	private MainFrame mf; // 메인프레임(윈도우 크기 값 참조용)
	private JPanel jp; // 중앙 정렬 시킬 패널
	
	/**
	 * 메인프레임과 중앙정렬시킬 패널을 받는 생성자.
	 * 컴포넌트이벤트를 통해 윈도우 크기가 변경될때마다 실시간으로 좌표를 계산하여
	 * 패널을 중앙 정렬 시킨다.
	 * 
	 * @param 메인프레임과 중앙정렬할 컨테이너를 받는다. 메인프레임에서 크기를 추출하고 같이 컨테이너에 설정해준다.
	 * */
	public SingleContainPanal(MainFrame mf, JPanel jp) {
		this.mf = mf; // 메인 프레임주소를 저장한다.
		this.jp = jp;
		
		setLayout(null); // 백그라운드 패널의 배치관리자를 해제한다.
		setSize(mf.getSize()); // 백그라운드 패널의 사이즈는 프레임의 크기로한다.
		setBackground(Color.WHITE); // 백그라운드 패널 색상을 흰색으로
		
		jp.setSize(getWidth(), getHeight()); // 로그인 패널 크기는 백그라운드 패널 크기와 동일.
		add(jp); // 백그라운드 패널에 로그인 패널을 추가한다.
		
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
