package com.api.rough;

//Static Imports
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test {

	@BeforeClass
	public void init() {
		RestAssured.baseURI = "http://localhost:8085/student";		
	}
	
	@org.testng.annotations.Test()
	public void test()
	{
		String body = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"gmail@gmail.com\",\"programme\":\"Computer Science\",\"courses\":[\"Java\",\"C++\"]}";
	given()
	.contentType(ContentType.JSON)
	.when()
	.body(body)
	.post()
	.then()
	.statusCode(HttpStatus.SC_CREATED);	
	
		

	}
	
	

}
