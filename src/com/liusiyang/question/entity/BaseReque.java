package com.liusiyang.question.entity;

public class BaseReque<T> {
	private String method;
	private T detail;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public T getDetail() {
		return detail;
	}
	public void setDetail(T detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "BaseRespon [method=" + method + ", detail=" + detail + "]";
	}
	
	
}
