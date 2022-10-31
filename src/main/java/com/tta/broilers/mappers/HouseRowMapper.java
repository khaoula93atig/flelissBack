package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.House;

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         20 mai 2020
 */
public class HouseRowMapper implements RowMapper<House> {

	@Override
	public House mapRow(ResultSet rs, int arg1) throws SQLException {

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
		
		//Company company = new Company();

		//company.setAddress(rs.getString("address"));
		//company.setCreationDate(rs.getDate("creation_date"));
		//company.setAgreement(rs.getString("agreement"));
		//company.setAnnualProduction("annual_production");
		//company.setCompanyId(rs.getString("company_id"));
		//company.setCountry(rs.getString("country"));
		//company.setFarmsNumber(rs.getInt("farms_number"));
		//company.setGeneralManageEmail(rs.getString("general_manager_email"));
		//company.setGeneralManageName(rs.getString("general_manager_name"));
		//company.setGeneralManageTel(rs.getString("general_manager_tel"));
		//company.setIntegration(rs.getBoolean("integration"));
		//company.setName(rs.getString("name"));
		//company.setZone(rs.getString("zone"));
		
		//farm.setCompany(company);
		house.setFarm(farm);
		
		

		return house;
	}

}
