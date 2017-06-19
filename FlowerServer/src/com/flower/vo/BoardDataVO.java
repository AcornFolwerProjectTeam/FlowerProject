package com.flower.vo;

public class BoardDataVO {
	private int postCode;
	private int postNumber;
	private int customerCode;
	private String postTitle;
	private String postComment;
	private int grade;
	private String date;
	// fields

	public BoardDataVO() {

	} // default constructor

	public BoardDataVO(int postCode, int postNumber, int customerCode, String postTitle, String postComment, int grade,
			String date) {
		super();
		this.postCode = postCode;
		this.postNumber = postNumber;
		this.customerCode = customerCode;
		this.postTitle = postTitle;
		this.postComment = postComment;
		this.grade = grade;
		this.date = date;
	} // constructor using fields

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	// getter - setter postCode

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
	// getter - setter postNumber

	public int getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	// getter - setter customerCode

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	// getter - setter postTitle

	public String getPostComment() {
		return postComment;
	}

	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}
	// getter - setter postComment

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	// getter - setter grade

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	// getter - setter date

}
