package com.flower.client.board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.flower.client.component.BottomBar;
import com.flower.client.vo.BoardVO;
import com.flower.clinet.config.EnVal;

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
	private BoardVO[] boardDatas;
	
	/**
	 * <p>������ �Խ��� �⺻������.</p>
	 * �Խ��ǿ� ���Ǵ� ���� �����̳�, ������Ʈ���� ���� �� �ʱ�ȭ&������ �̷������.
	 * */
	public OpenBoardPanel() {
		super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER); // �¿� ��ũ�ѹٴ� ������, ���� ��ũ�ѹٴ� ���
		setBackground(Color.WHITE);// ������ ������� �Ѵ�.
		addComponentListener(this); // ������Ʈ �̺�Ʈ �ڵ鷯 �߰�.
		
		// �⺻ �ʵ庯��/��ü ����
		jpnBackBoard = new JPanel(); // �Խñ� �гε��� ���� ���г� ���� 
		jpnBackBoard.setBackground(Color.WHITE); // ���г� ������ ���
		jpnBackBoard.setLayout(null); // ���г��� ��ġ�����ڴ� �����Ѵ�.
		setViewportView(jpnBackBoard); // �� ��ũ���гο� ���г��� �߰��Ѵ�.
		
		// TODO : �����κ��� �Խù� �����͸� �޾ƿ��� �ڵ� �ۼ��ʿ�.
		
		// �Խ��� �⺻����
		jpnPost = new PostPanel[EnVal.BOARDVIEWNUM]; // ȯ�溯���� �Խñ� ���������� �Խñ� �迭 ũ�� ����
		bbLine = new BottomBar[EnVal.BOARDVIEWNUM]; // ȯ�溯���� �Խñ� ���������� ���м� �迭 ũ�� ����
		
		// �ݺ������� �Խñ� �� ���м� �迭�� ������ �������ش�.
		for (int i = 0; i < jpnPost.length; i++) {
			jpnPost[i] = new PostPanel(); // �Խñ� ����
			bbLine[i] = new BottomBar(); // ���м� ����
		}
		
		setBoard(EnVal.BOARDVIEWNUM); // �Խñ۰� ���м��� ���гο� ���� ��ġ�Ѵ�.
		
		// �Խñ� �����͸� �������� �ڵ尡 �̱����̹Ƿ� �׽�Ʈ������ �ӽ��ڵ�
		boardDatas = new BoardVO[10];
		for (int i = 0; i < boardDatas.length; i++) {
			boardDatas[i] = new BoardVO();
			boardDatas[i].setGrade((int)(Math.random()*5)+1);
			boardDatas[i].setName("�׽�Ʈ����" + (i+1));
			boardDatas[i].setDate("2017-06-1" + (i+1));
			boardDatas[i].setTitle("�׽�Ʈ" + (i+1));
			boardDatas[i].setImgPath("imgs/menubarlogo.png");
			boardDatas[i].setComment("�����ѳ����̴����ƾƳ��չ�;�����Ʒ��Ͼ˹�;������;����;����ä��ä�lsadkfskadjfl;dsafkjlasd;kdfjd;sajfkl;sajdfsa;ldkjf�����Ӥ�����;�Ӥ������;�������;�Ӥ���");
		}
		
		if (boardDatas != null && boardDatas.length != 0) {
			showBoard(1, 10);
			showBoard(1, 5);
		} else {
			resetBoard();
		}
		// �ӽ��ڵ� ��
	}
	
	// showBoard method : �Խñ� �����͸� �Խ��� ������Ʈ�� �����Ѵ�.
	private void showBoard(int startNum, int endNum) {
		setBoard(endNum-(startNum-1)); // �Խ��� ũ�� ����
		int postIndex = 0; // �Խñ� ���ΰ� ����� ����
		int dataIndex = startNum - 1; // ������ ���ΰ� ����� ���� ���� �� �ʱⰪ�� ������ ������ ���� ��ȣ.
		
		// ������ ���ΰ��� �������� �ݺ��Ͽ� �Խñ� �����͸� �Խ��ǿ� �����Ѵ�.
		while (dataIndex < endNum){
			// �ڵ� ������ ����� ���� ������ ���� ����ȭ.
			PostPanel jp = jpnPost[postIndex]; // array to oneObj
			BoardVO bvo = boardDatas[dataIndex]; // array to oneObj
			
			jp.setGrade(bvo.getGrade()); // ��� ����
			jp.setName(bvo.getName()); // �г��� ����
			jp.setDate(bvo.getDate()); // ���� ����
			jp.setTitle(bvo.getTitle()); // ���� ����
			jp.setImg(bvo.getImgPath()); // �̹��� ����
			jp.setComment(bvo.getComment()); // ���� ����
			
			postIndex++; // �Խ��� ���ΰ��� ����������
			dataIndex++; // ������ ���ΰ��� ����������
		} // while end
	} // showBoard method end
	
	// setBoard method : �Խù� ��ġ�� �������� ��ġ�ϰ� ���гο� �߰�.
	private void setBoard(int size) {
		resetBoard(); // ���г� �����̳��� ��� ������Ʈ ����.
		
		// ���� �Խù� ũ�⸸ŭ �ݺ��ϸ� ��ü �ʱ�ȭ �� ��ũ�� �гο� �߰�.
		for (int i = 0; i < size; i++) {
			// �Խù� �߰�.
			jpnPost[i].setLocation(10, 10+170*i); // �Խñ� �г� ��ġ ����
			jpnBackBoard.add(jpnPost[i]); // ���гο� �Խñ� �߰�.
			
			// ���м� �߰�.
			bbLine[i].setLocation(10, jpnPost[i].getY()+150+8); // ���м� ��ġ ���� 
			bbLine[i].setSize(new Dimension(550, 3)); // ���м� ũ�� ����
			jpnBackBoard.add(bbLine[i]); // ���гο� ���м� �߰�.
		} // for end
		
		jpnBackBoard.setPreferredSize(new Dimension(600, bbLine[size-1].getY()+80)); // ���г� ũ�� ����
	} // setBoard method end
	
	// resetBoard method : ���г��� ��� ������Ʈ�� �����Ѵ�.
	private void resetBoard() {
		jpnBackBoard.removeAll(); // ��� ������Ʈ�� ����
	} // resetBoard method end

	// --- ComponentListener override methods ---
	// ������Ʈ ũ�Ⱑ ����Ǿ�����.
	@Override
	public void componentResized(ComponentEvent e) {
		// ��� �Խñ� �г� ũ��� ���м� �ʺ� �����Ѵ�.
		for (int i = 0; i < jpnPost.length; i++) {
			jpnPost[i].setSize(getWidth()-40, 150); // �Խñ� �ʺ� ����
			bbLine[i].setSize(getWidth()-40, 3); // ���м� �ʺ� ����
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
