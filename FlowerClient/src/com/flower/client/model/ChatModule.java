package com.flower.client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.flower.client.config.EnVal;

public class ChatModule{ // 서버와 통신, 소켓 연결, 주고 받는 것까지, 값은 view로 
	
	Socket socket = null;	// 5001
	private PrintWriter pw = null;
	private BufferedReader br = null;
	
	 /* ------- Constructor ---------
	 생성자에서는 서버와 연결한다.*/
	
	public ChatModule() throws UnknownHostException, ConnectException, IOException {
			socket = new Socket(EnVal.SERVERIP, EnVal.CHATPORT);	
	}
	
	public Socket getSocket() {
		return socket;
	}

	// 채팅 내용을 서버로 전송하는 method
	public void send(String msg) {
		try {
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 발신 객체를 생성한다.
			pw.println(msg);	// 메시지를 Buffer에 써준다.
			pw.flush();		// Buffer에 담긴 메시지를 flush한다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	// 서버에서 보내는 내용을 읽는 method
	public String receive(){
		String str = "";
		try {
			
			while ((str=br.readLine())!=null){
				str = br.readLine();	// 수신객체로부터 읽어올 값이 없을 때 까지 한줄씩 값을 읽어온다.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;	// 읽어온 문자열을 반환한다.
	}

	public void close() {
		try {
			if(pw!=null)pw.close();
			if(br!=null)br.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
