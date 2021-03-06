package com.api.crud;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;
public class PutTest extends TestBase{	
	
	@Test(description="http://localhost:8085/student/50")
	public void updateStudent(){
		//Put the student ID here
		String studentId="50";
		
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");
		courses.add("C#");
		
		Student student = new Student();
		student.setFirstName("Mark");
		student.setLastName("Taylor");
		student.setEmail("xyzqw@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.log()
		.all()
		.put("/"+studentId)
		.then()
		.statusCode(200);
		
	
	}

}
