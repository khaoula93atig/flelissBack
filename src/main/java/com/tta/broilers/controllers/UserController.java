package com.tta.broilers.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.UserInterface;
import com.tta.broilers.entities.User;
import com.tta.broilers.entities.rest.UserCredentials;
import com.tta.broilers.responses.BasicResponse;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserInterface userInterface;

	@GetMapping
	public List<User> findAll() {
		return userInterface.findAll();
	}

	@GetMapping("/{username}")
	public List<User> findByID(@PathVariable("username") String username) {

		return userInterface.findByID(username);
	}
	@GetMapping("/farm/{farmID}")
	public List<User> findByFarmID(@PathVariable("farmID") String farmID) {

		return userInterface.findByFarmID(farmID);
	}
	@GetMapping("/company/{companyID}")
	public List<User> findByCompanyID(@PathVariable("companyID") String companyID) {

		return userInterface.findByCompanyID(companyID);
	}
	@PostMapping(path = "/save/{role}")
	public ResponseEntity<?> save(@Valid@RequestBody User user ,@PathVariable ("role") String roleuser ) {
		System.out.println(user+roleuser);
		return userInterface.save(user, roleuser);

	}

	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public BasicResponse update(@RequestBody User user) {
		return userInterface.update(user);

	}

	@PostMapping(path = "/authenticate", consumes = "application/json", produces = "application/json")
	public List<User> save(@RequestBody UserCredentials credentials) {
		return userInterface.authenticate(credentials);

	}
}
