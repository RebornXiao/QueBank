package com.liusiyang.question.dao;

import java.util.List;
import java.util.Map;

import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import org.apache.ibatis.annotations.Param;

public interface QuestionContentMapper extends BaseMapper<QuestionContent> {

	List<QuestionContent> getAll(Map<String, Object> paramMap);

	Integer getAllNum(Map<String, Object> paramMap);

	QuestionContent selectById(Integer questionId);

	Integer selectCount();

	// 通过关键字分页查询数据列表
	public List<QuestionContent> selectPageListUseDycByType(
			Page<QuestionContent> page);

	// 通过关键字分页查询，返回总记录数
	public Integer selectPageCountUseDycByType(Page<QuestionContent> page);

}