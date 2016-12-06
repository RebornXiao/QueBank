package com.liusiyang.question.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liusiyang.question.entity.ChapterQuestion;
import com.liusiyang.question.entity.EmphasisQuestion;
import com.liusiyang.question.service.ChapterService;
import com.liusiyang.question.service.EmphasisService;

@Service("emphasisService")
public class EmphasisServiceImpl extends BaseServiceImpl<EmphasisQuestion>
		implements EmphasisService {

	public List<EmphasisQuestion> selectEmphasis(Integer id) {
		return emphasisQuestionMapper.selectEmphasis(id);
	}

}
