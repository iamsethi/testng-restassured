package com.laptop.crud;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;


public class GetTest {
	// Use static import so that we don't need to write RestAssured.when...
	@Test
	public void getTest()
	{
		String url = "http://localhost:8888/laptop-bag/webapi/api/ping/hello";
		when()
		.get(url);
	}
	
	

}
