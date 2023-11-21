package com.app.restController;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.user;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/login")
	public user SaveUser(@RequestBody user user) {
		return service.adduser(user);
	}
	@GetMapping("/users")
	public List<user> findAll(){
		return service.findAll();
	}
	
	@PutMapping("user/update/{id}")
	public user  updateuser(@PathVariable int id,@RequestBody user user) {
		return service.updateuser(id, user);
	}
	
	@GetMapping("/user/{id}")
	public Optional<user> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteById(id);
	  
	}
}
