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
import com.tta.broilers.entities.rest.MortalityByFlock;
import com.tta.broilers.entities.rest.MortalityByHouse;
import com.tta.broilers.entities.rest.MortalityByhouseLastDays;
import com.tta.broilers.entities.rest.WeeklyweightStandardByBreedAndAge;
import com.tta.broilers.mappers.MortalityByBreedRowMapper;
import com.tta.broilers.mappers.MortalityByCenterRowMapper;
import com.tta.broilers.mappers.MortalityByFlockRowMapper;
import com.tta.broilers.mappers.MortalityByHouseLastDaysRowMapper;
import com.tta.broilers.mappers.MortalityByHouseRowMapper;
import com.tta.broilers.mappers.MortalityByfarmRowMapper;
import com.tta.broilers.mappers.WeeklyWeightStandardByBreedAndAgeRowMapper;

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
				"SELECT Round(sum(visittasks.percentage)/count(*),2)as percentage, farm.farm_name\r\n"
				+ "				FROM public.visittasks left join visit on visit.visit_id = visittasks.visit_id\r\n"
				+ "				left join farm on farm.farm_id = visit.farm_id \r\n"
				+ "				where task_id=? and visit.visit_date=? and farm.company_id=?\r\n"
				+ "				group by farm.farm_name",new Object[] { task,  visitDate,  companyId },
				new MortalityByfarmRowMapper());
	}
	@Override
	public List<MortalityByFarm> getPercentagMortalityByFarmGeneral(String companyId) {
		return jdbcTemplate.query(
				/*"SELECT round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) as percentage ,farm.farm_name\n" +
						"FROM public.flock JOIN farm on farm.farm_id = flock.farm_id \n" +
						"where flock.check_end_of_cycle=false and farm.company_id=?\n" +
						"group by farm.farm_name"*/
				"SELECT COALESCE(t2.percentage, t1.percentage) AS percentage, t1.farm_name\n" +
						"FROM \n" +
						"(\n" +
						"    SELECT 0 AS percentage, farm_name \n" +
						"    FROM farm \n" +
						"    WHERE farm.company_id=?\n" +
						"    GROUP BY farm_name\n" +
						") t1\n" +
						"LEFT JOIN \n" +
						"(\n" +
						"    SELECT \n" +
						"        round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) as percentage, \n" +
						"        farm.farm_name\n" +
						"    FROM public.flock \n" +
						"    JOIN farm on farm.farm_id = flock.farm_id \n" +
						"    WHERE flock.check_end_of_cycle=false and farm.company_id=?\n" +
						"    GROUP BY farm.farm_name\n" +
						") t2\n" +
						"ON t1.farm_name = t2.farm_name;\n"
				,new Object[] { companyId , companyId},
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
	@Override
	public double getMortalityByFarm(String farmId) {
		return jdbcTemplate.queryForObject("SELECT round((sum(flock_number)- sum(rest_flock_number)+ 0.0)*100/(sum(flock_number)+ 0.0),2) \r\n"
				+ "				FROM public.flock \r\n"
				+ "				where flock.check_end_of_cycle=false and farm_id=?",new Object[] { farmId }, Double.class);
	}
	@Override
	public double getMortalityByHouse(String houseId, Date visitdate) {
		return jdbcTemplate.queryForObject("SELECT visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	WHERE visit_date=? and visit.house_id=? and visittasks.task_id=8",new Object[] {visitdate , houseId }, Double.class);
	}
	@Override
	public double getSurvivalByHouse(String houseId) {
		return jdbcTemplate.queryForObject("SELECT rest_flock_number\r\n"
				+ "	FROM public.flock\r\n"
				+ "	where house_id=? and check_end_of_cycle=false;",new Object[] {houseId }, Double.class);
	}
	@Override
	public int getAgeFlock(String houseId, Date date) {
		return jdbcTemplate.queryForObject("SELECT  ?-start_of_cycle  AS date_difference\r\n"
				+ "	FROM public.flock\r\n"
				+ "	WHERE house_id=? and check_end_of_cycle=false",new Object[] {date,houseId }, int.class);
	}
	@Override
	public List<MortalityByhouseLastDays> getMortalityOfLastdaysByhouse(String houseId) {
		return jdbcTemplate.query("SELECT measure , ' D'|| age_flock as ageDate , visit_date\n" +
				"\t\t\t\tfrom (select visittasks.measure , visit.age_flock , visit_date FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\n" +
				"\t\t\t\tjoin house on house.house_id = visit.house_id \n" +
				"\t\t\t\tjoin flock on flock.house_id = house.house_id\n" +
				"\t\t\t\tWHERE visit.house_id=? and visittasks.task_id=8 and flock.check_end_of_cycle=false\n" +
				"\t\t\t\tORDER BY visit_Date desc , visit.age_flock desc\n" +
				"\t\t\t\tLIMIT 7)\n" +
				"\t\t\t\torder by visit_date asc",new Object[] {houseId}, new MortalityByHouseLastDaysRowMapper());
	}
	@Override
	public List<MortalityByFlock> getMortalityByflock(String houseId, int year) {
		return jdbcTemplate.query("SELECT CASE WHEN round(((flock_number-rest_flock_number+ 0.0)/flock_number)*100,2)=0.00  THEN 100\r\n"
				+ "            WHEN round(((flock_number-rest_flock_number+ 0.0)/flock_number)*100,2)=100.00 THEN 0\r\n"
				+ "            ELSE round(((flock_number-rest_flock_number+ 0.0)/flock_number)*100,2)\r\n"
				+ "       END as mortality, flock_name\r\n"
				+ "	FROM public.flock \r\n"
				+ "	where house_id=? and EXTRACT(YEAR From hatch_date)=?",new Object[] {houseId,year}, new MortalityByFlockRowMapper() );
	}
	@Override
	public List<WeeklyweightStandardByBreedAndAge> getMortalityByAge(String flockId) {
		return jdbcTemplate.query("SELECT \r\n"
				+ "  (CASE \r\n"
				+ "     WHEN (visit.visit_date - flock.start_of_cycle) BETWEEN 0 AND 7 THEN 7 \r\n"
				+ "     WHEN (visit.visit_date - flock.start_of_cycle) BETWEEN 8 AND 14 THEN 14 \r\n"
				+ "     WHEN (visit.visit_date - flock.start_of_cycle) BETWEEN 15 AND 21 THEN 21 \r\n"
				+ "     WHEN (visit.visit_date - flock.start_of_cycle) BETWEEN 22 AND 28 THEN 28 \r\n"
				+ "     WHEN (visit.visit_date - flock.start_of_cycle) BETWEEN 29 AND 35 THEN 35 \r\n"
				+ "     WHEN (visit.visit_date - flock.start_of_cycle) BETWEEN 36 AND 42 THEN 42 \r\n"
				+ "   END) AS age_days, \r\n"
				+ "  SUM(measure) AS weight \r\n"
				+ "FROM \r\n"
				+ "  visittasks, \r\n"
				+ "  visit, \r\n"
				+ "  flock \r\n"
				+ "WHERE \r\n"
				+ "  visittasks.visit_id = visit.visit_id \r\n"
				+ "  AND visit.flock_id = ? \r\n"
				+ "  AND visittasks.task_id = 8 \r\n"
				+ "  AND (visit.visit_date - flock.start_of_cycle) BETWEEN 0 AND 42 \r\n"
				+ "GROUP BY \r\n"
				+ "  age_days\r\n"
				+ "  order by age_days asc",new Object[] {flockId}, new WeeklyWeightStandardByBreedAndAgeRowMapper() );
	}

}
