package com.myTeachAssistant.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTeachAssistant.site.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	Optional<User> findByUsername(String username);
}
