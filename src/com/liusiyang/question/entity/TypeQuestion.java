package com.liusiyang.question.entity;

import java.io.Serializable;

public class TypeQuestion implements Serializable{
    private Integer typeId;

	private String typeContent;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeContent() {
		return typeContent;
	}

	public void setTypeContent(String typeContent) {
		this.typeContent = typeContent;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1050871622797717382L;

}