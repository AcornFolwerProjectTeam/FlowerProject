package com.flower.client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.flower.clinet.config.EnVal;

public class ChatModule{ // ������ ���, ���� ����, �ְ� �޴� �ͱ���, ���� view�� 
	
	Socket socket = null;	// 5001
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	
	 /* ------- Constructor ---------
	 �����ڿ����� ������ �����Ѵ�.*/
	
	public ChatModule() {
		try {
			socket = new Socket(EnVal.SERVERIP, EnVal.CHATPORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ä�� ������ ������ �����ϴ� method
	public void send(String msg) {
		// �߽� ��ü ����
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(msg);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	// �������� ������ ������ �д� method
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
	
	
}