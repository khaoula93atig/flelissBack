package com.tta.broilers.repositories;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tta.broilers.dao.RoleInterface;
import com.tta.broilers.entities.Role;
import com.tta.broilers.mappers.RoleRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class RoleRepository implements RoleInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from role",new RoleRowMapper());

	}

	@Override
	public BasicResponse save(Role role) {
		try {

		jdbcTemplate.update(
					" INSERT INTO role(role_id, description) VALUES (?, ?);",role.getRoleID(),role.getDescription()

					 );
			return new BasicResponse("Role created: " + role.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	
	@Override
	public List<Role> findById(long id) {
		return jdbcTemplate.query("select * from role where role_id=?", new Object[] { id }, new RoleRowMapper());

	}
	
}
