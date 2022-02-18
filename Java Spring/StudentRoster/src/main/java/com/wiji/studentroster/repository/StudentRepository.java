package com.wiji.studentroster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wiji.studentroster.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findByDormitoryNull();
}
