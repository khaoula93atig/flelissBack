package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.UserPermission;

/**
 * @author rym lamouchi
 *
 */
public class UserPermissionRowMapper implements RowMapper<UserPermission> {

	@Override
	public UserPermission mapRow(ResultSet rs, int arg1) throws SQLException {

		UserPermission permission = new UserPermission();

		permission.setCreate(rs.getBoolean("create"));
		permission.setCreationDate(rs.getDate("birds_number"));
		permission.setDelete(rs.getBoolean("delete"));
		permission.setDescription(rs.getString("description"));
		permission.setExport(rs.getBoolean("export"));
		permission.setItem(rs.getString("item"));
		permission.setList(rs.getBoolean("list"));
		permission.setPrint(rs.getBoolean("print"));
		permission.setUpdate(rs.getBoolean("update"));
		permission.setRole(rs.getString("role"));

		return permission;
	}

}
