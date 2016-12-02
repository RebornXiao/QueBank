package com.liusiyang.question.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liusiyang.question.entity.ChapterQuestion;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import com.liusiyang.question.service.ChapterService;
import com.liusiyang.question.service.QuestionService;
import com.liusiyang.question.util.QuestionUtils;

/**
 * 根据章节
 * 
 */
@Controller
@RequestMapping("/chapter")
public class ChapterAction extends BaseAction {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	ChapterService chapterService;

	@RequestMapping(value = "/insert")
	// @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public String insert(ChapterQuestion chapterQuestion) {
		log.info("新增章节");
		try {

			chapterService.insert(chapterQuestion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/base/goURL/chapter/addChapter.action";
	}

	// 通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<ChapterQuestion> page,
			ChapterQuestion chapterQuestion) {
		System.out.println("新的请求开始了！");
		// page.setPage(1);
		// page.setRows(2);
		// page.setStart(1);

		Page<ChapterQuestion> p = chapterService.selectPage(page);
		System.out.println("----page:" + page);
		// supplier.setSupName("supName1");
		/*
		 * Map<String, Object> map =new HashMap<String, Object>();
		 * map.put("total",p.getTotalRecord()); map.put("rows",p.getList());
		 */

		return p.getPageMap();
	}
}
