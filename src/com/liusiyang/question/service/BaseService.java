package com.liusiyang.question.service;

import com.liusiyang.question.entity.Page;

public interface BaseService<T> {

	public int insert(T entity) throws Exception;

	public int update(T entity) throws Exception;

	public int delete(T entity) throws Exception;

	public T select(Integer id);

	// 通过关键字分页查询
	public Page<T> selectPage(Page<T> page);

	// 通过多条件分页查询
	public Page<T> selectPageUseDyc(Page<T> page);
}
