package com.tta.broilers.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.DashboardInterface;
import com.tta.broilers.entities.rest.FlockWeight;
import com.tta.broilers.entities.rest.WeightByBreed;
/**
 * @author EMNA
 *
 */
@RestController
@RequestMapping("/dashboard/weightPerFlock")
public class DashboardController {
	@Autowired
	DashboardInterface dashboardInterface;
	
	@GetMapping("/{center_id}")
	public List<FlockWeight> findWeightByFlock(@PathVariable("center_id") String center_id) {
		return dashboardInterface.findWeightByFlock(center_id);
	}
	
	@GetMapping("/breed/{center_id}")
	public ArrayList<WeightByBreed> getWeightperBreed(@PathVariable("center_id") String center_id) {
		return dashboardInterface.getWeightperBreed(center_id);
	}
}