package com.store.jewelry.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.store.jewelry.domain.Product;
import com.store.jewelry.repository.IProductRepository;

@Repository
public class ProductRepository implements IProductRepository {
	
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
			return product;
		}
	}

	public List<Product> getAllProducts() {
		String sql = "SELECT p.productId, "
				+ "			 p.productName, "
				+ "			 p.productDescription, "
				+ "			 pc.categoryName AS productCategory, "
				+ "			 pt.typeName AS productType, "
				+ "			 p.productPrice, "
				+ "			 pg.gemstoneName AS productGemstone, "
				+ "			 pm.materialName AS productMaterial, "
				+ "			 p.productWeight,"
				+ "			 pi.imageName AS productImageName "
				+ "	 FROM product p INNER JOIN productcategory pc ON pc.categoryId = p.productCategory"
				+ "					INNER JOIN productgemstone pg ON pg.gemstoneId = p.productGemstone"
				+ "					INNER JOIN productType pt ON pt.typeId = p.productType"
				+ "					INNER JOIN productmaterial pm ON pm.materialId = p.productMaterial"
				+ "					INNER JOIN product_images pi ON pi.productId = p.productId"
				+ "	 WHERE pi.imageRole ='main'";
		List<Product> list = namedParameter.query(sql, new ProductMapper());
		return list;
	}

}
