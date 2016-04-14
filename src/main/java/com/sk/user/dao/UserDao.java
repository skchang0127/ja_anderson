package com.sk.user.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public interface UserDao {
    UserDetails findByUsernameWithAuthorities(String username);
}
