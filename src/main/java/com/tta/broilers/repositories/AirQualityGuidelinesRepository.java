package com.tta.broilers.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.AirQualityGuidelinesInterface;
import com.tta.broilers.entities.AirQualityGuidelines;
import com.tta.broilers.mappers.AirQualityGuidelinesRowMapper;
import com.tta.broilers.responses.BasicResponse;


/**
 * @author rym lamouchi
 *
 */
@Repository
public class AirQualityGuidelinesRepository implements AirQualityGuidelinesInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AirQualityGuidelines> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from air_quality_guidelines", new AirQualityGuidelinesRowMapper());

	}

	@Override
	public BasicResponse save(AirQualityGuidelines airQualityGuidelines) {
		try {
			airQualityGuidelines.setCreationDate(new Date());

			jdbcTemplate.update(
					" INSERT INTO air_quality_guidelines(  "+
         "   element, max_percentage, min_percentage, breed) " + 
 "   VALUES (?, ?, ?, ?);",
					airQualityGuidelines.getElement(), airQualityGuidelines.getMax_percentage(), airQualityGuidelines.getMin_percentage(),
					airQualityGuidelines.getBreed() );
			return new BasicResponse("AirQualityGuidelines created: " + airQualityGuidelines.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<AirQualityGuidelines> getByBreed(int breed) {
		return jdbcTemplate.query("select * from air_quality_guidelines where breed=?", new Object[] { breed },
				new AirQualityGuidelinesRowMapper());
	}

	@Override
	public AirQualityGuidelines getByElement(String element) {
		System.out.println("element " + element);
		List<AirQualityGuidelines> result= jdbcTemplate.query("select * from air_quality_guidelines where element=?", new Object[] { element },
				new AirQualityGuidelinesRowMapper());
		if (result.isEmpty())
			return null;
		else return result.get(0);
	}


	 
}
