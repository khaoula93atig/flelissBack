package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.WeeklyFeed;
import com.tta.broilers.entities.rest.FeedWeightweekly;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface WeeklyFeedInterface  {
	
	List<WeeklyFeed> findAll();
	
	BasicResponse save(WeeklyFeed WeeklyFeed);
	List<Long> getbyAgeAndFlock(int age , String flockId);

	List<FeedWeightweekly> getFeedWeightWeeklyByAgeAndFlock(int week , String flockId);
	

}
