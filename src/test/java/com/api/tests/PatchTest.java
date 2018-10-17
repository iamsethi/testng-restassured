package com.api.tests;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;
public class PatchTest  extends TestBase{

	
	/**
	 * Test for Updating student information
	 */
	
	@Test
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
		student.setEmail("mnxxx@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/"+studentId)
		.then()
		.statusCode(200);
		
	
	}

}
