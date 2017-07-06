package com.store.jewelry.repository.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.store.jewelry.repository.IImageRepository;

@Repository
public class ImageRepository implements IImageRepository {
	
	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}

	public void addMainImage(Integer productId, String imageName, String imageRole) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productId", productId);
		paramSource.addValue("imageName", imageName);
		paramSource.addValue("imageRole", imageRole);
		
		String sql = "INSERT INTO product_images(productId, imageName, imageRole) Value(:productId, :imageName, :imageRole)";
		
		namedParameter.update(sql, paramSource);
	}

}
