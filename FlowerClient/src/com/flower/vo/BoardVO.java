package com.flower.vo;

public class BoardVO {
	private String title;
	private String imgPath;
	private String comment;
	private String name;
	private int grade;
	private String date;

	public BoardVO() {
		super();
	}

	public BoardVO(String title, String imgPath, String comment, String name, int grade, String date) {
		super();
		this.title = title;
		this.imgPath = imgPath;
		this.comment = comment;
		this.name = name;
		this.grade = grade;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
