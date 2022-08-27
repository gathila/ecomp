package com.xyz.ecomp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.ecomp.domain.product.Product;
import com.xyz.ecomp.domain.product.ProductCategory;
import com.xyz.ecomp.domain.product.ProductSubCategory;
import com.xyz.ecomp.domain.product.ProductTag;

@Repository
public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public List<Product> search(String input) {
		
		String sql = "select p.PRODUCT_ID, p.PRODUCT_NM, c.CATEGORY_ID, c.CATEGORY_NM, s.SUB_CATEGORY_ID, s.SUB_CATEGORY_NM, t.TAG_ID, t.TAG_NM \n"
				+ " from ECOMP_PRODUCT p left join ECOMP_PRODUCT_CATEGORY pc \n"
				+ " on p.PRODUCT_ID = pc.PRODUCT_ID left join ECOMP_PROD_CATEGORY c \n"
				+ " on pc.CATEGORY_ID = c.CATEGORY_ID left join ECOMP_PRODUCT_SUB_CATEGORY sc \n"
				+ " on (p.PRODUCT_ID=sc.PRODUCT_ID) left join ECOMP_PROD_SUB_CATEGORY s \n"
				+ " on (sc.SUB_CATEGORY_ID=s.SUB_CATEGORY_ID) left join ECOMP_PRODUCT_TAG pt \n"
				+ " on (pt.PRODUCT_ID=p.PRODUCT_ID) left join ECOMP_TAG t \n"
				+ " on (pt.TAG_ID=t.TAG_ID) \n"
				+ " where UPPER(p.PRODUCT_NM) like :input or \n"
				+ " UPPER(c.CATEGORY_NM) like :input or \n"
				+ " UPPER(s.SUB_CATEGORY_NM) like :input or \n"
				+ " UPPER(t.TAG_NM) like :input ";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("input", "%"+input.toUpperCase()+"%");
		
		Map<String, Product> prodMap = new HashMap<>();
		
		namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> {
			Product p = prodMap.computeIfAbsent(rs.getString("PRODUCT_ID"), (pid) -> createProduct(rs));
			return productMapper(rs, rowNum, p);
		});
		return new ArrayList(prodMap.values());
	}

	private Product createProduct(ResultSet rs) throws RuntimeException {

		try {
			Product p = new Product();
			p.setId(rs.getLong("PRODUCT_ID"));
			p.setProductName(rs.getString("PRODUCT_NM"));
			p.setProductCategories(new HashSet<>());
			p.setProductSubCategories(new HashSet<>());
			p.setTags(new HashSet<>());
			return p;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	Product productMapper(ResultSet rs, int rowNum, Product p) throws SQLException {
		
		
		ProductCategory pc = new ProductCategory();
		pc.setId(rs.getLong("CATEGORY_ID"));
		pc.setCategoryName(rs.getString("CATEGORY_NM"));
		p.getProductCategories().add(pc);
		
		
		ProductSubCategory psc = new ProductSubCategory();
		psc.setId(rs.getLong("SUB_CATEGORY_ID"));
		psc.setSubCategoryName(rs.getString("SUB_CATEGORY_NM"));
		p.getProductSubCategories().add(psc);
		
		ProductTag tag = new ProductTag();
		tag.setId(rs.getLong("TAG_ID"));
		tag.setTagName(rs.getString("TAG_NM"));
		p.getTags().add(tag);
		
		return p;
	}
}
