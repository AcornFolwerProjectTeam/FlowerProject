package com.flower.vo;

public class BoardListVO {
	private int boardCode;
	private String boardName;
	// fields

	public BoardListVO() {

	} // default constructor

	public BoardListVO(int boardCode, String boardName) {
		super();
		this.boardCode = boardCode;
		this.boardName = boardName;
	} // constructor using fields

	public int getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	// getter - setter boardCode

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	// getter - setter boardName

}
