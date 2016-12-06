package com.liusiyang.question.entity;

public class EmphasisQuestionTree {
	private Integer id;
	private String state = "open";
	private String text;

	
	public EmphasisQuestionTree() {
		super();
	}

	public EmphasisQuestionTree(Integer id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
