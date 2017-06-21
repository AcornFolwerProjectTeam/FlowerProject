package com.flower.client.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.ProductVO;

//ProductModule class
public class ProductModule {
	private ConnectServer cs = null;
	private Socket socket = null;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	ArrayList<ProductVO> list;
	
	// ----- Constructor -------
	public ProductModule() throws ConnectException, UnknownHostException, IOException{
		list=null;
		cs= new ConnectServer();
		socket = cs.getSocket();
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ProductVO> allFlower(){
		try {//���� ����Ʈ �ޱ�
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// �߽� ��ü�� �����Ѵ�.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "selectall");
			
			
			oos.writeObject(hmlist); // ������ HashMap�� �����Ѵ�.
			oos.flush();// Buffer flush
			// �������� ȸ������ ó�� ��� ����
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			// �����κ��� ������ ������ �޴´�.
			HashMap<String, Integer> hashData = (HashMap<String, Integer>) ois.readObject();
			int datasize = hashData.get("datasize"); // ������ ������ ������ ����
			
			// ������ŭ �����͸� �������� �߰��� VO�� list �����۾��� ��ģ��.
			ArrayList<ProductVO> list = null; // VO ���� ����ִ� list��ü
			ProductVO[] pvo = new ProductVO[datasize-1]; // list��ü ��� vo �迭
			
			// �ݺ������� VO�� list�����͸� �޾ƿ´�.
			for (int i = 0; i < datasize; i++) {
				if (i < datasize-1) { // 0~datasize-1 �ε����� vo������
					pvo[i] = (ProductVO) ois.readObject();
				} else { // datasize �ε����� list������
					list=(ArrayList<ProductVO>)ois.readObject();//arraylist�� �޾ƿ´�.					
				} // if end
			} // for end
			
			this.list=list;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(ois != null)ois.close();
					if(ois != null) oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		return list;
	}
	
	
	public ArrayList<ProductVO> meFlower(String me1, String me2, String color){
		try {//���� ���� �� ����Ʈ �ޱ�
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// �߽� ��ü�� �����Ѵ�.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "selectme");
			hmlist.put("me1", me1);
			hmlist.put("me2", me2);
			hmlist.put("color", color);
			
			oos.writeObject(hmlist); // ������ HashMap�� �����Ѵ�.
			oos.flush();// Buffer flush
			// �������� ȸ������ ó�� ��� ����
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			// �����κ��� ������ ������ �޴´�.
			HashMap<String, Integer> hashData = (HashMap<String, Integer>) ois.readObject();
			int datasize = hashData.get("datasize"); // ������ ������ ������ ����
						
			// ������ŭ �����͸� �������� �߰��� VO�� list �����۾��� ��ģ��.
			ArrayList<ProductVO> list = null; // VO ���� ����ִ� list��ü
			ProductVO[] pvo = new ProductVO[datasize-1]; // list��ü ��� vo �迭
						
			// �ݺ������� VO�� list�����͸� �޾ƿ´�.
			for (int i = 0; i < datasize; i++) {
				if (i < datasize-1) { // 0~datasize-1 �ε����� vo������
					pvo[i] = (ProductVO) ois.readObject();
				} else { // datasize �ε����� list������
					list=(ArrayList<ProductVO>)ois.readObject();//arraylist�� �޾ƿ´�.					
				} // if end
			
			}
						
			this.list=list;
			System.out.println("list" + list);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(ois != null)ois.close();
					if(oos != null) oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ProductVO> youFlower(String you1, String you2, String color){
		try {//�ʸ� ���� �� ����Ʈ �ޱ�
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// �߽� ��ü�� �����Ѵ�.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "selectyou");
			hmlist.put("you1", you1);
			hmlist.put("you2", you2);
			hmlist.put("color", color);
			
			oos.writeObject(hmlist); // ������ HashMap�� �����Ѵ�.
			oos.flush();// Buffer flush
			// �������� ȸ������ ó�� ��� ����
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			@SuppressWarnings("unchecked")
			// �����κ��� ������ ������ �޴´�.
			HashMap<String, Integer> hashData = (HashMap<String, Integer>) ois.readObject();
			int datasize = hashData.get("datasize"); // ������ ������ ������ ����
						
			// ������ŭ �����͸� �������� �߰��� VO�� list �����۾��� ��ģ��.
			ArrayList<ProductVO> list = null; // VO ���� ����ִ� list��ü
			ProductVO[] pvo = new ProductVO[datasize-1]; // list��ü ��� vo �迭
						
			// �ݺ������� VO�� list�����͸� �޾ƿ´�.
			for (int i = 0; i < datasize; i++) {
				if (i < datasize-1) { // 0~datasize-1 �ε����� vo������
					pvo[i] = (ProductVO) ois.readObject();
				} else { // datasize �ε����� list������
					list=(ArrayList<ProductVO>)ois.readObject();//arraylist�� �޾ƿ´�.					
				} // if end
			
			}
			
			
			 
			this.list=list;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(ois != null)ois.close();
					if(ois != null) oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		return list;
	}
	
	
	
	public void close() {
		cs.close();	// ���� ���� ����
	}
}
