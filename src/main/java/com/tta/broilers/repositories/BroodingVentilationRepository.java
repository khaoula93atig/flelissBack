package com.tta.broilers.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.BroodingVentilationInterface;
import com.tta.broilers.entities.BroodingVentilation;
import com.tta.broilers.mappers.BroodingVentilationMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class BroodingVentilationRepository implements BroodingVentilationInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BroodingVentilation> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from brooding_ventilation", new BroodingVentilationMapper());

	}

	@Override
	public BasicResponse save(BroodingVentilation broodingVentilation) {
		try {

			jdbcTemplate.update(" INSERT INTO brooding_ventilation(  "
					+ "   min_birds_age, max_birds_age, meters_per_second, breed, min_meters_per_second, max_meters_per_second,week) "
					+ "   VALUES (?, ?, ?, ?,?,?,?);", broodingVentilation.getMin_birds_age(),
					broodingVentilation.getMax_birds_age(), broodingVentilation.getMeters_per_second(),
					broodingVentilation.getBreed(), broodingVentilation.getMin_meters_per_second(),
					broodingVentilation.getMax_meters_per_second(), broodingVentilation.getWeek());
			return new BasicResponse("broodingVentilation created: " + broodingVentilation.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<BroodingVentilation> getByBreed(int breed) {
		return jdbcTemplate.query("select * from brooding_ventilation where breed=?", new Object[] { breed },
				new BroodingVentilationMapper());
	}

	@Override
	public BroodingVentilation getByWeek(int week) {
		System.out.println("search brooding_ventilation by weeks " + week);
		List<BroodingVentilation> result = jdbcTemplate.query("select * from brooding_ventilation where week=?",
				new Object[] { week }, new BroodingVentilationMapper());
		if (result.isEmpty())
			return null;
		else
			return result.get(0);
	}

}
