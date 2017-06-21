package com.flower.server.DAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import com.flower.vo.BoardDataVO;
import com.flower.vo.OrderListVO;
import com.flower.vo.ProductVO;

// thread를 상속받은 멀티스레드서버 클래스
public class MTreadServer extends Thread {
	Socket client;

	// 생성자를 통해서 socket의 참조변수를 전달받음
	public MTreadServer(Socket client) {
		this.client = client;
	} // default constructor ends

	@Override
	public void run() {

		try {
			// 수신 객체 : hashMap을 받기에 ObjectInputStream을 사용한다
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
			Object obj = ois.readObject();
			@SuppressWarnings("unchecked")
			HashMap<String, String> hm = (HashMap<String, String>) obj;

			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));

			HashMap<String, String> hmLogSignIn = null;

			// 로그인과 회원가입
			if (hm.get("request").equals("login")) {
				LogInDAO ln = new LogInDAO(hm);
				hmLogSignIn = ln.check();
				oos.writeObject(hmLogSignIn);
				oos.flush();

			} else if (hm.get("request").equals("signin")) {
				SignInDAO si = new SignInDAO(hm);
				hmLogSignIn = si.check();
				oos.writeObject(hmLogSignIn);
				oos.flush();
			}

			// 상품정보 조회
			// DAO 클래스에 hm 정보("request" 및 "me1" 등) 전달
			ProductDAO pda = new ProductDAO(hm);
			ArrayList<ProductVO> selectResult = null;

			// vo와 list 둘 다 클라이언트에 전송
			// 모든 제품정보를 보여주는 쿼리
			if (hm.get("request").equals("selectall")) {
				selectResult = pda.selectAll();
				HashMap<String, Integer> hashData = new HashMap<String, Integer>();
				hashData.put("datasize", selectResult.size() + 1);
				oos.writeObject(hashData);
				for (int i = 0; i < selectResult.size(); i++) {
					oos.writeObject(selectResult.get(i));
				}
				oos.writeObject(selectResult);
				oos.flush();
				// me 항목의 제품 정보를 보여주는 쿼리
			} else if (hm.get("request").equals("selectme")) {
				selectResult = pda.selectMe();
				HashMap<String, Integer> hashData = new HashMap<String, Integer>();
				hashData.put("datasize", selectResult.size() + 1);
				oos.writeObject(hashData);
				for (int i = 0; i < selectResult.size(); i++) {
					oos.writeObject(selectResult.get(i));
				}
				oos.writeObject(selectResult);
				oos.flush();
				// you 항목의 제품 정보를 보여주는 쿼리
			} else if (hm.get("request").equals("selectyou")) {
				selectResult = pda.selectYou();
				HashMap<String, Integer> hashData = new HashMap<String, Integer>();
				hashData.put("datasize", selectResult.size() + 1);
				oos.writeObject(hashData);
				for (int i = 0; i < selectResult.size(); i++) {
					oos.writeObject(selectResult.get(i));
				}
				oos.writeObject(selectResult);
				oos.flush();
			}

			// 주문 및 주문 정보 조회
			if (hm.get("request").equals("order")) {
				// DAO 클래스 인스턴스
				OrderDAO odo = new OrderDAO();
				// hashMap을 통해서 온 request와 다른 key, value를 전달
				odo.setHm(hm);
				// order query의 respond를 담은 hashMap return
				HashMap<String, String> hmOrder = odo.order();
				// hashMap을 전송
				oos.writeObject(hmOrder);
				oos.flush();
			} else if (hm.get("request").equals("orderlist")) {
				OrderDAO odo = new OrderDAO();
				odo.setHm(hm);
				ArrayList<OrderListVO> list = odo.selectUser();

				HashMap<String, Integer> hashData = new HashMap<String, Integer>();
				hashData.put("datasize", list.size() + 1);
				oos.writeObject(hashData);
				for (int i = 0; i < list.size(); i++) {
					oos.writeObject(list.get(i));
				}
				oos.writeObject(list);
				oos.flush();
			}
			// 게시판
			if (hm.get("request").equals("boardwrite")) {
				BoardDAO bdao = new BoardDAO();
				bdao.setHm(hm);
				HashMap<String, String> hmBoard = bdao.boardInsert();
				oos.writeObject(hmBoard);
				oos.flush();
				
				OrderDAO odao = new OrderDAO();
				odao.updateReceive(Integer.parseInt(hm.get("ordercode")), 2);
			}  else if (hm.get("request").equals("postList")) {
				BoardDAO bdao = new BoardDAO();
				bdao.setHm(hm);
				ArrayList<BoardDataVO> list = bdao.select();

				HashMap<String, Integer> hashData = new HashMap<String, Integer>();
				hashData.put("datasize", list.size() + 1);
				oos.writeObject(hashData);
				for (int i = 0; i < list.size(); i++) {
					oos.writeObject(list.get(i));
				}
				oos.writeObject(list);
				oos.flush();
			}

		} catch (IOException e) {
			System.out.println("IO exception in Reader and Writer, MThreadServer");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

		} // try - catch - finally ends

	}// run method ends

}// class ends
