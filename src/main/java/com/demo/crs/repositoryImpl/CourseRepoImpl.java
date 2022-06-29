package com.demo.crs.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.demo.crs.entity.Course;
import com.demo.crs.repository.CourseRepository;

@Repository
public class CourseRepoImpl implements CourseRepository {

	// instead of DB using collection for storing the data
	List<Course> courses = new ArrayList<>();

	@Override
	public boolean addCourse(Course course) {
		if (!isCourseExist(course.getName())) {
			courses.add(course);
		} else {
			return false;
		}
		return true;
	}

	private boolean isCourseExist(String name) {
		return courses.stream().filter(course -> course.getName().equals(name)).findAny().isPresent();
	}

	@Override
	public List<Course> getCourseByName(List<String> courseName) {
		return courses.stream().filter(course->courseName.contains(course.getName())).collect(Collectors.toList());
	}

	@Override
	public boolean deleteCourseByName(String courseName) {
		Course course = courses.stream().filter(cours->cours.getName().equals(courseName)).findFirst().orElse(null);
		if(course != null)
			courses.remove(course);
		else
			return false;
		return true;
	}

}
