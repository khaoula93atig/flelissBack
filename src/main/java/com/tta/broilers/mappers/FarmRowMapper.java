package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Company;
import com.tta.broilers.entities.Farm;

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         20 mai 2020
 */
public class FarmRowMapper implements RowMapper<Farm> {

	@Override
	public Farm mapRow(ResultSet rs, int arg1) throws SQLException {

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
		farm.setBridsNumberPerCenter(rs.getInt("brids_number_per_center"));
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
		
		farm.setCompany(company);
		return farm;
	}

}
