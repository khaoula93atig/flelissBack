package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.rest.FlockTechnicalReport;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface FlockInterface  {
	
	List<Flock> findAll();
	List<Flock> getById(String id);
	List<Flock>findByHouseID(String houseID);
	List<Flock>findByfarmId(String farmId);
	BasicResponse save(Flock flock);
	BasicResponse update(Flock flock);
	BasicResponse updateRestNumberFlock(String FlockID ,int restFlockNumber);
	FlockTechnicalReport getreportFlock(String flockId);
	List<Flock> findByHouseIDexisits(String houseID);
}
