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
	 * �α����� ó���ϴ� �޼���� ������ ����Ͽ� �����Ұ�� ȸ�������� �����ϰ� �� ���� ��ȯ�ϰ�
	 * ����������� �ܼ��� �������� ��ȯ�Ѵ�. ȸ�������� TODO ���� ����ȴ�.
	 * 
	 * @param id �α��� ���̵�
	 * @param password �α��� �н�����
	 * @return �α��� ������ ȸ�� ������ ��� �ִ� AccountVO, ���н� null
	 * */
	public AccountVO login(String id, String password) {
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
			
			// �������� �α��� ����� �޴´�.
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); // �������� ���� ���޹޾� �����Ѵ�.
			
			// ��üŸ���� ���� ���� �޾����� HashMap Ÿ���̹Ƿ� ����ȯ�� ���ش�.
			@SuppressWarnings("unchecked") // �ݵ�� HashMap Ÿ���� ���Ƿ� ���� ���ش�.
			HashMap<String, String> oisHm = (HashMap<String, String>) ois.readObject(); // Object to HashMap
			
			// �������� �����͸� �޾� �����Ѵ�.
			if (oisHm.get("respond").equals("okay")) { // �α��� ������
				AccountVO avo = new AccountVO(); // ȸ�� ������ ���� VO��ü ����
				
				avo.setId(oisHm.get("id")); // ID
				avo.setName(oisHm.get("name")); // �̸�(�г���)
				avo.setTel(oisHm.get("tel")); // ȸ�� ��ȭ��ȣ
				
				return avo; // VO�� ������ ȸ�������� ��ȯ�Ѵ�.
			} else { // ����(error)�ϰ�� �α��� ����
				return null; // null���� ��ȯ�Ѵ�.
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null)ois.close(); // �ƿ�ǲ ��Ʈ���� �����Ѵ�.
				if(oos!=null)oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // �۾��� �������Ƿ� �ƿ�ǲ ��Ʈ���� �ݴ´�.
			
		}
		
		return null; // ���� �޼��� ������� �α���ó���� ���� �ʾҴٸ� null���� ��ȯ�� ���� ����ó���Ѵ�.
	}// login method end
	
	// close method
	/**
	 * ������ ���ӵ� ���� ��ü�� �ݱ����� �޼���� �α��� ��ü�� ��� �� �ݵ�� ȣ��������Ѵ�.
	 * */
	public void close() {
		cs.close();
	} // close method end
	
} // LoginModule class end
