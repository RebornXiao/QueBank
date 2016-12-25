package com.liusiyang.question.entity.reponse;

import java.util.List;

import com.liusiyang.question.entity.QuestionContent;

public class QuestionRep {
	private List<QuestionContent> questionContents;

	public List<QuestionContent> getQuestionContents() {
		return questionContents;
	}

	public void setQuestionContents(List<QuestionContent> questionContents) {
		this.questionContents = questionContents;
	}

}
