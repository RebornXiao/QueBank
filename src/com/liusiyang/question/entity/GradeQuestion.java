package com.liusiyang.question.entity;

import java.io.Serializable;

public class GradeQuestion implements Serializable{
	private static final long serialVersionUID = 5459966476928565498L;

	private Integer gradeId;

    private String gradeContent;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeContent() {
        return gradeContent;
    }

    public void setGradeContent(String gradeContent) {
        this.gradeContent = gradeContent;
    }
}