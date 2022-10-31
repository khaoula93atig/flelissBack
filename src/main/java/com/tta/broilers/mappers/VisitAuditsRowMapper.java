package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.VisitAudits;

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class VisitAuditsRowMapper implements RowMapper<VisitAudits> {

	@Override
	public VisitAudits mapRow(ResultSet rs, int arg1) throws SQLException {

		VisitAudits visitAudits = new VisitAudits();
		visitAudits.setBreedingMnagementId(rs.getInt("breeding_management_id"));;
		visitAudits.setMeasure(rs.getBoolean("measure"));
		visitAudits.setVisitId(rs.getString("visit_id"));
		visitAudits.setCreationDate(rs.getDate("creation_date"));

	
	
		return visitAudits;
	}

}
