package com.myTeachAssistant.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myTeachAssistant.site.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	// returns all Tutorials with published having value as input published
	List<Tutorial> findByPublished(boolean published);

	// returns all Tutorials with favorite having value as input favorite
	List<Tutorial> findByFavorite(boolean favorite);

	// returns all Tutorials which title contains input title
	List<Tutorial> findByTitleContaining(String title);
}
