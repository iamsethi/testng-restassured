package com.laptop.crud;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ECustomizeHeader {
	@BeforeClass
	public static void setUp()
	{
		baseURI ="http://localhost" ;
		port=8888;
		basePath="/laptop-bag/webapi/api/";
	}
	
	@Test
	public void getTest()
	{
		String url = "find/203";
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Accept", "application/json"); 
		//headers.put("Accept", "application/xml");
		//headers.put("Accept", "application/text");
		String body=	given()
						.headers(headers)
						.when()
						.get(url)
						.thenReturn()
						.body()
						.asString();
			
			System.out.println(body);
		

	}
	
	

}
