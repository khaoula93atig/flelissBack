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
	public List<MortalityByBreed> getMortalityByBreed() {
		return jdbcTemplate.query(
				"SELECT breed, sum(flock_number)as number_initial, sum(rest_flock_number) as number_restant ,\r\n"
				+ "(sum(flock_number)- sum(rest_flock_number))*100/sum(flock_number) as mortality\r\n"
				+ "	FROM public.flock\r\n"
				+ "	where check_end_of_cycle=false\r\n"
				+ "	group by breed ORDER by breed ASC ",
				new MortalityByBreedRowMapper());
	}
	@Override
	public List<MortalityByFarm> getPercentagMortalityByFarm(int task, Date visitDate, String centerId) {
		return jdbcTemplate.query(
				"SELECT Round(sum(visittasks.percentage)/2,2)as percentage, visit.farm_id\r\n"
				+ "	FROM public.visittasks left join visit on visit.visit_id = visittasks.visit_id\r\n"
				+ "	where task_id=? and visit.visit_date=? and visit.center_id=?\r\n"
				+ "	group by farm_id",new Object[] { task,  visitDate,  centerId },
				new MortalityByfarmRowMapper());
	}

}
