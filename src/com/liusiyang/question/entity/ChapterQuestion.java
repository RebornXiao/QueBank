package com.liusiyang.question.entity;

import java.io.Serializable;

public class ChapterQuestion implements Serializable{
	
	
    private Integer chapterId;

	private String chapterContent;

	private Integer chapterGrade;

	private String chapterNum;

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

	public Integer getChapterGrade() {
		return chapterGrade;
	}

	public void setChapterGrade(Integer chapterGrade) {
		this.chapterGrade = chapterGrade;
	}

	public String getChapterNum() {
		return chapterNum;
	}

	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}

	private static final long serialVersionUID = 2665199576775576730L;

}