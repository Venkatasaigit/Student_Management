package com.app.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.app.model.user;


@Repository
public interface UserRepo extends JpaRepository<user, Integer>{

	
}
