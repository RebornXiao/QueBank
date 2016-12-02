package com.liusiyang.question.util;

public class QuestionUtils {

	public static String getQueType(int type) {
		String queString = "";
		if (type == 1) {
			queString = "选择题";
		} else if (type == 2) {
			queString = "填空题";
		} else if (type == 3) {
			queString = "解答题";
		}
		return queString;

	}

	public static String getQueType(String type) {

		String queString = "";
		if (type.equals("1")) {
			queString = "选择题";
		} else if (type.equals("2")) {
			queString = "填空题";
		} else if (type.equals("3")) {
			queString = "解答题";
		}
		return queString;

	}

	public static String getQueLevel(int level) {
		String queString = "";
		if (level == 1) {
			queString = "基础";
		} else if (level == 2) {
			queString = "中档";
		} else if (level == 3) {
			queString = "难题";
		}
		return queString;
	}
	
	public static String getQueLevel(String level) {
		String queString = "";
		if (level.equals("1")) {
			queString = "基础";
		} else if (level.equals("2")) {
			queString = "中档";
		} else if (level.equals("3")) {
			queString = "难题";
		}
		return queString;
	}

	public static String getQueGrade(int grade) {
		String queString = "";
		if (grade == 1) {
			queString = "五年级上";
		} else if (grade == 2) {
			queString = "五年级下";
		} else if (grade == 3) {
			queString = "六年级上";
		} else if (grade == 4) {
			queString = "六年级下";
		} else if (grade == 5) {
			queString = "七年级上";
		} else if (grade == 6) {
			queString = "七年级下";
		} else if (grade == 7) {
			queString = "八年级上";
		} else if (grade == 8) {
			queString = "八年级下";
		} else if (grade == 9) {
			queString = "九年级上";
		} else if (grade == 10) {
			queString = "九年级下";
		}
		return queString;
	}
	
	public static String getQueGrade(String grade) {
		String queString = "";
		if (grade .equals("1")) {
			queString = "五年级上";
		} else if (grade.equals("2")) {
			queString = "五年级下";
		} else if (grade.equals("3")) {
			queString = "六年级上";
		} else if (grade.equals("4")) {
			queString = "六年级下";
		} else if (grade.equals("5")) {
			queString = "七年级上";
		} else if (grade.equals("6")) {
			queString = "七年级下";
		} else if (grade.equals("7")) {
			queString = "八年级上";
		} else if (grade.equals("8")) {
			queString = "八年级下";
		} else if (grade.equals("9")) {
			queString = "九年级上";
		} else if (grade.equals("10")) {
			queString = "九年级下";
		}
		return queString;
	}

}
