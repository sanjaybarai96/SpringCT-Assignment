package com.demo.crs.constant;

public class ResponseMsg {

	public static final String COURSE_ADDED = "Course successfully inserted";
	public static final String COURSE_EXIST = "Course is already exist.";
	public static final String COURSE_INVALID = "Course data is invalid. Please check the course data";
	public static final String COURSE_DELETED = "Course is deleted.";
	public static final String COURSE_NOT_DELETED = "Course is not found to be delete.";

	public static final String STUDENT_ADDED = "Student successfully inserted.";
	public static final String STUDENT_EXIST = "Student is already exist.";
	public static final String STUDENT_INVALID = "Student data is invalid. Please check the student data";

	
	public static final String STUDENT_COURSE = "Student allocated course successfully.";
	public static final String COURSE_NOT_EXIST = "You mentioned course does not exist in DB :: ";
	public static final String STUDENT_COURSE_ALLOCATING_INVALID = "Student allocating course data is invalid. Please check the data";

	public static final String INVALID_COURSE_NAME = "Course name cannot be empty and null";
}
