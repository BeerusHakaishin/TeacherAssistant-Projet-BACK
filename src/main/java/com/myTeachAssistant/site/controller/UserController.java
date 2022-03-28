package com.myTeachAssistant.site.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myTeachAssistant.site.exception.UserNotFoundException;
import com.myTeachAssistant.site.model.Comment;
import com.myTeachAssistant.site.model.Role;
import com.myTeachAssistant.site.model.Tutorial;
import com.myTeachAssistant.site.model.User;
import com.myTeachAssistant.site.repository.TutorialRepository;
import com.myTeachAssistant.site.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	TutorialRepository tutorialRepository;

	// Get all users
	@GetMapping("/users")
	public List<User> getAll() {
		return userRepository.findAll();
	}

	// Get one user by its id
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Get all tutorials of an user
	@GetMapping("/users/{id}/tutorials")
	public List<Tutorial> retriveAllUsersTutos(@PathVariable long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		return userOptional.get().getTutorial();
	}

	// Get roles of an user
	@GetMapping("/users/{id}/roles")
	public Set<Role> findBySpecificRole(@PathVariable long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		return userOptional.get().getRoles();
	}

	// Get comments of an user
	@GetMapping("/users/{id}/comments")
	public List<Comment> findCommentByUser(@PathVariable long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		return userOptional.get().getComment();
	}

	// Create an user

	// Create a post for the specific user
	@PostMapping("/users/{id}/tutorials")
	public ResponseEntity<Object> createUser(@PathVariable long id, @RequestBody Tutorial tutorial) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		}
		User user = userOptional.get();
		// map the user to the post
		tutorial.setUser(user);
		// save post to the database
		tutorialRepository.save(tutorial);
		// getting the path of the post and append id of the post to the URI
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tutorial.getId())
				.toUri();
		// returns the location of the created post
		return ResponseEntity.created(location).build();
	}

	// Update an user

	// Delete an user
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(required = true) Long id) {
		if (userRepository.findById(id).isEmpty())
			return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);

		userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
