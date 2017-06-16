package com.flower.server.DAO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	ServerSocket ss;

	public MainServer() {

		try {
			ss = new ServerSocket(5000);
			while (true) {
				Socket client = ss.accept();
				System.out.println(client.getInetAddress().getHostAddress());
				
				MTreadServer mts = new MTreadServer(client);
				mts.start();
				
				
			} // while ends
			
			
		} catch (IOException e) {
			System.out.println("ServerSocket IO exception");
			e.printStackTrace();
		} // try - catch ends

	} // default constructor
	
	
} // class ends
