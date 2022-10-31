package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.HealthStatus;
/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class HealthStatusRowMapper implements RowMapper<HealthStatus> {

	@Override
	public HealthStatus mapRow(ResultSet rs, int arg1) throws SQLException {

		HealthStatus healthStatus = new HealthStatus();
	
		healthStatus.setHealthStatusId(rs.getInt("health_status_id"));;
		healthStatus.setDescription(rs.getString("description"));
		healthStatus.setCategory(rs.getString("category"));
		healthStatus.setCreationDate(rs.getDate("creation_date"));

		return healthStatus;
	}


}
