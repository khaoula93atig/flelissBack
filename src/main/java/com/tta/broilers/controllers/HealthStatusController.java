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

import com.tta.broilers.dao.HealthStatusInterface;
import com.tta.broilers.entities.HealthStatus;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/healthStatus")
public class HealthStatusController {

	@Autowired
	HealthStatusInterface healthStatusInterface;

	@GetMapping
	public List<HealthStatus> findAll() {

		return healthStatusInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<HealthStatus> findByID(@PathVariable("id") int id) {

		return healthStatusInterface.getById(id);
	}
	@PostMapping("/save")
	public BasicResponse save(@RequestBody HealthStatus HealthStatus) {
		return healthStatusInterface.save(HealthStatus);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody HealthStatus healthStatus) {
		return healthStatusInterface.update(healthStatus);
	}

}
