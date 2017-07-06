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

import com.store.jewelry.domain.Gender;
import com.store.jewelry.repository.IGenderRepository;

@Repository
public class GenderRepository implements IGenderRepository {
	
	public NamedParameterJdbcTemplate namedParameter;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameter = new NamedParameterJdbcTemplate(dataSource);
	}
	
	private static final class GenderMapper implements RowMapper<Gender> {
		public Gender mapRow(ResultSet rs, int rowNum) throws SQLException {
			Gender gender = new Gender();
			gender.setGenderId(rs.getInt("genderId"));
			gender.setGenderLink(rs.getString("genderLink"));
			gender.setGenderName(rs.getString("genderName"));			
			return gender;
		}
	}
	
	private static final class AvailableGenderMapper implements RowMapper<Gender> {
		public Gender mapRow(ResultSet rs, int rowNum) throws SQLException {
			Gender gender = new Gender();
			gender.setGenderId(rs.getInt("genderId"));
			gender.setGenderLink(rs.getString("genderLink"));
			gender.setGenderName(rs.getString("genderName"));
			gender.setQuantityGender(rs.getInt("quantityGender"));
			return gender;
		}
	}

	public List<Gender> getGenders() {
		String sql = "SELECT genderId, genderLink, genderName FROM productgender";
		return namedParameter.query(sql, new GenderMapper());
	}

	public List<Gender> availableGenderByParameter(String productCategory) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("productCategory", productCategory);
		String sql = "SELECT pg.genderId, pg.genderLink, pg.genderName, count(pg.genderName) as quantityGender "
				+ "	  FROM productgender pg INNER JOIN product p ON p.productGender = pg.genderId"
				+ "	  WHERE p.productCategory IN (SELECT categoryId "
				+ "								  FROM productcategory pc"
				+ "								  WHERE pc.categoryLink = :productCategory) "
				+ "	  GROUP BY pg.genderName";
		return namedParameter.query(sql, paramSource, new AvailableGenderMapper());
	}

}
