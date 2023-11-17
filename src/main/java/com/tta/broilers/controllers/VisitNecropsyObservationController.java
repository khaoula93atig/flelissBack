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

import com.tta.broilers.dao.VisitNecropsyObservationInterface;
import com.tta.broilers.entities.VisitNecropsyObservation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/visitNecropsyObservation")
public class VisitNecropsyObservationController {

	@Autowired
	VisitNecropsyObservationInterface visitNecropsyObservationInterface;

	@GetMapping
	public List<VisitNecropsyObservation> findAll() {

		return visitNecropsyObservationInterface.findAll();
	}

	@GetMapping("/{visitId}")
	public List<VisitNecropsyObservation> getByVisitId(@PathVariable("visitId") String visitId) {

		return visitNecropsyObservationInterface.getByVisitId(visitId);
		
	}
	
	@GetMapping("/{visitId}/{necropsyId}")
	public List<VisitNecropsyObservation> findByID(@PathVariable("visitId") String visitId, @PathVariable("necropsyId") int necropsyId) {

		return visitNecropsyObservationInterface.getById(visitId, necropsyId);
		
	}

	@PostMapping("/save")
	public VisitNecropsyObservation save(@RequestBody VisitNecropsyObservation visitNecropsyObservation) {
		return visitNecropsyObservationInterface.save(visitNecropsyObservation);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody VisitNecropsyObservation visitNecropsyObservation) {
		return visitNecropsyObservationInterface.update(visitNecropsyObservation);
	}

}
