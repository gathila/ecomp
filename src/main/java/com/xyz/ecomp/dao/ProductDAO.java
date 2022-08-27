package com.xyz.ecomp.dao;

import java.util.List;

import com.xyz.ecomp.domain.product.Product;

public interface ProductDAO {

	List<Product> search(String input);
}
