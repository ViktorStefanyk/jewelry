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

import com.store.jewelry.domain.PendantSize;
import com.store.jewelry.repository.IPendantSizeRepository;

@Repository
public class PendantSizeRepository implements IPendantSizeRepository {
	
	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static final class PendantMapper implements RowMapper<PendantSize> {
		public PendantSize mapRow(ResultSet rs, int rowNum) throws SQLException {
			PendantSize size = new PendantSize();
			size.setPendantSizeId(rs.getInt("pendantSizeId"));
			size.setPendantSize(rs.getFloat("pendantSize"));
			return size;
		}
	}
	
	private static final class AvailablePendantMapper implements RowMapper<PendantSize> {
		public PendantSize mapRow(ResultSet rs, int rowNum) throws SQLException {
			PendantSize size = new PendantSize();
			size.setPendantSizeId(rs.getInt("pendantSizeId"));
			size.setPendantSize(rs.getFloat("pendantSize"));
			size.setQuantityPendantSize(rs.getInt("quantityPendantSize"));
			return size;
		}
	}
	
	@Override
	public void addPendantSizes(Integer productId, Integer pendantSizeId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productId", productId);
		paramSource.addValue("pendantSizeId", pendantSizeId);
		String sql = "INSERT INTO product_pendantsize(productId, pendantSizeId) VALUE(:productId, :pendantSizeId)";
		namedParameter.update(sql, paramSource);
	}

	@Override
	public List<PendantSize> getAllPendantSizes() {
		String sql = "SELECT pendantSizeId, pendantSize "
				+ "		FROM pendantsize "
				+ "		GROUP BY pendantSize ASC";
		return namedParameter.query(sql, new PendantMapper());
	}

	@Override
	public List<PendantSize> availablePendantByParameter(String productCategory) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productCategory", productCategory);
		String sql = "SELECT pps.pendantSizeId, ps.pendantSize, count(pps.pendantSizeId) as quantityPendantSize "
				+ "		FROM product_pendantsize pps INNER JOIN product p ON p.productId = pps.productId "
				+ "									 INNER JOIN pendantsize ps ON ps.pendantSizeID = pps.pendantSizeId "
				+ "		WHERE p.productCategory IN (SELECT pc.categoryId"
				+ "									FROM productcategory pc"
				+ "									WHERE pc.categoryLink = :productCategory) "
				+ "		GROUP BY ps.pendantSize";
		return namedParameter.query(sql, paramSource, new AvailablePendantMapper());
	}

}
