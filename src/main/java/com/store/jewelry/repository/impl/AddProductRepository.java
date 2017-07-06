package com.store.jewelry.repository.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.store.jewelry.domain.Product;
import com.store.jewelry.repository.IAddProductRepository;

@Repository
public class AddProductRepository implements IAddProductRepository {
	
	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private SqlParameterSource getSqlParameterByModel(Product product) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		if (product != null) {
			paramSource.addValue("productId", product.getProductId());
			paramSource.addValue("productDescription", product.getProductDescription());
			paramSource.addValue("productName", product.getProductName());
			paramSource.addValue("productCategory", product.getProductCategory());
			paramSource.addValue("productType", product.getProductType());
			paramSource.addValue("productGemstone", product.getProductGemstone());
			paramSource.addValue("productMaterial", product.getProductMaterial());
			paramSource.addValue("productPrice", product.getProductPrice());
			paramSource.addValue("productWeight", product.getProductWeight());
			paramSource.addValue("productGender", product.getProductGender());
		}
		return paramSource;
	}

	public void addProduct(Product product) {
		String sql = "INSERT INTO product(productDescription, "
				+ "						  productName,"
				+ "						  productCategory, "
				+ "					      productType,"
				+ "						  productGemstone, "
				+ "						  productMaterial,"
				+ "						  productPrice, "
				+ "						  productWeight,"
				+ "						  productGender) "
				+ "			 VALUES (   :productDescription, "
				+ "						:productName, "
				+ "						:productCategory, "
				+ "						:productType, "
				+ "						:productGemstone, "
				+ "						:productMaterial, "
				+ "						:productPrice, "
				+ "						:productWeight,"
				+ "					    :productGender)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.namedParameter.update(sql, getSqlParameterByModel(product), keyHolder);
		Integer productId = keyHolder.getKey().intValue();
		product.setProductId(productId);
	}

}
