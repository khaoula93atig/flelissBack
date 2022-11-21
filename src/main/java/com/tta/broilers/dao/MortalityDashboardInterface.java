package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.rest.MortalityByBreed;

public interface MortalityDashboardInterface {
	
	public List<MortalityByBreed> getMortalityByBreed();

}
