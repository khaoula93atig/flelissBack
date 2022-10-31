package com.tta.broilers.dao;

import java.util.List;


import com.tta.broilers.entities.Breed;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface BreedInterface  {
	
	public List<Breed> findAll();
	public List<Breed> getById(int id);
	public BasicResponse save(Breed breed);
	public BasicResponse update(Breed breed);
 

}
