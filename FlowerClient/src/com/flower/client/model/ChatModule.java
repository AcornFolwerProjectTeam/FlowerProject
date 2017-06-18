package com.flower.client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.flower.clinet.config.EnVal;

public class ChatModule{ // 서버와 통신, 소켓 연결, 주고 받는 것까지, 값은 view로 
	
	Socket socket = null;	// 5001
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	
	 /* ------- Constructor ---------
	 생성자에서는 서버와 연결한다.*/
	
	public ChatModule() throws UnknownHostException, ConnectException, IOException {
			socket = new Socket(EnVal.SERVERIP, EnVal.CHATPORT);
	}
	
	// 채팅 내용을 서버로 전송하는 method
	public void send(String msg) {
		// 발신 객체 생성
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(msg);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	// 서버에서 보내는 내용을 읽는 method
	public String receive(){
		String str = "";
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
