package com.tta.broilers.dao;

import java.util.List;


import com.tta.broilers.entities.Company;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface CompanyInterface  {
	
	public List<Company> findAll();
	public List<Company> getById(String id);
	public BasicResponse save(Company company);
	public BasicResponse update(Company company);
	public long countAll();

}
