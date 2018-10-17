package com.api.loggingexamples;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.student.base.TestBase;
import com.student.model.Student;

import io.restassured.http.ContentType;
public class LoggingRequestValues extends TestBase{
	
	
	/**
	 * This test will print out all the request headers
	 */
	@Test
	public void test001(){
		System.out.println("---------------Printing Request Headers------------------");
		given()
		.log()
		.headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
	}
	
	/**
	 * This test will print out all the request Parameters
	 */
	@Test
	public void test002(){
		System.out.println("---------------Printing Request Parameters------------------");
		given()
		.param("programme", "Computer Science")
		.param("limit",1)
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	
	/**
	 * This test will print out the Request body
	 */
	@Test
	public void test003(){
		ArrayList<String> courses = new ArrayList<>();
		System.out.println("---------------Printing Request Body------------------");
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("Tej");
		student.setLastName("Hegde");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.body()
		.when()
		.body(student)
		.post();
	}
	
	/**
	 * This test will print out All the details
	 */
	@Test
	public void test004(){
		ArrayList<String> courses = new ArrayList<>();
		System.out.println("---------------Printing All the Request Details------------------");
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("Tej");
		student.setLastName("Hegde");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(student)
		.post();
	}
	
	
	/**
	 * This test will print Request details if validation fails
	 */
	@Test
	public void test005(){
		ArrayList<String> courses = new ArrayList<>();
		System.out.println("---------------Printing All the Request Details if validation fails------------------");
		courses.add("Java");
		courses.add("C++");
		
		Student student = new Student();
		student.setFirstName("Tejw");
		student.setLastName("Hegdew");
		student.setEmail("xyz234@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails()
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
	}
	
	
}
