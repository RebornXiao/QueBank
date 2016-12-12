package com.liusiyang.question.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import com.liusiyang.question.entity.Page;
import com.liusiyang.question.entity.QuestionContent;
import com.liusiyang.question.service.QuestionService;
import com.liusiyang.question.util.QuestionUtils;
import org.apache.commons.io.FileUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.List;

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
			String questionText = questionContent.getQuestionText();
			Pattern p = Pattern.compile("\" src=\"(.*?)\" width=");
			Matcher m = p.matcher(questionText);
			while (m.find()) {
				System.out.println(m.group(1));
				String filePath = m.group(1);
				// if (filePath.startsWith("file:")) {
				String filepathupload = filePath.replace("file:///", "");
				filepathupload = filepathupload.replace("\\", "/");
				File f = new File(filepathupload);
				String basePath = ContextLoader
						.getCurrentWebApplicationContext().getServletContext()
						.getRealPath("/upload");
				upload(f, basePath);
				questionText = questionText.replace(filePath,
						"http://localhost:8080/qb/upload/" + f.getName());
				log.info("上传地址:" + questionText);
			}
			questionContent.setQuestionText(questionText);
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
			questionContent.setQuestionChapterText(questionContent
					.getQuestionChapterText());
			questionContent.setQuestionEmphasisId(1);
			questionContent.setQuestionEmphasisText(questionContent
					.getQuestionEmphasisText());
			log.info(questionContent.toString());
			questionService.insert(questionContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:/base/goURL/question/addQuestion.action";
	}

	private void upload(File upload, String realpath) throws IOException {
		// File upload = null;// 实际上传文件
		String[] uploadContentType; // 文件的内容类型
		String uploadFileName = upload.getName(); // 上传文件名

		// String realpath =
		// ServletActionContext.getServletContext().getRealPath(
		// "/upload");// 获取服务器路径
		// String targetFileName = uploadFileName;
		File target = new File(realpath, uploadFileName);
		FileUtils.copyFile(upload, target);
		// 这是一个文件复制类copyFile()里面就是IO操作，如果你不用这个类也可以自己写一个IO复制文件的类
	}

	/**
	 * 判断str1中包含str2的个数
	 * 
	 * @param str1
	 * @param str2
	 * @return counter
	 */
	public int countStr(String str1, String str2) {
		int counter = 0;
		if (str1.indexOf(str2) == -1) {
			return 0;
		} else if (str1.indexOf(str2) != -1) {
			counter++;
			countStr(str1.substring(str1.indexOf(str2) + str2.length()), str2);
			return counter;
		}
		return 0;
	}

	// 通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody
	public Object selectPage(Page<QuestionContent> page) throws Exception {
		log.info("分页查询问题");
		Page<QuestionContent> p = questionService.selectPage(page);
		return p.getPageMap();
	}

	@RequestMapping("/selectById")
	@ResponseBody
	public Object selectById(Integer questionId) {
		return questionService.selectById(questionId);
	}

	@RequestMapping("/selectByEmphasis")
	@ResponseBody
	public Object selectByEmphasis(Page<QuestionContent> page,
			QuestionContent questionContent) throws Exception {
		log.info("分页查询问题");
		Page<QuestionContent> p = questionService.selectPage(page);
		return p.getPageMap();
	}

	public List xmlElements(String xmlDoc) {
		// 创建一个新的字符串
		StringReader read = new StringReader(xmlDoc);
		// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
		InputSource source = new InputSource(read);
		// 创建一个新的SAXBuilder
		SAXBuilder sb = new SAXBuilder();
		try {
			// 通过输入源构造一个Document
			org.jdom.Document doc = sb.build(source);
			// 取的根元素
			Element root = doc.getRootElement();
			System.out.println(root.getName());// 输出根元素的名称（测试）
			// 得到根元素所有子元素的集合
			List jiedian = root.getChildren();
			// 获得XML中的命名空间（XML中未定义可不写）
			Namespace ns = root.getNamespace();
			Element et = null;
			for (int i = 0; i < jiedian.size(); i++) {
				et = (Element) jiedian.get(i);// 循环依次得到子元素

				System.out.println(et.getChild("users_id", ns).getText());
				System.out.println(et.getChild("users_address", ns).getText());
			}

			et = (Element) jiedian.get(0);
			List zjiedian = et.getChildren();
			for (int j = 0; j < zjiedian.size(); j++) {
				Element xet = (Element) zjiedian.get(j);
				System.out.println(xet.getName());
			}
		} catch (JDOMException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return null;
	}

}
