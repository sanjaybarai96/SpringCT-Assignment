1]  Add a Course
URL: http://localhost:8080/course
Method : Post
Request: {
	     "name":"java",
	     "professorName":"Raju",
	     "description":"core java"
	   }
Response: Course successfully inserted

2]  Add a Student
URL:http://localhost:8080/student
Method : Post
Request: {
	     "name":"paul",
	     "email":"paul@gmail.com",
	     "number":"111111111"
	   }
Response: Student successfully inserted.

3]  Allocate course to student
URL:http://localhost:8080/student/allocateCourse
Method : Post
Request: {
 	    "studentName":"paul",
	    "courseName":"java"
	   }
Response:Student allocated course successfully.

4]  Get all student
URL: http://localhost:8080/student
Method : GET 
Response:  [
    			{
		        "name": "sanjay",
		        "email": "sanjay@gmail.com",
		        "number": "12345678",
		        "courseName": "java,c++,dot net"
		     },
		     {
		        "name": "paul",
		        "email": "paul@gmail.com",
		        "number": "111111111",
		        "courseName": "java"
		     }
	     ]

5]  Delete course
URL: http://localhost:8080/course/{courseName}
Method :Delete
Response: Course is deleted.

6]  Get student details follow by courseName
URL: http://localhost:8080/student/getStudentByCourse/{courseName}
Method : Get
Response: [
    		{
	        "name": "sanjay",
      	  "email": "sanjay@gmail.com",
	        "number": "12345678",
	        "courseName": "java,c++,dot net"
	     },
	     {
	        "name": "paul",
      	  "email": "paul@gmail.com",
	        "number": "111111111",
      	  "courseName": "java"
	    }
	  ]