package com.tta.broilers.repositories;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.NecropsyObservationInterface;
import com.tta.broilers.entities.NecropsyObservation;
import com.tta.broilers.mappers.NecropsyObservationRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class NecropsyObservationRepository implements NecropsyObservationInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<NecropsyObservation> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from necropsy_observation", new NecropsyObservationRowMapper());

	}

	@Override
	public BasicResponse save(NecropsyObservation necropsyObservation) {
		try {
			System.out.println("ok1 " + necropsyObservation);
			necropsyObservation.setCreation_date(new Date());
			;
			KeyHolder keyHolder = new GeneratedKeyHolder();
//
//			jdbcTemplate.update("INSERT INTO health_status ( description, category, creation_date) VALUES (?, ?, ?);",
//					healthStatus.getDescription(), healthStatus.getCategory(), healthStatus.getCreationDate(),
//					keyHolder,  new String[] {"health_status_id"});

			String sqlQuery = "INSERT INTO necropsy_observation( description, creation_date)VALUES  (?, ?);";

			jdbcTemplate.update(connection -> {
				PreparedStatement stmt = connection.prepareStatement(sqlQuery,
						new String[] { "necropsy_observation_id" });
				stmt.setString(1, necropsyObservation.getDescription());
				stmt.setDate(2, new java.sql.Date(necropsyObservation.getCreation_date().getTime()));
				return stmt;
			}, keyHolder);

			Number key = keyHolder.getKey();
			System.out.println("generated key " + key);
			return new BasicResponse("necropsyObservation created: " + necropsyObservation.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(NecropsyObservation necropsyObservation) {
		try {
			List<NecropsyObservation> toUpdate = getById(necropsyObservation.getNecropsy_observation_id());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE necropsy_observation SET necropsy_observation_id=?, description=?, creation_date=? WHERE necropsy_observation_id=?;",
						necropsyObservation.getDescription(), necropsyObservation.getNecropsy_observation_id());
				return new BasicResponse("HealthStatus updated: " + necropsyObservation.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<NecropsyObservation> getById(int id) {

		return jdbcTemplate.query("select * from health_status where health_status_id=?", new Object[] { id },
				new NecropsyObservationRowMapper());
	}

}
