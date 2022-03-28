package com.myTeachAssistant.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myTeachAssistant.site.model.ERole;
import com.myTeachAssistant.site.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole roleUser);
}
