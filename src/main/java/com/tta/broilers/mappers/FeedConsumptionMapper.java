package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.FeedConsumption; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class FeedConsumptionMapper implements RowMapper<FeedConsumption> {

	@Override
	public FeedConsumption mapRow(ResultSet rs, int arg1) throws SQLException {


		FeedConsumption feedConsumption = new FeedConsumption();

		feedConsumption.setAge_days(rs.getInt("age_days"));
		feedConsumption.setDaily_feed_consumption(rs.getDouble("daily_feed_consumption"));
		feedConsumption.setCumultive_feed_consumption(rs.getDouble("cumultive_feed_consumption"));
		feedConsumption.setCumulative_feed_conversion_fcr(rs.getDouble("cumulative_feed_conversion_fcr"));
		feedConsumption.setCreationDate(rs.getDate("creation_date"));
		 

		return feedConsumption;
	}

}
