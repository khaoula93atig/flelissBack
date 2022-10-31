package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.CompanyInterface;
import com.tta.broilers.entities.Company;
import com.tta.broilers.mappers.CompanyRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class CompanyRepository implements CompanyInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from company", new CompanyRowMapper());

	}

	@Override
	public BasicResponse save(Company company) {
		try {
			// company.setCompanyId(UUID.randomUUID().toString().replace("-", ""));
			company.setCompanyId(Utils.LeftPadString(String.valueOf(countAll() + 1), 4, "0"));
			company.setCreationDate(new Date());

			jdbcTemplate.update(
					"INSERT INTO company( company_id, name, farms_number, address, creation_date, country, "
							+ "   zone, general_manager_name, general_manager_tel, general_manager_email, "
							+ "    annual_production, agreement, integration) "
							+ "  VALUES (?, ?, ?, ?, ?, ?,   ?, ?, ?, ?,  ?, ?, ?);",
					company.getCompanyId(), company.getName(), company.getFarmsNumber(), company.getAddress(),
					company.getCreationDate(), company.getCountry(), company.getZone(), company.getGeneralManageName(),
					company.getGeneralManageTel(), company.getGeneralManageEmail(), company.getAnnualProduction(),
					company.getAgreement(), company.isIntegration());
			return new BasicResponse("Company created: " + company.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Company company) {
		try {
			List<Company> toUpdate = getById(company.getCompanyId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE company  SET  name=?, farms_number=?, address=?, creation_date=?, "
								+ "     country=?, zone=?, general_manager_name=?, general_manager_tel=?, "
								+ "     general_manager_email=?, annual_production=?, agreement=?, integration=?"
								+ " WHERE company_id=?;",
						company.getName(), company.getFarmsNumber(), company.getAddress(), company.getCreationDate(),
						company.getCountry(), company.getZone(), company.getGeneralManageName(),
						company.getGeneralManageTel(), company.getGeneralManageEmail(), company.getAnnualProduction(),
						company.getAgreement(), company.isIntegration(), company.getCompanyId());
				return new BasicResponse("Company updated: " + company.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Company> getById(String id) {

		return jdbcTemplate.query("select * from company where company_id=?", new Object[] { id },
				new CompanyRowMapper());
	}

	@Override
	public long countAll() {
		return jdbcTemplate.queryForObject("select count(*) from company ", Long.class);
	}

}
