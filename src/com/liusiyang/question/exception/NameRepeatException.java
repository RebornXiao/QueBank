package com.liusiyang.question.exception;
/**
 * 姓名重复自定义异常类
 * @author APPle
 *
 */
public class NameRepeatException extends Exception {

	public NameRepeatException(String msg){
		super(msg);
	}
}
