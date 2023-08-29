package com.tta.broilers.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tta.broilers.entities.UserSecurity;

@Repository
public interface UserSecurityRepository extends JpaRepository<UserSecurity, Long> {
	
	Optional<UserSecurity> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);

}
