package com.demo.crs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.crs.entity.Course;

@Repository
public interface CourseRepository {

	public boolean addCourse(Course course);
	public List<Course> getCourseByName(List<String> courseName);
	public boolean deleteCourseByName(String courseName);
}
