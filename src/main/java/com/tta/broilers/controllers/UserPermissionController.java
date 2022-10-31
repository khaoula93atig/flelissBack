package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tta.broilers.dao.UserPermissionInterface; 
import com.tta.broilers.entities.UserPermission; 
import com.tta.broilers.responses.BasicResponse;
 

/**
 * @author rym lamouchi
 *
 */
@Controller
@RequestMapping("/permission")
public class UserPermissionController {

	@Autowired
	UserPermissionInterface permissionInterface;

	@GetMapping
	public List<UserPermission> findAll() {
		return permissionInterface.findAll();
	}

	@GetMapping("/{item}")
	public List<UserPermission> findByID(@PathVariable("item") String item) {

		return permissionInterface.findByID(item);
	}

	@PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
	public BasicResponse save(@RequestBody UserPermission userPermission) {
		return permissionInterface.save(userPermission);

	}
	
	@PostMapping(path = "/save_list", consumes = "application/json", produces = "application/json")
	public BasicResponse saveList(@RequestBody List<UserPermission> userPermission) {
		return permissionInterface.save(userPermission);

	}
	

	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public BasicResponse update(@RequestBody UserPermission userPermission) {
		return permissionInterface.update(userPermission);

	}
}
