package com.demo.crs.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.demo.crs.entity.Student;
import com.demo.crs.entity.StudentCourse;
import com.demo.crs.repository.StudentRepository;

@Repository
public class StudentRepoImpl implements StudentRepository {

	//instead of DB using collection for storing the data
	List<Student> students = new ArrayList<>();
	List<StudentCourse> studentCourses = new ArrayList<>();

	@Override
	public boolean addStudent(Student student) {
		if(!isStudentExist(student.getEmail())) {
			students.add(student);
		}else {
			return false;
		}
		return true;
	}

	private boolean isStudentExist(String email) {

		return students.stream().filter(student->student.getEmail().equals(email))
				.findAny().isPresent();
	}

	@Override
	public List<Student> getAllStudent() {
		return students;
	}

	@Override
	public void allocateStudentCourse(StudentCourse studentCourse) {
		if(isStudentCourseExist(studentCourse.getStudentName())) {
			for(StudentCourse stdCourse : studentCourses) {
				
				if(stdCourse.getStudentName().equals(studentCourse.getStudentName())) {
					studentCourses.remove(stdCourse);
					studentCourses.add(studentCourse);
					return;
				}
			}
		}else {
			studentCourses.add(studentCourse);
		}
	}

	private boolean isStudentCourseExist(String studentName) {
		return studentCourses.stream().filter(studentCourse->studentCourse.getStudentName().equals(studentName)).findAny().isPresent();
	}

	@Override
	public List<StudentCourse> getStudentAllocateCourseByStudentName(List<String> studentNames) {
		return studentCourses.stream().filter(stdCourse->studentNames.contains(stdCourse.getStudentName())).collect(Collectors.toList());
	}

	@Override
	public List<StudentCourse> getStudentAllocateCourseByCourseName(String courseName) {
		return studentCourses.stream().filter(stdCourse->stdCourse.getCourseName().contains(courseName)).collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentByName(List<String> studentName) {
		return students.stream().filter(student->studentName.contains(student.getName())).collect(Collectors.toList());
	}
}
