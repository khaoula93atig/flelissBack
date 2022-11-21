package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.WeeklyweightbyNbreOfoiseaux;

public class WeeklyWeightbynbreOfOiseauxMapper implements RowMapper<WeeklyweightbyNbreOfoiseaux> {

	@Override
	public WeeklyweightbyNbreOfoiseaux mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeeklyweightbyNbreOfoiseaux weeklyWeight =new WeeklyweightbyNbreOfoiseaux();
		weeklyWeight.setCount(rs.getInt("count"));
		weeklyWeight.setWeight(rs.getInt("weight"));
		return weeklyWeight;
	}

}
