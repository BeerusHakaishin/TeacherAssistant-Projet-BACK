package com.myTeachAssistant.site.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTeachAssistant.site.model.ERole;
import com.myTeachAssistant.site.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);

	Optional<Set<Role>> findAllByNameIn(Set<ERole> name);
}
