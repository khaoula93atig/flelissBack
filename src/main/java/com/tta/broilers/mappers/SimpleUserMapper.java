package com.tta.broilers.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tta.broilers.entities.Role;
import com.tta.broilers.entities.User;

/**
 * @author RLamouchi @email r.lamouchi@ttatunisia.com
 *
 *         20 mai 2020
 */
public class SimpleUserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {

		User user = new User();

		user.setCreationDate(rs.getDate("creation_date"));
		user.setEmail(rs.getString("email"));
		user.setFarmID(rs.getString("farm_id"));
		user.setCompanyID(rs.getString("company_id"));
		user.setJob(rs.getString("job"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setTelNumber(rs.getString("tel_number"));
		user.setRole(rs.getString("role"));
		user.setUsername(rs.getString("username"));
 
		Role roleObject = new Role();
		roleObject.setDescription(rs.getString("role"));
		roleObject.setRoleID(rs.getInt("role_id"));
		
		user.setRoleObject(roleObject);
		return user;
	}

}
