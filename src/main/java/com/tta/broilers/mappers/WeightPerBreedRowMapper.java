package com.tta.broilers.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.WeightByBreed; 

/**
 * @author EMNA
 *
 *         
 */
public class WeightPerBreedRowMapper implements RowMapper<WeightByBreed> {

	@Override
	public WeightByBreed mapRow(ResultSet rs, int arg1) throws SQLException {

		WeightByBreed weightByBreed = new WeightByBreed();
	
		weightByBreed.setBreedID(rs.getInt("breed_id"));
		weightByBreed.setWeight(rs.getDouble("measure"));
		weightByBreed.setDescription(rs.getString("description"));
		weightByBreed.setVisitDate(rs.getDate("visit_date"));

		
		
		
		return weightByBreed;
	}


}
