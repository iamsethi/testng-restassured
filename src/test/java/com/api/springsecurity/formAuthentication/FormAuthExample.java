package com.api.springsecurity.formAuthentication;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

public class FormAuthExample {

	public static SessionFilter filter;
	
	@BeforeClass
	public static void init(){
		
		filter = new SessionFilter();//session ID will be captured in this filter
		
		RestAssured.baseURI="http://localhost:8085";
		
		RestAssured.given().auth().form("user", "user",new FormAuthConfig("/login","uname","pwd"))
		.filter(filter) //session ID will be captured in this filter
		.get();
		
		System.err.println(filter.getSessionId());
	}
	
	@Test
	public void getAllStudents(){
		RestAssured.given()
		.sessionId(filter.getSessionId())
		.get("/student/list")
		.then()
		.log().all();
	}
	
}
