package com.liusiyang.question.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JFileChooser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.liusiyang.question.entity.BasketList;
import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import com.liusiyang.question.service.BasketListService;
import com.liusiyang.question.service.QuestionService;
import com.liusiyang.question.util.WordTool;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/basket")
public class BasketAction extends BaseAction {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	QuestionService questionService;

	@Resource
	BasketListService basketListService;

	/**
	 * 随机题目
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/randomQuestion")
	@ResponseBody
	public Object randomQuestion(Integer num) throws Exception {
		log.info("随即问题");
		Integer count = questionService.getCount();
		List<QuestionContent> list = new ArrayList<QuestionContent>();
		// BasketList basketList = new BasketList();
		// StringBuffer fillingsb = new StringBuffer();
		// StringBuffer choosesb = new StringBuffer();
		// StringBuffer explainsb = new StringBuffer();
		// int number = 0;
		for (int i = 0; i < num; i++) {
			int id = 1 + (int) (Math.random() * count);
			QuestionContent questionContent = questionService.selectById(id);
			if (questionContent != null) {
				// number++;
				list.add(questionContent);
				// if (questionContent.getQuestionTypeId() == 1) {
				// fillingsb.append("," + questionContent.getQuestionId());
				// } else if (questionContent.getQuestionTypeId() == 2) {
				// choosesb.append("," + questionContent.getQuestionId());
				// } else {
				// explainsb.append("," + questionContent.getQuestionId());
				// }
			}
		}
		// if (fillingsb.toString().length() > 0) {
		// basketList.setFillingNo(fillingsb.toString().substring(1,
		// fillingsb.toString().length()));
		//
		// } else {
		// basketList.setFillingNo("");
		// }
		//
		// if (choosesb.toString().length() > 0) {
		// basketList.setChooseNo(choosesb.toString().substring(1,
		// choosesb.toString().length()));
		//
		// } else {
		// basketList.setChooseNo("");
		// }
		//
		// if (explainsb.toString().length() > 0) {
		// basketList.setExplainNo(explainsb.toString().substring(1,
		// explainsb.toString().length()));
		// } else {
		// basketList.setExplainNo("");
		// }
		// basketList.setQuestionNumbers(number);
		// basketListService.insert(basketList);
		return list;
	}

	/**
	 * 插入试题篮
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertAlone")
	@ResponseBody
	public Object insertOne(BasketList basketList) throws Exception {
		log.info("随即问题");
		basketListService.insert(basketList);
		return null;
	}

	/**
	 * 插入试题篮
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(String listData) throws Exception {
		log.info(listData.toString());
		List<QuestionContent> list = JSON.parseArray(listData,
				QuestionContent.class);
		int length = list.size();
		log.info("得到数据:" + length);
		// List<QuestionContent> list = new ArrayList<QuestionContent>();//
		// Arrays.asList(listData);
		BasketList basketList = new BasketList();
		StringBuffer fillingsb = new StringBuffer();
		StringBuffer choosesb = new StringBuffer();
		StringBuffer explainsb = new StringBuffer();
		int num = 0;
		if (listData != null && list.size() > 0) {
			num = list.size();
			for (int i = 0; i < num; i++) {
				QuestionContent questionContent = list.get(i);
				if (questionContent.getQuestionTypeId() == 1) {
					fillingsb.append("," + questionContent.getQuestionId());
				} else if (questionContent.getQuestionTypeId() == 2) {
					choosesb.append("," + questionContent.getQuestionId());
				} else {
					explainsb.append("," + questionContent.getQuestionId());
				}
			}
			if (fillingsb.toString().length() > 0) {
				basketList.setFillingNo(fillingsb.toString().substring(1,
						fillingsb.toString().length()));

			} else {
				basketList.setFillingNo("");
			}

			if (choosesb.toString().length() > 0) {
				basketList.setChooseNo(choosesb.toString().substring(1,
						choosesb.toString().length()));

			} else {
				basketList.setChooseNo("");
			}

			if (explainsb.toString().length() > 0) {
				basketList.setExplainNo(explainsb.toString().substring(1,
						explainsb.toString().length()));
			} else {
				basketList.setExplainNo("");
			}
			basketList.setQuestionNumbers(num);
			basketListService.insert(basketList);
		} else {

		}
		return "success";
	}

	// 通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<BasketList> page) {
		log.info("分页查询试题篮");
		Page<BasketList> p = basketListService.selectPage(page);
		return p.getPageMap();
	}

	// 通过关键字分页查询
	@RequestMapping("/outPrint")
	@ResponseBody
	public String outPrint(Integer id) {
		BasketList basketList = basketListService.select(id);
		WordTool tool = new WordTool();
		String chooseNo = basketList.getChooseNo();
		String fillingNo = basketList.getFillingNo();
		String explainNo = basketList.getExplainNo();
		String[] choose = fillingNo.split(",");
		String[] filling = chooseNo.split(",");
		String[] explain = explainNo.split(",");
		List<String> strings = new ArrayList<String>();
		strings.clear();
		strings.add("一、选择题");
		
		for (int i = 0,size = choose.length; i < size; i++) {
			Integer questionId = Integer.parseInt(choose[i]);
			QuestionContent questionContent = questionService.selectById(questionId);
			strings.add((i+1)+"、"+questionContent.getQuestionText());
		}
		strings.add("二、填空题");
		for (int i = 0,size = filling.length; i < size; i++) {
			Integer questionId = Integer.parseInt(filling[i]);
			QuestionContent questionContent = questionService.selectById(questionId);
			strings.add((i+1)+"、"+questionContent.getQuestionText());
		}
		strings.add("三、解答题");
		for (int i = 0,size = explain.length; i < size; i++) {
			Integer questionId = Integer.parseInt(explain[i]);
			QuestionContent questionContent = questionService.selectById(questionId);
			strings.add((i+1)+"、"+questionContent.getQuestionText());
		}
		
		JFileChooser fileChooser = new JFileChooser("D:\\");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();// 这个就是你选择的文件夹的路径
			try {
				String time = new Date().toLocaleString();
				int num = (int) (10000 + (Math.random() * 10000));
				tool.createDocContext(filePath + "/" + num + ".doc",
						(time + "练习试卷"), strings);
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
}
