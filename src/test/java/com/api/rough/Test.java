package com.api.rough;

//Static Imports
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test {
	
	private String accessToken;

	@BeforeClass
	public void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath = "/student";
		
	}
	
	@org.testng.annotations.Test(description = "https://api.sandbox.paypal.com/v1/oauth2/token")
	public void test()
	{

	long respTime=	given()
		.accept(ContentType.JSON)
		.when()
		.get("/list")
		.timeIn(TimeUnit.MILLISECONDS);
	
	System.out.println(respTime);
		

	}
	
	

}
