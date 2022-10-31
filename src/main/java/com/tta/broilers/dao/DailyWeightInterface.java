package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.DailyWeight;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface DailyWeightInterface  {
	
	List<DailyWeight> findAll();
	List<DailyWeight> getByBreed(int breed);
	String getWeeklyWeight(double weeklyWeight, int week, int breed);
	BasicResponse save(DailyWeight dailyWeight);
	void insertFromFile(int breed) throws Exception ;
	DailyWeight getByWeek(int week);
	DailyWeight getByAgeDays(int ageDays, int breed);
//	BasicResponse update(DailyWeight dailyWeight);

}
