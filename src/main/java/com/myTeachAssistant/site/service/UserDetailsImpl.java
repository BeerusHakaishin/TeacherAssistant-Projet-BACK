package com.myTeachAssistant.site.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.myTeachAssistant.site.model.Role;
import com.myTeachAssistant.site.model.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String email;

	private Set<? extends GrantedAuthority> grantedAuthority;

	public static UserDetailsImpl build(User user) {

		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setId(user.getId());
		userDetailsImpl.setUsername(user.getUsername());
		userDetailsImpl.setPassword(user.getPassword());
		userDetailsImpl.setEmail(user.getEmail());

		Set<SimpleGrantedAuthority> authoritys = new HashSet<SimpleGrantedAuthority>();

		for (Role role : user.getRoles()) {
			authoritys.add(new SimpleGrantedAuthority(role.getName().name()));
		}

		userDetailsImpl.setGrantedAuthority(authoritys);
		return userDetailsImpl;
	}

	// Getter && Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<? extends GrantedAuthority> getGrantedAuthority() {
		return grantedAuthority;
	}

	public void setGrantedAuthority(Set<? extends GrantedAuthority> grantedAuthority) {
		this.grantedAuthority = grantedAuthority;
	}

	// Implemented methods from userDetails interface
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.grantedAuthority;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
