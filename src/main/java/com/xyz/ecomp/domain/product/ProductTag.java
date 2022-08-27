package com.xyz.ecomp.domain.product;

import com.xyz.ecomp.domain.Audit;

public class ProductTag extends Audit {

	private long id;
	
	private String tagName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
}
