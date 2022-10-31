package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Breed;
import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.House;
import com.tta.broilers.entities.WeeklyFeed;
import com.tta.broilers.entities.rest.FlockTechnicalReport; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class WeeklyFeedRowMapper implements RowMapper<WeeklyFeed> {

	@Override
	public WeeklyFeed mapRow(ResultSet rs, int arg1) throws SQLException {

		WeeklyFeed weeklyFeed = new WeeklyFeed();
		weeklyFeed.setTotalFinisherFeed(rs.getDouble("sum_total_finisher_feed"));;
		weeklyFeed.setTotalStarterFeed(rs.getDouble("sum_total_starter_feed"));
		weeklyFeed.setTotalGrowerFeed(rs.getDouble("sum_total_grower_feed"));
		weeklyFeed.setStarterFeedPerBird(rs.getDouble("sum_starter_feed_per_bird"));
		weeklyFeed.setFinisherFeedBird(rs.getDouble("sum_finisher_feed_bird"));
		weeklyFeed.setGrowerFeedPerBird(rs.getDouble("sum_grower_feed_per_bird"));
		
		return weeklyFeed;
	}

}
