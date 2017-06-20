package com.flower.client.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.OrderListVO;

public class OrderModule {
	ConnectServer cs = null;
	Socket socket = null;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	boolean flag;
	
	// ----- Constructor -------
	public OrderModule() throws ConnectException, UnknownHostException, IOException {
		flag = false;
		cs = new ConnectServer();	// ConnectServer ��ü ����
		socket = cs.getSocket();	// Socket ����
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<OrderListVO> getOrderList(String id) {
		ArrayList<OrderListVO> list = null;
		try {
			// �ֹ�����
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// �߽� ��ü�� �����Ѵ�.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "orderlist");
			hmlist.put("id", id);
			
			
			oos.writeObject(hmlist); // ������ HashMap�� �����Ѵ�.
			oos.flush();// Buffer flush
			// �������� ȸ������ ó�� ��� ����
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			// �����κ��� ������ ������ �޴´�.
			HashMap<String, Integer> hashData = (HashMap<String, Integer>) ois.readObject();
			int datasize = hashData.get("datasize"); // ������ ������ ������ ����
			
			// ������ŭ �����͸� �������� �߰��� VO�� list �����۾��� ��ģ��.
			OrderListVO[] ovo = new OrderListVO[datasize-1]; // list��ü ��� vo �迭
			
			// �ݺ������� VO�� list�����͸� �޾ƿ´�.
			for (int i = 0; i < datasize; i++) {
				if (i < datasize-1) { // 0~datasize-1 �ε����� vo������
					ovo[i] = (OrderListVO) ois.readObject();
				} else { // datasize �ε����� list������
					list=(ArrayList<OrderListVO>)ois.readObject();//arraylist�� �޾ƿ´�.					
				} // if end
			} // for end
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null)ois.close();
				if(ois != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public boolean order(String id, String revtime, String revname, String revtel, String msg, String fname) {
		
		try {
			// ������ ȸ������ ������ ����
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream())); // �߽� ��ü�� �����Ѵ�.
			
			HashMap<String, String> hmOrder = new HashMap<String, String>(); 	// HashMap �����Ѵ�.
			
			// ���� ���� HashMap�� ��´�.
			hmOrder.put("request", "order");	// ������ order�� ��û�Ѵ�.
			hmOrder.put("id", id);	// id
			hmOrder.put("revtime", revtime);	// ���� �ð� 
			hmOrder.put("revname", revname);	// ã�� ��� �̸�
			hmOrder.put("revtel", revtel);		// ã�� ��� �ڵ�����ȣ
			hmOrder.put("message", msg);	// �޽���
			hmOrder.put("fname", fname);	// ��ǰ��

			
			oos.writeObject(hmOrder); // ������ HashMap�� �����Ѵ�.
			oos.flush();	// Buffer flush
			
			// �������� ȸ������ ó�� ��� ����
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream())); // ���� ��ü�� �����Ѵ�.
			
			@SuppressWarnings("unchecked")
			HashMap<String, String> hmServer  = (HashMap<String, String>)ois.readObject();  // �������� �޴� ��ü�� HashMap���� ����ȯ
			
			System.out.println(hmServer);
			if(hmServer.get("respond").equals("okay")){	// ������ �������ǿ� �ɸ��� ������ flag�� true�� �ش�.
				flag = true;
			}else if(hmServer.get("respond").equals("error")){	// ������ �������ǿ� �ɷ��� error ���� flag�� false�� �ش�.
				flag = false;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ois!=null)ois.close();	// ���� ��ü �ڿ��ݳ��Ѵ�.
				if(oos!=null)oos.close();	// �߽� ��ü �ڿ��ݳ��Ѵ�.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return flag;	// okay���� error������ boolean���� ��ȯ
	
	}
	
	public void close() {
		cs.close();	// ���� ���� ����
	}
}
