package com.myTeachAssistant.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myTeachAssistant.site.model.User;
import com.myTeachAssistant.site.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(required = true) Long id) {
		if (userRepository.findById(id).isEmpty())
			return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);

		userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}