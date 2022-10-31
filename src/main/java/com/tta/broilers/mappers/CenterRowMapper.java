package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Center;
import com.tta.broilers.entities.Company;
import com.tta.broilers.entities.Farm;

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         20 mai 2020
 */
public class CenterRowMapper implements RowMapper<Center> {

	@Override
	public Center mapRow(ResultSet rs, int arg1) throws SQLException {

		
		

		Center center = new Center();
		center.setCenterId(rs.getString("center_id"));
		center.setCenterName(rs.getString("center_name"));
		center.setAddress(rs.getString("address"));
		center.setZone(rs.getString("zone"));
		center.setHousesNumber(rs.getInt("houses_number"));
		center.setBreed(rs.getString("breed"));
		center.setProductionDensity(rs.getString("production_density"));
		center.setCenterManagerName(rs.getString("center_manager_name"));
		center.setCenterManagerEmail(rs.getString("center_manager_email"));
		center.setCenterManagerTel(rs.getString("center_manager_tel"));
        center.setNutritionSupervisor(rs.getString("nutrition_supervisor"));
        center.setSanitary_supervisor(rs.getString("sanitary_supervisor"));
    	center.setBridsNumberPerHouse(rs.getInt("brids_number_per_house"));
        center.setCenterMultiage(rs.getString("center_multiage"));
        center.setAvMortalityPerFlock(rs.getDouble("av_mortality_per_flock"));
        center.setAvWaterConsumption(rs.getDouble("av_water_consumption"));
        center.setAvFeedConsumption(rs.getDouble("av_feed_consumption"));
        center.setAvFcr(rs.getDouble("av_fcr"));
        center.setAvEef(rs.getDouble("av_eef"));
        center.setEggProduction(rs.getInt("egg_production"));
        center.setMainDiseases(rs.getString("main_diseases"));
        center.setSpecies(rs.getString("species"));
        center.setFarmId(rs.getString("farm_id"));
        center.setCompanyId(rs.getString("company_id"));
        

        
    
	

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

	
		Company company = new Company();

		company.setAddress(rs.getString("address"));
		company.setCreationDate(rs.getDate("creation_date"));
		company.setAgreement(rs.getString("agreement"));
		company.setAnnualProduction("annual_production");
		company.setCompanyId(rs.getString("company_id"));
		company.setCountry(rs.getString("country"));
		company.setFarmsNumber(rs.getInt("farms_number"));
		company.setGeneralManageEmail(rs.getString("general_manager_email"));
		company.setGeneralManageName(rs.getString("general_manager_name"));
		company.setGeneralManageTel(rs.getString("general_manager_tel"));
		company.setIntegration(rs.getBoolean("integration"));
		company.setName(rs.getString("name"));
		company.setZone(rs.getString("zone"));
		
		center.setCompany(company);
		center.setFarm(farm);
		return center;
	}

}
