/**
 * 
 */
package com.demo.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crs.entity.Student;
import com.demo.crs.entity.StudentCourse;
import com.demo.crs.service.StudentService;

/**
 * @author 10696450
 * It contains student functionality
 */

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	StudentService studentSevice;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		return studentSevice.addStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> listStudent() {
		return studentSevice.getAllStudent();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/allocateCourse")
	@ResponseBody
	public ResponseEntity<?> allocateCourseStudent(@RequestBody StudentCourse studentCourse) {
		return studentSevice.allocateStudentCourse(studentCourse);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getStudentByCourse/{courseName}")
	@ResponseBody
	public ResponseEntity<?> getStudentByCourseName(@PathVariable("courseName") String courseName) {
		return studentSevice.getStudentByCourseName(courseName);
		
	}
	
	
}
