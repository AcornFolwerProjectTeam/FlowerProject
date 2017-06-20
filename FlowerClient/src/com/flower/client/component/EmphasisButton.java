package com.flower.client.component;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.flower.client.config.EnVal;

@SuppressWarnings("serial")
public class EmphasisButton extends JButton {
	// --- Constructor ---
	public EmphasisButton() {
		super();
		// JButton 클래스의 기본 디자인을 해제한다.
		//setContentAreaFilled(false); // 내부 그라데이션 해제
		setFocusPainted(false); // 포커스 해제(글자에 외각선 제거용)
		//setOpaque(true);
		
		// 프로젝트 자체 스타일로 버튼을 설정한다.
		setBorder(new LineBorder(EnVal.MAINCOLOR, 2)); // 외각선 설정
		setForeground(Color.white); // 글자색 설정
		setFont(EnVal.BUTTONFONT); // 폰트 설정
		setBackground(EnVal.MAINCOLOR); // 버튼 배경색 설정
	}
	
	public EmphasisButton(String text) {
		this();
		setText(text);
	}
	// --- Constructor end ---
}
