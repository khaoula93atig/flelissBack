package com.tta.broilers.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.DashboardInterface;

import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.AlertByFarm;
import com.tta.broilers.entities.rest.AlertByHouse;
import com.tta.broilers.entities.rest.FlockOutResult;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.MortalityByFlock;
import com.tta.broilers.entities.rest.MortalityByhouseLastDays;
import com.tta.broilers.entities.rest.WeeklyWeightMesurementByFlock;
import com.tta.broilers.entities.rest.WeightByBreed;
import com.tta.broilers.entities.rest.WeightByFlock;
import com.tta.broilers.mappers.AlertByFarmRowMapper;
import com.tta.broilers.mappers.AlertByHouseRowMapper;
import com.tta.broilers.mappers.FlockDashRowMapper;
import com.tta.broilers.mappers.FlockOutResultRowMapper;
import com.tta.broilers.mappers.FlockRowMapper;
import com.tta.broilers.mappers.MortalityByFlockRowMapper;
import com.tta.broilers.mappers.MortalityByHouseLastDaysRowMapper;
import com.tta.broilers.mappers.MortalityByfarmRowMapper;
import com.tta.broilers.mappers.WeeklyWeightMesurementByFlockRowMapper;
import com.tta.broilers.mappers.WeeklyweightMesurementRowMapper;
import com.tta.broilers.mappers.WeightByFlockRowMapper;
import com.tta.broilers.mappers.WeightPerBreedRowMapper;

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
		return jdbcTemplate.query("SELECT visittasks.measure , visit_Date\r\n"
				+ "			FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "			join house on house.house_id = visit.house_id \r\n"
				+ "			join flock on flock.house_id = house.house_id\r\n"
				+ "			WHERE visit.house_id=? and visittasks.task_id=6 and flock.check_end_of_cycle=false\r\n"
				+ "			ORDER BY visit_Date DESC\r\n"
				+ "			LIMIT 7",new Object[] {houseId }, new MortalityByHouseLastDaysRowMapper() );
	}

	@Override
	public List<MortalityByhouseLastDays> geWeightByhouseOfLastDays(String houseId) {
		return jdbcTemplate.query("SELECT visittasks.measure , visit_Date\r\n"
				+ "			FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "			join house on house.house_id = visit.house_id \r\n"
				+ "			join flock on flock.house_id = house.house_id\r\n"
				+ "			WHERE visit.house_id=? and visittasks.task_id=11 and flock.check_end_of_cycle=false\r\n"
				+ "			ORDER BY visit_Date DESC\r\n"
				+ "			LIMIT 7",new Object[] {houseId }, new MortalityByHouseLastDaysRowMapper() );
	}

	@Override
	public List<MortalityByhouseLastDays> getWaterByhouseOfLastDays(String houseId) {
		return jdbcTemplate.query("SELECT visittasks.measure , visit_Date\r\n"
				+ "			FROM public.visit join visittasks on visittasks.visit_id = visit.visit_id\r\n"
				+ "			join house on house.house_id = visit.house_id \r\n"
				+ "			join flock on flock.house_id = house.house_id\r\n"
				+ "			WHERE visit.house_id=? and visittasks.task_id=7 and flock.check_end_of_cycle=false\r\n"
				+ "			ORDER BY visit_Date DESC\r\n"
				+ "			LIMIT 7",new Object[] {houseId }, new MortalityByHouseLastDaysRowMapper() );
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
	public List<MortalityByFarm> getTotalFeedConsumByFarm(String companyId) {
		return jdbcTemplate.query("SELECT weekly_feed.farm_id, (sum(total_starter_feed)+sum(total_grower_feed)+ sum(total_finisher_feed)) as percentage\r\n"
				+ "	FROM public.weekly_feed join flock on flock.flock_id = weekly_feed.flock_id\r\n"
				+ "	join farm on farm.farm_id = weekly_feed.farm_id\r\n"
				+ "	where flock.check_end_of_cycle=false and farm.company_id=?\r\n"
				+ "	group by weekly_feed.farm_id",new Object[] {companyId }, new MortalityByfarmRowMapper() );
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
		return jdbcTemplate.query("SELECT week, weekly_weight_measurement.flock_id ,average \r\n"
				+ "	FROM public.weekly_weight_measurement join flock on flock.flock_id = weekly_weight_measurement.flock_id\r\n"
				+ "	where weekly_weight_measurement.house_id=? and EXTRACT(YEAR From hatch_date)=?\r\n"
				+ "	group by weekly_weight_measurement.flock_id , week, average, weekly_weight_measurement.creation_date\r\n"
				+ "	ORDER BY week, weekly_weight_measurement.flock_id ASC;",
				new Object[] {HouseId, year }, new WeeklyWeightMesurementByFlockRowMapper());
	}

	@Override
	public List<WeeklyWeightMesurementByFlock> getfeedByFlock(String HouseId, int year) {
		return jdbcTemplate.query("SELECT weekly_feed.flock_id, week, (sum(total_starter_feed)+sum(total_grower_feed)+ sum(total_finisher_feed)) as average\r\n"
				+ "	FROM public.weekly_feed JOIN flock on flock.flock_id = weekly_feed.flock_id\r\n"
				+ "	where weekly_feed.house_id=?and EXTRACT(YEAR From hatch_date)=?\r\n"
				+ "	group by weekly_feed.flock_id , week;",
				new Object[] {HouseId, year }, new WeeklyWeightMesurementByFlockRowMapper());
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

	

	

	

	
	
}
