package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.tta.broilers.entities.Task; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         31 aout 2020
 */
public class TaskRowMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int arg1) throws SQLException {

		Task task = new Task();
	
		task.setTaskId(rs.getInt("task_id"));
		task.setDescription(rs.getString("description"));
		task.setCategory(rs.getString("category"));
		task.setMeasureUnit(rs.getString("measure_unit"));
		task.setCreationDate(rs.getDate("creation_date"));

		return task;
	}


}
