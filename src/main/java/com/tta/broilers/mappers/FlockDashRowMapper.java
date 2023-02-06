package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Flock;

public class FlockDashRowMapper implements RowMapper<Flock> {

	@Override
	public Flock mapRow(ResultSet rs, int rowNum) throws SQLException {
Flock flock = new Flock();
		
		flock.setFlockID(rs.getString("flock_id")); 
		flock.setHouseId(rs.getString("house_id"));
		flock.setFarmId(rs.getString("farm_id"));
		flock.setFlockName(rs.getString("flock_name"));
		flock.setBreed(rs.getInt("breed"));
		flock.setCycle(rs.getInt("cycle"));
		flock.setStartOfCycle(rs.getDate("start_of_cycle"));
		flock.setHatchDate(rs.getDate("hatch_date"));
		flock.setChikedPlaced(rs.getInt("chiked_placed"));
		flock.setPsOrigin(rs.getString("ps_origin"));
		flock.setCreationDate(rs.getDate("creation_date"));
		flock.setCheckEndOfCycle(rs.getBoolean("check_end_of_cycle"));
		flock.setFlockNumber(rs.getInt("flock_number"));
		flock.setEndOfCycle(rs.getDate("end_of_cycle"));
		flock.setRestFlockNumber(rs.getInt("rest_flock_number"));
		return flock;
	}

}
