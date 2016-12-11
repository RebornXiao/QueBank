package com.liusiyang.question.entity;

import java.io.Serializable;

public class ChapterQuestion implements Serializable{
	
	
    private Integer chapterId;

	private String chapterContent;


	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterContent() {
		return chapterContent;
	}

	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}


	private static final long serialVersionUID = 2665199576775576730L;

}