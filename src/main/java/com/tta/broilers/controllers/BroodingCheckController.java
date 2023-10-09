package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.BroodingCheckInterface;
import com.tta.broilers.entities.BroodingCheck;
import com.tta.broilers.entities.ChickReception;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/broodingCheck")
public class BroodingCheckController {

	@Autowired
	BroodingCheckInterface broodingCheckInterface;

	@GetMapping
	public List<BroodingCheck> findAll() {

		return broodingCheckInterface.findAll();
	}

 

	@PostMapping("/save")
	public BasicResponse save(@RequestBody BroodingCheck broodingCheck) {
		return broodingCheckInterface.save(broodingCheck);
	}
	
	@GetMapping("/getByFarm/{farm}")
	public List<BroodingCheck> findByFarm(@PathVariable String farm) {

		return broodingCheckInterface.getByFarm(farm);
	}

}
