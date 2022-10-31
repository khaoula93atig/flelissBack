package com.tta.broilers.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.UserPermissionInterface;
import com.tta.broilers.entities.UserPermission;
import com.tta.broilers.mappers.UserPermissionRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class UserPermissionRepository implements UserPermissionInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserPermission> findAll() {
		return jdbcTemplate.query(
				"   select * from user_permission  ",
				new UserPermissionRowMapper());

	}

	@Override
	public BasicResponse save(UserPermission permission) {
		try {
			permission.setCreationDate(new Date());

			jdbcTemplate.update(
					"INSERT INTO user_permission ( \"create\", update, delete, list, print, item, description, creation_date, role)  VALUES (?,?, ?, ?, ?, ?, ?, ?, ?);",
					permission.isCreate(), permission.isUpdate(), permission.isDelete(), permission.isList(),
					permission.isPrint(), permission.getItem(), permission.getDescription(),
					permission.getCreationDate(), permission.getRole());
			return new BasicResponse("User permission created: " + permission.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(UserPermission permission) {
		try {
			List<UserPermission> toUpdate = findByID(permission.getItem());
			if (!toUpdate.isEmpty()) {
				permission.setCreationDate(new Date());
				jdbcTemplate.update(
						"UPDATE user_permission SET  \"create\"=?, update=?, delete=?, list=?, print=?, description=?, role=? WHERE item=?;",
						permission.isCreate(), permission.isUpdate(), permission.isDelete(), permission.isList(),
						permission.isPrint(), permission.getDescription(), permission.getRole(),
						permission.getItem());
				return new BasicResponse("User permission updated: " + permission.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<UserPermission> findByID(String item) {
		return jdbcTemplate.query("select * from  user_permission where item=?", new Object[] { item },
				new UserPermissionRowMapper());

	}

	@Override
	public BasicResponse save(List<UserPermission> permissions) {
		BasicResponse response = null;
		for (UserPermission p : permissions)

			response = save(p);

		return response;
	}

	@Override
	public List<UserPermission> findByUser(String username) {
		return jdbcTemplate.query(
				"   select * from user_permission left join \"user\" on \"user\".username=user_permission.username where user_permission.username=?; ",
				new Object[] { username }, new UserPermissionRowMapper());

	}

}
