package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.HumidityGuideInterface;

import com.tta.broilers.entities.HumidityGuide;

import com.tta.broilers.mappers.HumidityGuideMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class HumidityGuideRepository implements HumidityGuideInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<HumidityGuide> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from humidity_guide", new HumidityGuideMapper());

	}

	@Override
	public BasicResponse save(HumidityGuide humidityGuide) {
		try {
			humidityGuide.setCreationDate(new Date());

			jdbcTemplate.update(
					" INSERT INTO humidity_guide(  "
							+ "   age_days, min_relative_humidity, max_relative_humidity, breed,week) "
							+ "   VALUES (?, ?, ?, ?,?);",
					humidityGuide.getAge_days(), humidityGuide.getMin_relative_humidity(),
					humidityGuide.getMax_relative_humidity(), humidityGuide.getBreed(), humidityGuide.getWeek());
			return new BasicResponse("HumidityGuide created: " + humidityGuide.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<HumidityGuide> getByBreed(int breed) {
		return jdbcTemplate.query("select * from humidity_guide where breed=?", new Object[] { breed },
				new HumidityGuideMapper());
	}

	@Override
	public HumidityGuide getByWeek(int week) {
		List<HumidityGuide> result = jdbcTemplate.query("select * from humidity_guide where week=?",
				new Object[] { week }, new HumidityGuideMapper());
		if (result.isEmpty())
			return null;
		else
			return result.get(0);
	}

}
