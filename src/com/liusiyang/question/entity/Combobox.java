package com.liusiyang.question.entity;

public class Combobox {
	private Integer id;
	private String text;

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

	@Override
	public String toString() {
		return "Combobox [id=" + id + ", text=" + text + "]";
	}

}
