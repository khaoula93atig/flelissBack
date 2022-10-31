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
import com.tta.broilers.dao.TaskInterface;
import com.tta.broilers.entities.Task;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskInterface taskInterface;

	@GetMapping
	public List<Task> findAll() {

		return taskInterface.findAll();
	}
	@GetMapping("/{id}")
	public List<Task> findByID(@PathVariable("id") int id) {

		return taskInterface.getById(id);
	}
	@PostMapping("/save")
	public BasicResponse save(@RequestBody Task task) {
		return taskInterface.save(task);
	}

	@PutMapping("/update")
	public BasicResponse update(@RequestBody Task task) {
		return taskInterface.update(task);
	}

}
