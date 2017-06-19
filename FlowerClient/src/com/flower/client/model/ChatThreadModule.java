package com.flower.client.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatThreadModule extends Thread{
	ChatModule cm;
	JTextArea jtaShow;
	JScrollPane jspShow;
	BufferedReader br;
	
	public ChatThreadModule(ChatModule cm, JTextArea jtaShow, JScrollPane jspShow) {
		this.cm = cm;
		this.jtaShow = jtaShow;
		this.jspShow = jspShow;
	}
	
	@Override
	public void run() {
		super.run();
		try {
			br = new BufferedReader(new InputStreamReader(cm.getSocket().getInputStream()));
			String data = "";
			while ((data=br.readLine())!=null){
				jtaShow.append("[admin]: " + data + "\n");
				JScrollBar jsb = jspShow.getVerticalScrollBar();
				int v = jsb.getMaximum();
				jsb.setValue(v);	
			}
		} catch (SocketException e) {
			try {
				if(br!=null)br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
