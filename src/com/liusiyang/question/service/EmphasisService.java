package com.liusiyang.question.service;

import java.util.List;

import com.liusiyang.question.entity.EmphasisQuestion;

public interface EmphasisService extends BaseService<EmphasisQuestion> {
	List<EmphasisQuestion> selectEmphasis(Integer id);
	EmphasisQuestion getEmphasisQuestion(String em);
}
