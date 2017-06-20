package com.flower.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductVO implements Serializable {
	private String fName;
	private String imgUrl;
	private String textUrl;
	private String thumbNail;
	private int fPrice;
	private int you1;
	private int you2;
	private int me1;
	private int me2;
	private int color;
	
	public ProductVO(String fName, int fPrice, String imgUrl, String textUrl, String thumbNail) {
		this.fName = fName;
		this.fPrice = fPrice;
		this.imgUrl = imgUrl;
		this.textUrl = textUrl;
		this.thumbNail = thumbNail;
	} // constructor

	// setter and getters
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTextUrl() {
		return textUrl;
	}

	public void setTextUrl(String textUrl) {
		this.textUrl = textUrl;
	}

	public int getfPrice() {
		return fPrice;
	}

	public void setfPrice(int fPrice) {
		this.fPrice = fPrice;
	}

	public int getYou1() {
		return you1;
	}

	public void setYou1(int you1) {
		this.you1 = you1;
	}

	public int getYou2() {
		return you2;
	}

	public void setYou2(int you2) {
		this.you2 = you2;
	}

	public int getMe1() {
		return me1;
	}

	public void setMe1(int me1) {
		this.me1 = me1;
	}

	public int getMe2() {
		return me2;
	}

	public void setMe2(int me2) {
		this.me2 = me2;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}
		
}// class ends
