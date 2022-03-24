package com.myTeachAssistant.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTeachAssistant.site.model.ERole;
import com.myTeachAssistant.site.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole roleUser);
}
