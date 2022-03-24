package com.myTeachAssistant.site.dto;

import javax.validation.constraints.Size;

public class TutorialDto {
	@Size(min = 5)
	private String title;

	@Size(min = 5)
	private String description;

	private Boolean published;

	private Boolean favorite;

	// Getter && Setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public boolean isPublished() {
		return published;
	}
}
