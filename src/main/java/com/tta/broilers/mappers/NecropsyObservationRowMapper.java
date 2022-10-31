package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.NecropsyObservation;
/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class NecropsyObservationRowMapper implements RowMapper<NecropsyObservation> {

	@Override
	public NecropsyObservation mapRow(ResultSet rs, int arg1) throws SQLException {

		NecropsyObservation necropsyObservation = new NecropsyObservation();
	
		necropsyObservation.setNecropsy_observation_id(rs.getInt("necropsy_observation_id"));;
		necropsyObservation.setDescription(rs.getString("description"));
		necropsyObservation.setCreation_date(rs.getDate("creation_date"));

		return necropsyObservation;
	}


}
