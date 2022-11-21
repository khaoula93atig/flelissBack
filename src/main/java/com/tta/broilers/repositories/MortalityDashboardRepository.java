package com.tta.broilers.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.MortalityDashboardInterface;
import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.mappers.MortalityByBreedRowMapper;

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

}
