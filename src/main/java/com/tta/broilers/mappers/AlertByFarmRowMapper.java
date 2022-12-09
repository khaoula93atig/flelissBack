package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.rest.AlertByFarm;

public class AlertByFarmRowMapper implements RowMapper<AlertByFarm> {

	@Override
	public AlertByFarm mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AlertByFarm alertMapper = new AlertByFarm();
		alertMapper.setCount(rs.getInt("count"));
		alertMapper.setTaskId(rs.getInt("task_id"));
		alertMapper.setCenterId(rs.getString("center_id"));
		alertMapper.setCenterName(rs.getString("center_name"));
		alertMapper.setHouseId(rs.getString("house_id"));
		alertMapper.setHouseName(rs.getString("house_name"));
		alertMapper.setDescription(rs.getString("description"));
		alertMapper.setDeviation(rs.getString("deviation"));
		alertMapper.setMesures(rs.getString("measure"));
		return alertMapper;
	}

}
