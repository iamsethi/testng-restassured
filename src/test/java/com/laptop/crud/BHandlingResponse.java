package com.laptop.crud;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class BHandlingResponse {
	
	//.accept(ContentType.XML) in which format you want to accept the data also we can use Header
	@Test
	public void getTest()
	{
		String url = "http://localhost:8080/laptop-bag/webapi/api/all";
		Response response = given()
				.accept(ContentType.XML)
				.when()
				.get(url);
		
		System.out.println(response.asString());
	}
	
	

}
