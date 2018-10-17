package com.api.assertions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssertionsExamples {
	static final String APIKEY = "s7wv3tu7h8snrjz5de29uq8v";

	@BeforeClass
	public static void init() {

		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}

	// 1) Verify if the number of items is equal to 10
	@Test
	public void test001() {
		given()
				.queryParam("query","ipod")
				.queryParam("apiKey",APIKEY)
				.queryParam("format","json")
				.when()
				.get("/search")
				.then()
				.body("numItems", equalTo(10));
		
	}

	// 2) Verify Query
	@Test
	public void test002() {
		given()
		.queryParam("query","ipod")
		.queryParam("apiKey",APIKEY)
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.body("query", equalToIgnoringCase("IPOD"));
	}


	// 3) Check Single Name in ArrayList
	@Test
	public void test003() {
		given()
		.queryParam("query","ipod")
		.queryParam("apiKey",APIKEY)
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.body("items.name",hasItem("Apple iPod touch 128GB"));
	}

	// 4) Check Multiple Names in ArrayList
	@Test
	public void test004() {
		given()
		.queryParam("query","ipod")
		.queryParam("apiKey",APIKEY)
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.body("items.name",hasItems("Apple iPod touch 128GB"));
	}
	
	// 5) Verify the gift options for the first product (Checking Values inside Map using hasValue())
		@Test
		public void test005() {
			given()
			.queryParam("query","ipod")
			.queryParam("apiKey",APIKEY)
			.queryParam("format","json")
			.when()
			.get("/search")
			.then()
			.body("items[0].imageEntities[0]", hasKey("entityType"));
			}

	// 6) Check hashmap values inside a list
	@Test
	public void test006() {

				given()
				.queryParam("query","ipod")
				.queryParam("apiKey",APIKEY)
				.queryParam("format","json")
				.when()
				.get("/search")
				.then()
				.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GB")));
				
	}
	

	// 7) Checking multiple values in the same statement
	@Test
	public void test007() {
		given()
		.queryParam("query","ipod")
		.queryParam("apiKey",APIKEY)
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GB")))
		.body("items.name",hasItem("Apple iPod touch 128GB"))
		.statusCode(200);
	}

	// 8) Logical Assertions
	@Test
	public void test008() {
		given()
		.queryParam("query","ipod")
		.queryParam("apiKey",APIKEY)
		.queryParam("format","json")
		.when()
		.get("/search")
		.then()
		.body("items.size()",equalTo(10))
		.body("items.size()",greaterThan(5))
		.body("items.size()",lessThan(11))
		.body("items.size()",greaterThanOrEqualTo(10))
		.body("items.size()",lessThanOrEqualTo(10));
			
	}

}
