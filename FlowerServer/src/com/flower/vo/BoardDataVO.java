package com.flower.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BoardDataVO  implements Serializable{
	private int postCode;
	private int customerCode;
	private int orderCode;
	private int productCode;
	private int postNumber;
	private String postTitle;
	private String postComment;
	private int grade;
	private String postDate;
	private String name;
	// fields
	
	public BoardDataVO() {
	}

	
	public BoardDataVO(int postCode, int customerCode, int orderCode, int productCode, int postNumber, String postTitle,
			String postComment, int grade, String postDate) {
		super();
		this.postCode = postCode;
		this.customerCode = customerCode;
		this.orderCode = orderCode;
		this.productCode = productCode;
		this.postNumber = postNumber;
		this.postTitle = postTitle;
		this.postComment = postComment;
		this.grade = grade;
		this.postDate = postDate;
	}
	
	
	public BoardDataVO(int postCode, int orderCode, int productCode, int postNumber, String postTitle,
			String postComment, int grade, String postDate, String name) {
		super();
		this.postCode = postCode;
		this.orderCode = orderCode;
		this.productCode = productCode;
		this.postNumber = postNumber;
		this.postTitle = postTitle;
		this.postComment = postComment;
		this.grade = grade;
		this.postDate = postDate;
		this.name = name;
	}

	@Override
	public String toString() {
		return "BoardDataVO [postCode=" + postCode + ", customerCode=" + customerCode + ", orderCode=" + orderCode
				+ ", productCode=" + productCode + ", postNumber=" + postNumber + ", postTitle=" + postTitle
				+ ", postComment=" + postComment + ", grade=" + grade + ", postDate=" + postDate + ", name=" + name
				+ "]";
	}

	public int getPostCode() {
		return postCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostComment() {
		return postComment;
	}
	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	
}
