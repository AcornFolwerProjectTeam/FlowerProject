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
	
	public ArrayList<ProductVO> allFlower(){
		try {//모든꽃 리스트 받기
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// 발신 객체를 생성한다.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "selectall");
			
			
			oos.writeObject(hmlist); // 서버에 HashMap을 전송한다.
			oos.flush();// Buffer flush
			// 서버에서 회원가입 처리 결과 수신
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			@SuppressWarnings("unchecked")
			
			 ArrayList<ProductVO> list=(ArrayList<ProductVO>)ois.readObject();//arraylist로 받아온다.
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
		try {//나를 위한 꽃 리스트 받기
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// 발신 객체를 생성한다.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "selectme");
			hmlist.put("me1", me1);
			hmlist.put("me2", me2);
			hmlist.put("color", color);
			
			oos.writeObject(hmlist); // 서버에 HashMap을 전송한다.
			oos.flush();// Buffer flush
			// 서버에서 회원가입 처리 결과 수신
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			ProductVO fvo = (ProductVO) ois.readObject();
			ArrayList<ProductVO> list=(ArrayList<ProductVO>)ois.readObject();//arraylist로 받아온다.
			this.list=list;
			System.out.println("list" + list);
			System.out.println("fvo" + fvo);
			
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
	
	public ArrayList<ProductVO> youFlower(String you1, String you2, String color){
		try {//너를 위한 꽃 리스트 받기
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));// 발신 객체를 생성한다.
			HashMap<String, String> hmlist = new HashMap<String, String>(); 
			hmlist.put("request", "selectyou");
			hmlist.put("you1", you1);
			hmlist.put("you2", you2);
			hmlist.put("color", color);
			
			oos.writeObject(hmlist); // 서버에 HashMap을 전송한다.
			oos.flush();// Buffer flush
			// 서버에서 회원가입 처리 결과 수신
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			
			@SuppressWarnings("unchecked")
			
			 ArrayList<ProductVO> list=(ArrayList<ProductVO>)ois.readObject();//arraylist로 받아온다.
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
		cs.close();	// 소켓 연결 끊기
	}
}
