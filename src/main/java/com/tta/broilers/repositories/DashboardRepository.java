package com.tta.broilers.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.DashboardInterface;
import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.AlertByFarm;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.WeightByBreed;
import com.tta.broilers.entities.rest.WeightByFlock;
import com.tta.broilers.mappers.AlertByFarmRowMapper;
import com.tta.broilers.mappers.FlockRowMapper;
import com.tta.broilers.mappers.MortalityByfarmRowMapper;
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

		// FlockWeight FlockWeight2=new FlockWeight();
		List<FlockWeight> newList = new ArrayList<FlockWeight>();

		/*for ( int  i = 0; i < weightByFlock.size() - 1; i++) {
			FlockWeight flockWeight = null;
			if (i == 0) {

				flockWeight = new FlockWeight();
				List<Integer> ageFlock = new ArrayList<>();
				List<Double> weight = new ArrayList<>();
				flockWeight.setFlockID(weightByFlock.get(i).getFlockID());
				flockWeight.setHouseID(weightByFlock.get(i).getHouseID());
				flockWeight.setCenterID(weightByFlock.get(i).getCenterID());
				ageFlock.add(weightByFlock.get(i).getAgeFlock());
				weight.add(weightByFlock.get(i).getWeight());
				flockWeight.setAgeFlock(ageFlock);
				flockWeight.setWeight(weight);
				newList.add(flockWeight);

			} else {
				if (!weightByFlock.get(i).getFlockID().equals(weightByFlock.get(i - 1).getFlockID())) {
					flockWeight = new FlockWeight();
					List<Integer> ageFlock = new ArrayList<>();
					List<Double> weight = new ArrayList<>();
					flockWeight.setFlockID(weightByFlock.get(i).getFlockID());
					flockWeight.setHouseID(weightByFlock.get(i).getHouseID());
					flockWeight.setCenterID(weightByFlock.get(i).getCenterID());
					ageFlock.add(weightByFlock.get(i).getAgeFlock());
					weight.add(weightByFlock.get(i).getWeight());
					flockWeight.setAgeFlock(ageFlock);
					flockWeight.setWeight(weight);
				} else {
					final int j=i;
					 flockWeight = newList.stream()
							  .filter(f -> weightByFlock.get(j).getFlockID().equals(f.getFlockID()))
							  .findAny()
							  .orElse(null);
					 
					List<Integer> ageFlock = flockWeight.getAgeFlock();
					List<Double> weight = flockWeight.getWeight();
					ageFlock.add(weightByFlock.get(i).getAgeFlock());
					weight.add(weightByFlock.get(i).getWeight());
					flockWeight.setAgeFlock(ageFlock);
					flockWeight.setWeight(weight);

				}
			}
			
		
			newList.add(flockWeight);
			
			
		
		}*/

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

	
	
}
