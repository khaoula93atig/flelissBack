package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Breed; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class BreedRowMapper implements RowMapper<Breed> {

	@Override
	public Breed mapRow(ResultSet rs, int arg1) throws SQLException {

		Breed role = new Breed();
        role.setBreedID(rs.getInt("breed_id"));
	    role.setDescription(rs.getString("description"));
		 

		return role;
	}

}
