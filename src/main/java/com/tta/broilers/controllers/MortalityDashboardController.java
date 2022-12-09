package com.tta.broilers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.tta.broilers.dao.MortalityDashboardInterface;
import com.tta.broilers.entities.rest.MortalityByBreed;
import com.tta.broilers.entities.rest.MortalityByCenter;
import com.tta.broilers.entities.rest.MortalityByFarm;
import com.tta.broilers.entities.rest.MortalityByHouse;

@RestController
@RequestMapping("/mortalitedashboard")
public class MortalityDashboardController {
	@Autowired
	MortalityDashboardInterface mortalitedashboard;
	
	@GetMapping("/breed/{company}")
	public List<MortalityByBreed> getMortalityByBreed(@PathVariable("company") String companyId){
		return mortalitedashboard.getMortalityByBreed(companyId);
	}

	@GetMapping("/farm/{task}/{date}/{company}")
	public List<MortalityByFarm> getBreedByMortality(@PathVariable("task") int task,@PathVariable("date") String date,@PathVariable("company") String companyId) throws ParseException{
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(date);
		return mortalitedashboard.getPercentagMortalityByFarm(task, date1, companyId);
	}
	@GetMapping("/farmgeneral/{company}")
	public List<MortalityByFarm> getBreedByMortalitygeneral(@PathVariable("company") String companyId) throws ParseException{
		return mortalitedashboard.getPercentagMortalityByFarmGeneral(companyId);
	}
	
	@GetMapping("/center/{farm}")
	public List<MortalityByCenter> getPercentageMortalityByCenter(@PathVariable("farm") String farmId){
		return mortalitedashboard.getPercentageMortalityByCenter(farmId);
	}
	
	@GetMapping("/house/{center}")
	public List<MortalityByHouse> getPercentageMortalityByHouse(@PathVariable("center") String centerId){
		return mortalitedashboard.getPercentageMortalityByHouse(centerId);
	}
	
	@GetMapping("/company/{company}")
	public double getMortalityByCompany(@PathVariable("company") String companyId){
		return mortalitedashboard.getMortalityByCompany(companyId);
	}
	
	@GetMapping("/company/survival/{company}")
	public double getSurvivalByCompany(@PathVariable("company") String companyId){
		return mortalitedashboard.getSurvivalByCompany(companyId);
	}
	
	@GetMapping("/farm/survival/{farm}")
	public double getSurvivalByFarm(@PathVariable("farm") String farmId){
		return mortalitedashboard.getSurvivalByFarm(farmId);
	}
	
}
