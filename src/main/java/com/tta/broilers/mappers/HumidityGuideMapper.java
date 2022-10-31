package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.HumidityGuide;


/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class HumidityGuideMapper implements RowMapper<HumidityGuide> {

	@Override
	public HumidityGuide mapRow(ResultSet rs, int arg1) throws SQLException {

		HumidityGuide humidityGuide = new HumidityGuide();

		humidityGuide.setBreed(rs.getInt("breed"));

		humidityGuide.setCreationDate(rs.getDate("creation_date"));

		humidityGuide.setAge_days(rs.getInt("age_days"));
		humidityGuide.setMax_relative_humidity(rs.getInt("max_relative_humidity"));
		humidityGuide.setMin_relative_humidity(rs.getInt("min_relative_humidity"));
		humidityGuide.setWeek(rs.getInt("week"));
		return humidityGuide;
	}

}
