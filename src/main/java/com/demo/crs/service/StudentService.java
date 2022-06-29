/**
 * 
 */
package com.demo.crs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.crs.constant.ResponseMsg;
import com.demo.crs.entity.Student;
import com.demo.crs.entity.StudentCourse;
import com.demo.crs.repository.StudentRepository;

/**
 * @author 10696450
 * It contains related student service functionality
 */
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	CourseService courseService;

	public ResponseEntity<?> addStudent(Student student) {
		if(student != null) {
			boolean status = studentRepo.addStudent(student);
			return status ? new ResponseEntity<>(ResponseMsg.STUDENT_ADDED,HttpStatus.CREATED)
					: new ResponseEntity<>(ResponseMsg.STUDENT_EXIST,HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseMsg.STUDENT_INVALID,HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<?> getAllStudent() {
		List<Student> students = studentRepo.getAllStudent();
		List<String> studentName = students.stream().map(Student::getName).collect(Collectors.toList());
		List<StudentCourse> studentCourses =  studentRepo.getStudentAllocateCourseByStudentName(studentName);
		students.forEach(student->{
			StudentCourse courseName = studentCourses.stream().filter(stdCourse->stdCourse.getStudentName().equals(student.getName())).findFirst().orElse(null);
			if(courseName == null) {
				student.setCourseName("");
			}else {
				student.setCourseName(courseName.getCourseName()!=null?courseName.getCourseName():"");
			}
		});
		return new ResponseEntity<>(students,HttpStatus.OK);
	}

	public ResponseEntity<?> allocateStudentCourse(StudentCourse studentCourse) {
		if(studentCourse != null) {
			List<String> courseNotExist = courseService.checkCourse(studentCourse.getCourseName());
			if(courseNotExist.isEmpty()) {
				studentRepo.allocateStudentCourse(studentCourse);
				return new ResponseEntity<>(ResponseMsg.STUDENT_COURSE,HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(ResponseMsg.COURSE_NOT_EXIST+courseNotExist,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ResponseMsg.STUDENT_COURSE_ALLOCATING_INVALID,HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<?> getStudentByCourseName(String courseName) {
		if(courseName != null && !courseName.isEmpty()) {
			List<StudentCourse> studentCourses = studentRepo.getStudentAllocateCourseByCourseName(courseName);
			List<String> studentName = studentCourses.stream().map(StudentCourse::getStudentName).collect(Collectors.toList());
			List<Student> students = studentRepo.getStudentByName(studentName);
			return new ResponseEntity<>(students,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(ResponseMsg.INVALID_COURSE_NAME,HttpStatus.BAD_REQUEST);
		}
	}
}
