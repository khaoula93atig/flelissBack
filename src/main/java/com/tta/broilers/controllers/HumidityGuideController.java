package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.HumidityGuideInterface;

import com.tta.broilers.entities.HumidityGuide;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/humidityGuide")
public class HumidityGuideController {

	@Autowired
	HumidityGuideInterface humidityGuideInterface;

	@GetMapping
	public List<HumidityGuide> findAll() {

		return humidityGuideInterface.findAll();
	}

 

	@PostMapping("/save")
	public BasicResponse save(@RequestBody HumidityGuide humidityGuide) {
		return humidityGuideInterface.save(humidityGuide);
	}

}
