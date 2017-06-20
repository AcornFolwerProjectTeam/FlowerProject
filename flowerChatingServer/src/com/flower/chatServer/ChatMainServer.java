package com.flower.chatServer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChatMainServer extends JFrame implements ActionListener, KeyListener {

	private JPanel jp1; // 왼쪽 패널
	private JPanel jp2; // 오른쪽 패널

	private JTextArea jtaMain; // 메인 채팅창
	private JTextArea jtaWait; // 대기자 목록

	private JLabel jlWait; // '대기자 목록' 을 표시하는 라벨
	private JTextField jtf; // 메세지 입력창
	private JScrollPane jsp; // 스크롤 패널

	private JButton jbtnExit; // 종료버튼
	private JButton jbtnSend; // 전송버튼
	private JButton jbtnStart; // 시작버튼

	private ServerSocket ss; // 서버 소켓
	private PrintWriter pw; // 송신객체

	private HashMap<String, ChatThreadServer> clientMap; // ip를 key로, ChatThreadServer의
													// 참조변수를 value로 가지는 HashMap
	private LinkedList<String> waiterList; // queue 자료 구조를 구현한 LinkedList 객체
	private ChatThreadServer targetClient; // ChatThreadServer의 참조변수
	private String ip;

	public ChatMainServer() {
		super("채팅서버"); // 메인 창 이름
		setLayout(null); // 레이아웃은 null
		setBounds(200, 200, 700, 700); // 창 시작점 지정

		jp1 = new JPanel(); // 왼쪽 패널 인스턴스
		jp2 = new JPanel(); // 오른쪽 패널 인스턴스
		// panel

		jtaMain = new JTextArea(); // 메인 채팅창 인스턴스
		jsp = new JScrollPane(jtaMain, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 메인 채팅창을 스크롤바에 부착
		jtf = new JTextField(); // 메세지 창 인스턴스
		jbtnSend = new JButton("전송"); // 전송버튼 인스턴스
		// panel 1 components

		jlWait = new JLabel("대기자 목록", 0); // 가운데 정렬
		jtaWait = new JTextArea(); // 대기자 목록 인스턴스
		jtaWait.setEditable(false); // 대기자 목록을 표시만을 하기 위해서 편집기능 삭제
		jbtnExit = new JButton("종료"); // 종료버튼 인스턴스
		jbtnStart = new JButton("시작"); // 시작버튼 인스턴스
		// panel 2 components

		clientMap = new HashMap<String, ChatThreadServer>(); // Map 인스턴스
		waiterList = new LinkedList<String>(); // LinkedList 인스턴스
		createP1(); // p1의 ui를 지정하는 메서드
		createP2(); // p2의 ui를 지정하는 메서드

		setDefaultCloseOperation(EXIT_ON_CLOSE); // x키 누를시 종료
		setVisible(true);
		startServer(); // 생성자 호출과 동시에 startServer 메서드 호출
	} // constructor ends

	private void createP1() {
		// TODO : panel 1의 규격을 정하고, component의 규격을 정해서 add 한다
		jp1.setLayout(null);
		jp1.setBounds(30, 30, 400, 600);
		jp1.setBackground(Color.WHITE);
		add(jp1);

		jsp.setBounds(20, 20, 350, 500);
		jtf.setBounds(20, 550, 290, 40);
		jbtnSend.setBounds(310, 550, 70, 40);

		jp1.add(jsp);
		jp1.add(jtf);
		jp1.add(jbtnSend);

		jtf.addKeyListener(this); // 메세지 입력 창에 리스너 부착
	}

	private void createP2() {
		// TODO : panel 2의 규격을 정하고, component의 규격을 정해서 add 한다
		jp2.setLayout(null);
		jp2.setBounds(450, 30, 225, 600);
		jp2.setBackground(Color.ORANGE);
		add(jp2);

		jlWait.setBounds(20, 80, 200, 50);
		jtaWait.setBounds(20, 130, 200, 200);

		jbtnExit.setBounds(20, 550, 200, 50);
		jbtnStart.setBounds(20, 400, 200, 50);

		jp2.add(jlWait);
		jp2.add(jtaWait);
		jp2.add(jbtnExit);
		jp2.add(jbtnStart);

		jbtnStart.addActionListener(this); // 시작버튼에 리스너 부착
		jbtnExit.addActionListener(this); // 종료버튼에 리스너 부착
	}

	private void startServer() {

		try {
			ss = new ServerSocket(5001); // 서버 소 켓 생성, port = 5001
			while (true) { // 무한 반복
				System.out.println("대기 중"); // 서버 대기 중
				// 접속하는 클라이언트 마다 새로운 소켓을 생성하여 대기시킨다
				Socket client = ss.accept(); 
				// 접속한 클라이언트의 ip 주소를 받아온다
				ip = client.getInetAddress().getHostAddress(); 
				if (clientMap.containsKey(ip)) { // Map에 해당 ip가 이미 존재하면
					System.out.println("이미 접속중인 사용자 입니다. IP : " + ip); 
					client.close(); // 소켓을 닫아버린다
					continue; // if 문에서 조건문이 참일 경우 해당 작업을 무시하고 다음으로 넘어감
				} // 즉 이미 접속한 ip면 종료시키고, 그렇지 않으면 아래 작업으로 넘어간다

				waiterList.offer(ip); // LinkedList에 ip element를 추가한다
				jtaWait.append(ip + "\n"); // 대기자 목록에 해당 ip를 출력한다

				// Socket, jtaMain, ip를 매개변수로 받는 스레드 서버 클래스의 생성자
				ChatThreadServer cmts = new ChatThreadServer(client, jtaMain, ip); 
				
																					
				System.out.println("접속 : " + cmts); // 어느 스레드가 접속하엿는지 출력
				clientMap.put(ip, cmts); // Map에 해당 ip와 Thread의 참조변수를 추가한다
				cmts.setClientMap(clientMap); // 멀티스레드 클래스에 현재 Map의 정보를 전달한다
				cmts.setJtaWait(jtaWait); // 멀티스레드 클래스에 현재 jtaWait의 정보를 전달한다
				cmts.start(); // 스레드 작업 시작
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // startServer method ends

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtnExit) {
			System.exit(0); // 종료버튼에 종료기능 추가
			// 자원 반납
				try {
				if (pw != null)
					pw.close();
				if (ss!= null)
					ss.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
		} else if (e.getSource() == jbtnStart) {
			if (waiterList.peek() != null) { // 대기자 목록에 사람이 있을 경우
				String ip = waiterList.poll(); // 맨 처음 들어온 사람의 ip 정보를 받아와서
				jtaMain.append(ip + "님과 상담을 시작합니다\n");
				if (clientMap.containsKey(ip)) { // Map에 해당 ip가 존재하면
					/* 
					 * get(ip)는 결국 ChatTreadServer의 참조변수setFlag method를 통해서
					 * 발언권을 부여
					 */
					/* 
					 * ip로 받아온 ChatTreadServer의
					 * 참조변수를 targetClient로 지정
					 */					
					targetClient = clientMap.get(ip); 
					clientMap.get(ip).setFlag(true); 
					targetClient.pushMessage("상담을 시작합니다.");								
				} else {
					// 해당 ip가 존재하지 않으면, 해당 메세지를 출력
					pw.println(ip + "는 접속이 끊어져 있습니다"); 				
					pw.flush();
				}
			} // else if jbtnStart ends
		} else if(e.getSource() == jbtnSend){
			String msg = "";
			msg = jtf.getText(); // 메세지 입력 창에 있는 메세지를
			jtaMain.append("Admin :" + msg + "\n");// 내 창에 보여주고
			targetClient.pushMessage(msg); // 송신객체를 통해서 main 채팅창에 올리도록
			jtf.setText(""); // 그리고 메세지창 초기화
		} // if- else if ends
	} // actionPerformed method ends

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { // enter 키 입력시
			String msg = "";
			msg = jtf.getText(); // 메세지 입력 창에 있는 메세지를
			jtaMain.append("Admin :" + msg + "\n");
			targetClient.pushMessage(msg); // 송신객체를 통해서 main 채팅창에 올리도록
			jtf.setText(""); // 그리고 메세지창 초기화
			jtf.requestFocusInWindow(); // window가 해당 창에 focus를 주도록
		}

	} // keyPressed method ends

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public static void main(String[] args) {
		new ChatMainServer();

	}

} // class ends
