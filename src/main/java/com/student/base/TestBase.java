package com.student.base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {
	
	
	@BeforeClass
	public static void init(){
		//java -jar rest.jar --server.port=8085
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8085;
		RestAssured.basePath="/student";
		
	}

}
