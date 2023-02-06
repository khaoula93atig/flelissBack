package com.tta.broilers.dao;

import java.util.Date;
import java.util.List;

import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByCenter;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.MortalityByFlock;
import com.tta.broilers.entities.rest.MortalityByHouse;
import com.tta.broilers.entities.rest.MortalityByhouseLastDays;

public interface MortalityDashboardInterface {
	
	public List<MortalityByBreed> getMortalityByBreed(String companyId);
	
	//daily mesure of mortality by farm of one company
	public List<MortalityByFarm> getPercentagMortalityByFarm(int task,Date visitDate,String companyId);
	
	//general mesure of mortality by farm of one company
	public List<MortalityByFarm> getPercentagMortalityByFarmGeneral(String companyId);
	
	//mortality by center
	public List<MortalityByCenter> getPercentageMortalityByCenter(String farmId);
	
	//mortality by house
	public List<MortalityByHouse> getPercentageMortalityByHouse(String centerId);
	
	//mortality By company
	public double getMortalityByCompany(String companyId);
	
	//survival by company
	public double getSurvivalByCompany(String companyId);
	
	//survival by farm
	public double getSurvivalByFarm(String farmId);
	
	//Mortality By farm
	public double getMortalityByFarm(String farmId);

	//Mortality By House
	public double getMortalityByHouse(String houseId,Date visitdate);
	
	//survival by house
	public double getSurvivalByHouse(String houseId);
	
	//age of flock
	public int getAgeFlock(String houseId , Date date);
	
	//mortalite by house list of 7 last days 
	public List<MortalityByhouseLastDays> getMortalityOfLastdaysByhouse(String houseId);
	 //mortality by flock
	public List<MortalityByFlock> getMortalityByflock(String houseId,int year);
}
