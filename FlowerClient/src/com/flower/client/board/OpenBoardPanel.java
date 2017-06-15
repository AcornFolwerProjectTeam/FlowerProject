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
 * <p>열거형 게시판 클래스.</p>
 * JScrollPane를 상속받아 열거형 게시판을 구현한 클래스.
 * */
@SuppressWarnings("serial")
public class OpenBoardPanel extends JScrollPane implements ComponentListener {
	private JPanel jpnBackBoard;
	private PostPanel[] jpnPost;
	private BottomBar[] bbLine;
	private BoardVO[] boardDatas;
	
	/**
	 * <p>열거형 게시판 기본생성자.</p>
	 * 게시판에 사용되는 내부 컨테이너, 컴포넌트등을 생성 및 초기화&설정이 이루어진다.
	 * */
	public OpenBoardPanel() {
		super(VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER); // 좌우 스크롤바는 사용안함, 상하 스크롤바는 사용
		setBackground(Color.WHITE);// 배경색은 흰색으로 한다.
		addComponentListener(this); // 컴포넌트 이벤트 핸들러 추가.
		
		// 기본 필드변수/객체 설정
		jpnBackBoard = new JPanel(); // 게시글 패널들을 담을 백패널 생성 
		jpnBackBoard.setBackground(Color.WHITE); // 백패널 배경색은 흰색
		jpnBackBoard.setLayout(null); // 백패널의 배치관리자는 해제한다.
		setViewportView(jpnBackBoard); // 이 스크롤패널에 백패널을 추가한다.
		
		// TODO : 서버로부터 게시물 데이터를 받아오는 코드 작성필요.
		
		// 게시판 기본설정
		jpnPost = new PostPanel[EnVal.BOARDVIEWNUM]; // 환경변수의 게시글 개수값으로 게시글 배열 크기 설정
		bbLine = new BottomBar[EnVal.BOARDVIEWNUM]; // 환경변수의 게시글 개수값으로 구분선 배열 크기 설정
		
		// 반복문으로 게시글 및 구분선 배열을 제각각 생성해준다.
		for (int i = 0; i < jpnPost.length; i++) {
			jpnPost[i] = new PostPanel(); // 게시글 생성
			bbLine[i] = new BottomBar(); // 구분선 생성
		}
		
		setBoard(EnVal.BOARDVIEWNUM); // 게시글과 구분선을 백패널에 사전 배치한다.
		
		// 게시글 데이터를 가져오는 코드가 미구현이므로 테스트를위한 임시코드
		boardDatas = new BoardVO[10];
		for (int i = 0; i < boardDatas.length; i++) {
			boardDatas[i] = new BoardVO();
			boardDatas[i].setGrade((int)(Math.random()*5)+1);
			boardDatas[i].setName("테스트계정" + (i+1));
			boardDatas[i].setDate("2017-06-1" + (i+1));
			boardDatas[i].setTitle("테스트" + (i+1));
			boardDatas[i].setImgPath("imgs/menubarlogo.png");
			boardDatas[i].setComment("간단한내용이다으아아나넝밀;ㅁㄴ아럼니알민;ㄴㅁㄹ;ㅁ낢;ㄴ라ㅓㅏㅓㅁlsadkfskadjfl;dsafkjlasd;kdfjd;sajfkl;sajdfsa;ldkjfㄴ마ㅣㅇ런ㅁ;ㅣㅏㄹ어님;어ㅏㄻ나ㅓ;ㅣㅇㄹ");
		}
		
		if (boardDatas != null && boardDatas.length != 0) {
			showBoard(1, 10);
			showBoard(1, 5);
		} else {
			resetBoard();
		}
		// 임시코드 끝
	}
	
	// showBoard method : 게시글 데이터를 게시판 컴포넌트에 대입한다.
	private void showBoard(int startNum, int endNum) {
		setBoard(endNum-(startNum-1)); // 게시판 크기 조정
		int postIndex = 0; // 게시글 색인값 저장용 변수
		int dataIndex = startNum - 1; // 데이터 색인값 저장용 변수 선언 및 초기값은 보여줄 데이터 시작 번호.
		
		// 데이터 색인값을 기준으로 반복하여 게시글 데이터를 게시판에 대입한다.
		while (dataIndex < endNum){
			// 코드 가독성 향상을 위해 변수를 통해 간소화.
			PostPanel jp = jpnPost[postIndex]; // array to oneObj
			BoardVO bvo = boardDatas[dataIndex]; // array to oneObj
			
			jp.setGrade(bvo.getGrade()); // 등급 설정
			jp.setName(bvo.getName()); // 닉네임 대입
			jp.setDate(bvo.getDate()); // 날자 대입
			jp.setTitle(bvo.getTitle()); // 제목 대입
			jp.setImg(bvo.getImgPath()); // 이미지 설정
			jp.setComment(bvo.getComment()); // 내용 대입
			
			postIndex++; // 게시판 색인값을 다음값으로
			dataIndex++; // 데이터 색인값을 다음값으로
		} // while end
	} // showBoard method end
	
	// setBoard method : 게시물 위치를 동적으로 배치하고 백패널에 추가.
	private void setBoard(int size) {
		resetBoard(); // 백패널 컨테이너의 모든 컴포넌트 제거.
		
		// 내부 게시물 크기만큼 반복하며 객체 초기화 및 스크롤 패널에 추가.
		for (int i = 0; i < size; i++) {
			// 게시물 추가.
			jpnPost[i].setLocation(10, 10+170*i); // 게시글 패널 위치 설정
			jpnBackBoard.add(jpnPost[i]); // 백패널에 게시글 추가.
			
			// 구분선 추가.
			bbLine[i].setLocation(10, jpnPost[i].getY()+150+8); // 구분선 위치 설정 
			bbLine[i].setSize(new Dimension(550, 3)); // 구분선 크기 설정
			jpnBackBoard.add(bbLine[i]); // 백패널에 구분선 추가.
		} // for end
		
		jpnBackBoard.setPreferredSize(new Dimension(600, bbLine[size-1].getY()+80)); // 백패널 크기 설정
	} // setBoard method end
	
	// resetBoard method : 백패널의 모든 컴포넌트를 제거한다.
	private void resetBoard() {
		jpnBackBoard.removeAll(); // 모든 컴포넌트를 제거
	} // resetBoard method end

	// --- ComponentListener override methods ---
	// 컴포넌트 크기가 변경되었을때.
	@Override
	public void componentResized(ComponentEvent e) {
		// 모든 게시글 패널 크기와 구분선 너비를 수정한다.
		for (int i = 0; i < jpnPost.length; i++) {
			jpnPost[i].setSize(getWidth()-40, 150); // 게시글 너비 수정
			bbLine[i].setSize(getWidth()-40, 3); // 구분선 너비 수정
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
