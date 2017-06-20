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

public class ChatModule{ // ������ ���, ���� ����, �ְ� �޴� �ͱ���, ���� view�� 
	
	Socket socket = null;	// 5001
	private PrintWriter pw = null;
	private BufferedReader br = null;
	
	 /* ------- Constructor ---------
	 �����ڿ����� ������ �����Ѵ�.*/
	
	public ChatModule() throws UnknownHostException, ConnectException, IOException {
			socket = new Socket(EnVal.SERVERIP, EnVal.CHATPORT);	
	}
	
	public Socket getSocket() {
		return socket;
	}

	// ä�� ������ ������ �����ϴ� method
	public void send(String msg) {
		try {
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // �߽� ��ü�� �����Ѵ�.
			pw.println(msg);	// �޽����� Buffer�� ���ش�.
			pw.flush();		// Buffer�� ��� �޽����� flush�Ѵ�.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	// �������� ������ ������ �д� method
	public String receive(){
		String str = "";
		try {
			
			while ((str=br.readLine())!=null){
				str = br.readLine();	// ���Ű�ü�κ��� �о�� ���� ���� �� ���� ���پ� ���� �о�´�.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;	// �о�� ���ڿ��� ��ȯ�Ѵ�.
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
