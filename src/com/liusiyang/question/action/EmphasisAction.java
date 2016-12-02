package com.liusiyang.question.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liusiyang.question.entity.EmphasisQuestion;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.service.EmphasisService;
import com.liusiyang.question.service.EmphasisTypeService;

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

	@Resource
	EmphasisTypeService emphasisTypeService;

	@RequestMapping(value = "/insert")
	// @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public String insert(EmphasisQuestion emphasisQuestion) {
		log.info("新增重点");
		try {
			emphasisService.insert(emphasisQuestion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/base/goURL/emphasis/addEmphasis.action";
	}

	// 通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<EmphasisQuestion> page,
			EmphasisQuestion emphasisQuestion) {
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

	@RequestMapping("/getAllType")
	@ResponseBody
	public Object getAll() {
		log.info("查询重点类型");
		emphasisTypeService.getAll();
		return emphasisTypeService.getAll();
	}

}
