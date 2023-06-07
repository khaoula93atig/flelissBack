package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.FlockOutResult;

public class FlockOutResultRowMapper implements RowMapper<FlockOutResult> {

	@Override
	public FlockOutResult mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		FlockOutResult flock = new FlockOutResult();
		flock.setFarm(arg0.getString("farm_name"));
		flock.setHouse(arg0.getString("house_name"));
		flock.setFlock(arg0.getString("flock_name"));
		flock.setWeight(arg0.getDouble("weight"));
		return flock;
	}

}
