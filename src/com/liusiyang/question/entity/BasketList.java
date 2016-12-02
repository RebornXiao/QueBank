package com.liusiyang.question.entity;

import java.io.Serializable;

public class BasketList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5397235746871157905L;

	private Integer basketListId;
	private Integer questionNumbers = 0;
	private String fillingNo;
	private String chooseNo;
	private String explainNo;

	public BasketList() {
		super();
	}
	
	

	public Integer getQuestionNumbers() {
		return questionNumbers;
	}



	public void setQuestionNumbers(Integer questionNumbers) {
		this.questionNumbers = questionNumbers;
	}



	public Integer getBasketListId() {
		return basketListId;
	}

	public void setBasketListId(Integer basketListId) {
		this.basketListId = basketListId;
	}

	public String getFillingNo() {
		return fillingNo;
	}

	public void setFillingNo(String fillingNo) {
		this.fillingNo = fillingNo;
	}

	public String getChooseNo() {
		return chooseNo;
	}

	public void setChooseNo(String chooseNo) {
		this.chooseNo = chooseNo;
	}

	public String getExplainNo() {
		return explainNo;
	}

	public void setExplainNo(String explainNo) {
		this.explainNo = explainNo;
	}



	@Override
	public String toString() {
		return "BasketList [basketListId=" + basketListId
				+ ", questionNumbers=" + questionNumbers + ", fillingNo="
				+ fillingNo + ", chooseNo=" + chooseNo + ", explainNo="
				+ explainNo + "]";
	}

	
}
