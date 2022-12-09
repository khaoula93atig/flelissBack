package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.Farm;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
public interface FarmInterface {

	public List<Farm> findAll();

	public List<Farm> getByCompanyId(String id);
	public List<Farm> getByFarmId(String id);

	public BasicResponse save(Farm farm);

	public BasicResponse update(Farm farm);

	public long countAll();
	public String getCompanyName(String companyId);
	

}
