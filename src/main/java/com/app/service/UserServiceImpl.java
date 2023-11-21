package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.user;
import com.app.repo.UserRepo;


@Service
public class UserServiceImpl {

	@Autowired
	private UserRepo Repo;
	
	
	public user adduser(user user) {
		
		Repo.save(user);	
		return user;
	}

	public List<user> findAll() {
		
		List<user> user=Repo.findAll();
		return user;
	}
	
	public user  updateuser(int id, user user) {
		Repo.findById(id).get();
		
		if(user.getName()!=null) {
			user.setName(user.getName());
		}
		if(user.getDob()!=null) {
			user.setDob(user.getDob());
		}
		if(user.getGender()!=null) {
			user.setGender(user.getGender());
		}
		if(user.getPassword()!=null) {
			user.setPassword(user.getPassword());
		}
		Repo.save(user);
		return user;
	}


	public Optional<user> findById(int id) {
		user user=Repo.findById(id).get();
		return Optional.of(user);
	}

	public String deleteById(int id) {
		user user=Repo.findById(id).get();
		Repo.delete(user);
		return "user removed";
		
	}


	public String delete(int id) {
		Repo.deleteById(id);
		return "user removed";
		
	}



}