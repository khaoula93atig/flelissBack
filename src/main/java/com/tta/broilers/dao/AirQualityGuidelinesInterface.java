package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.AirQualityGuidelines;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface AirQualityGuidelinesInterface  {
	
	List<AirQualityGuidelines> findAll();
	List<AirQualityGuidelines> getByBreed(int breed);
	AirQualityGuidelines getByElement(String element);
	BasicResponse save(AirQualityGuidelines airQualityGuidelines);
//	BasicResponse update(AirQualityGuidelines airQualityGuidelines);

}
