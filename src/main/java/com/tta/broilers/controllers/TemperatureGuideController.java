package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.TemperatureGuideInterface;
import com.tta.broilers.entities.TemperatureGuide;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/temperatureGuide")
public class TemperatureGuideController {

	@Autowired
	TemperatureGuideInterface temperatureGuideInterface;

	@GetMapping
	public List<TemperatureGuide> findAll() {

		return temperatureGuideInterface.findAll();
	}

 

	@PostMapping("/save")
	public BasicResponse save(@RequestBody TemperatureGuide temperatureGuide) {
		return temperatureGuideInterface.save(temperatureGuide);
	}

}
