package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.tta.broilers.entities.rest.MortalityByhouseLastDays;

public class MortalityByHouseLastDaysRowMapper implements RowMapper<MortalityByhouseLastDays> {

	@Override
	public MortalityByhouseLastDays mapRow(ResultSet rs, int rowNum) throws SQLException {
		MortalityByhouseLastDays mortalitybyHouse=new MortalityByhouseLastDays();
		mortalitybyHouse.setMesure(rs.getInt("measure"));
		mortalitybyHouse.setDate(rs.getDate("visit_Date"));
		return mortalitybyHouse;
	}

}
