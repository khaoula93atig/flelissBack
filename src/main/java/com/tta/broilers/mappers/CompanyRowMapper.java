package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Company; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class CompanyRowMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int arg1) throws SQLException {

		Company company = new Company();

		company.setAddress(rs.getString("address"));
		company.setCreationDate(rs.getDate("creation_date"));
		company.setAgreement(rs.getString("agreement"));
		company.setAnnualProduction(rs.getString("annual_production"));
		company.setCompanyId(rs.getString("company_id"));
		company.setCountry(rs.getString("country"));
		company.setFarmsNumber(rs.getInt("farms_number"));
		company.setGeneralManageEmail(rs.getString("general_manager_email"));
		company.setGeneralManageName(rs.getString("general_manager_name"));
		company.setGeneralManageTel(rs.getString("general_manager_tel"));
		company.setIntegration(rs.getBoolean("integration"));
		company.setName(rs.getString("name"));
		company.setZone(rs.getString("zone"));
		company.setLogo(rs.getString("logo"));

		return company;
	}

}
