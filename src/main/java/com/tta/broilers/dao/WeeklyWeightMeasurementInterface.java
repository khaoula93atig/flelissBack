package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.WeeklyWeightForChart;
import com.tta.broilers.entities.rest.WeeklyweightStandardByBreedAndAge;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface WeeklyWeightMeasurementInterface  {
	
	List<WeeklyWeightMeasurement> findAll();
	
	BasicResponse save(WeeklyWeightMeasurement weeklyWeightMeasurement);
	String checkStandard(int breed ,int week, double measure);
	List<WeeklyWeightForChart> getWeekWeightForChart(String farm, String flock, int breed);
	List<WeeklyweightStandardByBreedAndAge> getWeeklyWeightStandardByAgeAndBreed(int breed);

}
