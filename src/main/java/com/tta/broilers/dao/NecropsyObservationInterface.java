package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.NecropsyObservation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface NecropsyObservationInterface  {
	
	List<NecropsyObservation> findAll();
	List<NecropsyObservation> getById(int id);
	BasicResponse save(NecropsyObservation necropsyObservation);
	BasicResponse update(NecropsyObservation necropsyObservation);

}
