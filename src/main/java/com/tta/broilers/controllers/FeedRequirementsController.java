package com.tta.broilers.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.FeedRequirementsInterface;


/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/feedRequirements")
public class FeedRequirementsController {

	@Autowired
	FeedRequirementsInterface feedRequirementsInterface;

	@GetMapping("/insert/file/{breed}")
	public void insert(@PathVariable("breed") int breed) throws Exception {
		feedRequirementsInterface.insertFromFile(breed);
	}
	

}
