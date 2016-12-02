package com.liusiyang.question.service;

import java.util.List;

import com.liusiyang.question.entity.EmphasisType;

public interface EmphasisTypeService extends BaseService<EmphasisType> {
	List<EmphasisType> getAll();
}
