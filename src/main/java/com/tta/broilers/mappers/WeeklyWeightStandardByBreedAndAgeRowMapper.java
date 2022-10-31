package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.WeeklyweightStandardByBreedAndAge;

public class WeeklyWeightStandardByBreedAndAgeRowMapper implements RowMapper<WeeklyweightStandardByBreedAndAge> {

	@Override
	public WeeklyweightStandardByBreedAndAge mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeeklyweightStandardByBreedAndAge weeklyStandard = new WeeklyweightStandardByBreedAndAge();
		
		weeklyStandard.setAge(rs.getInt("age_days"));
		weeklyStandard.setWeight(rs.getFloat("weight"));
		return weeklyStandard;
	}

}
