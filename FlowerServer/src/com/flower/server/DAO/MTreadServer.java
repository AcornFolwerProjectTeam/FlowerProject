package com.flower.server.DAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

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
		super.run();

		try {
			// ���� ��ü : hashMap�� �ޱ⿡ ObjectInputStream�� ����Ѵ�
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
			Object obj = ois.readObject();
			@SuppressWarnings("unchecked")
			HashMap<String, String> hm = (HashMap<String, String>) obj;

			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(client.getOutputStream()));

			HashMap<String, String> hm1 = null;
			System.out.println(hm.get("request"));
			System.out.println("me1 :" + hm.get("me1"));
			System.out.println("me2 :" + hm.get("me2"));
			System.out.println("you1 :" + hm.get("you1"));
			System.out.println("you2 :" + hm.get("you2"));
			System.out.println("color :" + hm.get("color"));

			// �α��ΰ� ȸ������
			if (hm.get("request").equals("login")) {
				LogInDAO ln = new LogInDAO(hm);
				ln.check();
				hm1 = ln.check();

			} else if (hm.get("request").equals("signin")) {
				SignInDAO si = new SignInDAO(hm);
				si.check();
				hm1 = si.check();
			}
			oos.writeObject(hm1);
			oos.flush();

			// ��ǰ���� ��ȸ
			// DAO Ŭ������ hm ����("request" �� "me1" ��) ����
			ProductDAO pda = new ProductDAO(hm);
			ArrayList<ProductVO> selectResult = null;
			
			// vo�� list �� �� Ŭ���̾�Ʈ�� ����
			
			if (hm.get("request").equals("selectall")) {
				pda.selectAll();
				selectResult = pda.selectAll();
				for (int i = 0; i < selectResult.size(); i++) {
					oos.writeObject(selectResult.get(i));
				}
			} else if (hm.get("request").equals("selectme")) {
				System.out.println("select me ����");
				pda.selectMe();
				selectResult = pda.selectMe();
				for (int i = 0; i < selectResult.size(); i++) {
					oos.writeObject(selectResult.get(i));
				}
			} else if (hm.get("request").equals("selectyou")) {
				pda.selectYou();
				selectResult = pda.selectYou();
				for (int i = 0; i < selectResult.size(); i++) {
					oos.writeObject(selectResult.get(i));
				}
			}

			oos.writeObject(selectResult);
			oos.flush();

		} catch (IOException e) {
			System.out.println("IO exception in Reader and Writer, MThreadServer");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// run method ends

}// class ends
