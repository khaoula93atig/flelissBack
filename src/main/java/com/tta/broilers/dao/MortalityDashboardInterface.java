package com.tta.broilers.dao;

import java.util.Date;
import java.util.List;

import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByFarm;

public interface MortalityDashboardInterface {
	
	public List<MortalityByBreed> getMortalityByBreed(String companyId);
	
	//daily mesure of mortality by farm of one company
	public List<MortalityByFarm> getPercentagMortalityByFarm(int task,Date visitDate,String companyId);
	
	//general mesure of mortality by farm of one company
	public List<MortalityByFarm> getPercentagMortalityByFarmGeneral(String companyId);
	

}
