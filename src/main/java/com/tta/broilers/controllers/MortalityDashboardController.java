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
import com.tta.broilers.entities.rest.MortalityByFarm;

@RestController
@RequestMapping("/mortalitedashboard")
public class MortalityDashboardController {
	@Autowired
	MortalityDashboardInterface mortalitedashboard;
	
	@GetMapping
	public List<MortalityByBreed> getMortalityByBreed(){
		return mortalitedashboard.getMortalityByBreed();
	}

	@GetMapping("/farm/{task}/{date}/{center}")
	public List<MortalityByFarm> getBreedByMortality(@PathVariable("task") int task,@PathVariable("date") String date,@PathVariable("center") String center_id) throws ParseException{
		DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sourceFormat.parse(date);
		System.out.println(date1);
		return mortalitedashboard.getPercentagMortalityByFarm(task, date1, center_id);
	}
}
