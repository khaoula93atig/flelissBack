package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.WeeklyWeightMeasurementInterface;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.WeeklyWeightForChart;
import com.tta.broilers.entities.rest.WeeklyweightStandardByBreedAndAge;
import com.tta.broilers.entities.rest.WeeklyweightbyNbreOfoiseaux;
import com.tta.broilers.mappers.WeeklyWeightByFlockAndAgeRowMapper;
import com.tta.broilers.mappers.WeeklyWeightForChartRowMapper;
import com.tta.broilers.mappers.WeeklyWeightStandardByBreedAndAgeRowMapper;
import com.tta.broilers.mappers.WeeklyWeightbynbreOfOiseauxMapper;
import com.tta.broilers.mappers.WeeklyweightMesurementRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@Repository
public class WeeklyWeightMeasurementRepository implements WeeklyWeightMeasurementInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<WeeklyWeightMeasurement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicResponse save(WeeklyWeightMeasurement weeklyWeightMeasurement) {
		try {
			System.out.println("save weeklyWeightMeasurement "+weeklyWeightMeasurement);
			weeklyWeightMeasurement.setCreationDate(new Date());
			
		jdbcTemplate.update(

					"INSERT INTO weekly_weight_measurement(\r\n"
					+ "            week, farm_id, center_id, house_id, flock_id, weight, flock_nbr, \r\n"
					+ "            average, creation_date, breed, cv, uniformty)\r\n"
					+ "    VALUES (?, ?, ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, ?);\r\n"
					,weeklyWeightMeasurement.getWeek(),weeklyWeightMeasurement.getFarmId(),weeklyWeightMeasurement.getCenterId(),
					weeklyWeightMeasurement.getHouseId(),weeklyWeightMeasurement.getFlockId(),weeklyWeightMeasurement.getWeight(),
					weeklyWeightMeasurement.getFlockNbr(),weeklyWeightMeasurement.getAverage(),weeklyWeightMeasurement.getCreationDate(),
					weeklyWeightMeasurement.getBreed(),weeklyWeightMeasurement.getCv(),weeklyWeightMeasurement.getUniformity()
					);
		String deviation ;
		double standard=jdbcTemplate.queryForObject(
				"SELECT weight FROM weekly_weight_standard where breed=? and age_days=?",
				new Object[] { weeklyWeightMeasurement.getBreed() ,weeklyWeightMeasurement.getWeek()}, Double.class);
		System.out.println("standard         "+standard);
		if (weeklyWeightMeasurement.getAverage() < standard) {
			deviation = "Low";
		} else if (weeklyWeightMeasurement.getAverage() > standard) {
			deviation = "High";
		} else {
			deviation = "Normal";
		}
		
			return new BasicResponse(deviation, HttpStatus.OK);
			} catch (org.springframework.dao.DuplicateKeyException ex) {
				ex.printStackTrace();
				return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

			} catch (Exception ex) {
				ex.printStackTrace();
				return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

			}
	}

	@Override
	public String checkStandard(int breed,int week, double measure) {
		String deviation ;
		double standard=jdbcTemplate.queryForObject(
				"SELECT weight FROM weekly_weight_standard where breed=? and age_days=?",
				new Object[] { breed ,week}, Double.class);
		
		if (measure < standard) {
			deviation = "Low";
		} else if (measure > standard) {
			deviation = "High";
		} else {
			deviation = "Normal";
		}
		// TODO Auto-generated method stub
		return deviation;
	}

	@Override
	public List<WeeklyWeightForChart> getWeekWeightForChart(String farm, String flock, int breed) {
		return jdbcTemplate.query("SELECT week, average\r\n"
				+ "	FROM public.weekly_weight_measurement where farm_id=? and flock_id=? and breed=?"
				+ " GROUP by average , week ORDER by week ASC ;", new Object[] {farm, flock, breed} , new WeeklyWeightForChartRowMapper());
		 
	}

	@Override
	public List<WeeklyweightStandardByBreedAndAge> getWeeklyWeightStandardByAgeAndBreed(int breed) {
		return jdbcTemplate.query("SELECT age_days, weight\r\n"
				+ "	FROM public.weekly_weight_standard where breed=? order By age_days ASC;", new Object[] { breed} , new WeeklyWeightStandardByBreedAndAgeRowMapper());
	}

	@Override
	public List<WeeklyweightbyNbreOfoiseaux> getWeekWeighbyNbre(String farm, String flock, int breed, int week) {
		return jdbcTemplate.query("SELECT weight , COUNT(weight)\r\n"
				+ "FROM public.weekly_weight_measurement \r\n"
				+ "where farm_id=? and flock_id=? and breed=? and week=?\r\n"
				+ "group by weight ORDER by weight ASC;", new Object[] {farm, flock, breed,week} , new WeeklyWeightbynbreOfOiseauxMapper());
	}

	@Override
	public long getStandardWeightByBreedAndAge(int breed, int age) {
		return jdbcTemplate.queryForObject(
				"SELECT  weight\r\n"
				+ "	FROM public.weekly_weight_standard\r\n"
				+ "	WHERE breed=? and age_days=? ;",
				new Object[] { breed ,age},Long.class);
		
	}

	@Override
	public List<WeeklyWeightMeasurement> getweeklyweightOfFlocks(String flockId) {
		return jdbcTemplate.query("SELECT count(*) as count,average, week , flock_id, farm_id , house_id, center_id, cv , uniformty\r\n"
				+ "	FROM public.weekly_weight_measurement\r\n"
				+ "	WHERE flock_id=?\r\n"
				+ "	GROUP by average , week , flock_id , farm_id, house_id, center_id, cv , uniformty \r\n"
				+ "	ORDER by week ASC;", new Object[] {flockId} , new WeeklyweightMesurementRowMapper());
	}

	@Override
	public List<WeeklyWeightMeasurement> getWeeklyWeightByFlockAndAge(int age, String flockId) {
		return jdbcTemplate.query(
				"SELECT DISTINCT week, farm_id, center_id, house_id, flock_id, average, creation_date, breed, cv, uniformty\r\n"
				+ "	FROM public.weekly_weight_measurement \r\n"
				+ "	where weekly_weight_measurement.week=?\r\n"
				+ "	and weekly_weight_measurement.flock_id=?\r\n",
				new Object[] { age ,flockId}, new WeeklyWeightByFlockAndAgeRowMapper());
	}

	
	
}
