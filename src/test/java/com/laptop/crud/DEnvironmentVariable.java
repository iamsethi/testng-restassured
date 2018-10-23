package com.laptop.crud;

import static io.restassured.RestAssured.*;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class DEnvironmentVariable {
	@BeforeClass
	public static void setUp()
	{
		baseURI ="http://localhost" ;
		port=8080;
		basePath="/laptop-bag/webapi/api/";
	}
	
	@Test
	public void getTest()
	{
		String url = "find/121";
		int code = given()
				.accept(ContentType.XML)
				.when()
				.get(url)
				.thenReturn()
				.statusCode();
		
		System.out.println(code);
		Assert.assertEquals(HttpStatus.SC_NOT_FOUND, code);
		
	String body=	given()
		.accept(ContentType.XML)
		.when()
		.get(url)
		.thenReturn()
		.body()
		.asString();
	
	System.out.println(body);
	}
	
	

}
