package com.flower.server.VO;

public class AccountVO {

	private int customerCode;
	private String id;
	private String pw;
	private String name;
	private String tel;

	public AccountVO() {

	} // default constructor
	public AccountVO(String id, String pw){
		this.id = id;
		this.pw = pw;
	}

	public AccountVO(int customerCode, String id, String pw, String name, String tel) {
		super();
		this.customerCode = customerCode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	} // constructor using fields

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	// getter - setter customerCode

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	// getter - setter id

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	// getter - setter id

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// getter - setter name

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	// getter - setter tel
}
