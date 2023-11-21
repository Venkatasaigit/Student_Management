package com.app.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;
import com.app.repo.StudentRepo;
import com.app.service.StudentServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentRestController {

	@Autowired
	private StudentServiceImpl service;
	@Autowired
	
	private StudentRepo studentRepo;
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		System.out.println(student.toString());
		return studentRepo.save(student);
	}
	
	@GetMapping("/student")
	public List<Student>getAllStudent(){
		return studentRepo.findAll();
	}
	@GetMapping("student/{sid}")
	public Student getStudenById(@PathVariable("sid")Long sid) {
		return studentRepo.findById(sid).get();
	}
	@PutMapping("student/update/{id}")
	public Student  updateuser(@PathVariable Long id,@RequestBody Student user) {
		return service.updateuser(id, user);
	}
	@DeleteMapping("/student/{id}")
	public String delete(@PathVariable Long id) {
		return service.deleteById(id);
	}
}
