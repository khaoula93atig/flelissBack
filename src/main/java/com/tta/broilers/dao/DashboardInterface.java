package com.tta.broilers.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.AlertByFarm;
import com.tta.broilers.entities.rest.AlertByHouse;
import com.tta.broilers.entities.rest.FlockOutResult;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.MortalityByFlock;
import com.tta.broilers.entities.rest.MortalityByhouseLastDays;
import com.tta.broilers.entities.rest.WeeklyWeightMesurementByFlock;
import com.tta.broilers.entities.rest.WeightByBreed;
import com.tta.broilers.mappers.WeeklyweightMesurementRowMapper;

/**
 * @author EMNA
 *
 */
public interface DashboardInterface {
	
	//travail khaoula
	
	public List<WeeklyWeightMeasurement> weeklyweightByCompanyForFarms(String companyId);
	public List<WeeklyWeightMeasurement> weeklyweightBycenterforFarm(String farmId);
	public List<WeeklyWeightMeasurement> weeklyweightByHouseforCenter(String centerId);
	public List<AlertByFarm> getAllAlertByFarm(Date visitDate, String farmId);
	public List<AlertByHouse> getAlertByHouse(Date visitDate , String houseId);
	public double getFeedConsumtionDialy(Date visitDate , String houseId);
	public double getFeedConsumtionTotal(Date visitDate , String houseId);
	public List<MortalityByhouseLastDays> getFeedByhouseOfLastDays(String houseId);
	public List<MortalityByhouseLastDays> geWeightByhouseOfLastDays(String houseId);
	public List<MortalityByhouseLastDays> getWaterByhouseOfLastDays(String houseId);
	public double getWaterConsumtionDialy(Date visitDate , String houseId);
	public double getWaterConsumtionTotal(Date visitDate , String houseId);
	public double getWeightMesurementDialy(Date visitDate , String houseId);
	public double getCVMesurementTotal(Date visitDate , String houseId);
	public List<MortalityByFarm> getTotalFeedConsumByFarm(String companyId ,Date visitDate);
	public List<Flock> getFlocksByHouseAndYear(String HouseId, int year);
	public List<WeeklyWeightMesurementByFlock> getWeightByFlock(String HouseId, int year);
	public List<WeeklyWeightMesurementByFlock> getfeedByFlock(String HouseId, int year);
	public List<MortalityByFlock> getWaterByFlock(String HouseId,Date visitDate , int year);
	public List<FlockOutResult> getFlockOutResultOfBadyWeight(String companyId);
	
	
	
	
//travail emna 
	public List<FlockWeight> findWeightByFlock(String flock_id);

	public List<Farm> getById(String id);


	public long countAll();
	public String getCompanyName(String companyId);
	public  ArrayList<WeightByBreed> getWeightperBreed(String centerID);
	


}
