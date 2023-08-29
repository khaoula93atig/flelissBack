package com.tta.broilers.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tta.broilers.entities.ERole;
import com.tta.broilers.entities.RoleSecurity;

public interface RoleSecurityRepository extends JpaRepository<RoleSecurity, Long> {
	
	Optional<RoleSecurity> findByName(ERole name);

}
