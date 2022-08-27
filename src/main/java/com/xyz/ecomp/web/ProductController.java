package com.xyz.ecomp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.ecomp.domain.product.Product;
import com.xyz.ecomp.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;
	
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}



	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	@GetMapping("/search")
	public List<Product> search(@RequestParam("input") String input) {
		return productService.search(input);
	}
}
