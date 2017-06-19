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

import com.flower.client.vo.AccountVO;

// LoginModule class
/**
 * 계정 로그인 처리를 담당하는 로그인 클래스
 * */
public class LoginModule {
	private ConnectServer cs = null; // 서버 접속 객체
	private Socket socket = null; // 서버 접속상태를 받을 소캣
	private ObjectOutputStream oos; // 서버에 값 전달용 아웃풋 스트림
	private ObjectInputStream ois; // 서버에서 값을 받을 인풋 스트림
	
	// --- Constructors ---
	/**
	 * 로그인 클래스의 기본생성자로 매개값은 없지만 서버와 접속이 이루어진다.
	 * 때문에 이 객체를 인스턴스하여 사용한 이후 close 메서드를 호출해줘야한다. 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws ConnectException 
	 * */
	public LoginModule() throws ConnectException, UnknownHostException, IOException {
		cs = new ConnectServer();
		socket = cs.getSocket();
	}
	// --- Constructors end---
	
	// login method
	/**
	 * 로그인을 처리하는 메서드로 서버와 통신하여 성공할경우 회원정보를 저장하고 참 값을 반환하고
	 * 실패했을경우 단순히 거짓값만 반환한다. 회원정보는 TODO 값에 저장된다.
	 * 
	 * @param id 로그인 아이디
	 * @param password 로그인 패스워드
	 * @return 로그인 성공시 회원 정보를 담고 있는 AccountVO, 실패시 null
	 * */
	public AccountVO login(String id, String password) {
		try {
			// 변수/객체 설정
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); // 서버에 객체타입의 값을 전달하기위한 객체 생성
			HashMap<String, String> hmdata = new HashMap<String, String>(); // 해쉬맵단위로 보내므로 해쉬맵을 만든다.
			
			// 서버에 보낼 값을 준비한다.
			hmdata.put("request", "login"); // 요청은 로그인
			hmdata.put("id", id); // 아이디
			hmdata.put("password", password); // 비밀번호
			
			// 서버에 로그인 값을 전달한다.
			oos.writeObject(hmdata); // 서버에 값 전달을 전달하나 특성상 예약된다.
			oos.flush(); // 예약된 작업을 모두 처리한다.
			
			// 서버에서 로그인 결과를 받는다.
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); // 서버에서 값을 전달받아 세팅한다.
			
			// 객체타입의 값을 전달 받았으나 HashMap 타입이므로 형변환을 해준다.
			@SuppressWarnings("unchecked") // 반드시 HashMap 타입이 오므로 경고는 꺼준다.
			HashMap<String, String> oisHm = (HashMap<String, String>) ois.readObject(); // Object to HashMap
			
			// 서버에서 데이터를 받아 세팅한다.
			if (oisHm.get("respond").equals("okay")) { // 로그인 성공시
				AccountVO avo = new AccountVO(); // 회원 정보를 담을 VO객체 생성
				
				avo.setId(oisHm.get("id")); // ID
				avo.setName(oisHm.get("name")); // 이름(닉네임)
				avo.setTel(oisHm.get("tel")); // 회원 전화번호
				
				return avo; // VO에 세팅한 회원정보를 반환한다.
			} else { // 에러(error)일경우 로그인 실패
				return null; // null값을 반환한다.
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
		
		return null; // 만약 메서드 종료까지 로그인처리가 되지 않았다면 null값을 반환해 강제 실패처리한다.
	}// login method end
	
	// close method
	/**
	 * 서버와 접속된 소켓 객체를 닫기위한 메서드로 로그인 객체를 사용 후 반드시 호출해줘야한다.
	 * */
	public void close() {
		cs.close();
	} // close method end
	
} // LoginModule class end
