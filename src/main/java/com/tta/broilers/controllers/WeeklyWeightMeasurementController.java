package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.WeeklyWeightMeasurementInterface;
import com.tta.broilers.entities.WeeklyWeightMeasurement;
import com.tta.broilers.entities.rest.WeeklyWeightForChart;
import com.tta.broilers.entities.rest.WeeklyweightStandardByBreedAndAge;
import com.tta.broilers.entities.rest.WeeklyweightbyNbreOfoiseaux;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@RestController
@RequestMapping("/WeeklyWeightMeasurement")
public class WeeklyWeightMeasurementController {

	@Autowired
	WeeklyWeightMeasurementInterface weeklyWeightMeasurementInterface;

	@GetMapping
	public List<WeeklyWeightMeasurement> findAll() {

		return weeklyWeightMeasurementInterface.findAll();
		
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody WeeklyWeightMeasurement weeklyWeightMeasurement) {
		return weeklyWeightMeasurementInterface.save(weeklyWeightMeasurement);
	}
	
	@GetMapping("/weeklyweightBybreed/{breed}/{flock}/{farm}")
	public List<WeeklyWeightForChart> getWeeklyWeightByBreed(@PathVariable("breed") int breed, @PathVariable("flock") String flock, @PathVariable("farm") String farm ){
		return weeklyWeightMeasurementInterface.getWeekWeightForChart(farm,flock,breed);
	}

	@GetMapping("/StandardWeeklyweightBybreed/{breed}")
	public List<WeeklyweightStandardByBreedAndAge> getStandardWeeklyWeightByBreed(@PathVariable("breed") int breed){
		return weeklyWeightMeasurementInterface.getWeeklyWeightStandardByAgeAndBreed(breed);
	}
	
	@GetMapping("/weeklyweightBynbreOiseau/{breed}/{flock}/{farm}/{week}")
	public List<WeeklyweightbyNbreOfoiseaux> getWeeklyWeightBynbreoiseaux(@PathVariable("breed") int breed, @PathVariable("flock") String flock,
			@PathVariable("farm") String farm ,@PathVariable("week") int week ){
		return weeklyWeightMeasurementInterface.getWeekWeighbyNbre(farm, flock, breed, week);
	}
	
	@GetMapping("/standardweight/{breed}/{age}")
	public long getWeightBybreedAndage(@PathVariable("breed") int breed ,@PathVariable("age") int age ){
		return weeklyWeightMeasurementInterface.getStandardWeightByBreedAndAge(breed, age);
	}
	
	@GetMapping("/weeklyWeightMesurementOfFlock/{flockId}")
	public List<WeeklyWeightMeasurement> getWeeklyWeightMesurementOfFlock(@PathVariable("flockId") String flockId) {

		return weeklyWeightMeasurementInterface.getweeklyweightOfFlocks(flockId);
		
	}
	
	@GetMapping("/weeklyWeightByFlockAndAge/{age}/{flockId}")
	public List<WeeklyWeightMeasurement> getWeeklyWeightMesurementByFlockAndage(@PathVariable("age") int age, @PathVariable("flockId") String flockId) {

		return weeklyWeightMeasurementInterface.getWeeklyWeightByFlockAndAge(age, flockId);
		
	}
	

}
