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

import com.store.jewelry.domain.RingSize;
import com.store.jewelry.repository.IRingSizeRepository;

@Repository
public class RingSizeRepository implements IRingSizeRepository {

	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static final class SizeMapper implements RowMapper<RingSize> {
		public RingSize mapRow(ResultSet rs, int rowNum) throws SQLException {
			RingSize size = new RingSize();
			size.setRingSizeId(rs.getInt("ringSizeId"));
			size.setRingSize(rs.getFloat("ringSize"));
			return size;
		}
	}
	
	private static final class AvailableSizeMapper implements RowMapper<RingSize> {
		public RingSize mapRow(ResultSet rs, int rowNum) throws SQLException {
			RingSize size = new RingSize();
			size.setRingSizeId(rs.getInt("ringSizeId"));
			size.setRingSize(rs.getFloat("ringSize"));
			size.setQuantityRingSize(rs.getInt("quantityRingSize"));
			return size;
		}
	}
	 
	public List<RingSize> getAllRingSizes() {
		String sql = "SELECT ringSizeId, ringSize FROM ringsize GROUP BY ringSize ASC";
		List<RingSize> list = namedParameter.query(sql, new SizeMapper());
		return list;
	}

	public void addRingSizes(Integer productId, Integer ringSizeId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productId", productId);
		paramSource.addValue("ringSizeId", ringSizeId);
		
		String sql = "INSERT INTO product_ringsize(productId, ringSizeId) VALUE (:productId, :ringSizeId)";
		namedParameter.update(sql, paramSource);
	}

	public List<RingSize> availableRingSizeByParameters(String productCategory) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource(); 
		paramSource.addValue("productCategory", productCategory);
		
		String baseQuery = "SELECT prs.ringSizeId, rs.ringSize, count(prs.ringSizeId) as quantityRingSize "
				+ "			FROM product_ringsize prs INNER JOIN product p ON p.productId = prs.productId "
				+ "									  INNER JOIN ringsize rs ON rs.ringSizeId = prs.ringSizeId "
				+ " 		WHERE p.productCategory IN (SELECT pc.categoryId "
				+ "										FROM productcategory pc "
				+ "										WHERE pc.categoryLink = :productCategory) "
				+ " 		GROUP BY rs.ringSize";
		
		return namedParameter.query(baseQuery, paramSource, new AvailableSizeMapper());
	}

}
