package com.tta.broilers.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public BasicResponse save(@RequestPart("fichier") MultipartFile fichier,@RequestPart("company") String company) throws JsonMappingException, JsonProcessingException {
		Company comp = new ObjectMapper().readValue(company, Company.class);
		return companyInterface.save(fichier,comp);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Company company) {
		return companyInterface.update(company);
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<InputStreamResource> getPathByFileNameInteretCou(@PathVariable("id") String id)
			throws IOException {
		return companyInterface.getImage(id);
	}

}
