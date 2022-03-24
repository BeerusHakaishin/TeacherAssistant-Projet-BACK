package com.myTeachAssistant.site.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.myTeachAssistant.site.model.ERole;
import com.myTeachAssistant.site.model.Role;
import com.myTeachAssistant.site.repository.RoleRepository;

public class RoleService {
	@Autowired
	RoleRepository roleRepository;

	public Role findByName(ERole eRole) {
		Optional<Role> optRole = roleRepository.findByName(eRole);
		if (optRole.isPresent()) {
			return optRole.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
