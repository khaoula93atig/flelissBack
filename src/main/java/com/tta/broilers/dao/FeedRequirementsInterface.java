package com.tta.broilers.dao;

import com.tta.broilers.entities.FeedRequirements;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface FeedRequirementsInterface  {
	
//	List<AirQualityGuidelines> findAll();
//	List<AirQualityGuidelines> getByBreed(int breed);
	BasicResponse save(FeedRequirements feedRequirements);
	void insertFromFile(int breed) throws Exception;
//	BasicResponse update(AirQualityGuidelines airQualityGuidelines);

}
