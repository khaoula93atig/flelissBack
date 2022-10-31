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

import com.tta.broilers.dao.NecropsyObservationInterface;
import com.tta.broilers.entities.NecropsyObservation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("necropsyObservation")
public class NecropsyObservationController {

	@Autowired
	NecropsyObservationInterface necropsyObservationInterface;

	@GetMapping
	public List<NecropsyObservation> findAll() {

		return necropsyObservationInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<NecropsyObservation> findByID(@PathVariable("id") int id) {

		return necropsyObservationInterface.getById(id);
	}
	@PostMapping("/save")
	public BasicResponse save(@RequestBody NecropsyObservation necropsyObservation) {
		return necropsyObservationInterface.save(necropsyObservation);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody NecropsyObservation necropsyObservation) {
		return necropsyObservationInterface.update(necropsyObservation);
	}

}
