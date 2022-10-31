package com.tta.broilers.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tta.broilers.dao.UserInterface;
import com.tta.broilers.entities.User;
import com.tta.broilers.entities.rest.UserCredentials;
import com.tta.broilers.mappers.SimpleUserMapper;
import com.tta.broilers.mappers.UserRowMapper;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
@Repository
public class UserRepository implements UserInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("   select * from \"user\" where role !='Super Admin' ", new UserRowMapper());

	}

	@Override
	public BasicResponse save(User user) {
		try {
			user.setCreationDate(new Date());

			jdbcTemplate.update(
					"INSERT INTO \"user\" (  username, name, job, creation_date, password, farm_id, company_id, role, tel_number, email)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);",
					user.getUsername(), user.getName(), user.getJob(), user.getCreationDate(), user.getPassword(),
					user.getFarmID(), user.getCompanyID(), user.getRole(), user.getTelNumber(), user.getEmail());
			return new BasicResponse("User created: " + user.toString(), HttpStatus.OK);
		} catch (org.springframework.dao.DuplicateKeyException ex) {
			ex.printStackTrace();
			return new BasicResponse("Element existant!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public BasicResponse update(User user) {
		try {
			List<User> toUpdate = findByID(user.getUsername());
			if (!toUpdate.isEmpty()) {
				user.setCreationDate(new Date());
				System.out.println("usr " + user.toString());
				jdbcTemplate.update(
						"UPDATE \"user\" SET  name=?, job=?,  password=?, farm_id=?,company_id=?,  role=?, tel_number=?, email=? WHERE username=?;",
						user.getName(), user.getJob(), user.getPassword(), user.getFarmID(), user.getCompanyID(),
						user.getRole(), user.getTelNumber(), user.getEmail(), user.getUsername());
				return new BasicResponse("User updated: " + user.toString(), HttpStatus.OK);
			} else {
				return new BasicResponse("Element introuvable!", HttpStatus.BAD_REQUEST);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new BasicResponse("Error!", HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<User> findByID(String username) {
		return jdbcTemplate.query("select * from  \"user\" where username=?", new Object[] { username },
				new UserRowMapper());

	}

	@Override
	public List<User> authenticate(UserCredentials credentials) {
		List<User> localUser = new ArrayList<User>();
		// for super admin

		localUser = findByCredentials(credentials);
		if (!localUser.isEmpty()) {
			return localUser;
		}

		return localUser;

	}

	@Override
	public List<User> findByCredentials(UserCredentials credentials) {
		return jdbcTemplate.query("SELECT * FROM \"user\"  left join role on \"user\".role= role.description where username=? and password=?",
				new Object[] { credentials.getUsername(), credentials.getPassword() }, new SimpleUserMapper());
	}

	@Override
	public List<User> findByFarmID(String farmID) {
		return jdbcTemplate.query(
				"   select * from \"user\" left join farm on \"user\".farm_id=farm.farm_id  where farm.farm_id=?;",
				new Object[] { farmID }, new UserRowMapper());

	}

	@Override
	public List<User> findByCompanyID(String companyID) {
		return jdbcTemplate.query(
				"  select * from company c , \"user\" us where  c.company_id=us.company_id and c.company_id=?",
				new Object[] { companyID }, new UserRowMapper());
	}

}
