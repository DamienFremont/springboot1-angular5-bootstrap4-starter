package com.damienfremont.starter.security.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damienfremont.starter.security.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername( String username );
}

