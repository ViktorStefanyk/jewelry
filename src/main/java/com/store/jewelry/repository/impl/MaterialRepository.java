package com.store.jewelry.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.store.jewelry.domain.Material;
import com.store.jewelry.repository.IMaterialRepository;

@Repository
public class MaterialRepository implements IMaterialRepository {
	
	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static final class MaterialMapper implements RowMapper<Material> {
		public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
			Material material = new Material();
			material.setMaterialId(rs.getInt("materialId"));
			material.setMaterialName(rs.getString("materialName"));
			material.setMaterialLink(rs.getString("materialLink"));
			return material;
		}
	}
	
	private static final class AvailableMaterialMapper implements RowMapper<Material> {
		public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
			Material material = new Material();
			material.setMaterialId(rs.getInt("materialId"));
			material.setMaterialName(rs.getString("materialName"));
			material.setMaterialLink(rs.getString("materialLink"));
			material.setMaterialQuantity(rs.getInt("materialQuantity"));
			return material;
		}
	}

	@Override
	public List<Material> getMaterial() {
		
		String sql = "SELECT pm.materialId, pm.materialName, pm.materialLink"
				+ "		FROM productmaterial pm ";
		List<Material> list = namedParameter.query(sql, new MaterialMapper());
		return list;
	}

	@Override
	public List<Material> availableMaterialByParameter(String productCategory) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productCategory", productCategory);
		
		String sql = "SELECT pm.materialId, pm.materialName, pm.materialLink, count(*) as materialQuantity"
				+ "		FROM productmaterial pm INNER JOIN product p ON p.productMaterial = pm.materialId"
				+ "		WHERE p.productCategory = (SELECT pc.categoryId FROM productcategory pc WHERE pc.categoryLink = :productCategory) "
				+ "		GROUP BY pm.materialId";
		List<Material> list = namedParameter.query(sql, paramSource, new AvailableMaterialMapper());
		return list;
	}

}
