package com.xyz.ecomp.domain.product;

import java.util.Set;

import com.xyz.ecomp.domain.Audit;


public class Product extends Audit {

	private long id;
	
	private String productName;
	
	private Set<ProductCategory> productCategories;
	
	private Set<ProductSubCategory> productSubCategories;
	
	private Set<ProductTag> tags;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Set<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(Set<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

	public Set<ProductSubCategory> getProductSubCategories() {
		return productSubCategories;
	}

	public void setProductSubCategories(Set<ProductSubCategory> productSubCategories) {
		this.productSubCategories = productSubCategories;
	}

	public Set<ProductTag> getTags() {
		return tags;
	}

	public void setTags(Set<ProductTag> tags) {
		this.tags = tags;
	}
	
	
	
	
}
