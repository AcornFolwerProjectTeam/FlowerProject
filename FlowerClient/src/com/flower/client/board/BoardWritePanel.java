package com.flower.client.board;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.flower.client.MainClass;
import com.flower.client.component.StyleButton;
import com.flower.clinet.config.EnVal;

/*
 * 2x4 ���̺� ������ �������̽��� �ټ��� �����̳�/������Ʈ�� ��ġ�ϰ� �������� �־�
 * �����ϰ� �׸��°����� �����Ѵ�.
 * */


// BoardWritePanel class
@SuppressWarnings("serial") // �ø��� ��ȣ�� ���� �����Ƿ� ��� ����ó��.
public class BoardWritePanel extends JPanel {
	private MainClass mc;
	private JLabel jlabProductName; // ���� ��ǰ�� ���� ĭ
	private JLabel jlabProductNameVal; // ���� ��ǰ�� ǥ�� ĭ
	private JLabel jlabGrade; // ���� ����ĭ
	private JPanel jpanGrade; // ���� ������ư �ݳ� �����̳�
	private JRadioButton[] jrbGrade; // 1~5�� ���� ��ư �迭 
	private ButtonGroup bgGrade; // ���� ��ư �׷� ��ü
	private JLabel jlabTitle; // �Խñ� ���� �Է� ���� ĭ
	private JPanel jpanTitle; // �Խñ� ���� �ؽ�Ʈ�ʵ� �ݳ��� �г�
	private JTextField jtfTitle; // �Խñ� ���� ���Կ� �ؽ�Ʈ�ʵ�
	private JLabel jlabComment; // �Խñ� ���� ���� ĭ
	private JPanel jpanComment; // �Խñ� ���� �ؽ�Ʈ ����� �ݳ��� �г�
	private JTextArea jtaComment; // �Խñ� ���� ���Կ� �ؽ�Ʈ�����
	private StyleButton sbtnCancel; // ��� ��� ��ư
	private StyleButton sbtnPost; // ���(�Խñ� �Խ�) ��ư
	
	// --- Constructor ---
	public BoardWritePanel(MainClass mc) {
		this.mc = mc; // ���ͷѷ� ��鸵�� ���� ����Ŭ������ �޴´�.
		// �⺻����
		setSize(600, 800); // ũ�� ����
		setLayout(null); // �⺻ ��ġ������ ����
		setBackground(Color.WHITE); // ������ �������
		
		// -- ���Ż�ǰ���� --
		// ����ĭ
		jlabProductName = new JLabel("���� ��ǰ��"); // ���̺� ����
		jlabProductName.setBounds(30, 60, 101, 41); // ��ġ �� ũ�� ����
		jlabProductName.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		jlabProductName.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		jlabProductName.setFont(EnVal.LABLEFONT); // ��Ʈ ����
		add(jlabProductName); // �гο� �߰�.
		
		// ���� ǥ��ĭ
		jlabProductNameVal = new JLabel("  "); // ���̺� ����
		jlabProductNameVal.setBounds(130, 60, 400, 41); // ��ġ �� ũ�� ����
		jlabProductNameVal.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		jlabProductNameVal.setFont(EnVal.LABLEFONT); // ��Ʈ ����
		add(jlabProductNameVal); // �гο� �߰�.
		
		// -- ������ --
		// ����ĭ
		jlabGrade = new JLabel("����"); // ���̺� ����
		jlabGrade.setBounds(30, 100, 101, 41); // ��ġ �� ũ�� ����
		jlabGrade.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		jlabGrade.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		jlabGrade.setFont(EnVal.LABLEFONT); // ��Ʈ ����
		add(jlabGrade); // �гο� �߰�.
		
		// ���� ��ư ����
		jrbGrade = new JRadioButton[5]; // �迭 ������ 5��(1~5��)
		bgGrade = new ButtonGroup(); // ���� ��ư�� �׷����� ������ �׷찴ü ����
		// �ݺ������� ��ư ���� �� �ؽ�Ʈ�� �� �߰� �ϰ� �׷����� ���´�.
		String star = "";
		for (int i = 0; i < jrbGrade.length; i++) {
			star += "��"; // �� ������ �ݺ� �� ȸ����ŭ ������Ŵ
			jrbGrade[i] = new JRadioButton(star); // �ؽ�Ʈ�� ���߰�.
			jrbGrade[i].setBackground(Color.WHITE); // ���� ����
			jrbGrade[i].setForeground(Color.MAGENTA); // �� �� ����
			jrbGrade[i].setFocusPainted(false); // ���콺 ���ý� �ߴ� �׵θ� ����
			bgGrade.add(jrbGrade[i]); // �׷쿡 ��ư�߰�.
		}
		
		// ���� ������ư �ݳ� �����̳�
		jpanGrade = new JPanel(); // �г� ����
		jpanGrade.setBounds(130, 100, 400, 41); // ��ġ �� ũ�� ����
		jpanGrade.setBackground(Color.WHITE); // ������ ���
		jpanGrade.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		// �ݺ������� ���� ��ư�� �ݳ� �����̳� �гο� �߰�.
		for (int i = (bgGrade.getButtonCount()-1); i >= 0; i--) {
			jpanGrade.add(jrbGrade[i]);
		}
		jrbGrade[bgGrade.getButtonCount()-1].setSelected(true);
		add(jpanGrade); // �гο� �߰�.
		
		// -- �Խñ� ���� --
		// �Խñ� ���� �Է� ���� ĭ
		jlabTitle = new JLabel("����"); // ���̺� ����
		jlabTitle.setBounds(30, 140, 101, 41); // ��ġ �� ũ�� ����
		jlabTitle.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		jlabTitle.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		jlabTitle.setFont(EnVal.LABLEFONT); // ��Ʈ ����
		add(jlabTitle); // �гο� �߰�.

		// �Խñ� ���� ���Կ� �ؽ�Ʈ�ʵ�
		jtfTitle = new JTextField(); // �ؽ�Ʈ �ʵ� ����
		jtfTitle.setFont(EnVal.LABLEFONT);
		
		// �Խñ� ���� �ؽ�Ʈ�ʵ� �ݳ��� �г�
		jpanTitle = new JPanel(); // �г� ����
		jpanTitle.setBounds(130, 140, 400, 41); // ��ġ �� ũ�� ����
		jpanTitle.setBackground(Color.WHITE); // ������ ���
		jpanTitle.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		jpanTitle.setLayout(null); // �⺻ ��ġ������ ����
		jtfTitle.setBounds(5, 5, jpanTitle.getWidth()-10, jpanTitle.getHeight()-9); // �ؽ�Ʈ �ʵ� ��ġ �� ũ�⸦ ��������
		jpanTitle.add(jtfTitle); // �ؽ�Ʈ�ʵ带 �ݳ� �����̳� �гο� �߰�.
		add(jpanTitle); // �гο� �߰�.
		
		// -- �Խñ� ���� --
		jlabComment = new JLabel("����"); // ���̺� ����
		jlabComment.setBounds(30, 180, 101, 500); // ��ġ �� ũ�� ����
		jlabComment.setHorizontalAlignment(SwingConstants.CENTER); // ��� ����
		jlabComment.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		jlabComment.setFont(EnVal.LABLEFONT); // ��Ʈ ����
		add(jlabComment); // �гο� �߰�.

		// �Խñ� ���� ���Կ� �ؽ�Ʈ�ʵ�
		jtaComment = new JTextArea(); // �ؽ�Ʈ �ʵ� ����
		jtaComment.setFont(EnVal.LABLEFONT);
		jtaComment.setBorder(new LineBorder(Color.LIGHT_GRAY)); // �׵θ� ����
		jtaComment.setLineWrap(true); // �ڵ� �ٹٲ�
		
		// �Խñ� ���� �ؽ�Ʈ�ʵ� �ݳ��� �г�
		jpanComment = new JPanel(); // �г� ����
		jpanComment.setBounds(130, 180, 400, 500); // ��ġ �� ũ�� ����
		jpanComment.setBackground(Color.WHITE); // ������ ���
		jpanComment.setBorder(new LineBorder(EnVal.MAINCOLOR)); // �׵θ� ����
		jpanComment.setLayout(null); // �⺻ ��ġ������ ����
		jtaComment.setBounds(5, 5, jpanComment.getWidth()-10, jpanComment.getHeight()-9); // �ؽ�Ʈ �ʵ� ��ġ �� ũ�⸦ ��������
		jpanComment.add(jtaComment); // �ؽ�Ʈ�ʵ带 �ݳ� �����̳� �гο� �߰�.
		add(jpanComment); // �гο� �߰�.
		
		// -- ��ư --
		// ��� ��� ��ư
		sbtnCancel = new StyleButton("��� ���");
		sbtnCancel.setBounds(150, 695, 140, 40);	// ��ġ �� ũ�� ����
		add(sbtnCancel);
		
		// ��� ��ư
		sbtnPost = new StyleButton("���");
		sbtnPost.setBounds(310, 695, 140, 40);	// ��ġ �� ũ�� ���� 
		add(sbtnPost);
	}
	// --- Constructor end---

	public void setProductName(String productName) {
		jlabProductNameVal.setText("  " + productName); // ��ǰ�� ����
	}
	
} // BoardWritePanel class end
