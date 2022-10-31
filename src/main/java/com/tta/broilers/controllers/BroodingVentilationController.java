package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.BroodingVentilationInterface;
import com.tta.broilers.entities.BroodingVentilation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/broodingVentilation")
public class BroodingVentilationController {

	@Autowired
	BroodingVentilationInterface broodingVentilationInterface;

	@GetMapping
	public List<BroodingVentilation> findAll() {

		return broodingVentilationInterface.findAll();
	}

 

	@PostMapping("/save")
	public BasicResponse save(@RequestBody BroodingVentilation broodingVentilation) {
		return broodingVentilationInterface.save(broodingVentilation);
	}

}
