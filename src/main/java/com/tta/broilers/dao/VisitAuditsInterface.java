package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.VisitAudits;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface VisitAuditsInterface {

	List<VisitAudits> findAll();

	List<VisitAudits> getByVisitId(String visitId);

	List<VisitAudits> getById(String visitId, int breedingManagementId);

	BasicResponse save(VisitAudits visitAudits);

	BasicResponse update(VisitAudits visitAudits);

}
