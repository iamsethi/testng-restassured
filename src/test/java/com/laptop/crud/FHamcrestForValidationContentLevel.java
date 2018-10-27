package com.laptop.crud;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class FHamcrestForValidationContentLevel {
	@BeforeClass
	public static void setUp()
	{
		baseURI ="http://localhost" ;
		port=8080;
		basePath="/laptop-bag/webapi/api/";
	}
	
	@Test
	public void testContent()
	{
		String url = "find/203";
		given()
		.accept(ContentType.JSON)
		.when()
		.get(url)
		.then()
		.body("BrandName",containsString("Dell"),"Id",equalToIgnoringCase("203"));

	}
	
	

}
