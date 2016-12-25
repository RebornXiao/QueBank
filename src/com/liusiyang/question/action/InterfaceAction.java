package com.liusiyang.question.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liusiyang.question.entity.BaseReque;
import com.liusiyang.question.entity.Methods;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import com.liusiyang.question.entity.ResponContent;
import com.liusiyang.question.service.ChapterService;
import com.liusiyang.question.service.EmphasisService;
import com.liusiyang.question.service.QuestionService;

@Controller
@RequestMapping("/i")
public class InterfaceAction extends BaseAction {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	QuestionService questionService;

	@Resource
	EmphasisService emphasisService;

	@Resource
	ChapterService chapterService;

	@RequestMapping(value = "/c", method = RequestMethod.GET)
	@ResponseBody
	// 如果返回json格式，需要这个注解，这里用来测试环境
	public void getRequst(HttpServletRequest req, HttpServletResponse rep) {
		rep.setContentType("text/html; charset=UTF-8");
		String content = req.getParameter("content");
		// String pass = req.getParameter("pass");

		// log.info("收到客户端请求：" + content.toString());
		String toPhone = null;
		BaseReque baseRespon = JSON.parseObject(content, BaseReque.class);
		String method = baseRespon.getMethod();
		ResponContent responCon = new ResponContent();

		if (method.equals(Methods.GETALLQUESTION)) {
			try {
				
				Page<QuestionContent> page = new Page<QuestionContent>();
				QuestionContent questionContent = new QuestionContent();
				
				page.setParamEntity(questionContent);
				page.setRows(50);
				page.setPage(1);
				page.setStart(1);
				
				Page<QuestionContent> p = questionService.selectPage(page);
//				p.getList();
				responCon.setMsg(p.getList());
//				toPhone = JSON.toJSONString(p.getPageMap());
//				responCon.setMsg(p.getList());
			} catch (Exception e) {
				e.printStackTrace();
				responCon.setCode(1);
				responCon.setMsg("异常");
			}
		}

		PrintWriter writer = null;
		try {
			writer = rep.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println(JSON.toJSONString(responCon));
		writer.flush();

	}

}
