package com.liusiyang.question.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.List;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.rtf.RtfWriter2;

import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.rtf.RtfWriter2;

public class HtmlToWord {

	public static void ItexttoWord(String html) throws IOException,
			DocumentException {
		OutputStream out = new FileOutputStream("D://a.doc");
		com.lowagie.text.Document document = new com.lowagie.text.Document(
				PageSize.A4);
		RtfWriter2.getInstance(document, out);
		document.open();
		Paragraph context = new Paragraph();
//		String htmlContent = "<img src='http://localhost:8080/qb/upload/wps165B.tmp.png'/>";
		StyleSheet ss = new StyleSheet();
		List htmlList = HTMLWorker.parseToList(new StringReader(html),
				ss);
		for (int i = 0; i < htmlList.size(); i++) {
			com.lowagie.text.Element e = (com.lowagie.text.Element) htmlList
					.get(i);
			context.add(e);
		}
		document.add(context);
		document.close();
		System.out.println("ok");

	}
	
	public static void main(String[] args) throws IOException, DocumentException {
		String html = "";
		ItexttoWord(html);
		
	}
}
