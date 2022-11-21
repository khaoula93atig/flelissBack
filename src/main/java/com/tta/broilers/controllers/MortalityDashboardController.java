package com.tta.broilers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.tta.broilers.dao.MortalityDashboardInterface;
import com.tta.broilers.entities.rest.MortalityByBreed;

@RestController
@RequestMapping("/mortalitedashboard")
public class MortalityDashboardController {
	@Autowired
	MortalityDashboardInterface mortalitedashboard;
	
	@GetMapping
	public List<MortalityByBreed> getBreedByMortality(){
		return mortalitedashboard.getMortalityByBreed();
	}

}
