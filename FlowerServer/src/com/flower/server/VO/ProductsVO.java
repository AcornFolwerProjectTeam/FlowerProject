package com.flower.server.VO;

public class ProductsVO {
	private int productCode;
	private String product;
	private String price;
	private int me1, me2, me3;
	private int you1, you2, you3;
	private String img;
	private String details;

	// fields

	ProductsVO() {

	} // default constructor

	public ProductsVO(int productCode, String product, String price, int me1, int me2, int me3, int you1, int you2,
			int you3, String img, String details) {
		super();
		this.productCode = productCode;
		this.product = product;
		this.price = price;
		this.me1 = me1;
		this.me2 = me2;
		this.me3 = me3;
		this.you1 = you1;
		this.you2 = you2;
		this.you3 = you3;
		this.img = img;
		this.details = details;
	} // constructor using field

	// ---- getter and setter
	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public int getMe3() {
		return me3;
	}

	public void setMe3(int me3) {
		this.me3 = me3;
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

	public int getYou3() {
		return you3;
	}

	public void setYou3(int you3) {
		this.you3 = you3;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
