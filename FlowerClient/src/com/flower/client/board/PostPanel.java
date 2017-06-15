package com.flower.client.board;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

// PostPanel class
@SuppressWarnings("serial")
public class PostPanel extends JPanel {
	private JLabel jlabGrade;// ��� ���̺�
	private JLabel jlabName;// �г��� ���̺�
	private JLabel jlabDate;// ���� ���̺�
	private JLabel jlabTitle;// ���� ���̺�
	private JLabel jlabImg;// �̹��� ���̺�
	private JTextArea jtaComment;// ���� �ؽ�Ʈ �����
	
	// --- Constructor ---
	/**
	 * ����Ʈ�г��� �⺻�����ڷ� �г� ũ�� �� ������Ʈ �ʱ� ��ġ���� �����Ѵ�.
	 * */
	public PostPanel() {
		// �⺻ ����
		setBackground(Color.WHITE); // ������ �������
		setSize(new Dimension(550, 150)); // �ʱ� ũ�� ����
		setLayout(null); // ��ġ������ ����
		
		// ������Ʈ ��ġ
		// ���
		jlabGrade = new JLabel(); // ��� ���̺� ����
		jlabGrade.setBounds(10, 10, 70, 20); // �ʱ���ġ&ũ�� ����
		jlabGrade.setForeground(Color.MAGENTA); // �ؽ�Ʈ ���� ����
		add(jlabGrade); // �гο� �߰��Ѵ�.
		
		// �г���
		jlabName = new JLabel(); // �г��� ���̺� ����
		jlabName.setHorizontalAlignment(SwingConstants.RIGHT); // ������ ����
		jlabName.setBounds(350, 10, 100, 20); // �ʱ���ġ&ũ�� ����
		add(jlabName); // �гο� �߰��Ѵ�.
		
		// ����
		jlabDate = new JLabel(); // ���� ���̺� ����
		jlabDate.setBounds(460, 10, 75, 20); // �ʱ���ġ&ũ�� ����
		add(jlabDate); // �гο� �߰��Ѵ�.
		
		// ����
		jlabTitle = new JLabel(); // ���� ���̺� ����
		jlabTitle.setBounds(10, 40, 525, 20); // �ʱ���ġ&ũ�� ����
		add(jlabTitle); // �гο� �߰��Ѵ�.
		
		// �̹���
		jlabImg = new JLabel("N/A"); // �̹��� ���̺� ����
		jlabImg.setBounds(10, 70, 70, 70); // �ʱ���ġ&ũ�� ����
		add(jlabImg); // �гο� �߰��Ѵ�.
		
		// ����
		jtaComment = new JTextArea(); // ���� �ؽ�Ʈ ����� ����
		jtaComment.setBounds(90, 70, 445, 70); // �ʱ���ġ&ũ�� ����
		jtaComment.setLineWrap(true); // �ڵ��ٹٲ� ����
		jtaComment.setEditable(false); // ���� �Ұ��� ����
		add(jtaComment); // �гο� �߰��Ѵ�.
	}
	// --- Constructor end ---
	
	/**
	 * ��� �� ������ �����Ѵ�.
	 * 1~5���� ������ �� ������ �ʰ��ϴ� ���ϰ�� ������ �������� 1, �Ǵ� 5�� �����ȴ�.
	 * 
	 * @param grade : �� ����
	 * */
	public void setGrade(int grade) {
		// ������ �������� 1~5 ������ ��� ���������� ���������.
		if (grade < 1) // 1���� ������� 1��
			grade = 1;
		else if (grade > 5) // 5���� ������� 5��
			grade = 5;
		
		String star = ""; // �� ���ڸ� ������ ���ڿ�
		
		// �䱸���� �� ���� ��ŭ �ݺ��Ͽ� �� ���ڸ� �����Ѵ�.
		for (int i = 1; i <= grade; i++) { // 1~grade
			star += "��";
		} // for end
		
		jlabGrade.setText(star); // �� ���̺� ������ �� ���ڿ��� �����Ѵ�.
	} // setGrade method end
	
	/**
	 * �г��� ���̺� �ؽ�Ʈ�� �����Ѵ�.
	 * 
	 * @param name : ������ �ؽ�Ʈ ����
	 * */
	public void setName(String name) {
		jlabName.setText(name);
	} // setName method end
	
	/**
	 * ���� ���̺� �ؽ�Ʈ�� �����Ѵ�.
	 * 
	 * @param date : ������ ���� �ؽ�Ʈ
	 * */
	public void setDate(String date) {
		jlabDate.setText(date);
	} // setDate method end
	
	/**
	 * ���� ���̺� �ؽ�Ʈ�� �����Ѵ�.
	 * 
	 * @param title : ������ ���� ����
	 * */
	public void setTitle(String title) {
		jlabTitle.setText(title);
	} // setTitle method end
	
	/**
	 * ������ ���̺��� �̹����� �����Ѵ�.
	 * �ܼ��� ��ΰ��� ������ ���ο��� setIcon���� ó���Ѵ�.
	 * 
	 * @param imgPath : �̹��� ���
	 * */
	public void setImg(String imgPath) {
		jlabImg.setIcon(new ImageIcon(imgPath));
	} // setImg method end
	
	/**
	 * �Խñ� ���� �ؽ�Ʈ�� �����Ѵ�.
	 * 
	 * @param comment : ������ �Խñ� ����
	 * */
	public void setComment(String comment) {
		jtaComment.setText(comment);
	} // setComment method end
	
	/**
	 * �г��� ���̺��� ��ġ�� �̵��Ѵ�.
	 * 
	 * @param x : X��ǥ
	 * @param y : Y��ǥ
	 * */
	public void setNameLocation(int x, int y) {
		jlabName.setLocation(x, y); // �г��� ���̺� ��ġ ����
	} // setNameLocation method end
	
	/**
	 * ���� ���̺��� ��ġ�� �̵��Ѵ�.
	 * 
	 * @param x : X��ǥ
	 * @param y : Y��ǥ
	 * */
	public void setDateLocation(int x, int y) {
		jlabDate.setLocation(x, y); // ���� ���̺� ��ġ ����
	} // setDateLocation method end
	
	/**
	 * ���� �ؽ�Ʈ ������� ũ�⸦ �����Ѵ�.
	 * 
	 * @param width : �ʺ�
	 * @param height : ����
	 * */
	public void setCommentSize(int width, int height) {
		jtaComment.setSize(width, height); // ���� �ؽ�Ʈ ����� ũ�� ����
	} // setCommentSize method end
}
// PostPanel class end
