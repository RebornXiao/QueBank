package com.liusiyang.question.entity;

import java.io.Serializable;

public class LevelQuestion implements Serializable{
    private Integer levelId;

	private String levelContent;

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelContent() {
		return levelContent;
	}

	public void setLevelContent(String levelContent) {
		this.levelContent = levelContent;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8402859309332286884L;

}