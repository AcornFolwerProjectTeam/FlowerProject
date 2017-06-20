package com.flower.client.config;

import java.awt.Color;
import java.awt.Font;

/**
 * ȯ�溯�� Ŭ������ �׸�����, ���뺯�� �� �����صδ� ���� ���� Ŭ�����̴�.
 * */
public class EnVal {
	/**
	 * ������Ʈ �׸� �����÷�. (RGB : 34, 41, 68)
	 * */
	public static Color MAINCOLOR = new Color(34, 41, 68);
	
	/**
	 * ��ư ��Ʈ (��������/����/ũ��14)
	 * */
	public static Font BUTTONFONT = new Font("���� ����", Font.BOLD, 14);
	
	/**
	 * ���̺� ���� ��Ʈ (��������/����/ũ��14)
	 * */
	public static Font LABLEFONT = new Font("���� ����", Font.BOLD, 13);
	
	/**
	 * �Խ��� ���������� ������ �Խù���
	 * */
	public static int BOARDVIEWNUM = 10;
	
	/**
	 * �Խ��� ���������� ������ ��������
	 * */
	public static int BOARDPAGENUM = 5;
	
	/**
	 * ȭ�� ������ �ڵ� ������ �ִ� �����̳� �ʺ�.
	 * */
	public static int MAXCOMPONENTWIDTH = 800;
	
	/**
	 * ȭ�� ������ �ڵ� ������ �ִ� �����̳� ����.
	 * */
	public static int MAXCOMPONENTHEIGhT = 950;
	
	/**
	 * ���� IP
	 * */
	public static String SERVERIP = "192.168.0.201";
	
	/**
	 * ���� ��Ʈ��ȣ
	 * */
	public static int SERVERPORT = 5000;
	
	/**
	 * ä�� ��Ʈ��ȣ
	 * */
	public static int CHATPORT = 5001;
}