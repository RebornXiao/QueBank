package com.liusiyang.question.service;

import java.util.List;

import com.liusiyang.question.entity.Page;

public interface BaseService<T> {

	public int insert(T entity) throws Exception;

	public int update(T entity) throws Exception;

	public int delete(T entity) throws Exception;

	public T select(Integer id) throws Exception;

	public List<T> getAll() throws Exception;

	// 通过关键字分页查询
	public Page<T> selectPage(Page<T> page) throws Exception;

	// 通过多条件分页查询
	public Page<T> selectPageUseDyc(Page<T> page) throws Exception;
}
