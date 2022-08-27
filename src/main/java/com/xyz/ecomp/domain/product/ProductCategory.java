package com.xyz.ecomp.domain.product;

import com.xyz.ecomp.domain.Audit;

public class ProductCategory extends Audit {

	private Long id;
	
	private String categoryName;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
