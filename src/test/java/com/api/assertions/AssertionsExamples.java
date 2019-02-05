package com.api.assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssertionsExamples {
	static final String APIKEY = "38456a8097msh8b40ea11c2cad67p1f4175jsn50cae3bbd864";

	@BeforeClass
	public static void init() {

		RestAssured.baseURI = "https://trains.p.rapidapi.com/";
	}
	

	// 1) Verify if the number of items is equal to 10
	@Test
	public void test001() {
		given()
		.header("Content-Type", "application/json")
		.header("X-RapidAPI-Key", APIKEY)
		.when()
		.body("{\"search\":\"Rajdhani\"}")
		.post()
		.then()
			.body("train_num.size()", equalTo(6));
		
	}

	// 2) Verify Query
	@Test
	public void test002() {
		given()
		.header("Content-Type", "application/json")
		.header("X-RapidAPI-Key", APIKEY)
		.when()
		.body("{\"search\":\"Rajdhani\"}")
		.post()
		.then()
		.body("train_from[0]", equalToIgnoringCase("dbrg"));
	}


	// 3) Check Single Name in ArrayList
	@Test
	public void test003() {
		given()
		.header("Content-Type", "application/json")
		.header("X-RapidAPI-Key", APIKEY)
		.when()
		.body("{\"search\":\"Rajdhani\"}")
		.post()
		.then()
		.body("train_from",hasItem("NDLS"));}

	// 4) Check Multiple Names in ArrayList
	@Test
	public void test004() {
		given()
		.header("Content-Type", "application/json")
		.header("X-RapidAPI-Key", APIKEY)
		.when()
		.body("{\"search\":\"Rajdhani\"}")
		.post()
		.then()
		.body("train_from",hasItems("NDLS","DBRG"));}

	
	// 5) Verify the gift options for the first product (Checking Values inside Map using hasValue())
		@Test
		public void test005() {
			given()
			.header("Content-Type", "application/json")
			.header("X-RapidAPI-Key", APIKEY)
			.when()
			.body("{\"search\":\"Rajdhani\"}")
			.post()
			.then()
			.body("data[0]", hasKey("classes"));
			}



	// 6) Check hashmap values inside a list
		@Test
		public void test006() {
			given()
			.header("Content-Type", "application/json")
			.header("X-RapidAPI-Key", APIKEY)
			.when()
			.body("{\"search\":\"Rajdhani\"}")
			.post()
			.then()
			.body("data.findAll{it.id=='7974'}", hasItems(hasEntry("id", "7974")));
					
		}
		
	// 7) Checking multiple values in the same statement
	  @Test
		public void test007() {
			given()
			.header("Content-Type", "application/json")
			.header("X-RapidAPI-Key", APIKEY)
			.when()
			.body("{\"search\":\"Rajdhani\"}")
			.post()
			.then()
			.body("data.findAll{it.id=='7974'}", hasItems(hasEntry("id", "7974")))
			.body("data.id",hasItem("7974"))
			.statusCode(200);
		}
	// 8) Logical Assertions
	@Test
	public void test008() {
		given()
		.header("Content-Type", "application/json")
		.header("X-RapidAPI-Key", APIKEY)
		.when()
		.body("{\"search\":\"Rajdhani\"}")
		.post()
		.then()
		.body("train_num.size()",equalTo(6))
		.body("train_num.size()",greaterThan(5))
		.body("train_num.size()",lessThan(11))
		.body("train_num.size()",greaterThanOrEqualTo(6))
		.body("train_num.size()",lessThanOrEqualTo(6));
			
	}

}
