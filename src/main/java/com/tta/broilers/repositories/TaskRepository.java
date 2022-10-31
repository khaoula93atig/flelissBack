package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.TaskInterface;
import com.tta.broilers.entities.Task;
import com.tta.broilers.mappers.TaskRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class TaskRepository implements TaskInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from task", new TaskRowMapper());

	}

	@Override
	public BasicResponse save(Task task) {
		try {
			
			task.setCreationDate(new Date());

			jdbcTemplate.update(
					"INSERT INTO task( task_id, description, category, measure_unit, creation_date) "
							+ "  VALUES (?, ?, ?, ?, ?);", task.getTaskId(), task.getDescription(), task.getCategory(), task.getMeasureUnit(), task.getCreationDate()
					);
			return new BasicResponse("Company created: " + task.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(Task task) {
		try {
			List<Task> toUpdate = getById(task.getTaskId());
			if (!toUpdate.isEmpty()) {
				jdbcTemplate.update(
						"UPDATE company  SET description, category, measure_unit, creation_date WHERE task_id=?;",
						task.getDescription(),task.getCategory(),task.getMeasureUnit(), task.getCreationDate()
						);
				return new BasicResponse("Company updated: " + task.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Task> getById(int id) {

		return jdbcTemplate.query("select * from task where task_id=?", new Object[] { id },
				new TaskRowMapper());
	}



}
