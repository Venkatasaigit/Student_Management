package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	

}
