package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.FlockInterface;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.VisitTasks;
import com.tta.broilers.entities.WeeklyFeed;
import com.tta.broilers.entities.rest.FlockTechnicalReport;
import com.tta.broilers.mappers.FlockReportRowMapper;
import com.tta.broilers.mappers.FlockRowMapper;
import com.tta.broilers.mappers.VisitTasksRowMapper;
import com.tta.broilers.mappers.WeeklyFeedRowMapper;
import com.tta.broilers.responses.BasicResponse;
import com.tta.broilers.utils.Utils;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class FlockRepository implements FlockInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Flock> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
				"select * from flock left join house on flock.house_id=house.house_id left join farm on house.farm_id=farm.farm_id left join breed on flock.breed=breed.breed_id",
				new FlockRowMapper());

	}

	@Override
	public BasicResponse save(Flock flock) {
		try {
			System.out.println(flock.toString());

			flock.setCreationDate(new Date());
			flock.setHatchDate(Utils.SMPDF4.parse(flock.getHatchDateString()));
			flock.setStartOfCycle(Utils.SMPDF4.parse(flock.getStartOfCycleString()));
			flock.setFlockID(flock.getHouseId() + "-" + Utils.SMPDF2.format(flock.getStartOfCycle()));
			flock.setRestFlockNumber(flock.getFlockNumber());
			jdbcTemplate.update("INSERT INTO flock(" + " flock_id,flock_name,house_id, breed, cycle, start_of_cycle,"
					+ " ps_origin,           hatch_date, chiked_placed, creation_date,farm_id,flock_number,check_end_of_cycle,rest_flock_number)"
					+ "    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?);", flock.getFlockID(), flock.getFlockName(),
					flock.getHouseId(), flock.getBreed(), flock.getCycle(), flock.getStartOfCycle(),
					flock.getPsOrigin(), flock.getHatchDate(), flock.getChikedPlaced(), flock.getCreationDate(),flock.getFarmId(),
					flock.getFlockNumber(), flock.isCheckEndOfCycle(), flock.getRestFlockNumber());

			return new BasicResponse("Flock created: " + flock.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Flock flock) {
		System.out.println("flock to update " + flock);

		try {
			List<Flock> toUpdate = getById(flock.getFlockID());
			flock.setHatchDate(Utils.SMPDF4.parse(flock.getHatchDateString()));
			flock.setStartOfCycle(Utils.SMPDF4.parse(flock.getStartOfCycleString()));
			flock.setCreationDate(new Date());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE flock\r\n"
								+ "   SET breed=?,flock_name=?, cycle=?, start_of_cycle=?, hatch_date=?, \r\n"
								+ "       chiked_placed=?, ps_origin=?, \r\n"
								+ "     flock_number=?, check_end_of_cycle=?, creation_date=? , end_of_cycle=?\r\n"
								+ " WHERE flock_id =?;",
						flock.getBreed(), flock.getFlockName(), flock.getCycle(), flock.getStartOfCycle(),
						flock.getHatchDate(), flock.getChikedPlaced(), flock.getPsOrigin(), flock.getFlockNumber(),
						flock.isCheckEndOfCycle(), flock.getCreationDate(), flock.getEndOfCycle(), flock.getFlockID());
				return new BasicResponse("Flock updated: " + flock.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Flock> getById(String id) {

		return jdbcTemplate.query(
				"select * from flock  left join house on flock.house_id=house.house_id left join farm on house.farm_id=farm.farm_id left join breed on flock.breed=breed.breed_id where flock_id=?",
				new Object[] { id }, new FlockRowMapper());
	}

	@Override
	public List<Flock> findByHouseID(String houseID) {
		return jdbcTemplate.query(
				"select * from flock left join house on flock.house_id=house.house_id left join farm on house.farm_id=farm.farm_id left join breed on flock.breed=breed.breed_id where flock.house_id=?",
				new Object[] { houseID }, new FlockRowMapper());

	}

	@Override
	public BasicResponse updateRestNumberFlock(String FlockID, int restFlockNumber) {

		try {
			List<Flock> toUpdate = getById(FlockID);
			System.out.println(toUpdate);
			System.out.println(restFlockNumber);
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update("UPDATE flock\r\n" + "SET rest_flock_number=? WHERE flock_id =?;", restFlockNumber,
						FlockID);
				return new BasicResponse("Flock updated: ", HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public FlockTechnicalReport getreportFlock(String flockID) {
		
		List<FlockTechnicalReport> result = jdbcTemplate.query("\r\n"
				+ "select farm.farm_name,house.area,house.house_name,flock.flock_number, flock.start_of_cycle , flock.end_of_cycle ,flock.rest_flock_number,\r\n"
				+ " flock.cycle ,center.center_name,( flock.flock_number- flock.rest_flock_number)as totalMortality , breed.description as breed from farm , center,house ,\r\n"
				+ " flock , breed where farm.farm_id=center.farm_id and center.center_id=house.center_id and flock.flock_id=? and\r\n"
				+ " house.house_id=flock.house_id and flock.breed=breed.breed_id",
				new Object[] { flockID }, new FlockReportRowMapper());

		System.out.println("result " + result.toString());

		List<WeeklyFeed> result2 = jdbcTemplate.query("\r\n"
				+ "select sum(total_starter_feed)as sum_total_starter_feed ,sum(total_grower_feed)as sum_total_grower_feed ,sum(total_finisher_feed)as sum_total_finisher_feed ,\r\n"
				+ "sum(starter_feed_per_bird)as sum_starter_feed_per_bird,sum(grower_feed_per_bird)as sum_grower_feed_per_bird ,sum(finisher_feed_bird)as sum_finisher_feed_bird\r\n"
				+ " from weekly_feed where flock_id=?", new Object[] { flockID }, new WeeklyFeedRowMapper());
		System.out.println("result2 " + result.get(0).getFarmName());
		
		double totalweight = jdbcTemplate.queryForObject(
				" \r\n"
				+ "select measure from visittasks, visit where visittasks.visit_id=visit.visit_id and visit.flock_id=? and visittasks.task_id=11 order by visittasks.creation_date  desc limit 1",
				new Object[] { flockID }, double.class);
		
		double totalFeed = jdbcTemplate.queryForObject(
				"select  sum(measure ) from visittasks, visit where visittasks.visit_id=visit.visit_id and visit.flock_id=?  and visittasks.task_id=6 ",
				new Object[] { flockID }, double.class);
		double mortality1Week = jdbcTemplate.queryForObject(
				"select sum(measure) from visittasks, visit where visittasks.visit_id=visit.visit_id and visit.flock_id=? and visittasks.task_id=8 and visit.age_flock<=7 ",
				new Object[] { flockID }, double.class);
		
		System.out.println("Totalweight " + totalweight);
		System.out.println("mortality1Week " + mortality1Week);
		
		FlockTechnicalReport flockTechnicalReport = new FlockTechnicalReport();
		flockTechnicalReport.setFarmName(result.get(0).getFarmName());
		flockTechnicalReport.setCenterName(result.get(0).getCenterName());
		flockTechnicalReport.setHouseArea(result.get(0).getHouseArea());
		flockTechnicalReport.setFlockNumber(result.get(0).getFlockNumber());
		flockTechnicalReport.setStartOfCycle(result.get(0).getStartOfCycle());
		flockTechnicalReport.setEndOfCycle(result.get(0).getEndOfCycle());
		flockTechnicalReport.setRestFlockNumber(result.get(0).getRestFlockNumber());
		flockTechnicalReport.setCycle(result.get(0).getCycle());
		flockTechnicalReport.setCenterName(result.get(0).getCenterName());
		flockTechnicalReport.setTotalMortality(result.get(0).getTotalMortality());
		flockTechnicalReport.setBreed(result.get(0).getBreed());
		flockTechnicalReport.setHouseName(result.get(0).getHouseName());
		flockTechnicalReport.setWeeklyFeed(result2.get(0));
		flockTechnicalReport.setTotalWeight(totalweight);

		flockTechnicalReport.setTotalFeedConsumption(totalFeed);

		return flockTechnicalReport;

	}

	@Override
	public List<Flock> findByfarmId(String farmId) {
		return jdbcTemplate.query(
				"select * from flock \r\n"
				+ "INNER JOIN house ON house.house_id = flock.house_id\r\n"
				+ "INNER JOIN breed ON breed.breed_id = flock.breed\r\n"
				+ "Inner Join farm on farm.farm_id = flock.farm_id\r\n"
				+ "where flock.farm_id=?;",
				new Object[] { farmId }, new FlockRowMapper());
	}

}
