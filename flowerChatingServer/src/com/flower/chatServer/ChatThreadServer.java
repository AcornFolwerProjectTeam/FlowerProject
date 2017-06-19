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

	
	// client 소켓, ip, JTextArea를 매개변수로 받는 스레드 서버의 생성자
	public ChatThreadServer(Socket client, JTextArea jtaMain, String ip) {
		this.client = client; // 받아온 클라이언트 소켓 참조값을 필드변수에 저장
		this.jtaMain = jtaMain; // JtaMain 참조값을 필드변수에 저장
		this.flag = false; // 기본 flag는 false 값
		this.ip = ip; // 접속한 ip 정보를 필드변수에 저장
		try {
			// 수신객체와 송신객체
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// constructor ends

	public void pushMessage(String msg) { 
		// jtf에 있는 msg를 매개변수로 받아와서 클라이언트에 전송한다
		pw.println(msg);
		pw.flush();
	} // pushMessage method ends

	@Override
	public void run() {
		while (true) { // 무한 반복
			String msg = null;
			
			//클라이언트가 정상종료를 했을 경우
			try {
				if(client.getInputStream().read() == -1){ // 연결감지객체, -1이면 연결종료
					accessExit();
					break;
				}
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} // try - catch ends
			
			
			//클라이언트가 창을 종료시켰을 경우
			try {
				msg = br.readLine(); // 클라이언트의 메세지를 받아온다
			} catch (java.net.SocketException e) { // 클라이언트의 접속이 종료되었을 경우
				accessExit();
				break;
			} catch (IOException e) {
				e.printStackTrace();
			} // try - catch ends


			if (flag == true) {
				jtaMain.append("(" + ip + ")" + ":" + msg + "\n");
			} // flag가 true 일 때, 해당 ip에 발언권을 부여한다

		}

	} // run method ends
		
	private void accessExit(){
		String disConnIp = null; // 접속종료된 ip

		try {
			// 클라이언트 접속이 종료되었을 경우 접속 종료 처리
			disConnIp = client.getInetAddress().getHostAddress();
			clientMap.remove(disConnIp); // 현재 ip를 Map에서 제거하고
			client.close();// 소켓 닫기(접속 종료)
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 대기자 목록 갱신
		jtaWait.setText("");
		editIp(disConnIp);
		jtaMain.append(disConnIp + "님께서 퇴장하셨습니다.\n");
		System.out.println("접속 종료");
		
	} // 접속을 종료했을 때, client를 소켓을 닫고 대기자 목록을 갱신하는 메소드

	private void editIp(String disConnIp) {
		String tempText = jtaWait.getText();
		System.out.println(tempText);
		tempText = tempText.replace(disConnIp + "\n", "");
		jtaWait.setText(tempText);
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	} // flag가 private method 기에 setter를 통하여 조정을 해준다

	public void setClientMap(HashMap<String, ChatThreadServer> clientMap) {
		this.clientMap = clientMap;
	}	

	public void setJtaWait(JTextArea jtaWait) {
		this.jtaWait = jtaWait;
	}

}
