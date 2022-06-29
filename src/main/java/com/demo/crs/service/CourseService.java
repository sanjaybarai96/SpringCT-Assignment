package com.demo.crs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.crs.constant.ResponseMsg;
import com.demo.crs.entity.Course;
import com.demo.crs.repository.CourseRepository;

/**
 * @author 10696450 
 * It shows the business logic related to course
 */
@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepo;

	public ResponseEntity<?> addCourse(Course course) {
		if (course != null) {
			boolean status = courseRepo.addCourse(course);

			return status ? new ResponseEntity<>(ResponseMsg.COURSE_ADDED, HttpStatus.CREATED)
					: new ResponseEntity<>(ResponseMsg.COURSE_EXIST, HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseMsg.COURSE_INVALID, HttpStatus.BAD_REQUEST);

	}

	public List<String> checkCourse(String courseName) {
		if(courseName != null && !courseName.isEmpty()) {
			List<String> courses = Arrays.asList(courseName.split(","));
			List<Course> dbCourse =  getCourseByName(courses);
			if(dbCourse.size() == courses.size()) {
				return new ArrayList<>();
			}else {
				List<String> courseNames = dbCourse.stream().map(Course::getName)
						.collect(Collectors.toList());
				return courses.stream().filter(course->!courseNames.contains(course))
								.collect(Collectors.toList());
			}
		}
		return null;
	}

	public List<Course> getCourseByName(List<String> courseName) {
		if(courseName != null && !courseName.isEmpty())
			return courseRepo.getCourseByName(courseName);
		else
			return new ArrayList<>();
	}

	public ResponseEntity<?> deleteCourseByName(String courseName) {
		if(courseName != null && !courseName.isEmpty()) {
			boolean status = courseRepo.deleteCourseByName(courseName);
			return status ? new ResponseEntity<>(ResponseMsg.COURSE_DELETED,HttpStatus.OK): new ResponseEntity<>(ResponseMsg.COURSE_NOT_DELETED,HttpStatus.NOT_FOUND);
		}
		else
			return new ResponseEntity<>(ResponseMsg.COURSE_INVALID, HttpStatus.BAD_REQUEST);
		
	}
}
