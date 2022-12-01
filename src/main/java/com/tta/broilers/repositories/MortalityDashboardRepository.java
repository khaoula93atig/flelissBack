package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.MortalityDashboardInterface;
import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.mappers.MortalityByBreedRowMapper;
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

}
