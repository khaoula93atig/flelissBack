package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.FarmInterface;
import com.tta.broilers.entities.Farm;
import com.tta.broilers.mappers.FarmRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author EMNA
 *
 */
@Repository
public class FarmRepository implements FarmInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Farm> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from farm left join company on farm.company_id= company.company_id",
				new FarmRowMapper());

	}

	@Override
	public BasicResponse save(Farm farm) {
		try {
			
			String companyName= getCompanyName(farm.getCompanyID());
			
			System.out.println("farm "+farm.toString());
			farm.setFarmId(farm.getCompanyID() + "-" + Utils.LeftPadString(String.valueOf(countAll() + 1), 4, "0"));
		    farm.setCreationDate(new Date());
		farm.setFarmName(companyName+"-"+farm.getFarmName());
			jdbcTemplate.update("INSERT INTO farm(farm_id, farm_name, address, area, type_production, farm_manager_name,"
					+ " farm_manager_email, farm_manager_tel, brids_number_per_center, number_center, result, av_mortality_rate, fcr, epef, av_lay_rate, company_id, rotation,creation_date,breed, \"Houses_number\")"
					+ " VALUES (?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?);\r\n"
					+ "",farm.getFarmId(),farm.getFarmName(),farm.getAddress(),farm.getArea(),
					farm.getTypeProduction(),farm.getFarmManageName(),farm.getFarmManageEmail(),farm.getFarmManageTel(),
					farm.getBridsNumberPerCenter(),farm.getNumberCenter(),farm.getResult(),
					farm.getAvMortalityRate(),farm.getFcr(),farm.getEpef(),farm.getAvLayRate(),farm.getCompanyID(),farm.getRotation(),farm.getCreationDate(),farm.getBreed(),farm.getHousesNumber());
			
			return new BasicResponse("Farm created: " + farm.toString(), HttpStatus.OK);
			
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Farm farm) {
		try {
			System.out.println("farm "+farm);
			List<Farm> toUpdate = getByFarmId(farm.getFarmId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE public.farm\r\n"
						+ "	SET address=?, area=?, type_production=?, farm_manager_name=?, farm_manager_email=?, farm_manager_tel=?,\r\n"
						+ "	brids_number_per_center=?, number_center=?, result=?, av_mortality_rate=?, fcr=?, epef=?, \r\n"
						+ "	company_id=?, rotation=?, av_lay_rate=?, creation_date=?, breed=?, farm_name=?, \"Houses_number\"=?\r\n"
						+ "	WHERE farm_id=?;",
						farm.getAddress(),farm.getArea(),farm.getTypeProduction(),farm.getFarmManageName(),
						farm.getFarmManageEmail(),farm.getFarmManageTel(),farm.getBridsNumberPerCenter(),farm.getNumberCenter(),
						farm.getResult(),farm.getAvMortalityRate(),farm.getFcr(),farm.getEpef(),farm.getCompanyID(),
						farm.getRotation(),farm.getAvLayRate(),farm.getCreationDate(),farm.getBreed(),farm.getFarmName(),farm.getHousesNumber(), farm.getFarmId());
				return new BasicResponse("Farm updated: " + farm.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Farm> getByFarmId(String id) {

		return jdbcTemplate.query(
				"select * from farm left join company on farm.company_id= company.company_id where farm.farm_id=? ",
				new Object[] { id }, new FarmRowMapper());
	}

	@Override
	public long countAll() {
		return jdbcTemplate.queryForObject("select count(*) from farm ", Long.class);

	}
	@Override
	public String getCompanyName(String companyId ) {
		return jdbcTemplate.queryForObject("SELECT name FROM company where company_id=?",new Object[] { companyId } ,String.class);

	}

	@Override
	public List<Farm> getByCompanyId(String id) {
		return jdbcTemplate.query(
				"select * from farm left join company on farm.company_id= company.company_id where company.company_id=? ",
				new Object[] { id }, new FarmRowMapper());
	}

}
