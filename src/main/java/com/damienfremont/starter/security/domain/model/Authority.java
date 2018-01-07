package com.damienfremont.starter.security.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "AUTHORITIES")
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = -1675424994116972475L;

	@Id @NotNull @Size(max = 50) @Column(length = 50)
	private String authority;
	@MapsId("username") @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL) @JoinColumn(name = "username")
	private User user;
	

	public Authority() {
		// Empty constructor needed for Jackson.
	}

	public Authority(String authority) {
		this.authority = authority;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Authority authority = (Authority) o;

		return !(authority != null ? !authority.equals(authority.authority) : authority.authority != null);
	}

	@Override
	public int hashCode() {
		return authority != null ? authority.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Authority{" + "authority='" + authority + '\'' + "}";
	}
	
}