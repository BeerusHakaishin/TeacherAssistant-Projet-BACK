package com.myTeachAssistant.site.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// We specify that the role name property is the value of the enumeration ERole
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private ERole name;

	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<User> users = new HashSet<>();

	// Empty constructor
	public Role() {
	}

	// Args constructor
	public Role(ERole name) {
		this.name = name;
	}

	// Getter && Setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	// To string
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", users=" + users + "]";
	}

}
