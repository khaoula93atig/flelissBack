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

import com.tta.broilers.dao.HealthStatusInterface;
import com.tta.broilers.entities.HealthStatus;
import com.tta.broilers.mappers.HealthStatusRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class HealthStatusRepository implements HealthStatusInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<HealthStatus> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from health_status", new HealthStatusRowMapper());

	}

	@Override
	public BasicResponse save(HealthStatus healthStatus) {
		try {
			System.out.println("ok1 " + healthStatus);
			healthStatus.setCreationDate(new Date());
			KeyHolder keyHolder = new GeneratedKeyHolder();
//
//			jdbcTemplate.update("INSERT INTO health_status ( description, category, creation_date) VALUES (?, ?, ?);",
//					healthStatus.getDescription(), healthStatus.getCategory(), healthStatus.getCreationDate(),
//					keyHolder,  new String[] {"health_status_id"});

			String sqlQuery = "INSERT INTO health_status ( description, category, creation_date) VALUES (?, ?, ?);";

			jdbcTemplate.update(connection -> {
				PreparedStatement stmt = connection.prepareStatement(sqlQuery, new String[] { "health_status_id" });
				stmt.setString(1, healthStatus.getDescription());
				stmt.setString(2, healthStatus.getCategory());
				stmt.setDate(3, new java.sql.Date(healthStatus.getCreationDate().getTime()));
				return stmt;
			}, keyHolder);

			Number key = keyHolder.getKey();
			System.out.println("generated key " + key);
			return new BasicResponse("HealthStatus created: " + healthStatus.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(HealthStatus healthStatus) {
		try {
			List<HealthStatus> toUpdate = getById(healthStatus.getHealthStatusId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update("UPDATE health_status SET  description=?, category=? WHERE health_status_id=?;",
						healthStatus.getDescription(), healthStatus.getCategory(), healthStatus.getHealthStatusId());
				return new BasicResponse("HealthStatus updated: " + healthStatus.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<HealthStatus> getById(int id) {

		return jdbcTemplate.query("select * from health_status where health_status_id=?", new Object[] { id },
				new HealthStatusRowMapper());
	}

}
