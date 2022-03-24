package com.myTeachAssistant.site.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTeachAssistant.site.model.Blacklist;

public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
	Optional<Blacklist> findByToken(String token);
}
