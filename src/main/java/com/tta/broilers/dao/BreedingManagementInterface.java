package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.BreedingManagement;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface BreedingManagementInterface {


	List<BreedingManagement> findAll();
	List<BreedingManagement> getByFarm(String farm);
	BasicResponse save(BreedingManagement breedingManagement);
	BasicResponse saveObject(BreedingManagement breedingManagement);
	BasicResponse update(BreedingManagement breedingManagement);
	List<BreedingManagement> getById(String string);
}
