package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.FlockInterface;
import com.tta.broilers.entities.Flock;
import com.tta.broilers.entities.rest.FlockTechnicalReport;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 * 
 */
@RestController
@RequestMapping("/flock")
public class FlockController {

	@Autowired
	FlockInterface flockInterface;

	@GetMapping
	public List<Flock> findAll() {

		return flockInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<Flock> findByID(@PathVariable("id") String id) {

		return flockInterface.getById(id);
	}
	@GetMapping("/house/{houseID}")
	public List<Flock> findByHouseID(@PathVariable("houseID") String houseID) {

		return flockInterface.findByHouseID(houseID);
	}
	@GetMapping("/farm/{farmId}")
	public List<Flock> findByFarmid(@PathVariable("farmId") String farmId) {

		return flockInterface.findByfarmId(farmId);
	}
	@PostMapping("/save")
	public BasicResponse save(@RequestBody Flock flock) {
		return flockInterface.save(flock);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Flock flock) {
		return flockInterface.update(flock);
	}
	@PutMapping("/updateRestNumberFlock/{flockID}/{restFlockNumber}")
	public BasicResponse updateRestNumberFlock(@PathVariable ("flockID") String flockID,@PathVariable ("restFlockNumber") int restFlockNumber) {
		return flockInterface.updateRestNumberFlock( flockID , restFlockNumber);
	}
	
	@GetMapping("/report/{flockID}")
	public FlockTechnicalReport getreportFlock(@PathVariable("flockID") String flockID) {

		return flockInterface.getreportFlock(flockID);
	}
}
