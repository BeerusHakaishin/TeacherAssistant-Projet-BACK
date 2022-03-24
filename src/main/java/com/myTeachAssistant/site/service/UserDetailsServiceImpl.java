package com.myTeachAssistant.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myTeachAssistant.site.model.User;
import com.myTeachAssistant.site.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = usersRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("L'utilisateur n'existe pas en BDD"));

		return UserDetailsImpl.build(user);
	}
}
