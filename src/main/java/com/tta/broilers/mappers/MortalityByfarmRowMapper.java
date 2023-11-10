package com.tta.broilers.mappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.MortalityByFarm;

public class MortalityByfarmRowMapper implements RowMapper<MortalityByFarm> {

	@Override
	public MortalityByFarm mapRow(ResultSet rs, int rowNum) throws SQLException {
		MortalityByFarm mortalitybyFarm=new MortalityByFarm();
		
		mortalitybyFarm.setFarmName(rs.getString("farm_name"));
		mortalitybyFarm.setPercentage(rs.getDouble("percentage"));
		
		return mortalitybyFarm;
	}

	
}
