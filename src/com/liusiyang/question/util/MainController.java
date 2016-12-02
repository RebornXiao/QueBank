package com.liusiyang.question.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public final static String ADD = "添加失败，服务器异常";

	public final static String DEL = "删除失败，服务器异常";

	public final static String UPD = "修改失败，服务器异常";

	public final static String QUERY = "查询失败，服务器异常";

	/**
	 * @describe 异常错误消息
	 * 
	 * @author ruanpeng
	 * @date 2014年6月30日
	 * @param
	 * @return
	 */
	public void addError(String errMsg, Exception e, HttpServletRequest request) {
		e.printStackTrace();
		log.error(errMsg, e);
		request.setAttribute("err", errMsg);
	}

	/**
	 * @describe 对用JS escape的URL进行解码
	 * 
	 * @author ruanpeng
	 * @date 2014年6月30日
	 * @param
	 * @return
	 */
	public String urlDecode(String url) throws Exception {
		// return URLDecoder.decode(url, "UTF-8");
		return url;
	}

	/**
	 * @describe 获取调用端IP地址
	 * 
	 * @auther ruanpeng
	 * @date 2014年8月14日
	 * @param request
	 * @return
	 */
	public String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

}
