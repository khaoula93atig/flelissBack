package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Country; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         22 sep 2020
 */
public class CountryRowMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int arg1) throws SQLException {

		Country company = new Country();

		company.setId(rs.getInt("id"));
		company.setName(rs.getString("name"));
		 

		return company;
	}

}
