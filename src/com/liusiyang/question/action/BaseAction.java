package com.liusiyang.question.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base")
public class BaseAction {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	 ServletContext application;
	
	//方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
		@RequestMapping("/goURL/{folder}/{file}")
		public String goURL(@PathVariable String folder,@PathVariable String file) {
			log.warn("goURL.folder|file===" + folder+"/"+file);
			return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
		}

}
