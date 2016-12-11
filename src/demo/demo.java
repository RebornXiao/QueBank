package demo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
	}

	private static String getText(Integer id) {
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

	private static String getNum(Integer id) {
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