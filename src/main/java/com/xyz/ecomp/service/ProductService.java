package com.xyz.ecomp.service;

import java.util.List;

import com.xyz.ecomp.domain.product.Product;

public interface ProductService {

	public List<Product> search(String input);
}
