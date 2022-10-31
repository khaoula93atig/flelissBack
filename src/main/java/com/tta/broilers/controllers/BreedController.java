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

import com.tta.broilers.dao.BreedInterface;
import com.tta.broilers.entities.Breed;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/breed")
public class BreedController {

	@Autowired
	BreedInterface breedInterface;

	@GetMapping
	public List<Breed> findAll() {

		return breedInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<Breed> findByID(@PathVariable("id") int id) {

		return breedInterface.getById(id);
	}
	@PostMapping("/save")
	public BasicResponse save(@RequestBody Breed breed) {
		return breedInterface.save(breed);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Breed breed) {
		return breedInterface.update(breed);
	}

}
