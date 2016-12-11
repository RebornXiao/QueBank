package com.liusiyang.question.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liusiyang.question.entity.Combobox;
import com.liusiyang.question.entity.EmphasisQuestion;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.service.EmphasisService;

/**
 * 根据重点
 * 
 */
@Controller
@RequestMapping("/emphasis")
public class EmphasisAction extends BaseAction {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	EmphasisService emphasisService;

	@RequestMapping("/insert")
	@ResponseBody
	public String insert(String emphasis) {
		log.info("新增重点");
		try {
			EmphasisQuestion emphasisQu = emphasisService
					.getEmphasisQuestion(emphasis);
			if (emphasisQu != null && emphasisQu.getEmphasisId() > 0) {
				return "have";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		EmphasisQuestion emphasisQuestion = new EmphasisQuestion();
		emphasisQuestion.setEmphasisContent(emphasis);
		try {
			emphasisService.insert(emphasisQuestion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	// 通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<EmphasisQuestion> page,
			EmphasisQuestion emphasisQuestion) throws Exception {
		// page.setPage(1);
		// page.setRows(2);
		// page.setStart(1);

		Page<EmphasisQuestion> p = emphasisService.selectPage(page);
		System.out.println("----page:" + page);
		// supplier.setSupName("supName1");
		/*
		 * Map<String, Object> map =new HashMap<String, Object>();
		 * map.put("total",p.getTotalRecord()); map.put("rows",p.getList());
		 */

		return p.getPageMap();
	}

	// 通过关键字分页查询
	@RequestMapping("/selectAll")
	@ResponseBody
	public Object selectAll() throws Exception {
		List<EmphasisQuestion> emphasisQuestions = emphasisService.getAll();
		List<Combobox> comboboxs = new ArrayList<Combobox>();
		comboboxs.clear();
		if (emphasisQuestions != null && emphasisQuestions.size() > 0) {
			for (int i = 1, size = emphasisQuestions.size() + 1; i < size; i++) {
				Combobox combobox = new Combobox();
				combobox.setId(i);
				combobox.setText(emphasisQuestions.get(i - 1)
						.getEmphasisContent());
				comboboxs.add(combobox);
			}
		}

		return comboboxs;
	}
}
