package com.xyz.ecomp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.ecomp.domain.product.Product;

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
				+ " where p.PRODUCT_NM like '%abc%' or \n"
				+ " c.CATEGORY_NM like '%abc%' or \n"
				+ " s.SUB_CATEGORY_NM like '%abc%' or \n"
				+ " t.TAG_NM like '%abc%' \n";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> productMapper(rs, rowNum));
		return null;
	}

	
	Product productMapper(ResultSet rs, int rowNum) throws SQLException {
		
		Product p = new Product();
		p.setId(rs.getLong("PRODUCT_ID"));
		
		return p;
	}
}
