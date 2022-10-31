package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.TemperatureGuide;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface TemperatureGuideInterface  {
	
	List<TemperatureGuide> findAll();
	List<TemperatureGuide> getByBreed(int breed);
	BasicResponse save(TemperatureGuide temperatureGuide);
	TemperatureGuide getByWeek(int week);
//	BasicResponse update(AirQualityGuidelines airQualityGuidelines);

}
