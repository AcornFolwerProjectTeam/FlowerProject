package com.flower.client.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

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
