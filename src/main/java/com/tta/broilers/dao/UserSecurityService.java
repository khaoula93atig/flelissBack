package com.tta.broilers.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tta.broilers.entities.UserSecurity;
import com.tta.broilers.repositories.UserSecurityRepository;

@Service
public class UserSecurityService {
	@Autowired
	UserSecurityRepository userRepository;

	public String updateUser(UserSecurity userSecurity) {
			UserSecurity userUpdate = userRepository.findById(userSecurity.getIdSecurity()).get();
			userUpdate = userRepository.saveAndFlush(userSecurity);
			return "upadate avec succes";
		
	}

}
