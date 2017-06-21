package com.flower.client.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.component.BottomBar;
import com.flower.vo.BoardDataVO;

// OpenBoardPanel class
/**
 * <p>������ �Խ��� Ŭ����.</p>
 * JScrollPane�� ��ӹ޾� ������ �Խ����� ������ Ŭ����.
 * */
@SuppressWarnings("serial")
public class OpenBoardPanel extends JScrollPane implements ComponentListener {
	private JPanel jpnBackBoard;
	private PostPanel[] jpnPost;
	private BottomBar[] bbLine;
	
	/**
	 * <p>������ �Խ��� �⺻������.</p>
	 * �Խ��ǿ� ���Ǵ� ���� �����̳�, ������Ʈ���� ���� �� �ʱ�ȭ&������ �̷������.
	 * */
	public OpenBoardPanel() {
		super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER); // �¿� ��ũ�ѹٴ� ������, ���� ��ũ�ѹٴ� ���
		setBackground(Color.WHITE);// ������ ������� �Ѵ�.
		setBorder(null);	// �Խ��� �׵θ��� ������ �ʴ´�.
		addComponentListener(this); // ������Ʈ �̺�Ʈ �ڵ鷯 �߰�.
		
		// �⺻ �ʵ庯��/��ü ����
		jpnBackBoard = new JPanel(); // �Խñ� �гε��� ���� ���г� ���� 
		jpnBackBoard.setBackground(Color.WHITE); // ���г� ������ ���
		jpnBackBoard.setLayout(null); // ���г��� ��ġ�����ڴ� �����Ѵ�.
		setViewportView(jpnBackBoard); // �� ��ũ���гο� ���г��� �߰��Ѵ�.
		
	}
	
	// setBoard method : �Խù� ��ġ�� �������� ��ġ�ϰ� ���гο� �߰�.
	public void setBoard(ArrayList<BoardDataVO> list, String imgPath) {
		resetBoard(); // ���г� �����̳��� ��� ������Ʈ ����.
		// �Խ��� �⺻����
		jpnPost = new PostPanel[list.size()]; // ����Ʈ ���������� �Խñ� �迭 ũ�� ����
		bbLine = new BottomBar[list.size()]; // ����Ʈ ���������� ���м� �迭 ũ�� ����
		
		// ���� �Խù� ũ�⸸ŭ �ݺ��ϸ� ��ü �ʱ�ȭ �� ��ũ�� �гο� �߰�.
		for (int i = 0; i < list.size(); i++) {
			// �Խù� �߰�.
			jpnPost[i] = new PostPanel();
			jpnPost[i].setLocation(10, 10+170*i); // �Խñ� �г� ��ġ ����
			jpnPost[i].setGrade(list.get(i).getGrade()); // ��� ����
			jpnPost[i].setName(list.get(i).getName()); // �Խ��� ����
			jpnPost[i].setDate(list.get(i).getPostDate()); // �Խ��� ����
			jpnPost[i].setTitle(list.get(i).getPostTitle()); // �Խñ� ���� ����
			jpnPost[i].setImg(imgPath); // �̹��� ����
			jpnPost[i].setComment(list.get(i).getPostComment()); // ���� ����
			jpnBackBoard.add(jpnPost[i]); // ���гο� �Խñ� �߰�.
			
			// ���м� �߰�.
			bbLine[i] = new BottomBar();
			bbLine[i].setLocation(10, jpnPost[i].getY()+150+8); // ���м� ��ġ ���� 
			bbLine[i].setSize(new Dimension(getWidth()-40, 3)); // ���м� ũ�� ����
			jpnBackBoard.add(bbLine[i]); // ���гο� ���м� �߰�.
		} // for end
		
		jpnBackBoard.setPreferredSize(new Dimension(getWidth()-40, bbLine[list.size()-1].getY()+80)); // ���г� ũ�� ����
	} // setBoard method end
	
	// resetBoard method : ���г��� ��� ������Ʈ�� �����Ѵ�.
	public void resetBoard() {
		jpnBackBoard.removeAll(); // ��� ������Ʈ�� ����
	} // resetBoard method end

	// --- ComponentListener override methods ---
	// ������Ʈ ũ�Ⱑ ����Ǿ�����.
	@Override
	public void componentResized(ComponentEvent e) {
		if (jpnPost != null) {
			// ��� �Խñ� �г� ũ��� ���м� �ʺ� �����Ѵ�.
			for (int i = 0; i < jpnPost.length; i++) {
				jpnPost[i].setSize(getWidth()-40, 150); // �Խñ� �ʺ� ����
				bbLine[i].setSize(getWidth()-40, 3); // ���м� �ʺ� ����
			}
		}
	} // componentResized method end 

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
	// --- ComponentListener override methods end ---
} // OpenBoardPanel class end
