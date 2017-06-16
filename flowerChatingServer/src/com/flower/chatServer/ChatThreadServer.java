package com.flower.chatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

//import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class ChatThreadServer extends Thread{
	private Socket client;
	private JTextArea jtaMain;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private boolean flag;
	private HashMap<String, ChatThreadServer> clientMap = null;

	public ChatThreadServer(Socket client, JTextArea jtaMain) {
		this.client = client;
		this.jtaMain = jtaMain;
		this.flag = false;
		
		try {
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pushMessage(String msg) {
		
		System.out.println(pw);
		pw.println(msg);
		pw.flush();
	}
	
	@Override
	public void run() {
		while (true) {
			String msg = null;

			try {
				msg = br.readLine();
			} catch (java.net.SocketException e) {
				try {
					clientMap.remove(client.getInetAddress().getHostAddress());
					client.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("접속 종료");
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(flag);
			
			if(flag == true){
				jtaMain.append(msg + "\n");				
			} 

			//JScrollBar jsb = jsp.getVerticalScrollBar();
			//jsb.setValue(jsb.getMaximum());
		}
		
		
	} // run method ends
	public void setFlag(boolean flag){
		this.flag = flag; 
	}
	
	public void setClientMap(HashMap<String, ChatThreadServer> clientMap) {
		this.clientMap = clientMap;
	}
	
}
