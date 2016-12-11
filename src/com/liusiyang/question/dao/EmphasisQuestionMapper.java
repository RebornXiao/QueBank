package com.liusiyang.question.dao;

import com.liusiyang.question.entity.EmphasisQuestion;
import com.liusiyang.question.entity.EmphasisType;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmphasisQuestionMapper extends BaseMapper<EmphasisQuestion> {
	public List<EmphasisQuestion> selectEmphasis(Integer id);
	
	public EmphasisQuestion getEmphasisQuestion(String emphasis);
}