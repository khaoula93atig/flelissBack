package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Role; 

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         04 sep 2020
 */
public class RoleRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int arg1) throws SQLException {

		Role role = new Role();
        role.setRoleID(rs.getLong("role_id"));
	    role.setDescription(rs.getString("description"));
		 

		return role;
	}

}
