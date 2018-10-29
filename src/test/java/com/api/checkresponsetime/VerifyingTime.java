package com.api.checkresponsetime;

//Static Imports
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class VerifyingTime {

	
	static RequestSpecBuilder requestbuilder;
	static RequestSpecification rspec;
	
	static ResponseSpecBuilder responsebuilder;
	static ResponseSpecification responseSpec;

	static Map<String,Object> responseHeaders = new HashMap<String,Object>();

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://query.yahooapis.com";
		RestAssured.basePath = "/v1/public";
		
		requestbuilder = new RequestSpecBuilder();
		
		requestbuilder.addParam("q", "select * from yahoo.finance.xchange where pair in (\"USDTHB\", \"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")");
		requestbuilder.addParam("format","json");
		requestbuilder.addParam("env","store://datatables.org/alltableswithkeys");
		
		rspec= requestbuilder.build();
		
		//Building response
		responseHeaders.put("Content-Type","application/json;charset=utf-8");
		responseHeaders.put("Server","ATS");
		
		responsebuilder= new ResponseSpecBuilder();
		responsebuilder.expectBody("query.count",equalTo(0));
		responsebuilder.expectStatusCode(200);
		responsebuilder.expectHeaders(responseHeaders);
		responsebuilder.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);
		
		responseSpec= responsebuilder.build();
		
	
	}

	// 1)Get the time value
	@Test
	public void test001() {
	long responseTime=	given()
		.spec(rspec)
		.log()
		.all()
		.when()
		.get("/yql")
		.timeIn(TimeUnit.SECONDS);
	
	System.err.println("The time taken is: "+responseTime+" seconds");
	
	given()
	.spec(rspec)
	.log()
	.all()
	.when()
	.get("/yql")
	.then()
	.spec(responseSpec);		
	
	}

}