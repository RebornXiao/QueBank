package com.liusiyang.question.entity;

public class ResponContent<T> {
	private T msg;
	private int code = 0;// 0正常，1异常
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getMsg() {
		return msg;
	}
	public void setMsg(T msg) {
		this.msg = msg;
	}
	
}
