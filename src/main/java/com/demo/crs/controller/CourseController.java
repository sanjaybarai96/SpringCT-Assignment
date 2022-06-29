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

import com.demo.crs.entity.Course;
import com.demo.crs.service.CourseService;

/**
 * @author 10696450
 * It shows the functionality related to course api
 */

@RestController
@RequestMapping(value="/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{courseName}")
	@ResponseBody
	public ResponseEntity<?> deleteCourse(@PathVariable("courseName") String courseName) {
	 return courseService.deleteCourseByName(courseName);	
	}
}
