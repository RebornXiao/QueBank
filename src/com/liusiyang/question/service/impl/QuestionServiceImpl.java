package com.liusiyang.question.service.impl;

import org.springframework.stereotype.Service;

import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import com.liusiyang.question.service.QuestionService;

@Service("questionService")
public class QuestionServiceImpl extends BaseServiceImpl<QuestionContent>
		implements QuestionService {

	public QuestionContent selectById(Integer questionId) {
		return questionContentMapper.selectById(questionId);
	}

	public Integer getCount() {
		return questionContentMapper.selectCount();
	}

}
