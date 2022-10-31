package com.tta.broilers.controllers;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.VisitTasksInterface;
import com.tta.broilers.entities.VisitTasks;
import com.tta.broilers.entities.rest.WeightVariation;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/visittasks")
public class VisitTasksController {

	@Autowired
	VisitTasksInterface vistTasksInterface;

	@GetMapping
	public List<VisitTasks> findAll() {

		return vistTasksInterface.findAll();
	}

	@GetMapping("/{visitId}")
	public List<VisitTasks> getByVisitId(@PathVariable("visitId") String visitId) {

		return vistTasksInterface.getByVisitId(visitId);
		
	}
	
	@GetMapping("/flock/{flockId}")
	public WeightVariation WeightVariationByFlock(@PathVariable("flockId") String flockId) {

		return vistTasksInterface.WeightVariationByFlock(flockId);
		
	}
	@GetMapping("/{visitId}/{taskId}")
	public List<VisitTasks> findByID(@PathVariable("visitId") String visitId, @PathVariable("taskId") int taskId) {

		return vistTasksInterface.getById(visitId, taskId);
		
	}
	@GetMapping("getbydate/{visitDate}/{taskId}/{flockId}")
	public double getTotalMeasures(@PathVariable("visitDate") String visitDate, @PathVariable("taskId") int taskId , @PathVariable("flockId") String flockId) throws ParseException {

		return vistTasksInterface.getTotalMeasures(visitDate, taskId,  flockId);
		
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody VisitTasks visitTasks) {
		return vistTasksInterface.save(visitTasks);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody VisitTasks visitTasks) {
		return vistTasksInterface.update(visitTasks);
	}


}
