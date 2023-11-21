package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Student;
import com.app.repo.StudentRepo;


@Service
public class StudentServiceImpl {


@Autowired
private StudentRepo Repo;


public Student adduser(Student user) {
	
	Repo.save(user);	
	return user;
}

public List<Student> findAll() {
	
	List<Student> user=Repo.findAll();
	return user;
}

public Student  updateuser(Long id, Student user) {
	Repo.findById(id).get();
	
	if(user.getSname()!=null) {
		user.setSname(user.getSname());
	}
	if(user.getSdob()!=null) {
		user.setSdob(user.getSdob());
	}
	if(user.getSgender()!=null) {
		user.setSgender(user.getSgender());
	}
	if(user.getSpassword()!=null) {
		user.setSpassword(user.getSpassword());
	}
	Repo.save(user);
	return user;
}


public Optional<Student> findById(Long id) {
	Student user=Repo.findById(id).get();
	return Optional.of(user);
}

public String deleteById(Long id) {
	Student user=Repo.findById(id).get();
	Repo.delete(user);
	return "Student removed";
	
}


public String delete(Long id) {
	Repo.deleteById(id);
	return "Student removed";
	
}



}