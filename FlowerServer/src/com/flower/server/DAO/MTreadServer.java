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

// thread�� ��ӹ��� ��Ƽ�����弭�� Ŭ����
public class MTreadServer extends Thread {
	Socket client;

	// �����ڸ� ���ؼ� socket�� ���������� ���޹���
	public MTreadServer(Socket client) {
		this.client = client;
	} // default constructor ends

	@Override
	public void run() {

		try {
			// ���� ��ü : hashMap�� �ޱ⿡ ObjectInputStream�� ����Ѵ�
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
			Object obj = ois.readObject();
			@SuppressWarnings("unchecked")
			HashMap<String, String> hm = (HashMap<String, String>) obj;

			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));

			HashMap<String, String> hmLogSignIn = null;

			// �α��ΰ� ȸ������
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

			// ��ǰ���� ��ȸ
			// DAO Ŭ������ hm ����("request" �� "me1" ��) ����
			ProductDAO pda = new ProductDAO(hm);
			ArrayList<ProductVO> selectResult = null;

			// vo�� list �� �� Ŭ���̾�Ʈ�� ����
			// ��� ��ǰ������ �����ִ� ����
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
				// me �׸��� ��ǰ ������ �����ִ� ����
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
				// you �׸��� ��ǰ ������ �����ִ� ����
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

			// �ֹ� �� �ֹ� ���� ��ȸ
			if (hm.get("request").equals("order")) {
				// DAO Ŭ���� �ν��Ͻ�
				OrderDAO odo = new OrderDAO();
				// hashMap�� ���ؼ� �� request�� �ٸ� key, value�� ����
				odo.setHm(hm);
				// order query�� respond�� ���� hashMap return
				HashMap<String, String> hmOrder = odo.order();
				// hashMap�� ����
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
			// �Խ���
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
