package com.liusiyang.question.service;

import com.liusiyang.question.entity.BasketTemp;

public interface BasketTempService extends BaseService<BasketTemp> {

	public BasketTemp selectById(Integer id);
}
