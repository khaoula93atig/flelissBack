package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.AirQualityGuidelines;

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class AirQualityGuidelinesRowMapper implements RowMapper<AirQualityGuidelines> {

	@Override
	public AirQualityGuidelines mapRow(ResultSet rs, int arg1) throws SQLException {

		AirQualityGuidelines airQualityGuidelines = new AirQualityGuidelines();

		airQualityGuidelines.setBreed(rs.getInt("breed"));

		airQualityGuidelines.setCreationDate(rs.getDate("creation_date"));

		airQualityGuidelines.setElement(rs.getString("element"));
		airQualityGuidelines.setMax_percentage(rs.getDouble("max_percentage"));
		airQualityGuidelines.setMin_percentage(rs.getDouble("min_percentage"));

		return airQualityGuidelines;
	}

}
