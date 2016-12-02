package com.liusiyang.question.dao;

import com.liusiyang.question.entity.EmphasisType;
import com.liusiyang.question.entity.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmphasisTypeMapper extends BaseMapper<EmphasisType> {
	// 通过关键字分页查询数据列表
	public List<EmphasisType> getAll();
}