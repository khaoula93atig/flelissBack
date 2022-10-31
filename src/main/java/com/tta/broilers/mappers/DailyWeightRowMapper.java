package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.DailyWeight; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class DailyWeightRowMapper implements RowMapper<DailyWeight> {

	@Override
	public DailyWeight mapRow(ResultSet rs, int arg1) throws SQLException {

		DailyWeight dailyWeight = new DailyWeight();

		dailyWeight.setAge_days(rs.getInt("age_days"));
		dailyWeight.setAverage_daily_gain(rs.getDouble("average_daily_gain")); 
		dailyWeight.setBreed(rs.getInt("breed"));
		dailyWeight.setCumulative_feed_conversion(rs.getDouble("cumulative_feed_conversion"));
		dailyWeight.setDaily_gain(rs.getDouble("daily_gain"));
		dailyWeight.setWeight(rs.getDouble("weight"));
		dailyWeight.setWeek(rs.getInt("week"));;
		dailyWeight.setCreationDate(rs.getDate("creation_date"));
		
		 

		return dailyWeight;
	}

}
