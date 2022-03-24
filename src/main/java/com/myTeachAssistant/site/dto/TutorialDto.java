package com.myTeachAssistant.site.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TutorialDto {
	@NotBlank
	@NotNull
	@Size(max = 100)
	private String title;

	@NotBlank
	@NotNull
	private String description;

	@NotNull
	private Boolean published;

	@NotNull
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
}
