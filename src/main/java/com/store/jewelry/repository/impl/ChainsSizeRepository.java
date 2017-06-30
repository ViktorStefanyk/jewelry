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

import com.store.jewelry.domain.ChainsSize;
import com.store.jewelry.repository.IChainsSizeRepository;

@Repository
public class ChainsSizeRepository implements IChainsSizeRepository {
	
	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static final class SizeMapper implements RowMapper<ChainsSize> {
		public ChainsSize mapRow(ResultSet rs, int rowNum) throws SQLException {
			ChainsSize size = new ChainsSize();
			size.setChainsSizeId(rs.getInt("chainsSizeId"));
			size.setChainsSize(rs.getFloat("chainsSize"));
			return size;
		}
	}
	
	private static final class AvailableSizeMapper implements RowMapper<ChainsSize> {
		public ChainsSize mapRow(ResultSet rs, int rowNum) throws SQLException {
			ChainsSize size = new ChainsSize();
			size.setChainsSizeId(rs.getInt("chainsSizeId"));
			size.setChainsSize(rs.getFloat("chainsSize"));
			size.setQuantityChainsSize(rs.getInt("quantityChainsSize"));
			return size;
		}
	}

	@Override
	public List<ChainsSize> getAllChainsSizes() {
		String sql = "SELECT chainsSizeId, chainsSize FROM chainssize GROUP BY chainsSize ASC";
		List<ChainsSize> list = namedParameter.query(sql, new SizeMapper());
		return list;
	}

	@Override
	public void addChainsSizes(Integer productId, Integer chainsSizeId) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productId", productId);
		paramSource.addValue("chainsSizeId", chainsSizeId);	
		String sql = "INSERT INTO product_chainssize(productId, chainsSizeId) VALUE (:productId, :chainsSizeId)";
		namedParameter.update(sql, paramSource);
		
	}

	@Override
	public List<ChainsSize> availableChainsSizeByParameters(String productCategory) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource(); 
		paramSource.addValue("productCategory", productCategory);
		
		String baseQuery = "SELECT pcs.chainsSizeId, cs.chainsSize, count(cs.chainsSizeId) as quantityChainsSize "
				+ "			FROM product_chainssize pcs INNER JOIN product p ON p.productId = pcs.productId"
				+ "										INNER JOIN chainssize cs ON cs.chainsSizeId = pcs.chainsSizeId"
				+ "			WHERE p.productCategory IN (SELECT pc.categoryId"
				+ "										FROM productcategory pc"
				+ "										WHERE pc.categoryLink = :productCategory) "
				+ "			GROUP BY cs.chainsSize";
		
		return namedParameter.query(baseQuery, paramSource, new AvailableSizeMapper());
	}

}
