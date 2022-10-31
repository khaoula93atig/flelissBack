package com.tta.broilers.dao;

import java.util.List;

import com.tta.broilers.entities.UserPermission;
import com.tta.broilers.responses.BasicResponse;

/**
 * @author rym lamouchi
 *
 */
public interface UserPermissionInterface {

	List<UserPermission> findAll();
	List<UserPermission> findByUser(String username);
	BasicResponse save(UserPermission permission);
	BasicResponse save(List<UserPermission> permissions);

	BasicResponse update(UserPermission user);

	List<UserPermission> findByID(String item);

}
