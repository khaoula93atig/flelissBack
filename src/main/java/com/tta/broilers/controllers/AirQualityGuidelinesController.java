package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.AirQualityGuidelinesInterface;
import com.tta.broilers.entities.AirQualityGuidelines;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/airQualityGuidelines")
public class AirQualityGuidelinesController {

	@Autowired
	AirQualityGuidelinesInterface airQualityGuidelinesInterface;

	@GetMapping
	public List<AirQualityGuidelines> findAll() {

		return airQualityGuidelinesInterface.findAll();
	}

 

	@PostMapping("/save")
	public BasicResponse save(@RequestBody AirQualityGuidelines airQualityGuidelines) {
		return airQualityGuidelinesInterface.save(airQualityGuidelines);
	}

}
