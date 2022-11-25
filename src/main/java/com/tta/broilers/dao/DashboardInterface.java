package com.tta.broilers.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tta.broilers.entities.Farm;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.WeightByBreed;

/**
 * @author EMNA
 *
 */
public interface DashboardInterface {

	public List<FlockWeight> findWeightByFlock(String flock_id);

	public List<Farm> getById(String id);


	public long countAll();
	public String getCompanyName(String companyId);
	public  ArrayList<WeightByBreed> getWeightperBreed(String centerID);
	


}
