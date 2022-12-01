package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.MortalityByBreed;

public class MortalityByBreedRowMapper implements RowMapper<MortalityByBreed> {

	@Override
	public MortalityByBreed mapRow(ResultSet rs, int rowNum) throws SQLException {
		MortalityByBreed mortalite= new MortalityByBreed();
		
		mortalite.setBreed(rs.getInt("breed"));
		mortalite.setPercentage(rs.getDouble("percentage"));
		
		return mortalite;
	}

}
