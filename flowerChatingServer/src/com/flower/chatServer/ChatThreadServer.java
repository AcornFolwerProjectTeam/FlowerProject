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

public class ChatThreadServer extends Thread {
	private Socket client;
	private JTextArea jtaMain;
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private boolean flag;
	private HashMap<String, ChatThreadServer> clientMap = null;
	private JTextArea jtaWait;
	private String ip;

	
	// client ����, ip, JTextArea�� �Ű������� �޴� ������ ������ ������
	public ChatThreadServer(Socket client, JTextArea jtaMain, String ip) {
		this.client = client; // �޾ƿ� Ŭ���̾�Ʈ ���� �������� �ʵ庯���� ����
		this.jtaMain = jtaMain; // JtaMain �������� �ʵ庯���� ����
		this.flag = false; // �⺻ flag�� false ��
		this.ip = ip; // ������ ip ������ �ʵ庯���� ����
		try {
			// ���Ű�ü�� �۽Ű�ü
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// constructor ends

	public void pushMessage(String msg) { 
		// jtf�� �ִ� msg�� �Ű������� �޾ƿͼ� Ŭ���̾�Ʈ�� �����Ѵ�
		pw.println(msg);
		pw.flush();
	} // pushMessage method ends

	@Override
	public void run() {
		while (true) { // ���� �ݺ�
			String msg = null;
			
			//Ŭ���̾�Ʈ�� �������Ḧ ���� ���
			try {
				if(client.getInputStream().read() == -1){ // ���ᰨ����ü, -1�̸� ��������
					accessExit();
					break;
				}
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} // try - catch ends
			
			
			//Ŭ���̾�Ʈ�� â�� ��������� ���
			try {
				msg = br.readLine(); // Ŭ���̾�Ʈ�� �޼����� �޾ƿ´�
			} catch (java.net.SocketException e) { // Ŭ���̾�Ʈ�� ������ ����Ǿ��� ���
				accessExit();
				break;
			} catch (IOException e) {
				e.printStackTrace();
			} // try - catch ends


			if (flag == true) {
				jtaMain.append("(" + ip + ")" + ":" + msg + "\n");
			} // flag�� true �� ��, �ش� ip�� �߾���� �ο��Ѵ�

		}

	} // run method ends
		
	private void accessExit(){
		String disConnIp = null; // ��������� ip

		try {
			// Ŭ���̾�Ʈ ������ ����Ǿ��� ��� ���� ���� ó��
			disConnIp = client.getInetAddress().getHostAddress();
			clientMap.remove(disConnIp); // ���� ip�� Map���� �����ϰ�
			client.close();// ���� �ݱ�(���� ����)
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// ����� ��� ����
		jtaWait.setText("");
		editIp(disConnIp);
		jtaMain.append(disConnIp + "�Բ��� �����ϼ̽��ϴ�.\n");
		System.out.println("���� ����");
		
	} // ������ �������� ��, client�� ������ �ݰ� ����� ����� �����ϴ� �޼ҵ�

	private void editIp(String disConnIp) {
		String tempText = jtaWait.getText();
		System.out.println(tempText);
		tempText = tempText.replace(disConnIp + "\n", "");
		jtaWait.setText(tempText);
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	} // flag�� private method �⿡ setter�� ���Ͽ� ������ ���ش�

	public void setClientMap(HashMap<String, ChatThreadServer> clientMap) {
		this.clientMap = clientMap;
	}	

	public void setJtaWait(JTextArea jtaWait) {
		this.jtaWait = jtaWait;
	}

}
