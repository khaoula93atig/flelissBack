package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.HealthStatus;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface HealthStatusInterface  {
	
	List<HealthStatus> findAll();
	List<HealthStatus> getById(int id);
	BasicResponse save(HealthStatus healthStatus);
	BasicResponse update(HealthStatus healthStatus);

}
