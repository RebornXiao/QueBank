package com.liusiyang.question.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.context.ContextLoader;

public class Demo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 这是你要保存之后的文件，是自定义的，本身不存在
		
//		String filename = "file:///C:\Users\tc\AppData\Local\Temp\ksohtml\wpsC196.tmp.png";
		String filename = "";
//		filepath = filepath.replace("file:///", "");
//		filepath = filepath.replace("\\", "\\\");
		
		File f = new File(filename);
		String id = UUID.randomUUID().toString();
		Date date = new Date();

		// a2. 拼接文件名
		String newname = "liusiyang_" + "111.png";

		File afterfile = new File("d://" + newname);
		// String basePath = ContextLoader.getCurrentWebApplicationContext()
		// .getServletContext().getRealPath("/upload")
		// + "/" + newname;
		// 定义文件输入流，用来读取beforefile文件
		FileInputStream fis = new FileInputStream(f);

		// 定义文件输出流，用来把信息写入afterfile文件中
		FileOutputStream fos = new FileOutputStream(afterfile);

		// 文件缓存区
		byte[] b = new byte[1024];
		// 将文件流信息读取文件缓存区，如果读取结果不为-1就代表文件没有读取完毕，反之已经读取完毕
		while (fis.read(b) != -1) {
			// 将缓存区中的内容写到afterfile文件中
			fos.write(b);
			fos.flush();
		}
	}

}
