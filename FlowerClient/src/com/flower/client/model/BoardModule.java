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

public class BoardModule {
	private ConnectServer cs = null; // ���� ���� ��ü
	private Socket socket = null; // ���� ���ӻ��¸� ���� ��Ĺ
	private ObjectOutputStream oos; // ������ �� ���޿� �ƿ�ǲ ��Ʈ��
	private ObjectInputStream ois; // �������� ���� ���� ��ǲ ��Ʈ��
	
	// --- Constructor ---
	// �⺻������
	public BoardModule() throws ConnectException, UnknownHostException, IOException {
		cs = new ConnectServer();
		socket = cs.getSocket();
	}
	// --- Constructor end---
	
	public boolean writePost(String title, int grade, String comment, String id, String fname) {
		try {
			// ����/��ü ����
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); // ������ ��üŸ���� ���� �����ϱ����� ��ü ����
			HashMap<String, String> hmdata = new HashMap<String, String>(); // �ؽ��ʴ����� �����Ƿ� �ؽ����� �����.
			
			// ������ ���� ���� �غ��Ѵ�.
			hmdata.put("request", "boardwrite"); // ��û�� �ı� �Խñ� �ۼ�
			hmdata.put("id", id); // ȸ�� id
			hmdata.put("fname", fname); // ��ǰ��
			hmdata.put("posttitle", title); // �Խñ� ����
			hmdata.put("postcomment", comment); // �Խñ� ����
			hmdata.put("grade", String.valueOf(grade)); // ��й�ȣ
			
			// ������ �α��� ���� �����Ѵ�.
			oos.writeObject(hmdata); // ������ �� ������ �����ϳ� Ư���� ����ȴ�.
			oos.flush(); // ����� �۾��� ��� ó���Ѵ�.
			
			// �������� �α��� ����� �޴´�.
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); // �������� ���� ���޹޾� �����Ѵ�.
			
			// ��üŸ���� ���� ���� �޾����� HashMap Ÿ���̹Ƿ� ����ȯ�� ���ش�.
			@SuppressWarnings("unchecked") // �ݵ�� HashMap Ÿ���� ���Ƿ� ���� ���ش�.
			HashMap<String, String> oisHm = (HashMap<String, String>) ois.readObject(); // Object to HashMap
			
			System.out.println(oisHm.get("respond"));
			// �������� �������θ� �޾� �����Ѵ�.
			if (oisHm.get("respond").equals("okay")) { // �Խ� ������
				return true; // �������� ��ȯ�Ѵ�.
			} else { // ����(error)�ϰ�� �α��� ����
				return false; // ���а��� ��ȯ�Ѵ�.
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
		
		return false;
	}
	
	
	// close method
	/**
	 * ������ ���ӵ� ���� ��ü�� �ݱ����� �޼���� �α��� ��ü�� ��� �� �ݵ�� ȣ��������Ѵ�.
	 * */
	public void close() {
		cs.close();
	} // close method end

}
