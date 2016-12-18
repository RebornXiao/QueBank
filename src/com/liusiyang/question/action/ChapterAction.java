package com.liusiyang.question.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.liusiyang.question.entity.ChapterQuestion;
import com.liusiyang.question.entity.Combobox;
import com.liusiyang.question.entity.EmphasisQuestion;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import com.liusiyang.question.service.ChapterService;
import com.liusiyang.question.service.QuestionService;
import com.liusiyang.question.util.QuestionUtils;
import com.sun.org.apache.bcel.internal.generic.I2F;
import com.sun.org.apache.regexp.internal.recompile;

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
	@ResponseBody
	public String insert(String chapter) {
		log.info("新增章节");
		try {
			ChapterQuestion chapterQues = chapterService.getChapter(chapter);
			if (chapterQues != null && chapterQues.getChapterId() > 0) {
				return "have";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ChapterQuestion chapterQuestion = new ChapterQuestion();
		chapterQuestion.setChapterContent(chapter);
		try {
			chapterService.insert(chapterQuestion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	// 通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<ChapterQuestion> page,
			ChapterQuestion chapterQuestion) throws Exception {
		System.out.println("新的请求开始了！");
		// page.setPage(1);
		// page.setRows(2);
		// page.setStart(1);

		Page<ChapterQuestion> p = chapterService.selectPage(page);
		// supplier.setSupName("supName1");
		/*
		 * Map<String, Object> map =new HashMap<String, Object>();
		 * map.put("total",p.getTotalRecord()); map.put("rows",p.getList());
		 */

		return p.getPageMap();
	}

	// 分页查询
	@RequestMapping("/selectPageByNum")
	@ResponseBody
	public Object selectPageByNum(Page<ChapterQuestion> page) throws Exception {
		System.out.println("新的请求开始了！");
		// page.setPage(1);
		// page.setRows(2);
		// page.setStart(1);

		Page<ChapterQuestion> p = chapterService.selectPage(page);
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
		List<ChapterQuestion> chapterQuestions = chapterService.getAll();
		List<Combobox> comboboxs = new ArrayList<Combobox>();
		comboboxs.clear();

		if (chapterQuestions != null && chapterQuestions.size() > 0) {
			for (int i = 1, size = chapterQuestions.size() + 1; i < size; i++) {
				Combobox combobox = new Combobox();
				combobox.setId(i);
				combobox.setText(chapterQuestions.get(i - 1)
						.getChapterContent());
				if (i == 1) {
					combobox.setSelected(true);
				}
				comboboxs.add(combobox);
			}
		}

		return comboboxs;
	}

	@RequestMapping("/getChapter")
	@ResponseBody
	public Object getChapter() {

		List<AAA> list = new ArrayList<AAA>();
		list.clear();
		for (int i = 1; i < 100; i++) {
			AAA a = new AAA();
			a.setId(i);
			String text = getText(i);
			a.setText("第" + text + "章");
			list.add(a);
		}
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		return jsonString;
	}

	private String getText(Integer id) {
		String text = "";
		if (id <= 10) {
			text = getNum(id);
		} else {
			if (id % 10 == 0) {
				text = (id / 10) + "十";
			} else {
				if (id / 10 == 1) {
					text = "十" + getNum(id % 10);
				} else {
					text = getNum(id / 10) + "十" + getNum(id % 10);
				}
			}
		}
		return text;
	}

	private String getNum(Integer id) {
		String text = "";
		switch (id) {
		case 0:
			text = "十";
		case 1:
			text = "一";
			break;
		case 2:
			text = "二";
			break;
		case 3:
			text = "三";
			break;
		case 4:
			text = "四";
			break;
		case 5:
			text = "五";
			break;
		case 6:
			text = "六";
			break;
		case 7:
			text = "七";
			break;
		case 8:
			text = "八";
			break;
		case 9:
			text = "九";
			break;
		case 10:
			text = "十";
			break;

		default:
			break;
		}
		return text;
	}
}

class AAA extends Object {
	private Integer id;
	private String text;

	public AAA() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "AAA [id=" + id + ", text=" + text + "]";
	}

}
