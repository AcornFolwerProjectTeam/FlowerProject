package com.flower.client.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.BoardDataVO;

public class BoardModule {
	private ConnectServer cs = null; // 서버 접속 객체
	private Socket socket = null; // 서버 접속상태를 받을 소캣
	private ObjectOutputStream oos; // 서버에 값 전달용 아웃풋 스트림
	private ObjectInputStream ois; // 서버에서 값을 받을 인풋 스트림
	
	// --- Constructor ---
	// 기본생성자
	public BoardModule() throws ConnectException, UnknownHostException, IOException {
		cs = new ConnectServer();
		socket = cs.getSocket();
	}
	// --- Constructor end---
	
	@SuppressWarnings("unchecked")
	public ArrayList<BoardDataVO> getPostList(String fname) {
		ArrayList<BoardDataVO> list = null;
		try {
			// 주문정보
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// 발신 객체를 생성한다.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "postList");
			hmlist.put("fname", fname);
			
			oos.writeObject(hmlist); // 서버에 HashMap을 전송한다.
			oos.flush();// Buffer flush
			// 서버에서 회원가입 처리 결과 수신
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			// 서버로부터 데이터 개수를 받는다.
			HashMap<String, Integer> hashData = (HashMap<String, Integer>) ois.readObject();
			int datasize = hashData.get("datasize"); // 데이터 개수를 정수로 저장
			
			// 개수만큼 데이터를 가져오며 추가로 VO와 list 구별작업을 거친다.
			BoardDataVO[] bvo = new BoardDataVO[datasize-1]; // list객체 요소 vo 배열
			
			// 반복문으로 VO와 list데이터를 받아온다.
			for (int i = 0; i < datasize; i++) {
				if (i < datasize-1) { // 0~datasize-1 인덱스는 vo데이터
					bvo[i] = (BoardDataVO) ois.readObject();
				} else { // datasize 인덱스는 list데이터
					list=(ArrayList<BoardDataVO>)ois.readObject();//arraylist로 받아온다.					
				} // if end
			} // for end
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null)ois.close();
				if(ois != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public boolean writePost(String title, int grade, String comment, String id, String fname, int ordercode) {
		try {
			// 변수/객체 설정
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); // 서버에 객체타입의 값을 전달하기위한 객체 생성
			HashMap<String, String> hmdata = new HashMap<String, String>(); // 해쉬맵단위로 보내므로 해쉬맵을 만든다.
			
			// 서버에 보낼 값을 준비한다.
			hmdata.put("request", "boardwrite"); // 요청은 후기 게시글 작성
			hmdata.put("id", id); // 회원 id
			hmdata.put("fname", fname); // 제품명
			hmdata.put("posttitle", title); // 게시글 제목
			hmdata.put("postcomment", comment); // 게시글 내용
			hmdata.put("grade", String.valueOf(grade)); // 평점
			hmdata.put("ordercode", String.valueOf(ordercode)); // 평점
			
			// 서버에 로그인 값을 전달한다.
			oos.writeObject(hmdata); // 서버에 값 전달을 전달하나 특성상 예약된다.
			oos.flush(); // 예약된 작업을 모두 처리한다.
			
			// 서버에서 로그인 결과를 받는다.
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); // 서버에서 값을 전달받아 세팅한다.
			
			// 객체타입의 값을 전달 받았으나 HashMap 타입이므로 형변환을 해준다.
			@SuppressWarnings("unchecked") // 반드시 HashMap 타입이 오므로 경고는 꺼준다.
			HashMap<String, String> oisHm = (HashMap<String, String>) ois.readObject(); // Object to HashMap
			
			System.out.println(oisHm.get("respond"));
			// 서버에서 성공여부를 받아 리턴한다.
			if (oisHm.get("respond").equals("okay")) { // 게시 성공시
				return true; // 성공값을 반환한다.
			} else { // 에러(error)일경우 로그인 실패
				return false; // 실패값을 반환한다.
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null)ois.close(); // 아웃풋 스트림을 종료한다.
				if(oos!=null)oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 작업이 끝났으므로 아웃풋 스트림을 닫는다.
			
		}
		
		return false;
	}
	
	
	// close method
	/**
	 * 서버와 접속된 소켓 객체를 닫기위한 메서드로 로그인 객체를 사용 후 반드시 호출해줘야한다.
	 * */
	public void close() {
		cs.close();
	} // close method end

}
