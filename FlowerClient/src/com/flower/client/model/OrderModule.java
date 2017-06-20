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

import com.flower.vo.OrderListVO;

public class OrderModule {
	ConnectServer cs = null;
	Socket socket = null;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	boolean flag;
	
	// ----- Constructor -------
	public OrderModule() throws ConnectException, UnknownHostException, IOException {
		flag = false;
		cs = new ConnectServer();	// ConnectServer 객체 생성
		socket = cs.getSocket();	// Socket 연결
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<OrderListVO> getOrderList(String id) {
		ArrayList<OrderListVO> list = null;
		try {
			// 주문정보
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// 발신 객체를 생성한다.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "orderlist");
			hmlist.put("id", id);
			
			
			oos.writeObject(hmlist); // 서버에 HashMap을 전송한다.
			oos.flush();// Buffer flush
			// 서버에서 회원가입 처리 결과 수신
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			// 서버로부터 데이터 개수를 받는다.
			HashMap<String, Integer> hashData = (HashMap<String, Integer>) ois.readObject();
			int datasize = hashData.get("datasize"); // 데이터 개수를 정수로 저장
			
			// 개수만큼 데이터를 가져오며 추가로 VO와 list 구별작업을 거친다.
			OrderListVO[] ovo = new OrderListVO[datasize-1]; // list객체 요소 vo 배열
			
			// 반복문으로 VO와 list데이터를 받아온다.
			for (int i = 0; i < datasize; i++) {
				if (i < datasize-1) { // 0~datasize-1 인덱스는 vo데이터
					ovo[i] = (OrderListVO) ois.readObject();
				} else { // datasize 인덱스는 list데이터
					list=(ArrayList<OrderListVO>)ois.readObject();//arraylist로 받아온다.					
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
	
	public boolean order(String id, String revtime, String revname, String revtel, String msg, String fname) {
		
		try {
			// 서버에 회원가입 데이터 전송
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); // 발신 객체를 생성한다.
			
			HashMap<String, String> hmOrder = new HashMap<String, String>(); 	// HashMap 생성한다.
			
			// 보낼 값을 HashMap에 담는다.
			hmOrder.put("request", "order");	// 서버에 order를 요청한다.
			hmOrder.put("id", id);	// id
			hmOrder.put("revtime", revtime);	// 예약 시간 
			hmOrder.put("revname", revname);	// 찾는 사람 이름
			hmOrder.put("revtel", revtel);		// 찾는 사람 핸드폰번호
			hmOrder.put("message", msg);	// 메시지
			hmOrder.put("fname", fname);	// 상품명

			
			oos.writeObject(hmOrder); // 서버에 HashMap을 전송한다.
			oos.flush();	// Buffer flush
			
			// 서버에서 회원가입 처리 결과 수신
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); // 수신 객체를 생성한다.
			
			@SuppressWarnings("unchecked")
			HashMap<String, String> hmServer  = (HashMap<String, String>)ois.readObject();  // 서버에서 받는 객체를 HashMap으로 형변환
			
			System.out.println(hmServer);
			if(hmServer.get("respond").equals("okay")){	// 서버의 제약조건에 걸리지 않으면 flag에 true를 준다.
				flag = true;
			}else if(hmServer.get("respond").equals("error")){	// 서버의 제약조건에 걸려서 error 나면 flag에 false를 준다.
				flag = false;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null)ois.close();	// 수신 객체 자원반납한다.
				if(oos!=null)oos.close();	// 발신 객체 자원반납한다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return flag;	// okay인지 error인지를 boolean으로 반환
	
	}
	
	public void close() {
		cs.close();	// 소켓 연결 끊기
	}
}
