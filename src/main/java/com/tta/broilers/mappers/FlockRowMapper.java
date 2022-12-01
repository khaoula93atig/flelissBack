package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Breed;
import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.House; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class FlockRowMapper implements RowMapper<Flock> {

	@Override
	public Flock mapRow(ResultSet rs, int arg1) throws SQLException {

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
		House house = new House();

		house.setBirdsNumber(rs.getInt("birds_number"));
		house.setHouseId(rs.getString("house_id"));
		house.setFarmID(rs.getString("farm_id"));
		house.setCreationDate(rs.getDate("creation_date"));
		house.setNbrCyclesPerYear(rs.getInt("nbr_cycles_per_year"));
		house.setDensity(rs.getInt("density"));
		house.setFeeder(rs.getString("feeder"));
		house.setArea(rs.getInt("area"));
		house.setVentilation(rs.getString("ventilation"));
		house.setWaterSource(rs.getString("water_source"));
		house.setDurationOfRotation(rs.getInt("duration_of_rotation"));
		house.setCenterId(rs.getString("center_id"));
		house.setHouseName(rs.getString("house_name"));
	
		
		Farm farm = new Farm();
		farm.setFarmId(rs.getString("farm_id"));
		farm.setFarmName(rs.getString("farm_name"));
		farm.setHousesNumber(rs.getInt("Houses_number"));
		farm.setAddress(rs.getString("address"));
		farm.setArea(rs.getString("area"));
		farm.setBreed(rs.getString("breed"));
		farm.setTypeProduction(rs.getString("type_production"));		
		farm.setFarmManageEmail(rs.getString("farm_manager_email"));
		farm.setFarmManageName(rs.getString("farm_manager_name"));
		farm.setFarmManageTel(rs.getString("farm_manager_tel"));
		farm.setCompanyID(rs.getString("company_id"));
		farm.setBridsNumberPerCenter(rs.getInt("houses_number"));
        farm.setNumberCenter(rs.getInt("number_center"));
        farm.setResult(rs.getString("result"));
		farm.setAvMortalityRate(rs.getDouble("av_mortality_rate"));
		farm.setFcr(rs.getDouble("fcr"));
		farm.setEpef(rs.getDouble("epef"));
		farm.setAvLayRate(rs.getDouble("av_lay_rate"));
		farm.setCreationDate(rs.getDate("creation_date")); 


		Breed breed = new Breed();
		breed.setBreedID(rs.getInt("breed_id"));
		breed.setDescription(rs.getString("description"));
		
		house.setFarm(farm);
		flock.setHouse(house);
		flock.setBreedObject(breed);
		
		
		return flock;
	}

}
