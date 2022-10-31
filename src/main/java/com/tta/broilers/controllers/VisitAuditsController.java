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

import com.tta.broilers.dao.VisitAuditsInterface;
import com.tta.broilers.entities.VisitAudits;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/VisitAudits")
public class VisitAuditsController {

	@Autowired
	VisitAuditsInterface visitAuditsInterface;

	@GetMapping
	public List<VisitAudits> findAll() {

		return visitAuditsInterface.findAll();
	}

	@GetMapping("/{visitId}")
	public List<VisitAudits> getByVisitId(@PathVariable("visitId") String visitId) {

		return visitAuditsInterface.getByVisitId(visitId);
		
	}
	
	@GetMapping("/{visitId}/{breedingManagementId}")
	public List<VisitAudits> findByID(@PathVariable("visitId") String visitId, @PathVariable("breedingManagementId") int breedingManagementId) {

		return visitAuditsInterface.getById(visitId, breedingManagementId);
		
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody VisitAudits visitAudits) {
		return visitAuditsInterface.save(visitAudits);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody VisitAudits visitAudits) {
		return visitAuditsInterface.update(visitAudits);
	}

}
