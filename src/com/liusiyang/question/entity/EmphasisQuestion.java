package com.liusiyang.question.entity;

import java.io.Serializable;

public class EmphasisQuestion implements Serializable {
	private Integer emphasisId;

	private String emphasisContent;

	public Integer getEmphasisId() {
		return emphasisId;
	}

	public void setEmphasisId(Integer emphasisId) {
		this.emphasisId = emphasisId;
	}

	public String getEmphasisContent() {
		return emphasisContent;
	}

	public void setEmphasisContent(String emphasisContent) {
		this.emphasisContent = emphasisContent;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2166517633885634075L;

}