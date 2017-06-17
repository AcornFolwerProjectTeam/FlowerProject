package com.flower.client.model;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.flower.clinet.config.EnVal;

// ConnectServer class
/**
 * 서버에 접속하여 소캣 객체를 생성하는 클래스. 
 * */
public class ConnectServer {
	private Socket socket = null; // 서버에 접속하고 연결 정보를 담는 소캣 객체
	
	// --- Constructors ---
	/**
	 * 기본생성자로 클래스가 생성됨과 동시에 설정파일에 기입된 서버 IP주소와 포트번호로
	 * 서버에 접속하여 소캣 객체를 생성한다.
	 * @throws IOException 
	 * @throws ConnectException, UnknownHostException 
	 * */
	public ConnectServer() throws ConnectException, UnknownHostException, IOException {
		socket = new Socket(EnVal.SERVERIP, EnVal.SERVERPORT);
	}
	// --- Constructors end---
	
	/**
	 * 접속된 소캣 객체를 닫는다.
	 * */
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 이 클래스가 담고있는 소켓 객체를 반환한다.
	 * 
	 * @return Socket 타입의 소캣객체
	 * */
	public Socket getSocket() {
		return socket;
	}
	
	
} // ConnectServer class end
