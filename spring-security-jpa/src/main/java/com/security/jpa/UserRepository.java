package com.security.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jpa.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}
