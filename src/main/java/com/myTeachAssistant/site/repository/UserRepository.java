package com.myTeachAssistant.site.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTeachAssistant.site.model.Role;
import com.myTeachAssistant.site.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	Optional<User> findByUsername(String username);

	List<User> findDistinctAllByRolesIn(Optional<Set<Role>> roles);
}
