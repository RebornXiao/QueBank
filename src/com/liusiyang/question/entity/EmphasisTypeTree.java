package com.liusiyang.question.entity;

import java.util.List;

public class EmphasisTypeTree {
	private Integer id;
	private String text;
	private List<EmphasisQuestionTree> children;

	
	
	public EmphasisTypeTree() {
		super();
	}

	public EmphasisTypeTree(Integer id, String text) {
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<EmphasisQuestionTree> getChildren() {
		return children;
	}

	public void setChildren(List<EmphasisQuestionTree> children) {
		this.children = children;
	}

}