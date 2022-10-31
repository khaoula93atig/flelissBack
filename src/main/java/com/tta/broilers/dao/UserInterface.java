package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.User;
import com.tta.broilers.entities.rest.UserCredentials;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface UserInterface {

	List<User> findAll();

	List<User> findByID(String username); 
	List<User>findByFarmID(String farmID);
	List<User>findByCompanyID(String companyID);
	List<User> findByCredentials(UserCredentials credentials);

	BasicResponse save(User user);

	BasicResponse update(User user);

	List<User> authenticate(UserCredentials credentials);

}
