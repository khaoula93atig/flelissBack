package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.VisitHealthStatus;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface VisitHealthStatusInterface {

	List<VisitHealthStatus> findAll();

	List<VisitHealthStatus> getByVisitId(String visitId);

	List<VisitHealthStatus> getById(String visitId, int healthStatusId);

	BasicResponse save(VisitHealthStatus visitHealthStatus);

	BasicResponse update(VisitHealthStatus visitHealthStatus);

}
