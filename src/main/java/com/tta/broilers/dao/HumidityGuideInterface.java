package com.tta.broilers.dao;

import java.util.List;


import com.tta.broilers.entities.HumidityGuide;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface HumidityGuideInterface  {
	
	List<HumidityGuide> findAll();
	List<HumidityGuide> getByBreed(int breed);
	BasicResponse save(HumidityGuide HumidityGuide);
	HumidityGuide getByWeek(int week);
//	BasicResponse update(AirQualityGuidelines airQualityGuidelines);

}
