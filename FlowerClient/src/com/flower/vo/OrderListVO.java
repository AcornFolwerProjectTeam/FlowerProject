package com.flower.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderListVO implements Serializable {
	private int orderCode;
	private int customerCode;
	private String revTime;
	private String revTel;
	private String revName;
	private String message;
	private String fName;
	private int fPrice;
	private int receive;
	private String imgUrl;
	private String orderDate;

	// fields

	public OrderListVO() {

	} // default constructor

	public OrderListVO(int orderCode, int customerCode, String revTime, String revTel, String revName, String message,
			String fName, int fPrice, int receive, String imgUrl, String orderDate) {
		super();
		this.orderCode = orderCode;
		this.customerCode = customerCode;
		this.revTime = revTime;
		this.revTel = revTel;
		this.revName = revName;
		this.message = message;
		this.fName = fName;
		this.fPrice = fPrice;
		this.receive = receive;
		this.imgUrl = imgUrl;
		this.orderDate = orderDate;
	}

	
	@Override
	public String toString() {
		return "OrderListVO [orderCode=" + orderCode + ", customerCode=" + customerCode + ", revTime=" + revTime
				+ ", revTel=" + revTel + ", revName=" + revName + ", message=" + message + ", fName=" + fName
				+ ", fPrice=" + fPrice + ", receive=" + receive + ", imgUrl=" + imgUrl + ", orderDate=" + orderDate
				+ "]";
	}

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

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getReceive() {
		return receive;
	}

	public void setReceive(int receive) {
		this.receive = receive;
	}

	public int getfPrice() {
		return fPrice;
	}

	public void setfPrice(int fPrice) {
		this.fPrice = fPrice;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}
