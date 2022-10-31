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

import com.tta.broilers.dao.CenterInterface;
import com.tta.broilers.entities.Center;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author EMNA
 *
 */
@RestController
@RequestMapping("/center")
public class CenterController {

	@Autowired
	CenterInterface centerInterface;

	@GetMapping
	public List<Center> findAll() {

		return centerInterface.findAll();
	}

	@GetMapping("/{id}")
	public List<Center> findByID(@PathVariable("id") String id) {

		return centerInterface.getById(id);
	}

	
	@GetMapping("/getByCompany/{id}")
	public List<Center> getByCompanyID(@PathVariable("id") String id) {

		return centerInterface.getById(id);
	}
	@GetMapping("/getByFarmId/{id}")
	public List<Center> getByFarmId(@PathVariable("id") String id) {

		return centerInterface.getByFarmId(id);
	}
	
	@PostMapping("/save")
	public BasicResponse save(@RequestBody Center center) {
		System.out.println("center farm" + center.toString());
		return centerInterface.save(center);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Center farme) {
		return centerInterface.update(farme);
	}
	@GetMapping("/findCentersByRole/{roleID}/{farmId}/{companyId}")
	public List<Center> findCentersByRole(@PathVariable("roleID") int roleID,@PathVariable("farmId") String farmId,@PathVariable("companyId") String companyId) {

		return centerInterface.findCentersByRole(roleID,farmId,companyId);
	}
}
