package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.BroodingVentilation;


/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class BroodingVentilationMapper implements RowMapper<BroodingVentilation> {

	@Override
	public BroodingVentilation mapRow(ResultSet rs, int arg1) throws SQLException {

		BroodingVentilation broodingVentilation = new BroodingVentilation();
		broodingVentilation.setMin_birds_age(rs.getInt("min_birds_age"));
		broodingVentilation.setMax_birds_age(rs.getInt("max_birds_age"));
		broodingVentilation.setMeters_per_second(rs.getDouble("meters_per_second"));
		broodingVentilation.setMin_meters_per_second(rs.getDouble("min_meters_per_second"));
		broodingVentilation.setMax_meters_per_second(rs.getDouble("max_meters_per_second"));
		broodingVentilation.setBreed(rs.getInt("breed"));
		broodingVentilation.setWeek(rs.getInt("week"));
		return broodingVentilation;
	}

}
