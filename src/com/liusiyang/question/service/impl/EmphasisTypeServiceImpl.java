package com.liusiyang.question.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liusiyang.question.entity.ChapterQuestion;
import com.liusiyang.question.entity.EmphasisQuestion;
import com.liusiyang.question.entity.EmphasisType;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.service.ChapterService;
import com.liusiyang.question.service.EmphasisService;
import com.liusiyang.question.service.EmphasisTypeService;

@Service("emphasisTypeService")
public class EmphasisTypeServiceImpl extends BaseServiceImpl<EmphasisType>
		implements EmphasisTypeService {

	public List<EmphasisType> getAll() {
		return emphasisTypeMapper.getAll();
	}

}
