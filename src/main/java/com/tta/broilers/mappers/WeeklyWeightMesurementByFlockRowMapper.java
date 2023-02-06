package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.WeeklyWeightMesurementByFlock;



public class WeeklyWeightMesurementByFlockRowMapper implements RowMapper<WeeklyWeightMesurementByFlock>{

	@Override
	public WeeklyWeightMesurementByFlock mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeeklyWeightMesurementByFlock weight = new WeeklyWeightMesurementByFlock();
		weight.setWeek(rs.getInt("week"));
		weight.setAverage(rs.getDouble("average"));
		weight.setFlockId(rs.getString("flock_id"));
		return weight;
	}
	

}
