package com.tta.broilers.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.TemperatureGuideInterface;
import com.tta.broilers.entities.TemperatureGuide;
import com.tta.broilers.mappers.TemperatureGuideMapper;
import com.tta.broilers.responses.BasicResponse;


/**
 * @author rym lamouchi
 *
 */
@Repository
public class TemperatureGuideRepository implements TemperatureGuideInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<TemperatureGuide> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from temperature_guide", new TemperatureGuideMapper());

	}

	@Override
	public BasicResponse save(TemperatureGuide temperatureGuide) {
		try {
			

			jdbcTemplate.update(
					" INSERT INTO temperature_guide(  "+
         "   age_days, lower_30_weeks, upper_30_weeks, breed,week) " + 
 "   VALUES (?, ?, ?, ?,?);",temperatureGuide.getAge_days(),temperatureGuide.getLower_30_weeks(),temperatureGuide.getUpper_30_weeks(),temperatureGuide.getBreed(),temperatureGuide.getWeek()
 );
			return new BasicResponse("temperatureGuide created: " + temperatureGuide.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<TemperatureGuide> getByBreed(int breed) {
		return jdbcTemplate.query("select * from temperature_guide where breed=?", new Object[] { breed },
				new TemperatureGuideMapper());
	}
	
	@Override
	public TemperatureGuide getByWeek(int week) {
		System.out.println("search temp by weeks " + week);
		List<TemperatureGuide> result= jdbcTemplate.query("select * from temperature_guide where week=?", new Object[] { week },
				new TemperatureGuideMapper());
		if (result.isEmpty())
			return null;
		else return result.get(0);
	}

	 
}
