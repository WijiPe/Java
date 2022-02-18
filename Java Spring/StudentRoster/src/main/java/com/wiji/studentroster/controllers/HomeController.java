package com.wiji.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wiji.studentroster.models.Dormitory;
import com.wiji.studentroster.models.Student;
import com.wiji.studentroster.services.MainService;


@Controller
public class HomeController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/dormitories/new")
	public String dashboard(@ModelAttribute("dormitory")Dormitory dormitory) {
		return "dormForm.jsp";
	}
	
	@PostMapping("/submitDormitoriesForm")
	public String addDormitory(@Valid @ModelAttribute("dormitory")Dormitory dormitory, BindingResult result) {
		if(result.hasErrors()) {
			return "dormForm.jsp";
		}else {
			mainService.createDormitory(dormitory);
			return "redirect:/dormitories";
		}
	}
	
	@GetMapping("/dormitories")
	public String domitories(@ModelAttribute("dormitory")Dormitory dormitory, Model model) {
		List<Dormitory> dormitories = mainService.allDormitories();
		model.addAttribute("dormitories", dormitories);
		return "dormitory.jsp";
	}
	
	@GetMapping("/students/new")
	public String addStudent(@ModelAttribute("student")Student student) {
		return "sForm.jsp";
	}
	
	@PostMapping("/submitStudentsForm")
	public String post(@Valid @ModelAttribute("student")Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "sForm.jsp";
		}else {
			mainService.createStudent(student);
			return "redirect:/students/new";
		}
	}
	
	@GetMapping("/dormitory/{id}")
	public String display(@PathVariable("id")Long id, Model model, @ModelAttribute("student")Student student) {
		Dormitory dormitory = mainService.findOneDormitory(id);
		List<Student> students = mainService.allStudents();
		model.addAttribute("dormitory", dormitory);
		model.addAttribute("students", students);
		return "studentForm.jsp";
	}
	
	@PutMapping("/submitStudentinDormForm/{id}")
	public String studentFormProcess(@PathVariable("id")Long id, @RequestParam("studentId")Long studentId, Model model) {
		Dormitory dormitory = mainService.findOneDormitory(id);
		Student updateStudent = mainService.findOneStudent(studentId);
		updateStudent.setDormitory(dormitory);
		mainService.updateStudent(updateStudent);
		return "redirect:/dormitory/"+id;
	}
	
	@PutMapping("/student/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		Student student = mainService.findOneStudent(id);
		Long dormitoryId = student.getDormitory().getId();
		student.setDormitory(null);
		mainService.updateStudent(student);
		return "redirect:/dormitory/"+dormitoryId;
	}
	
}
