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

import com.tta.broilers.dao.HouseInterface;
import com.tta.broilers.entities.House;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/house")
public class HouseController {

	@Autowired
	HouseInterface houseInterface;

	@GetMapping
	public List<House> findAll() {
		return houseInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<House> findByID(@PathVariable("id") String id) {

		return houseInterface.findById(id);
	}
	@GetMapping("/farm/{farmID}")
	public List<House> findByFarmID(@PathVariable("farmID") String farmID) {

		return houseInterface.findByFarmID(farmID);
	}
	@GetMapping("/center/{centerID}")
	public List<House> getHousesByCenter(@PathVariable("centerID") String centerID) {

		return houseInterface.getHousesByCenter(centerID);
	}
	@PostMapping("/save")
	public BasicResponse save(@RequestBody House house) {
		return houseInterface.save(house);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody House house) {
		return houseInterface.update(house);
	}
	
	@GetMapping("/breed/{houseId}")
	public int getBreedofHouse(@PathVariable("houseId") String houseId) {

		return houseInterface.getBreedofHouse(houseId);
	}
}
