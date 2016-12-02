package com.liusiyang.question.service.impl;

import org.springframework.stereotype.Service;

import com.liusiyang.question.entity.BasketTemp;
import com.liusiyang.question.service.BasketTempService;

@Service("basketTempService")
public class BasketTempServiceImpl extends BaseServiceImpl<BasketTemp>
		implements BasketTempService {
	public BasketTemp selectById(Integer id) {
		return basketTempMapper.selectById(id);
	}
}
