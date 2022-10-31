package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.Role;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface RoleInterface {

	List<Role> findAll();
	
	List<Role> findById(long id);
	BasicResponse save(Role role);

}
