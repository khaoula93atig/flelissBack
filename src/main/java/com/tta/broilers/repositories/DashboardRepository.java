package com.tta.broilers.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tta.broilers.entities.rest.*;
import com.tta.broilers.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.DashboardInterface;

import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.WeeklyWeightMeasurement;

/**
 * @author EMNA
 *
 */
@Repository
public class DashboardRepository implements DashboardInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Farm> getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCompanyName(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlockWeight> findWeightByFlock(String center_id) {
		List<WeightByFlock> weightByFlock = jdbcTemplate.query(
				"select age_flock , measure ,flock_id , house_id ,center_id from visit v , visittasks vt  where center_id=? and vt.visit_id=v.visit_id and task_id=11 order by flock_id ",
				new Object[] { center_id }, new WeightByFlockRowMapper());
	
		List<FlockWeight> newList = parsObject(weightByFlock);
		
		 List<FlockWeight> newList2=removeDuplicates(newList);
		 newList2.forEach(d->System.out.println(" newList2 ****  " + d.toString()));
		//// }
		return newList2;
		//

	}

	private List<FlockWeight> parsObject(List<WeightByFlock> weightByFlock) {

		List<FlockWeight> newList = new ArrayList<FlockWeight>();

		return newList;
	}

	public List<FlockWeight> removeDuplicates(List<FlockWeight> list) {

		// Create a new ArrayList
		List<FlockWeight> newList = new ArrayList<FlockWeight>();

		// Traverse through the first list
		for (FlockWeight element : list) {

			// If this element is not present in newList
			// then add it
			if (!newList.contains(element)) {

				newList.add(element);
			}
		}

		// return the new list
		return newList;
	}

	public ArrayList<WeightByBreed> getWeightperBreed(String centerID) {

		List<WeightByBreed> weightByBreedRoss = jdbcTemplate.query(
				"select vt.measure , b.description , b .breed_id , v.visit_date from visit v, visittasks vt, flock f, breed b where v.visit_id=vt.visit_id and v.flock_id=f.flock_id and f.breed=b.breed_id and vt.task_id=11 and v.center_id=? and b.breed_id=3 order by  visit_date desc limit 1 ",
				new Object[] { centerID }, new WeightPerBreedRowMapper());
		System.out.println("weightByBreedRoss " + weightByBreedRoss.toString());

		List<WeightByBreed> weightByBreedCoob = jdbcTemplate.query(
				"select vt.measure , b.description , b .breed_id , v.visit_date from visit v, visittasks vt, flock f, breed b where v.visit_id=vt.visit_id and v.flock_id=f.flock_id and f.breed=b.breed_id and vt.task_id=11 and v.center_id=? and b.breed_id=2 order by  visit_date desc limit 1 ",
				new Object[] { centerID }, new WeightPerBreedRowMapper());
		System.out.println("weightByBreedCoob " + weightByBreedCoob.toString());

		List<WeightByBreed> weightByBreedHubbard = jdbcTemplate.query(
				"select vt.measure , b.description , b .breed_id , v.visit_date from visit v, visittasks vt, flock f, breed b where v.visit_id=vt.visit_id and v.flock_id=f.flock_id and f.breed=b.breed_id and vt.task_id=11 and v.center_id=? and b.breed_id=1 order by  visit_date desc limit 1 ",
				new Object[] { centerID }, new WeightPerBreedRowMapper());
		System.out.println("weightByBreedHubbard " + weightByBreedHubbard.toString());

		ArrayList<WeightByBreed> weightByBreed = new ArrayList<WeightByBreed>();

		for (WeightByBreed cobb : weightByBreedCoob) {
			weightByBreed.add(cobb);
		}
		for (WeightByBreed ross : weightByBreedRoss) {
			weightByBreed.add(ross);
		}
		for (WeightByBreed hubbard : weightByBreedHubbard) {
			weightByBreed.add(hubbard);
		}

	

		// return the new list
		return weightByBreed;
	}

	@Override
	public List<WeeklyWeightMeasurement> weeklyweightByCompanyForFarms(String companyId) {
		return jdbcTemplate.query(
				"SELECT count(*),house_id,weekly_weight_measurement.center_id, flock_id, week, weekly_weight_measurement.farm_id, average, weekly_weight_measurement.breed, cv, uniformty\r\n"
				+ "	FROM public.weekly_weight_measurement JOIN farm on farm.farm_id = weekly_weight_measurement.farm_id\r\n"
				+ "	where farm.company_id=?\r\n"
				+ "	group by week,house_id, weekly_weight_measurement.farm_id,weekly_weight_measurement.center_id, average, weekly_weight_measurement.breed, cv, uniformty , flock_id",new Object[] { companyId },
				new WeeklyweightMesurementRowMapper());
	}

	@Override
	public List<WeeklyWeightMeasurement> weeklyweightBycenterforFarm(String farmId) {
		return jdbcTemplate.query(
				"SELECT count(*), flock_id,house_id,weekly_weight_measurement.farm_id, week, weekly_weight_measurement.center_id, average, weekly_weight_measurement.breed, cv, uniformty\r\n"
				+ "				FROM public.weekly_weight_measurement JOIN center on center.center_id = weekly_weight_measurement.center_id  \r\n"
				+ "					where weekly_weight_measurement.farm_id=?\r\n"
				+ "				group by week,house_id,weekly_weight_measurement.farm_id, weekly_weight_measurement.center_id, average, weekly_weight_measurement.breed, cv, uniformty , flock_id",new Object[] { farmId },
				new WeeklyweightMesurementRowMapper());
	}

	@Override
	public List<WeeklyWeightMeasurement> weeklyweightByHouseforCenter(String centerId) {
		return jdbcTemplate.query(
				"SELECT count(*), flock_id,house_id,weekly_weight_measurement.farm_id, week, weekly_weight_measurement.center_id, average, weekly_weight_measurement.breed, cv, uniformty\r\n"
				+ "				FROM public.weekly_weight_measurement  \r\n"
				+ "					where center_id=?\r\n"
				+ "				group by week,house_id,weekly_weight_measurement.farm_id, weekly_weight_measurement.center_id, average, weekly_weight_measurement.breed, cv, uniformty , flock_id",new Object[] { centerId },
				new WeeklyweightMesurementRowMapper());
	}

	@Override
	public List<AlertByFarm> getAllAlertByFarm(Date visitDate, String farmId) {
		return jdbcTemplate.query(
				"SELECT count(*), visittasks.task_id , visit.center_id , visit.house_id , center.center_name , house.house_name , task.description ,visittasks.deviation , visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join center on center.center_id = visit.center_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	join task on task.task_id = visittasks.task_id\r\n"
				+ "	WHERE visit_date=? and visit.farm_id=? and (visittasks.deviation!='Normal' and visittasks.deviation!='' and visittasks.deviation!='average')\r\n"
				+ "	group by visittasks.task_id , visit.center_id , visit.house_id , center.center_name , house.house_name , task.description ,visittasks.deviation , visittasks.measure",new Object[] { visitDate, farmId },
				new AlertByFarmRowMapper());
	}

	@Override
	public List<AlertByHouse> getAlertByHouse(Date visitDate, String houseId) {
		return jdbcTemplate.query(
				"SELECT count(*), visittasks.task_id , task.description ,visittasks.deviation , visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ " join house on house.house_id = visit.house_id \r\n"
				+ "	join task on task.task_id = visittasks.task_id\r\n"
				+ "	WHERE visit_date=? and visit.house_id=? and (visittasks.deviation!='Normal' and visittasks.deviation!='' and visittasks.deviation!='average')\r\n"
				+ "	group by visittasks.task_id , task.description ,visittasks.deviation , visittasks.measure",new Object[] { visitDate, houseId },
				new AlertByHouseRowMapper());
	}

	@Override
	public double getFeedConsumtionDialy(Date visitDate, String houseId) {
		return jdbcTemplate.queryForObject("SELECT visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	WHERE visit_date=? and visit.house_id=? and visittasks.task_id=6",new Object[] {visitDate, houseId }, Double.class);
	}

	@Override
	public double getFeedConsumtionTotal(Date visitDate, String houseId) {
		return jdbcTemplate.queryForObject("SELECT sum(visittasks.measure)\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	join flock on flock.flock_id = visit.flock_id\r\n"
				+ "	WHERE visit.house_id=? and visittasks.task_id=6 and flock.check_end_of_cycle=false and visit.visit_date<=?",new Object[] {houseId ,visitDate }, Double.class);
	}

	@Override
	public List<MortalityByhouseLastDays> getFeedByhouseOfLastDays(String houseId) {
		return jdbcTemplate.query("SELECT measure , ' D'|| age_flock as ageDate , visit_date\n" +
				"from (SELECT visittasks.measure ,age_flock, visit_Date  \n" +
				"FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\n" +
				"join house on house.house_id = visit.house_id\n" +
				"join flock on flock.house_id = house.house_id\n" +
				"WHERE visit.house_id=? and visittasks.task_id=6 and flock.check_end_of_cycle=false\n" +
				"ORDER BY visit_Date DESC\n" +
				"LIMIT 7)\n" +
				"order by visit_date asc",new Object[] {houseId }, new MortalityByHouseLastDaysRowMapper() );
	}

	@Override
	public List<MortalityByhouseLastDays> geWeightByhouseOfLastDays(String houseId) {
		return jdbcTemplate.query("SELECT measure , ' D'|| age_flock as ageDate , visit_date\n" +
				"from (SELECT visittasks.measure ,age_flock, visit_Date  \n" +
				"FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\n" +
				"join house on house.house_id = visit.house_id\n" +
				"join flock on flock.house_id = house.house_id\n" +
				"WHERE visit.house_id=? and visittasks.task_id=11 and flock.check_end_of_cycle=false\n" +
				"ORDER BY visit_Date DESC\n" +
				"LIMIT 7)\n" +
				"order by visit_date asc",new Object[] {houseId }, new MortalityByHouseLastDaysRowMapper() );
	}

	@Override
	public List<MortalityByhouseLastDays> getWaterByhouseOfLastDays(String houseId) {
		return jdbcTemplate.query("SELECT measure , ' D'|| age_flock as ageDate , visit_date\n" +
				"from (SELECT visittasks.measure ,age_flock, visit_Date  \n" +
				"FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\n" +
				"join house on house.house_id = visit.house_id\n" +
				"join flock on flock.house_id = house.house_id\n" +
				"WHERE visit.house_id=? and visittasks.task_id=7 and flock.check_end_of_cycle=false\n" +
				"ORDER BY visit_Date DESC\n" +
				"LIMIT 7)\n" +
				"order by visit_date asc",new Object[] {houseId }, new MortalityByHouseLastDaysRowMapper() );
	}

	@Override
	public double getWaterConsumtionDialy(Date visitDate, String houseId) {
		return jdbcTemplate.queryForObject("SELECT visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	WHERE visit_date=? and visit.house_id=? and visittasks.task_id=7",new Object[] {visitDate, houseId }, Double.class);
	}

	@Override
	public double getWaterConsumtionTotal(Date visitDate, String houseId) {
		return jdbcTemplate.queryForObject("SELECT sum(visittasks.measure)\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	join flock on flock.flock_id = visit.flock_id\r\n"
				+ "	WHERE visit.house_id=? and visittasks.task_id=7 and flock.check_end_of_cycle=false and visit.visit_date<=?",new Object[] {houseId ,visitDate }, Double.class);
	}

	@Override
	public double getWeightMesurementDialy(Date visitDate, String houseId) {
		return jdbcTemplate.queryForObject("SELECT visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	WHERE visit_date=? and visit.house_id=? and visittasks.task_id=11",new Object[] {visitDate, houseId }, Double.class);
	}

	@Override
	public double getCVMesurementTotal(Date visitDate, String houseId) {
		return jdbcTemplate.queryForObject("SELECT visittasks.measure\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	WHERE visit_date=? and visit.house_id=? and visittasks.task_id=12",new Object[] {visitDate, houseId }, Double.class);
	}

	@Override
	public List<MortalityByFarm> getTotalFeedConsumByFarm(String companyId , Date visitDate) {
		return jdbcTemplate.query("SELECT COALESCE(t2.percentage, t1.percentage) AS percentage, t1.farm_name\n" +
				"\t\t\t\tFROM \n" +
				"\t\t\t\t( SELECT 0 AS percentage, farm_name\n" +
				"\t\t\t\tFROM farm \n" +
				"\t\t\t\tWHERE farm.company_id=? \n" +
				"\t\t\t\tGROUP BY farm_name\n" +
				"\t\t\t\t) t1\n" +
				"\t\t\t\tLEFT JOIN\n" +
				"\t\t\t\t(SELECT (sum(measure)) as percentage, farm.farm_name\n" +
				"\t\t\t\tFROM public.visittasks join visit on visit.visit_id= visittasks.visit_id\n" +
				"\t\t\t\tjoin flock on flock.flock_id = visit.flock_id\n" +
				"\t\t\t\tjoin farm on farm.farm_id = visit.farm_id\n" +
				"\t\t\t\twhere flock.check_end_of_cycle=false and farm.company_id=? and\n" +
				"\t\t\t\t visittasks.task_id=6 and visit.visit_date<=? \n" +
				"\t\t\t\tgroup by farm.farm_name\n" +
				"\t\t\t\t) t2\n" +
				"\t\t\t\tON t1.farm_name = t2.farm_name;",new Object[] {companyId , companyId , visitDate }, new MortalityByfarmRowMapper() );
	}

	@Override
	public List<Flock> getFlocksByHouseAndYear(String HouseId, int year) {
		return jdbcTemplate.query("SELECT *\r\n"
				+ "	FROM public.flock"
				+ "	where house_id=? and EXTRACT(YEAR From hatch_date)=?;",
				new Object[] {HouseId, year }, new FlockDashRowMapper());
	}

	@Override
	public List<WeeklyWeightMesurementByFlock> getWeightByFlock(String HouseId, int year) {
		return jdbcTemplate.query("select weekly_weight_measurement.flock_id, week, average \n" +
						"\t\t\t\t\t from weekly_weight_measurement JOIN flock on flock.flock_id = weekly_weight_measurement.flock_id\n" +
						"\t\t\t\twhere weekly_weight_measurement.house_id=? and EXTRACT(YEAR From hatch_date)=?\n" +
						"\t\t\t\tgroup by weekly_weight_measurement.flock_id , week , average\n" +
						"\t\t\t\tunion\n" +
						"select visit.flock_id , visit.age_flock , visittasks.measure\n" +
						"from visit JOIN flock on flock.flock_id = visit.flock_id\n" +
						"join visittasks on visittasks.visit_id = visit.visit_id \n" +
						"where visittasks.task_id=11 and visit.age_flock in (0,7,14,21,28,35,42)  and visit.house_id = ? \n" +
						"and EXTRACT(YEAR From hatch_date)=?",
				new Object[] {HouseId, year ,HouseId, year}, new WeeklyWeightMesurementByFlockRowMapper());
	}

	@Override
	public List<WeeklyWeightMesurementByFlock> getfeedByFlock(String HouseId, int year) {
		return jdbcTemplate.query("select weekly_feed.flock_id, week, (sum(total_starter_feed)+sum(total_grower_feed)+ sum(total_finisher_feed)) as average \n" +
						"\t\t\t\t\t from public.weekly_feed JOIN flock on flock.flock_id = weekly_feed.flock_id\n" +
						"\t\t\t\twhere weekly_feed.house_id=? and EXTRACT(YEAR From hatch_date)=?\n" +
						"\t\t\t\tgroup by weekly_feed.flock_id , week\n" +
						"union\n" +
						"select visit.flock_id , visit.age_flock , visit.total_feed_consumption\n" +
						"from visit JOIN flock on flock.flock_id = visit.flock_id\n" +
						"where  visit.age_flock in (0,7,14,21,28,35,42) and visit.house_id = ? and EXTRACT(YEAR From hatch_date)=?",
				new Object[] {HouseId, year ,HouseId, year }, new WeeklyWeightMesurementByFlockRowMapper());
	}

	@Override
	public List<WeeklyWeightMesurementByFlock> getFcrByFlock(String houseId) {
		String req = "select weekly_feed.flock_id, weekly_feed.week,Round(((sum(total_starter_feed)+sum(total_grower_feed)+ sum(total_finisher_feed))/average),3) as average\n" +
				"from public.weekly_feed \n" +
				"JOIN flock on flock.flock_id = weekly_feed.flock_id\n" +
				"Join weekly_weight_measurement on weekly_weight_measurement.flock_id = weekly_feed.flock_id \n" +
				"and weekly_feed.week = weekly_weight_measurement.week\n" +
				"where weekly_feed.house_id=?\n" +
				"group by weekly_feed.flock_id , weekly_feed.week , average";
		return jdbcTemplate.query(req ,new Object[] {houseId} , new WeeklyWeightMesurementByFlockRowMapper() );
	}

	@Override
	public List<MortalityByFlock> getWaterByFlock(String HouseId, Date visitDate, int year) {
		return jdbcTemplate.query("SELECT sum(visittasks.measure)AS mortality, flock.flock_name\r\n"
				+ "	FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "	join house on house.house_id = visit.house_id \r\n"
				+ "	join flock on flock.flock_id = visit.flock_id\r\n"
				+ "	WHERE visit.house_id=? and visittasks.task_id=7 and visit.visit_date<=? and EXTRACT(YEAR From hatch_date)=?\r\n"
				+ "	group by flock.flock_name",
				new Object[] {HouseId, visitDate, year }, new MortalityByFlockRowMapper());
	}

	@Override
	public List<FlockOutResult> getFlockOutResultOfBadyWeight(String companyId) {
		String req1="select farm.farm_name, house.house_name,flock.flock_name,visittasks.measure as weight\r\n"
				+ "from visit , flock , house , farm , visittasks\r\n"
				+ "where visit.flock_id=flock.flock_id and visit.farm_id = farm.farm_id and house.house_id=visit.house_id and visit.visit_id=visittasks.visit_id\r\n"
				+ "and age_flock=35 and flock.check_end_of_cycle=true and visittasks.task_id=11 and farm.company_id=?;";
		List<FlockOutResult> list1=jdbcTemplate.query(req1, new Object[] {companyId},new FlockOutResultRowMapper());
		
		String req2="SELECT farm.farm_name, house.house_name,flock.flock_name,average as weight\r\n"
				+ "FROM public.weekly_weight_measurement , flock , house , farm   \r\n"
				+ "where weekly_weight_measurement.farm_id = farm.farm_id and house.house_id=weekly_weight_measurement.house_id and \r\n"
				+ "flock.flock_id = weekly_weight_measurement.flock_id \r\n"
				+ "and week=35 and flock.check_end_of_cycle=true and farm.company_id=?\r\n"
				+ "group by average , farm.farm_name, house.house_name,flock.flock_name;";
		List<FlockOutResult> list2=jdbcTemplate.query(req2, new Object[] {companyId},new FlockOutResultRowMapper());
		
		return Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
	}

	@Override
	public List<WeeklyWeightMeasurementForFarm> getWeeklyWeighMeasurementForFarm(String companyId) {
		String req ="SELECT COALESCE(t2.week, t1.week) AS week, COALESCE(t2.avg, t1.avg) AS avg, t1.farm_name\n" +
				"\t\t\t\tFROM \n" +
				"\t\t\t\t( SELECT 0 as week , 0 AS avg, farm_name\n" +
				"\t\t\t\tFROM farm\n" +
				"\t\t\t\tWHERE farm.company_id=? \n" +
				"\t\t\t\tGROUP BY farm_name)\n" +
				"\t\t\t\tt1\n" +
				"\t\t\t\tLEFT JOIN\n" +
				"\t\t\t\t(select week , farm.farm_name , avg(average) as avg\n" +
				"from weekly_weight_measurement join company on company_id = ? \n" +
				"join farm on farm.company_id = company.company_id and weekly_weight_measurement.farm_id =farm.farm_id\n" +
				"join flock on flock.farm_id = farm.farm_id and check_end_of_cycle = false\n" +
				"group by week , farm.farm_name  \n" +
				"order By week ASC) t2\n" +
				"\t\t\t\tON t1.farm_name = t2.farm_name;";
		return jdbcTemplate.query(req, new Object[] {companyId ,companyId},new WeeklyWeightMeasurementForFarmRowMapper());
	}

	@Override
	public List<WeeklyWeightMeasurementByHouse> getWeeklyWeighMeasurementByHouse(String companyId, String farmName) {
		String req ="SELECT COALESCE(t2.week, t1.week) AS week, COALESCE(t2.average, t1.average) AS average, t1.house_name\n" +
				"\t\t\t\tFROM \n" +
				"\t\t\t\t( SELECT 0 as week , 0 AS average, house_name\n" +
				"\t\t\t\tFROM house join farm on farm.farm_id =house.farm_id \n" +
				"\t\t\t\tWHERE farm.company_id=? and farm.farm_name =?\n" +
				"\t\t\t\tGROUP BY house_name )\n" +
				"\t\t\t\tt1\n" +
				"\t\t\t\tLEFT JOIN\n" +
				"\t\t\t\t(select week , average , house.house_name\n" +
				"from weekly_weight_measurement join company on company_id = ? \n" +
				"join farm on farm.company_id = company.company_id and weekly_weight_measurement.farm_id =farm.farm_id and\n" +
				"farm.farm_name =?\n" +
				"join flock on flock.farm_id = farm.farm_id and check_end_of_cycle = false\n" +
				"join house on house.house_id = weekly_weight_measurement.house_id\n" +
				"group by week , average ,house.house_name\n" +
				"order By week ASC)\n" +
				"\t\t\t\tt2\n" +
				"\t\t\t\tON t1.house_name = t2.house_name;";
		return jdbcTemplate.query(req, new Object[] {companyId ,farmName , companyId , farmName},new WeeklyWeightMeasurementByHouseRowMapper());
	}


}
