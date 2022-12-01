package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.WeeklyWeightMeasurement;

public class WeeklyweightMesurementRowMapper implements RowMapper<WeeklyWeightMeasurement> {

	@Override
	public WeeklyWeightMeasurement mapRow(ResultSet rs, int rowNum) throws SQLException {

		WeeklyWeightMeasurement weeklyWeightMesure = new WeeklyWeightMeasurement();
		weeklyWeightMesure.setCount(rs.getDouble("count"));
		weeklyWeightMesure.setAverage(rs.getDouble("average"));
		weeklyWeightMesure.setWeek(rs.getInt("week"));
		weeklyWeightMesure.setFlockId(rs.getString("flock_id"));
		weeklyWeightMesure.setCv(rs.getDouble("cv"));
		weeklyWeightMesure.setUniformity(rs.getDouble("uniformty"));
		weeklyWeightMesure.setFarmId(rs.getString("farm_id"));

		return weeklyWeightMesure;
	}

}
