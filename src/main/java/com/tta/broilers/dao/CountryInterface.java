package com.tta.broilers.dao;

import java.io.IOException;
import java.util.List;

import com.tta.broilers.entities.Country;

public interface CountryInterface {

	
	public List<Country> findAll();
	public void setFromFile() throws IOException;
	public void save(Country country);
}

