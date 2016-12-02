package com.liusiyang.question.dao;

import com.liusiyang.question.entity.BasketTemp;

public interface BasketTempMapper extends BaseMapper{
	BasketTemp selectById(Integer id);
}
