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
 * <p>열거형 게시판 클래스.</p>
 * JScrollPane를 상속받아 열거형 게시판을 구현한 클래스.
 * */
@SuppressWarnings("serial")
public class OpenBoardPanel extends JScrollPane implements ComponentListener {
	private JPanel jpnBackBoard;
	private PostPanel[] jpnPost;
	private BottomBar[] bbLine;
	
	/**
	 * <p>열거형 게시판 기본생성자.</p>
	 * 게시판에 사용되는 내부 컨테이너, 컴포넌트등을 생성 및 초기화&설정이 이루어진다.
	 * */
	public OpenBoardPanel() {
		super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER); // 좌우 스크롤바는 사용안함, 상하 스크롤바는 사용
		setBackground(Color.WHITE);// 배경색은 흰색으로 한다.
		setBorder(null);	// 게시판 테두리를 보이지 않는다.
		addComponentListener(this); // 컴포넌트 이벤트 핸들러 추가.
		
		// 기본 필드변수/객체 설정
		jpnBackBoard = new JPanel(); // 게시글 패널들을 담을 백패널 생성 
		jpnBackBoard.setBackground(Color.WHITE); // 백패널 배경색은 흰색
		jpnBackBoard.setLayout(null); // 백패널의 배치관리자는 해제한다.
		setViewportView(jpnBackBoard); // 이 스크롤패널에 백패널을 추가한다.
		
	}
	
	// setBoard method : 게시물 위치를 동적으로 배치하고 백패널에 추가.
	public void setBoard(ArrayList<BoardDataVO> list, String imgPath) {
		resetBoard(); // 백패널 컨테이너의 모든 컴포넌트 제거.
		// 게시판 기본설정
		jpnPost = new PostPanel[list.size()]; // 리스트 개수값으로 게시글 배열 크기 설정
		bbLine = new BottomBar[list.size()]; // 리스트 개수값으로 구분선 배열 크기 설정
		
		// 내부 게시물 크기만큼 반복하며 객체 초기화 및 스크롤 패널에 추가.
		for (int i = 0; i < list.size(); i++) {
			// 게시물 추가.
			jpnPost[i] = new PostPanel();
			jpnPost[i].setLocation(10, 10+170*i); // 게시글 패널 위치 설정
			jpnPost[i].setGrade(list.get(i).getGrade()); // 등급 설정
			jpnPost[i].setName(list.get(i).getName()); // 게시자 설정
			jpnPost[i].setDate(list.get(i).getPostDate()); // 게시일 설정
			jpnPost[i].setTitle(list.get(i).getPostTitle()); // 게시글 제목 설정
			jpnPost[i].setImg(imgPath); // 이미지 설정
			jpnPost[i].setComment(list.get(i).getPostComment()); // 내용 설정
			jpnBackBoard.add(jpnPost[i]); // 백패널에 게시글 추가.
			
			// 구분선 추가.
			bbLine[i] = new BottomBar();
			bbLine[i].setLocation(10, jpnPost[i].getY()+150+8); // 구분선 위치 설정 
			bbLine[i].setSize(new Dimension(getWidth()-40, 3)); // 구분선 크기 설정
			jpnBackBoard.add(bbLine[i]); // 백패널에 구분선 추가.
		} // for end
		
		jpnBackBoard.setPreferredSize(new Dimension(getWidth()-40, bbLine[list.size()-1].getY()+80)); // 백패널 크기 설정
	} // setBoard method end
	
	// resetBoard method : 백패널의 모든 컴포넌트를 제거한다.
	public void resetBoard() {
		jpnBackBoard.removeAll(); // 모든 컴포넌트를 제거
	} // resetBoard method end

	// --- ComponentListener override methods ---
	// 컴포넌트 크기가 변경되었을때.
	@Override
	public void componentResized(ComponentEvent e) {
		if (jpnPost != null) {
			// 모든 게시글 패널 크기와 구분선 너비를 수정한다.
			for (int i = 0; i < jpnPost.length; i++) {
				jpnPost[i].setSize(getWidth()-40, 150); // 게시글 너비 수정
				bbLine[i].setSize(getWidth()-40, 3); // 구분선 너비 수정
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
