package com.liusiyang.question.entity;

import java.io.Serializable;

public class EmphasisQuestion implements Serializable{
    private Integer emphasisId;

	private String emphasisContent;

	private Integer emphasisType;

	private String emphasisTypeText;

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

	public Integer getEmphasisType() {
		return emphasisType;
	}

	public void setEmphasisType(Integer emphasisType) {
		this.emphasisType = emphasisType;
	}

	public String getEmphasisTypeText() {
		return emphasisTypeText;
	}

	public void setEmphasisTypeText(String emphasisTypeText) {
		this.emphasisTypeText = emphasisTypeText;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2166517633885634075L;

}