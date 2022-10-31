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

import com.tta.broilers.dao.BreedingManagementInterface;
import com.tta.broilers.entities.BreedingManagement;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author emna
 *
 */
@RestController
@RequestMapping("/breedingManagement")
public class BeedingManagementController {

	@Autowired
	BreedingManagementInterface breedingManagementInterface;

	@GetMapping
	public List<BreedingManagement> findAll() {

		return breedingManagementInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<BreedingManagement> findByID(@PathVariable("id") String id) {

		return breedingManagementInterface.getById(id);
	}
	@PostMapping("/save")
	public BasicResponse save(@RequestBody BreedingManagement breedingManagement) {
		return breedingManagementInterface.save(breedingManagement);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody BreedingManagement breedingManagement) {
		return breedingManagementInterface.update(breedingManagement);
	}

}
