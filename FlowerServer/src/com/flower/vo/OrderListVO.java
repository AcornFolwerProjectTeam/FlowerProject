package com.flower.vo;

public class OrderListVO {
	private int orderCode;
	private int customerCode;
	private String revTime;
	private String revTel;
	private String revName;
	private String message;
	// fields

	OrderListVO() {

	} // default constructor

	OrderListVO(int orderCode, int customerCode, String revTime, String revTel, String revName, String message) {
		super();
		this.orderCode = orderCode;
		this.customerCode = customerCode;
		this.revTime = revTime;
		this.revTel = revTel;
		this.revName = revName;
		this.message = message;
	} // constructor using fields

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	// getter - setter orderCode

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	// getter - setter customerCoder

	public String getRevTime() {
		return revTime;
	}

	public void setRevTime(String revTime) {
		this.revTime = revTime;
	}
	// getter - setter revTime

	public String getRevTel() {
		return revTel;
	}

	public void setRevTel(String revTel) {
		this.revTel = revTel;
	}
	// getter - setter revTel

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}
	// getter - setter revName

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	// getter - setter message

}
