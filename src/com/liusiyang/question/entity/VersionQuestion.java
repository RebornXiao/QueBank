package com.liusiyang.question.entity;

import java.io.Serializable;

public class VersionQuestion implements Serializable {
	private Integer versionId;

	private String versionName;

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -213369865560708258L;

}