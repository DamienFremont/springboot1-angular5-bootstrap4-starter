package com.damienfremont.starter.security.service;

import java.util.List;

import com.damienfremont.starter.security.domain.model.User;


public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
}
