package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.TemperatureGuide;


/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class TemperatureGuideMapper implements RowMapper<TemperatureGuide> {

	@Override
	public TemperatureGuide mapRow(ResultSet rs, int arg1) throws SQLException {

		TemperatureGuide temperatureGuide = new TemperatureGuide();
		temperatureGuide.setAge_days(rs.getInt("age_days"));
		temperatureGuide.setLower_30_weeks(rs.getDouble("lower_30_weeks"));
		temperatureGuide.setUpper_30_weeks(rs.getDouble("upper_30_weeks"));
		temperatureGuide.setBreed(rs.getInt("breed"));
		temperatureGuide.setWeek(rs.getInt("week"));
		return temperatureGuide;
	}

}
