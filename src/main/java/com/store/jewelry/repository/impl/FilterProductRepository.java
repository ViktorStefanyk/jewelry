package com.store.jewelry.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.store.jewelry.domain.Product;
import com.store.jewelry.repository.IFilterProductRepository;

@Repository
public class FilterProductRepository implements IFilterProductRepository {
	
	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static final class ProductMapper implements RowMapper<Product> {
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException{
			Product product = new Product();
			product.setProductId(rs.getInt("productId"));
			product.setProductName(rs.getString("productName"));
			product.setProductDescription(rs.getString("productDescription"));
			product.setProductCategory(rs.getString("productCategory"));
			product.setProductType(rs.getString("productType"));
			product.setProductPrice(rs.getInt("productPrice"));
			product.setProductGemstone(rs.getString("productGemstone"));
			product.setProductMaterial(rs.getString("productMaterial"));
			product.setProductWeight(rs.getFloat("productWeight"));
			product.setProductImageName(rs.getString("productImageName"));
			product.setProductGender(rs.getString("productGender"));
			return product;
		}
	}
	

	public List<Product> getProductsByParameter(String productCategory, List<Integer> productGemstones, 
												List<Integer> productType, List<Integer> productMaterial,
												Integer productMinPrice, Integer productMaxPrice,
												List<Integer> sizeRing, List<Integer> sizeChains,
												List<Integer> sizePendant, Integer productGender) {
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource(); 
		paramSource.addValue("productCategory", productCategory);
		paramSource.addValue("productGemstone", productGemstones);
		paramSource.addValue("productType", productType);
		paramSource.addValue("productMaterial", productMaterial);
		paramSource.addValue("productMinPrice", productMinPrice);
		paramSource.addValue("productMaxPrice", productMaxPrice);
		paramSource.addValue("sizeRing", sizeRing);
		paramSource.addValue("sizeChains", sizeChains);
		paramSource.addValue("sizePendant", sizePendant);
		paramSource.addValue("productGender", productGender);
		
		String baseQuery = "SELECT p.productId, "
				+ "			 p.productName, "
				+ "			 p.productDescription, "
				+ "			 pc.categoryName AS productCategory, "
				+ "			 pt.typeName AS productType, "
				+ "			 p.productPrice, "
				+ "			 pg.gemstoneName AS productGemstone, "
				+ "			 pm.materialName AS productMaterial, "
				+ "			 p.productWeight,"
				+ "			 pi.imageName AS productImageName,"
				+ "			 pgg.genderName AS productGender "
				+ "	 FROM product p INNER JOIN productcategory pc ON pc.categoryId = p.productCategory"
				+ "					INNER JOIN productgemstone pg ON pg.gemstoneId = p.productGemstone"
				+ "					INNER JOIN productType pt ON pt.typeId = p.productType"
				+ "					INNER JOIN productmaterial pm ON pm.materialId = p.productMaterial"
				+ "					INNER JOIN product_images pi ON pi.productId = p.productId"
				+ "					INNER JOIN productgender pgg ON pgg.genderId = p.productGender";
		List<String> conditions = new ArrayList<String>();
		
		if (productCategory != null) {
			conditions.add(" pc.categoryLink = :productCategory AND pi.imageRole ='main' ");
		}
		
		if (productGemstones != null) {
			conditions.add(" pg.gemstoneId IN (:productGemstone) ");				
		}
		
		if (productType != null) {
			conditions.add(" pt.typeId IN (:productType) ");
		}
		
		if (productMaterial != null) {
			conditions.add(" pm.materialId IN (:productMaterial) ");
		}
		
		if (productMinPrice != null && productMaxPrice == null) {
			conditions.add(" p.productPrice > :productMinPrice ");
		}
		
		if (productMinPrice == null && productMaxPrice != null) {
			conditions.add(" p.productPrice < :productMaxPrice ");
		}
		
		if (productMinPrice != null && productMaxPrice != null) {
			conditions.add(" p.productPrice between :productMinPrice AND :productMaxPrice ");
		}
		
		if (productGender != null ) {
			conditions.add(" pgg.genderId IN (:productGender) ");
		}
		
		if (sizeRing != null) {
			conditions.add(" p.productId IN (SELECT prs.productId FROM product_ringsize prs WHERE prs.ringSizeId IN (:sizeRing) ) ");			
		}
		
		if (sizeChains != null) {
			conditions.add(" p.productId IN (SELECT pcs.productId FROM product_chainssize pcs WHERE pcs.chainsSizeId IN (:sizeChains) ) ");
		}
		
		if (sizePendant != null) {
			conditions.add(" p.productId IN (SELECT pps.productId FROM product_pendantsize pps WHERE pps.pendantSizeId IN (:sizePendant) ) ");
		}
		
		if (!conditions.isEmpty()) {
			baseQuery+= " WHERE ";
			String sql_and = " AND ";
			baseQuery+= String.join(sql_and, conditions);
		}
		
		return namedParameter.query(baseQuery, paramSource, new ProductMapper());
	}

}
