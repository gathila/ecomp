package com.xyz.ecomp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.ecomp.dao.ProductDAO;
import com.xyz.ecomp.domain.product.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	@Override
	public List<Product> search(String input) {
		return productDAO.search(input);
	}

}
