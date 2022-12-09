package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.MortalityByHouse;

public class MortalityByHouseRowMapper implements RowMapper<MortalityByHouse> {

	@Override
	public MortalityByHouse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		MortalityByHouse mortalirtyByHouse = new MortalityByHouse();
		mortalirtyByHouse.setHouseId(rs.getString("house_id"));
		mortalirtyByHouse.setPercentage(rs.getDouble("percentage"));
		return mortalirtyByHouse;
	}

}
