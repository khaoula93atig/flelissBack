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

import com.tta.broilers.dao.CompanyInterface;
import com.tta.broilers.entities.Company;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyInterface companyInterface;

	@GetMapping
	public List<Company> findAll() {

		return companyInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<Company> findByID(@PathVariable("id") String id) {

		return companyInterface.getById(id);
	}
	
	@PostMapping("/save")
	public BasicResponse save(@RequestBody Company company) {
		return companyInterface.save(company);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Company company) {
		return companyInterface.update(company);
	}

}
