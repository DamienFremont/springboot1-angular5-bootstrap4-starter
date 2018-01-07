package com.damienfremont.starter.security.domain.model;

import java.util.*;
import java.util.stream.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USERS")
public class User implements UserDetails {

	private static final long serialVersionUID = -329458369761366578L;

	@Id
	private String username;

	@Size(min = 8, max = 100)
	private String password;
	
	private boolean enabled = true;
	@Transient
	private boolean accountNonExpired = true;
	@Transient
	private boolean credentialsNonExpired = true;
	@Transient
	private boolean accountNonLocked = true;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user") @BatchSize(size = 20)
	private Collection<Authority> authorities = new ArrayList<>();
	
	public User() {
		// Empty constructor needed for Jackson.
	}

	public User(User user) {
		this.username = user.getUsername();
		this.enabled = user.getEnabled();
		this.authorities = user.getAuthorities().stream().map(i -> new Authority(i.getAuthority()))
				.collect(Collectors.toSet());
		this.authorities = user.authorities;
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
	
	public boolean isEnabled() {
		return enabled;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}



}
