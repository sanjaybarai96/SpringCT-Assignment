package com.demo.crs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.crs.entity.Student;
import com.demo.crs.entity.StudentCourse;

@Repository
public interface StudentRepository {

	public boolean addStudent(Student student);
	public List<Student> getAllStudent();
	public void allocateStudentCourse(StudentCourse studentCourse);
	public List<StudentCourse> getStudentAllocateCourseByStudentName(List<String> studentName);
	public List<StudentCourse> getStudentAllocateCourseByCourseName(String courseName);
	public List<Student> getStudentByName(List<String> studentName);
}
