package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import com.tta.broilers.entities.rest.FeedWeightweekly;
import com.tta.broilers.mappers.FeedWeightWeeklyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.WeeklyFeedInterface;
import com.tta.broilers.dao.WeeklyWeightMeasurementInterface;
import com.tta.broilers.entities.WeeklyFeed;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.mappers.WeeklyWeightByFlockAndAgeRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@Repository
public class WeeklyFeedRepository implements WeeklyFeedInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<WeeklyFeed> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse save(WeeklyFeed WeeklyFeed) {
		try {
			System.out.println("save WeeklyFeed "+WeeklyFeed.toString());
			WeeklyFeed.setCreationDate(new Date());
			
		jdbcTemplate.update(

					"INSERT INTO weekly_feed(\r\n"
					+ "            breed, farm_id, center_id, house_id, flock_id, week, total_starter_feed, \r\n"
					+ "            starter_feed_per_bird, total_grower_feed, grower_feed_per_bird, \r\n"
					+ "            total_finisher_feed, finisher_feed_bird, creation_date)\r\n"
					+ "    VALUES (?, ?, ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, \r\n"
					+ "            ?, ?, ?);\r\n"
					+ ""
					,WeeklyFeed.getBreed(),WeeklyFeed.getFarmId(),WeeklyFeed.getCenterId(),WeeklyFeed.getHouseId(),
					WeeklyFeed.getFlockId(),WeeklyFeed.getWeek(),WeeklyFeed.getTotalStarterFeed(),WeeklyFeed.getStarterFeedPerBird(),
					WeeklyFeed.getTotalGrowerFeed(),WeeklyFeed.getGrowerFeedPerBird(),WeeklyFeed.getTotalFinisherFeed(),
					WeeklyFeed.getFinisherFeedBird(),WeeklyFeed.getCreationDate()
					);
		
		
			return new BasicResponse("", HttpStatus.OK);
			} catch (org.springframework.dao.DuplicateKeyException ex) {
				ex.printStackTrace();
				return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

			} catch (Exception ex) {
				ex.printStackTrace();
				return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

			}
	}

	@Override
	public List<Long> getbyAgeAndFlock(int age, String flockId) {
		return jdbcTemplate.queryForList(
				"SELECT (total_starter_feed+total_grower_feed+total_finisher_feed) as feed\r\n"
				+ "	FROM public.weekly_feed WHERE week=? and flock_id=? ;",
				new Object[] { age ,flockId}, Long.class);
	}

	@Override
	public List<FeedWeightweekly> getFeedWeightWeeklyByAgeAndFlock(int week, String flockId) {
		String req = "select average , weekly_feed.total_finisher_feed , weekly_feed.total_grower_feed , weekly_feed.total_starter_feed\n" +
				"from weekly_weight_measurement \n" +
				"join weekly_feed on weekly_feed.week = weekly_weight_measurement.week \n" +
				"and weekly_feed.flock_id = weekly_weight_measurement.flock_id\n" +
				"where weekly_feed.flock_id = ? and weekly_feed.week =? \n" +
				"group by average,weekly_feed.total_finisher_feed , weekly_feed.total_grower_feed , weekly_feed.total_starter_feed";
		return jdbcTemplate.query(req ,new Object[] { flockId, week}, new FeedWeightWeeklyRowMapper());
	}


}
