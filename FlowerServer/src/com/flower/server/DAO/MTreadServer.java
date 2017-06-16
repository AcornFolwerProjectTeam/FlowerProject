package com.flower.server.DAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;


public class MTreadServer extends Thread {
	Socket client;
	
	public MTreadServer(Socket client){
		this.client = client;
	} // default constructor ends
	
	@Override
	public void run() {
		super.run();
		
		try {
			// receive object
			ObjectInputStream ois = new ObjectInputStream(
										new BufferedInputStream(
												client.getInputStream()));
			Object obj = ois.readObject();
			@SuppressWarnings("unchecked")
			HashMap<String, String> hm = (HashMap<String, String>) obj;

			ObjectOutputStream oos = new ObjectOutputStream(
										new BufferedOutputStream(
											client.getOutputStream()));
			
			
			HashMap<String, String> hm1 = null;
			System.out.println(hm.get("request"));
			System.out.println(hm.get("id"));
			System.out.println(hm.get("password"));
			System.out.println(hm.get("name"));
			System.out.println(hm.get("phone"));
			
			if(hm.get("request").equals("login")){
				LogInDAO ln = new LogInDAO(hm);
				ln.check();
				hm1 = ln.check();
				
			} else if(hm.get("request").equals("signin")){
				SignInDAO si = new SignInDAO(hm);
				si.check();
				hm1 = si.check();
			}
			oos.writeObject(hm1);
			oos.flush();
			
		} catch (IOException e) {
			System.out.println("IO exception in Reader and Writer, MThreadServer");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// run method ends
	
}//class ends
