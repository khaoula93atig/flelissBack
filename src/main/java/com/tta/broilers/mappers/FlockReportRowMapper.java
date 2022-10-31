package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Breed;
import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.House;
import com.tta.broilers.entities.rest.FlockTechnicalReport; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class FlockReportRowMapper implements RowMapper<FlockTechnicalReport> {

	@Override
	public FlockTechnicalReport mapRow(ResultSet rs, int arg1) throws SQLException {

		FlockTechnicalReport flocktTechnicalReport = new FlockTechnicalReport();
		flocktTechnicalReport.setFarmName(rs.getString("farm_name"));
		flocktTechnicalReport.setHouseArea(rs.getDouble("area"));
		flocktTechnicalReport.setFlockNumber(rs.getInt("flock_number"));
		flocktTechnicalReport.setStartOfCycle(rs.getDate("start_of_cycle"));
		flocktTechnicalReport.setEndOfCycle(rs.getDate("end_of_cycle"));
		flocktTechnicalReport.setRestFlockNumber(rs.getInt("rest_flock_number"));
		flocktTechnicalReport.setCycle(rs.getInt("cycle"));
		flocktTechnicalReport.setCenterName(rs.getString("center_name"));
		flocktTechnicalReport.setTotalMortality(rs.getDouble("totalMortality"));
		flocktTechnicalReport.setBreed(rs.getString("breed"));
		flocktTechnicalReport.setHouseName(rs.getString("house_name"));
		return flocktTechnicalReport;
	}

}
