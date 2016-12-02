package com.liusiyang.question.entity;

import java.io.Serializable;

public class EmphasisType implements Serializable {
	private Integer emphasisTypeId;

	private String emphasisTypeText;

	public Integer getEmphasisTypeId() {
		return emphasisTypeId;
	}

	public void setEmphasisTypeId(Integer emphasisTypeId) {
		this.emphasisTypeId = emphasisTypeId;
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

	@Override
	public String toString() {
		return "EmphasisType [emphasisTypeId=" + emphasisTypeId
				+ ", emphasisTypeText=" + emphasisTypeText + "]";
	}
	
	

}