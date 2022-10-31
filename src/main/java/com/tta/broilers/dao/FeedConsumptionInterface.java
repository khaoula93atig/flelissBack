package com.tta.broilers.dao;

import com.tta.broilers.entities.FeedConsumption;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface FeedConsumptionInterface  {
	
//	List<FeedConsumption> findAll();
//	List<FeedConsumption> getByBreed(int breed);
	BasicResponse save(FeedConsumption feedConsumption);
	void insertFromFile(int breed) throws Exception;
//	BasicResponse update(FeedConsumption feedConsumption);
	FeedConsumption getByAgeDays(int ageDays);

}
