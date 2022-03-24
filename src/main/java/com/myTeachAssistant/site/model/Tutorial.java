package com.myTeachAssistant.site.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tutorials")
public class Tutorial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private Boolean published;

	@Column(name = "favorite")
	private Boolean favorite;

	// Empty Constructor
	public Tutorial() {
	}

	// Args Constructor
	public Tutorial(String title, String description, Boolean published, Boolean favorite) {
		this.title = title;
		this.description = description;
		this.published = published;
		this.favorite = favorite;
	}

	// Getter && Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isPublished() {
		return published;
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
}