package com.tta.broilers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tta.broilers.dao.RoleInterface;

import com.tta.broilers.entities.Role;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleInterface roleInterface;

	@GetMapping
	public List<Role> findAll() {
		return roleInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<Role> findByID(@PathVariable("id") long id) {

		return roleInterface.findById(id);
	}

	@PostMapping("/save")
	public BasicResponse save(@RequestBody Role role) {
		return roleInterface.save(role);
	}

}
