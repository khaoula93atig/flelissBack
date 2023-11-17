package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.VisitNecropsyObservation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface VisitNecropsyObservationInterface {

	List<VisitNecropsyObservation> findAll();

	List<VisitNecropsyObservation> getByVisitId(String visitId);

	List<VisitNecropsyObservation> getById(String visitId, int necropsyId);

	VisitNecropsyObservation save(VisitNecropsyObservation visitNecropsyObservation);

	BasicResponse update(VisitNecropsyObservation visitNecropsyObservation);

}
