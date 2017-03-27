package com.spring.student.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.student.tracker.entity.Student;
import com.spring.student.tracker.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listStudents(Model model){
		
		List<Student> theStudents = studentService.getStudents();
		model.addAttribute("students", theStudents);
		
		
		return "list-Students";
	}

	@RequestMapping(value = "/showFormForAdd",method = RequestMethod.GET)
	public String showFormForAdd(Model model){
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		model.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@RequestMapping(value="/saveStudent", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student theStudent){
		
		// save the new student using our service
		studentService.saveStudent(theStudent);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/showFormForUpdate", method = RequestMethod.GET)
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model model){
		
		
		// get student from the studentService
			Student theStudent = studentService.getStudent(theId);
		
			// set student as a model attribute pre-populate the form
			model.addAttribute("student", theStudent);
		
			// send over to the form 
		return "student-form";
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.GET)
	public String deleteStudent(@RequestParam("studentId") int theId){
			
		studentService.deleteStudent(theId);
		return "redirect:/student/list";
	}
}
