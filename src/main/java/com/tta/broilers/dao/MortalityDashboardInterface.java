package com.tta.broilers.dao;

import java.util.Date;
import java.util.List;

import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByFarm;

public interface MortalityDashboardInterface {
	
	public List<MortalityByBreed> getMortalityByBreed();
	public List<MortalityByFarm> getPercentagMortalityByFarm(int task,Date visitDate,String centerId);

}
