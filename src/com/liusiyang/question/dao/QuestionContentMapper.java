package com.liusiyang.question.dao;

import java.util.List;
import java.util.Map;

import com.liusiyang.question.entity.QuestionContent;
import org.apache.ibatis.annotations.Param;

public interface QuestionContentMapper extends BaseMapper<QuestionContent> {

	List<QuestionContent> getAll(Map<String, Object> paramMap);

	Integer getAllNum(Map<String, Object> paramMap);

	QuestionContent selectById(Integer questionId);
	
	Integer selectCount();

}