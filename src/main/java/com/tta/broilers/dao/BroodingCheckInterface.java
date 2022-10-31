package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.BroodingCheck;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */

public interface BroodingCheckInterface  {
	
	List<BroodingCheck> findAll();
	List<BroodingCheck> getByBreed(int breed);
	BasicResponse save(BroodingCheck broodingCheck);
	BroodingCheck getByWeek(int week);


}
