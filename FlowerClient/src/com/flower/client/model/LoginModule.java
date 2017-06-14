package com.flower.client.model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class LoginModule {
	ConnectServer cs = null;
	Socket socket = null;
	private ObjectOutputStream oos;
	//private BufferedReader br;
	
	public LoginModule() {
		cs = new ConnectServer();
		socket = cs.getSocket();
	}
	
	public boolean login(String id, String password) {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			//br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			HashMap<String, String> hmdata = new HashMap<String, String>();
			
			hmdata.put("request", "login");
			hmdata.put("id", id);
			hmdata.put("password", password);
			
			oos.reset();
			oos.writeObject(hmdata);
			oos.flush();
			
			// TODO 로그인 결과 데이터 받기
			
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
