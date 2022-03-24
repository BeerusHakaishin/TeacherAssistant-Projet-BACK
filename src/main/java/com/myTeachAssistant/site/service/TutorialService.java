package com.myTeachAssistant.site.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.myTeachAssistant.site.dto.TutorialDto;
import com.myTeachAssistant.site.model.Tutorial;
import com.myTeachAssistant.site.model.User;
import com.myTeachAssistant.site.repository.TutorialRepository;
import com.myTeachAssistant.site.repository.UserRepository;

@Service
public class TutorialService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	TutorialRepository tutorialRepository;

	public void create(TutorialDto tutorialDto) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();

		User user = userRepository.getById(userDetailsImpl.getId());

		Tutorial tutorial = new Tutorial();
		tutorial.setTitle(tutorialDto.getTitle());
		tutorial.setDescription(tutorialDto.getDescription());
		tutorial.setPublished(tutorial.isPublished());
		tutorial.setFavorite(tutorial.isFavorite());
		tutorial.setUser(user);
		tutorialRepository.save(tutorial);
	}

	public Optional<Tutorial> read(Long id) {
		return tutorialRepository.findById(id);
	}
}
