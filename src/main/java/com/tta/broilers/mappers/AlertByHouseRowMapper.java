package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.AlertByHouse;

public class AlertByHouseRowMapper implements RowMapper<AlertByHouse> {

	@Override
	public AlertByHouse mapRow(ResultSet rs, int rowNum) throws SQLException {
		AlertByHouse alertMapper = new AlertByHouse();
		alertMapper.setCount(rs.getInt("count"));
		alertMapper.setTaskId(rs.getInt("task_id"));
		alertMapper.setDescription(rs.getString("description"));
		alertMapper.setDeviation(rs.getString("deviation"));
		alertMapper.setMesures(rs.getString("measure"));
		return alertMapper;
	}

}
