package com.liusiyang.question.entity;

import java.io.Serializable;

public class QuestionText implements Serializable {

	private String questionText;

	private Integer questionLevelId;

	private Integer questionTypeId;

	private Integer questionGradeId;

	private String questionTypeText;

	private String questionChapterText;

	private String questionEmphasisText;

	public QuestionText() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7053513045726638691L;

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Integer getQuestionLevelId() {
		return questionLevelId;
	}

	public void setQuestionLevelId(Integer questionLevelId) {
		this.questionLevelId = questionLevelId;
	}

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public Integer getQuestionGradeId() {
		return questionGradeId;
	}

	public void setQuestionGradeId(Integer questionGradeId) {
		this.questionGradeId = questionGradeId;
	}

	public String getQuestionTypeText() {
		return questionTypeText;
	}

	public void setQuestionTypeText(String questionTypeText) {
		this.questionTypeText = questionTypeText;
	}

	public String getQuestionChapterText() {
		return questionChapterText;
	}

	public void setQuestionChapterText(String questionChapterText) {
		this.questionChapterText = questionChapterText;
	}

	public String getQuestionEmphasisText() {
		return questionEmphasisText;
	}

	public void setQuestionEmphasisText(String questionEmphasisText) {
		this.questionEmphasisText = questionEmphasisText;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}