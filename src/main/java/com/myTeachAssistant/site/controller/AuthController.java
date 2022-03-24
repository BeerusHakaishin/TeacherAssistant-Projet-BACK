package com.myTeachAssistant.site.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myTeachAssistant.site.dto.LoginDto;
import com.myTeachAssistant.site.dto.UserDto;
import com.myTeachAssistant.site.jwt.JwtResponse;
import com.myTeachAssistant.site.jwt.JwtUtils;
import com.myTeachAssistant.site.model.Blacklist;
import com.myTeachAssistant.site.model.User;
import com.myTeachAssistant.site.repository.BlacklistRepository;
import com.myTeachAssistant.site.repository.RoleRepository;
import com.myTeachAssistant.site.repository.UserRepository;
import com.myTeachAssistant.site.service.UserDetailsImpl;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	BlacklistRepository blackListRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles));
	}

	@PostMapping("/signup")
	public User createUser(@Valid @RequestBody UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setRoles(userDto.getRoles());
		return userRepository.save(user);
	}

	@GetMapping("/logout")
	public void logOut(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			String jwt = headerAuth.substring(7, headerAuth.length());
			Blacklist blackList = new Blacklist();
			blackList.setToken(jwt);
			blackList.setDate(new Date());
			blackListRepository.save(blackList);
		}
	}

	@GetMapping("/istokenexpired")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('MOD')")
	public boolean isTokenExpired() {
		return true;
	}

}
