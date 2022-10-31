package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.WeeklyWeightForChart;


public class WeeklyWeightForChartRowMapper  implements RowMapper<WeeklyWeightForChart>{

	@Override
	public WeeklyWeightForChart mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeeklyWeightForChart weeklyWeightForChart = new WeeklyWeightForChart();
		
		weeklyWeightForChart.setAverge(rs.getFloat("average"));
		weeklyWeightForChart.setWeek(rs.getInt("week"));
		
		
		return weeklyWeightForChart;
	}

}
