package com.liusiyang.question.action;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import com.liusiyang.question.service.QuestionService;
import com.liusiyang.question.util.QuestionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/question")
public class QuestionAction extends BaseAction {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	QuestionService questionService;

	@RequestMapping(value = "/insert")
	// @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public String insert(QuestionContent questionContent) {
		log.info("新增问题");
		try {
			questionContent.setQuestionAnswer("");
			questionContent.setQuestionTypeText(QuestionUtils
					.getQueType(questionContent.getQuestionTypeId()));
			questionContent.setQuestionLevelText(QuestionUtils
					.getQueLevel(questionContent.getQuestionLevelId()));
			questionContent.setQuestionGradeText(QuestionUtils
					.getQueGrade(questionContent.getQuestionGradeId()));

			questionContent.setQuestionVersionText("人教版");
			questionContent.setQuestionVersionId(1);
			questionContent.setQuestionChapterId(1);
			questionContent.setQuestionChapterText("有理数");
			questionContent.setQuestionEmphasisId(1);
			questionContent.setQuestionEmphasisText("努力买房");
			log.info(questionContent.toString());
			questionService.insert(questionContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/base/goURL/question/addQuestion.action";
	}

	// 通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<QuestionContent> page) {
		log.info("分页查询问题");
		Page<QuestionContent> p = questionService.selectPage(page);
		return p.getPageMap();
	}

	@RequestMapping("/selectById")
	@ResponseBody
	public Object selectById(Integer questionId) {
		return questionService.selectById(questionId);
	}
	
	

}
