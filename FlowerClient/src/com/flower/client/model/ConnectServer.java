package com.flower.client.model;

import java.io.IOException;
import java.net.Socket;

import com.flower.clinet.config.EnVal;

// ConnectServer class
/**
 * ������ �����Ͽ� ��Ĺ ��ü�� �����ϴ� Ŭ����. 
 * */
public class ConnectServer {
	private Socket socket = null; // ������ �����ϰ� ���� ������ ��� ��Ĺ ��ü
	
	// --- Constructors ---
	/**
	 * �⺻�����ڷ� Ŭ������ �����ʰ� ���ÿ� �������Ͽ� ���Ե� ���� IP�ּҿ� ��Ʈ��ȣ��
	 * ������ �����Ͽ� ��Ĺ ��ü�� �����Ѵ�.
	 * */
	public ConnectServer() {
		try {
			socket = new Socket(EnVal.SERVERIP, EnVal.SERVERPORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// --- Constructors end---
	
	/**
	 * ���ӵ� ��Ĺ ��ü�� �ݴ´�.
	 * */
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �� Ŭ������ ����ִ� ���� ��ü�� ��ȯ�Ѵ�.
	 * 
	 * @return Socket Ÿ���� ��Ĺ��ü
	 * */
	public Socket getSocket() {
		return socket;
	}
	
	
} // ConnectServer class end
