package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.CountryInterface;
import com.tta.broilers.entities.Country;

/**
 * @author rym lamouchi
 
 *
 */
@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryInterface countryInterface;

	@GetMapping
	public List<Country> findAll() {

		return countryInterface.findAll();
	}
	
	
	@PostMapping("/insert/file")
	public void insertFromFile() {

		try {
			countryInterface.setFromFile();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
