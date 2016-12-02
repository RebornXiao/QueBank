package com.liusiyang.question.service;

import com.liusiyang.question.entity.QuestionContent;

public interface QuestionService extends BaseService<QuestionContent> {
	QuestionContent selectById(Integer questionId);

	Integer getCount();
}
