package com.liusiyang.question.entity;

import java.io.Serializable;

public class BasketTemp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5397235746871157905L;

	private Integer questionId;

	private String questionText;

	private String questionAnswer;

	private Integer questionLevelId;

	private Integer questionTypeId;

	private Integer questionGradeId;

	private Integer questionChapterId;

	private Integer questionEmphasisId;

	private Integer questionVersionId;

	private String questionLevelText;

	private String questionTypeText;

	private String questionGradeText;

	private String questionChapterText;

	private String questionEmphasisText;

	private String questionVersionText;

	public BasketTemp() {
		super();
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
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

	public Integer getQuestionChapterId() {
		return questionChapterId;
	}

	public void setQuestionChapterId(Integer questionChapterId) {
		this.questionChapterId = questionChapterId;
	}

	public Integer getQuestionEmphasisId() {
		return questionEmphasisId;
	}

	public void setQuestionEmphasisId(Integer questionEmphasisId) {
		this.questionEmphasisId = questionEmphasisId;
	}

	public Integer getQuestionVersionId() {
		return questionVersionId;
	}

	public void setQuestionVersionId(Integer questionVersionId) {
		this.questionVersionId = questionVersionId;
	}

	public String getQuestionLevelText() {
		return questionLevelText;
	}

	public void setQuestionLevelText(String questionLevelText) {
		this.questionLevelText = questionLevelText;
	}

	public String getQuestionTypeText() {
		return questionTypeText;
	}

	public void setQuestionTypeText(String questionTypeText) {
		this.questionTypeText = questionTypeText;
	}

	public String getQuestionGradeText() {
		return questionGradeText;
	}

	public void setQuestionGradeText(String questionGradeText) {
		this.questionGradeText = questionGradeText;
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

	public String getQuestionVersionText() {
		return questionVersionText;
	}

	public void setQuestionVersionText(String questionVersionText) {
		this.questionVersionText = questionVersionText;
	}

	@Override
	public String toString() {
		return "BasketTemp [questionId=" + questionId + ", questionText="
				+ questionText + ", questionAnswer=" + questionAnswer
				+ ", questionLevelId=" + questionLevelId + ", questionTypeId="
				+ questionTypeId + ", questionGradeId=" + questionGradeId
				+ ", questionChapterId=" + questionChapterId
				+ ", questionEmphasisId=" + questionEmphasisId
				+ ", questionVersionId=" + questionVersionId
				+ ", questionLevelText=" + questionLevelText
				+ ", questionTypeText=" + questionTypeText
				+ ", questionGradeText=" + questionGradeText
				+ ", questionChapterText=" + questionChapterText
				+ ", questionEmphasisText=" + questionEmphasisText
				+ ", questionVersionText=" + questionVersionText + "]";
	}

	


	
}
