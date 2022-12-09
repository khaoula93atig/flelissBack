package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.MortalityDashboardInterface;
import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByCenter;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.MortalityByHouse;
import com.tta.broilers.mappers.MortalityByBreedRowMapper;
import com.tta.broilers.mappers.MortalityByCenterRowMapper;
import com.tta.broilers.mappers.MortalityByHouseRowMapper;
import com.tta.broilers.mappers.MortalityByfarmRowMapper;

@Repository
public class MortalityDashboardRepository implements MortalityDashboardInterface{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MortalityByBreed> getMortalityByBreed(String companyId) {
		return jdbcTemplate.query(
				"SELECT round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) as percentage ,flock.breed\r\n"
				+ "				FROM public.flock JOIN farm on farm.farm_id = flock.farm_id \r\n"
				+ "				where flock.check_end_of_cycle=false and farm.company_id=? \r\n"
				+ "				group by flock.breed ORDER by breed ASC "
				,new Object[] { companyId },
				new MortalityByBreedRowMapper());
	}
	@Override
	public List<MortalityByFarm> getPercentagMortalityByFarm(int task, Date visitDate, String companyId) {
		return jdbcTemplate.query(
				"SELECT Round(sum(visittasks.percentage)/count(*),2)as percentage, visit.farm_id\r\n"
				+ "				FROM public.visittasks left join visit on visit.visit_id = visittasks.visit_id\r\n"
				+ "				left join farm on farm.farm_id = visit.farm_id \r\n"
				+ "				where task_id=? and visit.visit_date=? and farm.company_id=?\r\n"
				+ "				group by visit.farm_id",new Object[] { task,  visitDate,  companyId },
				new MortalityByfarmRowMapper());
	}
	@Override
	public List<MortalityByFarm> getPercentagMortalityByFarmGeneral(String companyId) {
		return jdbcTemplate.query(
				"SELECT round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) as percentage ,flock.farm_id\r\n"
				+ "	FROM public.flock JOIN farm on farm.farm_id = flock.farm_id \r\n"
				+ "	where flock.check_end_of_cycle=false and farm.company_id=? \r\n"
				+ "	group by flock.farm_id",new Object[] { companyId },
				new MortalityByfarmRowMapper());
	}
	@Override
	public List<MortalityByCenter> getPercentageMortalityByCenter(String farmId) {
		return jdbcTemplate.query(
				"SELECT round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) as percentage , house.center_id\r\n"
				+ "	FROM public.flock join house on house.house_id = flock.house_id\r\n"
				+ "	where flock.farm_id=? and check_end_of_cycle=false\r\n"
				+ "	group by house.center_id",new Object[] { farmId },
				new MortalityByCenterRowMapper());
	}
	@Override
	public List<MortalityByHouse> getPercentageMortalityByHouse(String centerId) {
		return jdbcTemplate.query(
				"SELECT round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) as percentage , flock.house_id\r\n"
				+ "	FROM public.flock join house on house.house_id = flock.house_id\r\n"
				+ "	where house.center_id=? and check_end_of_cycle=false\r\n"
				+ "	group by flock.house_id",new Object[] { centerId },
				new MortalityByHouseRowMapper());
	}
	@Override
	public double getMortalityByCompany(String companyId) {
		return jdbcTemplate.queryForObject("SELECT round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) \r\n"
				+ "				FROM public.flock JOIN farm on farm.farm_id = flock.farm_id \r\n"
				+ "				where flock.check_end_of_cycle=false and farm.company_id=? ",new Object[] { companyId }, Double.class);
	}
	@Override
	public double getSurvivalByCompany(String companyId) {
		return jdbcTemplate.queryForObject("SELECT round( ((sum(rest_flock_number)+ 0.0)*100)/(sum(flock_number)+ 0.0),2) as percentage \r\n"
				+ "				FROM public.flock JOIN farm on farm.farm_id = flock.farm_id \r\n"
				+ "				where flock.check_end_of_cycle=false and farm.company_id=? ",new Object[] { companyId }, Double.class);
	}
	@Override
	public double getSurvivalByFarm(String farmId) {
		return jdbcTemplate.queryForObject("SELECT round( ((sum(rest_flock_number)+ 0.0)*100)/(sum(flock_number)+ 0.0),2) as percentage \r\n"
				+ "				FROM public.flock JOIN farm on farm.farm_id = flock.farm_id \r\n"
				+ "				where flock.check_end_of_cycle=false and farm.farm_id=?",new Object[] { farmId }, Double.class);
	}

}
