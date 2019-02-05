package com.laptop.ssl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class TestGetWithSSL extends BaseSSLClass  {
	
	@Test
	public void testGet() {
		String s = given()
				.relaxedHTTPSValidation()
		.accept(ContentType.XML)
		.when()
		.get("/all")
		.thenReturn()
		.asString();
		System.out.println(s);
		
		/**
		 * 1. To bypass the certificate check
		 * 2. Is to supply valid certificate along with request
		 * 
		 * */
		
	}
	
	@Test
	public void testGetWithCertificate() {
		
		given()
		.log()
		.all()
		.when()
		.get("/all")
		.then()
		.assertThat()
		.body("$", is(notNullValue()));
		
	}

}
