package com.flower.client.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

// LoginModule class
/**
 * ���� �α��� ó���� ����ϴ� �α��� Ŭ����
 * */
public class LoginModule {
	private ConnectServer cs = null; // ���� ���� ��ü
	private Socket socket = null; // ���� ���ӻ��¸� ���� ��Ĺ
	private ObjectOutputStream oos; // ������ �� ���޿� �ƿ�ǲ ��Ʈ��
	private ObjectInputStream ois; // �������� ���� ���� ��ǲ ��Ʈ��
	
	// --- Constructors ---
	/**
	 * �α��� Ŭ������ �⺻�����ڷ� �Ű����� ������ ������ ������ �̷������.
	 * ������ �� ��ü�� �ν��Ͻ��Ͽ� ����� ���� close �޼��带 ȣ��������Ѵ�. 
	 * */
	public LoginModule() {
		cs = new ConnectServer();
		socket = cs.getSocket();
	}
	// --- Constructors end---
	
	// login method
	/**
	 * �α����� ó���ϴ� �޼���� ������ ����Ͽ� �����Ұ�� ȸ�������� �����ϰ� �� ���� ��ȯ�ϰ�
	 * ����������� �ܼ��� �������� ��ȯ�Ѵ�. ȸ�������� TODO ���� ����ȴ�.
	 * 
	 * @param id �α��� ���̵�
	 * @param password �α��� �н�����
	 * @return �α��� ������ true, ���н� false
	 * */
	public boolean login(String id, String password) {
		try {
			// ����/��ü ����
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); // ������ ��üŸ���� ���� �����ϱ����� ��ü ����
			HashMap<String, String> hmdata = new HashMap<String, String>(); // �ؽ��ʴ����� �����Ƿ� �ؽ����� �����.
			
			// ������ ���� ���� �غ��Ѵ�.
			hmdata.put("request", "login"); // ��û�� �α���
			hmdata.put("id", id); // ���̵�
			hmdata.put("password", password); // ��й�ȣ
			
			// ������ �α��� ���� �����Ѵ�.
			oos.writeObject(hmdata); // ������ �� ������ �����ϳ� Ư���� ����ȴ�.
			oos.flush(); // ����� �۾��� ��� ó���Ѵ�.
			oos.close(); // �۾��� �������Ƿ� �ƿ�ǲ ��Ʈ���� �ݴ´�.
			
			// �������� �α��� ����� �޴´�.
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); // �������� ���� ���޹޾� �����Ѵ�.
			
			// ��üŸ���� ���� ���� �޾����� HashMap Ÿ���̹Ƿ� ����ȯ�� ���ش�.
			@SuppressWarnings("unchecked") // �ݵ�� HashMap Ÿ���� ���Ƿ� ���� ���ش�.
			HashMap<String, String> oisHm = (HashMap<String, String>) ois.readObject(); // Object to HashMap
			
			ois.close(); // �ƿ�ǲ ��Ʈ���� �����Ѵ�.
			
			// ��������
			if (oisHm.get("respond").equals("okey")) {
				// TODO : �α��� ������ �������� ��ġ�� VO�� �����ϴ� �ڵ� �ۼ� �ʿ�
				return true; // �����ߴٴ� �ǹ��� ������ ��ȯ�Ѵ�.
			} else { // ����(error)�ϰ��
				return false; // �������� ��ȯ�Ѵ�.
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}// login method end
	
	// close method
	/**
	 * ������ ���ӵ� ���� ��ü�� �ݱ����� �޼���� �α��� ��ü�� ��� �� �ݵ�� ȣ��������Ѵ�.
	 * */
	public void close() {
		cs.close();
	} // close method end
	
} // LoginModule class end
