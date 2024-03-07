package com.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUsername(String username);

}
