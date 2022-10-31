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

import com.tta.broilers.dao.VisitHealthStatusInterface;
import com.tta.broilers.entities.VisitHealthStatus;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/VisitHealthStatus")
public class VisitHealthStatusController {

	@Autowired
	VisitHealthStatusInterface visitHealthStatusInterface;

	@GetMapping
	public List<VisitHealthStatus> findAll() {

		return visitHealthStatusInterface.findAll();
	}

	@GetMapping("/{visitId}")
	public List<VisitHealthStatus> getByVisitId(@PathVariable("visitId") String visitId) {

		return visitHealthStatusInterface.getByVisitId(visitId);
		
	}
	
	@GetMapping("/{visitId}/{necropsyId}")
	public List<VisitHealthStatus> findByID(@PathVariable("visitId") String visitId, @PathVariable("necropsyId") int necropsyId) {

		return visitHealthStatusInterface.getById(visitId, necropsyId);
		
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody VisitHealthStatus visitHealthStatus) {
		return visitHealthStatusInterface.save(visitHealthStatus);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody VisitHealthStatus visitHealthStatus) {
		return visitHealthStatusInterface.update(visitHealthStatus);
	}

}
