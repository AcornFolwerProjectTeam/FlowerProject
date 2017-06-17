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

public class RegisterModule {
	ConnectServer cs = null;
	Socket socket = null;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	boolean flag;
	
	// ----- Constructor -------
	public RegisterModule() throws ConnectException, UnknownHostException, IOException{ 
		flag = false;
		cs = new ConnectServer();	// ConnectServer 객체 생성
		socket = cs.getSocket();	// Socket 연결
	}
	
	public boolean register(String id, String pw, String name, String phone) {
		
		try {
			// 서버에 회원가입 데이터 전송
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); // 발신 객체를 생성한다.
			
			HashMap<String, String> hmReg = new HashMap<String, String>(); 	// HashMap 생성한다.
			
			// 보낼 값을 HashMap에 담는다.
			hmReg.put("request", "signin");	// 서버에 register를 요청한다.
			hmReg.put("id", id);	// id
			hmReg.put("pw", pw);	// pw
			hmReg.put("name", name);	// 이름
			hmReg.put("phone", phone);	// 전화번호
			
			oos.writeObject(hmReg); // 서버에 HashMap을 전송한다.
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
