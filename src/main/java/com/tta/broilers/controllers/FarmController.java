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

import com.tta.broilers.dao.FarmInterface;
import com.tta.broilers.entities.Farm;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/farm")
public class FarmController {

	@Autowired
	FarmInterface farmeInterface;

	@GetMapping
	public List<Farm> findAll() {

		return farmeInterface.findAll();
	}

	@GetMapping("/{id}")
	public List<Farm> findByID(@PathVariable("id") String id) {

		return farmeInterface.getById(id);
	}

	
	@GetMapping("/getByCompany/{id}")
	public List<Farm> getByCompanyID(@PathVariable("id") String id) {

		return farmeInterface.getById(id);
	}
	
	@PostMapping("/save")
	public BasicResponse save(@RequestBody Farm farm) {
		//System.out.println("create farm" + farm.toString());
		return farmeInterface.save(farm);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Farm farme) {
		return farmeInterface.update(farme);
	}

}
