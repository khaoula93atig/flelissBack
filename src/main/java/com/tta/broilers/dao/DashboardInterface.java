package com.tta.broilers.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.AlertByFarm;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.WeightByBreed;

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
	
	
	
	
	
//travail emna 
	public List<FlockWeight> findWeightByFlock(String flock_id);

	public List<Farm> getById(String id);


	public long countAll();
	public String getCompanyName(String companyId);
	public  ArrayList<WeightByBreed> getWeightperBreed(String centerID);
	


}
