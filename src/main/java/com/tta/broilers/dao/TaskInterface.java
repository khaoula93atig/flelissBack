package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.Task;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface TaskInterface  {
	
	List<Task> findAll();
	List<Task> getById(int id);
	BasicResponse save(Task task);
	BasicResponse update(Task task);

}
