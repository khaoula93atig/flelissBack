package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.MortalityByFlock;
import com.tta.broilers.entities.rest.MortalityByHouse;

public class MortalityByFlockRowMapper implements RowMapper<MortalityByFlock>  {

	@Override
	public MortalityByFlock mapRow(ResultSet rs, int rowNum) throws SQLException {
		MortalityByFlock mortalirtyByFlock = new MortalityByFlock();
		mortalirtyByFlock.setFlockName(rs.getString("flock_name"));
		mortalirtyByFlock.setPercentage(rs.getDouble("mortality"));
		return mortalirtyByFlock;
	}

}
