package com.tta.broilers.repositories;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tta.broilers.dao.BreedInterface;
import com.tta.broilers.entities.Breed;
import com.tta.broilers.mappers.BreedRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class BreedRepository implements BreedInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Breed> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from breed", new BreedRowMapper());

	}

	@Override
	public BasicResponse save(Breed breed) {
		try {

			jdbcTemplate.update(" INSERT INTO breed (breed_id, description) VALUES (?, ?);", breed.getBreedID(),
					breed.getDescription()

			);
			return new BasicResponse("Breed created: " + breed.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Breed> getById(int id) {
		return jdbcTemplate.query("select * from breed where breed_id=?", new Object[] { id }, new BreedRowMapper());

	}

	@Override
	public BasicResponse update(Breed breed) {
		try {
			List<Breed> toUpdate = getById(breed.getBreedID());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update("UPDATE breed  SET  description=? WHERE breed_id=?;", breed.getDescription(),
						breed.getBreedID());
				return new BasicResponse("Breed updated: " + breed.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

}
