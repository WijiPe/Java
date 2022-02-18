package com.wiji.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiji.studentroster.models.Dormitory;
import com.wiji.studentroster.models.Student;
import com.wiji.studentroster.repository.DormitoryRepository;
import com.wiji.studentroster.repository.StudentRepository;


@Service
public class MainService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DormitoryRepository dormitoryRepository;
	
	public Student saveDojo(Student student) {
		return studentRepository.save(student);
	}
	
	public Dormitory saveNinja(Dormitory dormitory) {
		return dormitoryRepository.save(dormitory);
	}
	
	public List<Student> allStudents(){
		return studentRepository.findByDormitoryNull();
	}
	
	public List<Dormitory> allDormitories(){
		return dormitoryRepository.findAll();
	}
	
	public Dormitory findOneDormitory(Long id){
		Optional<Dormitory> optionalDormitory = dormitoryRepository.findById(id);
		if(optionalDormitory.isPresent()) {
			return optionalDormitory.get();
		}else {
    		return null;
    	}
	}
	
	public Student findOneStudent(Long id){
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
		}else {
    		return null;
    	}
	}

	 public Student createStudent(Student student) {
	     return studentRepository.save(student);
	 }
	 
	 public Dormitory createDormitory(Dormitory dormitory) {
	     return dormitoryRepository.save(dormitory);
	 }
	 
	 public Student updateStudent(Student student) {
		 return studentRepository.save(student);
	}
	 
//	 public void deleteStudent(Long id) {
//		studentRepository.deleteById(id);
//	}
	 
}
