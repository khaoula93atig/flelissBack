package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.House;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface HouseInterface {

	public List<House> findAll();

	public List<House> findById(String id);

	public List<House> findByFarmID(String farmID);
	public List<House> getHousesByCenter(String centerId);
	public BasicResponse save(House house);

	public BasicResponse update(House house);
	public String  getCenterName(String centerId);
	public long countAll();
}
