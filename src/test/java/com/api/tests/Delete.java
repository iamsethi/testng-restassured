package com.api.tests;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.student.base.TestBase;
public class Delete extends TestBase  {
	
	
	/**
	 * Test for Deleting student information
	 */
	@Test
	public void deleteStudent(){
		//Put the student ID here
		String studentId="59";
		
		given()
		.when()
		.delete("/"+studentId)
		.then()
		.statusCode(204);
	}

}
