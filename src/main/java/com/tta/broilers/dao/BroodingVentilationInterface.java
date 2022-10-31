package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.BroodingVentilation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface BroodingVentilationInterface  {
	
	List<BroodingVentilation> findAll();
	List<BroodingVentilation> getByBreed(int breed);
	BasicResponse save(BroodingVentilation broodingVentilation);
	BroodingVentilation getByWeek(int week);


}
