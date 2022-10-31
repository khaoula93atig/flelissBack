package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.CenterInterface;
import com.tta.broilers.entities.Center;
import com.tta.broilers.mappers.CenterRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author EMNA
 *
 */
@Repository
public class CenterRepository implements CenterInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Center> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from center ce , farm f , company co where ce.farm_id=f.farm_id and f.company_id=co.company_id",
				new CenterRowMapper());

	}

	@Override
	public BasicResponse save(Center center) {
		try {
			String farmName= getFarmName(center.getFarmId());
	
			
			center.setCenterId(center.getFarmId() + "-" + Utils.LeftPadString(String.valueOf(countAll() + 1), 4, "0"));
			center.setCreationDate(new Date());
			center.setCenterName(farmName+"-"+center.getCenterName());
			jdbcTemplate.update("INSERT INTO center(\r\n"
					+ "            center_id, houses_number, center_name, address, breed, production_density, \r\n"
					+ "            zone, center_manager_name, center_manager_email, center_manager_tel, \r\n"
					+ "            nutrition_supervisor, sanitary_supervisor, brids_number_per_house, \r\n"
					+ "            center_multiage, av_mortality_per_flock, av_feed_consumption, \r\n"
					+ "            av_water_consumption, egg_production, av_fcr, av_eef, main_diseases, \r\n"
					+ "            species, farm_id, company_id, creation_date)\r\n"
					+ "    VALUES (?, ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, \r\n"
					+ "            ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?, ?, \r\n"
					+ "            ?, ?, ?, ?);\r\n"
					+ "",center.getCenterId(),center.getHousesNumber(),center.getCenterName(),center.getAddress(),
					center.getBreed(),center.getProductionDensity(),center.getZone(),center.getCenterManagerName(),
					center.getCenterManagerEmail(),center.getCenterManagerTel(),center.getNutritionSupervisor(),
					center.getSanitary_supervisor(),center.getBridsNumberPerHouse(),center.getCenterMultiage(),center.getAvMortalityPerFlock(),
					center.getAvFeedConsumption(),center.getAvWaterConsumption(),center.getEggProduction(),center.getAvFcr(),
					center.getAvEef(),center.getMainDiseases(),center.getSpecies(),center.getFarmId(),center.getCompanyId(),center.getCreationDate());
			return new BasicResponse("center created: " + center.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Center center) {
		try {
			List<Center> toUpdate = getById(center.getCenterId());
			System.out.println("toUpdate "+toUpdate.toString());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE center\r\n"
						+ "  SET houses_number=?, center_name=?, address=?, breed=?, \r\n"
						+ "       production_density=?, zone=?, center_manager_name=?, center_manager_email=?, \r\n"
						+ "       center_manager_tel=?, nutrition_supervisor=?, sanitary_supervisor=?, \r\n"
						+ "       brids_number_per_house=?, center_multiage=?, av_mortality_per_flock=?, \r\n"
						+ "       av_feed_consumption=?, av_water_consumption=?, egg_production=?, \r\n"
						+ "       av_fcr=?, av_eef=?, main_diseases=?, species=?, farm_id=?, company_id=?, \r\n"
						+ "       creation_date=?\r\n"
						+ " WHERE center_id=?",center.getHousesNumber(),center.getCenterName(),center.getAddress(),
						center.getBreed(),center.getProductionDensity(),center.getZone(),center.getCenterManagerName(),
						center.getCenterManagerEmail(),center.getCenterManagerTel(),center.getNutritionSupervisor(),center.getSanitary_supervisor(),
						center.getBridsNumberPerHouse(),center.getCenterMultiage(),center.getAvMortalityPerFlock(),
								center.getAvWaterConsumption(),center.getAvWaterConsumption(),center.getEggProduction(),
								center.getAvFcr(),center.getAvEef(),center.getMainDiseases(),center.getSpecies(),center.getFarmId(),
								center.getCompanyId(),center.getCreationDate(),center.getCenterId());
				return new BasicResponse("Center updated: " + center.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Center> getById(String id) {

		return jdbcTemplate.query(
				"select * from center left join farm on farm.farm_id= center.farm_id  left join company on company.company_id= farm.company_id   where center.center_id=? ",
				new Object[] { id }, new CenterRowMapper());
	}

	@Override
	public long countAll() {
		return jdbcTemplate.queryForObject("select count(*) from center ", Long.class);

	}

	@Override
	public String getFarmName(String farmId ) {
		return jdbcTemplate.queryForObject("SELECT farm_name FROM farm where farm_id=?",new Object[] { farmId } ,String.class);

	}

	@Override
	public List<Center> getByFarmId(String id) {
		return jdbcTemplate.query(
				"select * from center left join farm on farm.farm_id= center.farm_id  left join company on farm.company_id= company.company_id  where farm.farm_id=?",
				new Object[] { id }, new CenterRowMapper());
	}

	
	// if role user = COE or Super Admin get all centers by company id else if role user autre get all centers by farmID 
	
	
	@Override
	public List<Center> findCentersByRole(int roleID , String farmId , String companyId) {
		
		if (roleID!=1||roleID!=2) {
			System.out.println("if true ");
			return jdbcTemplate.query(
					"select * from center left join farm on farm.farm_id= center.farm_id  left join company on company.company_id= farm.company_id   where center.farm_id=? ",
					new Object[] { farmId }, new CenterRowMapper());
			
		}else {
			System.out.println("else true ");
			return jdbcTemplate.query(
					"select * from center left join farm on farm.farm_id= center.farm_id  left join company on company.company_id= farm.company_id   where center.company_id=? ",
					new Object[] { companyId }, new CenterRowMapper());
		}
		
		
	}




}
