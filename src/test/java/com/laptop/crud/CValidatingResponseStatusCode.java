package com.laptop.crud;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class CValidatingResponseStatusCode {

	@Test
	public void getTest()
	{
		String url = "http://localhost:8080/laptop-bag/webapi/api/all";
		int code = given()
				.accept(ContentType.XML)
				.when()
				.get(url)
				.thenReturn()
				.statusCode();
		
		System.out.println(code);
		Assert.assertEquals(HttpStatus.SC_NO_CONTENT, code);
		
		given()
		.accept(ContentType.XML)
		.when()
		.get(url)
		.then()
		.assertThat()
		.statusCode(HttpStatus.SC_NO_CONTENT);
	}
	
	

}
