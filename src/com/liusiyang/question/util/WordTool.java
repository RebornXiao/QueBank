package com.liusiyang.question.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JFileChooser;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
import com.sun.org.apache.regexp.internal.recompile;

public class WordTool {
	public void createDocContext(String file, String titleStr,
			List<String> strings) throws DocumentException, IOException {
		// 设置纸张大小
		Document document = new Document(PageSize.A4);
		// 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
		RtfWriter2.getInstance(document, new FileOutputStream(file));
		document.open();
		// 设置中文字体
		BaseFont bfChinese = BaseFont.createFont("STSongStd-Light",
				"UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		addTitle(document, bfChinese, titleStr);
		// 正文字体风格
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		// addUnderline(document);
		for (int i = 0, size = strings.size(); i < size; i++) {
			addContent(document, bfChinese, strings.get(i));
		}
		// 利用类FontFactory结合Font和Color可以设置各种各样字体样式
		// addTable(document, bfChinese);
		document.add(new Paragraph("\n"));
		// 添加图片
		// Image
		// img=Image.getInstance("http://127.0.0.1:8080/testSystem/images/1_r1_c1.png");
		// img.setAbsolutePosition(0, 0);
		// img.setAlignment(Image.RIGHT);//设置图片显示位置
		// img.scaleAbsolute(12,35);//直接设定显示尺寸
		// img.scalePercent(50);//表示显示的大小为原尺寸的50%
		// img.scalePercent(25, 12);//图像高宽的显示比例
		// img.setRotation(30);//图像旋转一定角度
		// document.add(img);
		document.close();
	}

	// 添加标题
	private void addTitle(Document document, BaseFont bfChinese, String titleStr)
			throws DocumentException {
		// 标题字体风格
		Font titleFont = new Font(bfChinese, 24, Font.BOLD);
		Paragraph title = new Paragraph(titleStr);
		// 设置标题格式对齐方式
		title.setAlignment(Element.ALIGN_CENTER);
		title.setFont(titleFont);
		document.add(title);
	}

	// 添加正文
	private void addContent(Document document, BaseFont bfChinese,
			String contextStr) throws DocumentException {
		Font contextFont = new Font(bfChinese, 10, Font.NORMAL);
		Paragraph context = new Paragraph(contextStr);
		// 正文格式左对齐
		context.setAlignment(Element.ALIGN_LEFT);
		context.setFont(contextFont);
		// 离上一段落（标题）空的行数
		context.setSpacingBefore(5);
		// 设置第一行空的列数
		context.setFirstLineIndent(20);
		document.add(context);
	}

	// 添加下划线
	private void addUnderline(Document document) throws DocumentException {
		Paragraph underline = new Paragraph("                    ",
				FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 12,
						Font.UNDERLINE, new Color(0, 0, 255)));
		document.add(underline);
	}

	// 插入表格
	private void addTable(Document document, BaseFont bfChinese)
			throws DocumentException {
		// 设置 Table 表格
		Table aTable = new Table(3);
		int width[] = { 25, 25, 50 };
		aTable.setWidths(width);// 设置每列所占比例
		aTable.setWidth(90); // 占页面宽度 90%
		aTable.setAlignment(Element.ALIGN_CENTER);// 居中显示
		aTable.setAlignment(Element.ALIGN_MIDDLE);// 纵向居中显示
		aTable.setAutoFillEmptyCells(true); // 自动填满
		aTable.setBorderWidth(1); // 边框宽度
		aTable.setBorderColor(new Color(0, 125, 255)); // 边框颜色
		aTable.setPadding(0);// 衬距，看效果就知道什么意思了
		aTable.setSpacing(0);// 即单元格之间的间距
		aTable.setBorder(2);// 边框
		// 设置表头
		Cell haderCell = new Cell("表格表头");
		haderCell.setHeader(true);
		haderCell.setColspan(3);
		aTable.addCell(haderCell);
		aTable.endHeaders();
		Font fontChinese = new Font(bfChinese, 12, Font.NORMAL, Color.GREEN);
		Cell cell = new Cell(new Phrase("这是一个测试的 3*3 Table 数据", fontChinese));
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		cell.setBorderColor(new Color(255, 0, 0));
		cell.setRowspan(2);
		aTable.addCell(cell);
		aTable.addCell(new Cell("#1"));
		aTable.addCell(new Cell("#2"));
		aTable.addCell(new Cell("#3"));
		aTable.addCell(new Cell("#4"));
		Cell cell3 = new Cell(new Phrase("一行三列数据", fontChinese));
		cell3.setColspan(3);
		cell3.setVerticalAlignment(Element.ALIGN_CENTER);
		aTable.addCell(cell3);
		document.add(aTable);
	}

	public static void main(String[] args) {
		WordTool b = new WordTool();
		List<String> strings = new ArrayList<String>();
		strings.add("填空题");
		strings.add("选择题");
		strings.add("解答题");
		strings.add("填空题");
		strings.add("选择题");
		strings.add("解答题");

		JFileChooser fileChooser = new JFileChooser("D:\\");

		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(fileChooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();// 这个就是你选择的文件夹的路径
			System.out.println(filePath + "-------------------->");
			try {
				String time = new Date().toLocaleString();
				int num = (int) (10000 + (Math.random() * 10000));
				b.createDocContext(filePath + "/" + num + ".doc",
						(time + "练习试卷"), strings);
			} catch (DocumentException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
