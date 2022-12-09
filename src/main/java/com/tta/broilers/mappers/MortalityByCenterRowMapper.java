package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.MortalityByCenter;

public class MortalityByCenterRowMapper implements RowMapper<MortalityByCenter> {

	@Override
	public MortalityByCenter mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		MortalityByCenter mortalityBycenter= new MortalityByCenter();
		mortalityBycenter.setPercentage(rs.getDouble("percentage"));
		mortalityBycenter.setCenterId(rs.getString("center_id"));
		return mortalityBycenter;
	}

}
