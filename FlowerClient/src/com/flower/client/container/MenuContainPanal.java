package com.flower.client.container;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

import com.flower.client.MainClass;
import com.flower.client.MainFrame;
import com.flower.client.component.BottomBar;
import com.flower.client.component.TopMenuBar;;

// MenuContainPanal class
/**
 * 특정 컨테이너를 항상 화면 가운데로 위치시킬 백패널 클래스.
 * */
@SuppressWarnings("serial")
public class MenuContainPanal extends JPanel implements ComponentListener {
	private MainFrame mf; // 메인프레임(윈도우 크기 값 참조용)
	private TopMenuBar topMenuBar;
	private JPanel jp; // 중앙 정렬 시킬 패널
	private BottomBar bottomBar;
	
	/**
	 * 메인프레임과 중앙정렬시킬 패널을 받는 생성자.
	 * 생성자로 받는 패널고 더불어 상단 메뉴와 하단 이미지바를 출력하고
	 * 컴포넌트이벤트를 통해 윈도우 크기가 변경될때마다 실시간으로 좌표를 계산하여
	 * 패널을 중앙 정렬 및 메뉴바의 크기 및 위치가 동적 이동 및 증감이 된다.
	 * 
	 * @param 윈도우 크기값을 받을 MainFrame과 중앙정렬할 JPanel 컨테이너, 카드레이아웃 정보를 담고있는 MainClass 상단세부 메뉴 출력 여부 Boolean을 받는다.
	 * */
	public MenuContainPanal(MainFrame mf, JPanel jp, MainClass mc, Boolean flag) {
		this.mf = mf; // 메인 프레임주소를 저장한다.
		this.jp = jp;
		
		setLayout(null); // 백그라운드 패널의 배치관리자를 해제한다.
		setSize(mf.getSize()); // 백그라운드 패널의 사이즈는 프레임의 크기로한다.
		setBackground(Color.WHITE); // 백그라운드 패널 색상을 흰색으로
		
		// 상단 메뉴바 배치
		topMenuBar = new TopMenuBar(mc, flag);
		topMenuBar.setLocation(15, 10); // 위치 지정
		add(topMenuBar); // 패널에 메뉴바 추가.
		// 하단 이미지바 배치
		bottomBar = new BottomBar();
		bottomBar.setLocation(15,735); // 위치 지정
		add(bottomBar); // 패널에 이미지바 추가.
		
		jp.setSize(getWidth(), getHeight()); // 패널 크기는 백그라운드 패널 크기와 동일.
		add(jp); // 백그라운드 패널에 패널을 추가한다.
		
		
		addComponentListener(this);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		jp.setLocation(mf.getWidth() / 2 - 300, mf.getHeight() / 2 - 400); // 주 패널 가운데 정렬
		topMenuBar.setSize(mf.getWidth()-50, topMenuBar.getHeight()); // 메뉴바 크기 동적 수정
		topMenuBar.moveOrderBtnLocationX(mf.getWidth()-410);
		topMenuBar.moveChatBtnLocationX(mf.getWidth()-310);
		topMenuBar.moveLogoutBtnLocationX(mf.getWidth()-210);
		
		bottomBar.setLocation(bottomBar.getX(), mf.getHeight()-65); // 이미지바 하단으로 위치 동적 이동
		bottomBar.setSize(mf.getWidth()-50, bottomBar.getHeight()); // 이미지바 크기 동적 수정
	}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
} // MenuContainPanal class end
