package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.Center;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface CenterInterface {

	public List<Center> findAll();

	public List<Center> getById(String id);
	public List<Center> getByFarmId(String id);
	public BasicResponse save(Center farm);

	public BasicResponse update(Center farm);

	public long countAll();


	public String getFarmName(String farmId);

	public List<Center> findCentersByRole(int roleID , String farmId , String companyId);
	
	
}
