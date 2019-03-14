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
	static final String OAUTH_TOKEN = "BQAn-qK_njsN4QS_YDxiBuXzXU_X3gozuJJ7sHtw5V7jGNxETIjowLesCMGeo17UbDy8fKKTVZ0hKPNtF9KlsCKjC84qmTvs9lIVkgcF2S6IgVWV8AUs1J_2fJkeAKnW_uR1RhQZsWlpYb6Ef_D-j4jn9uWqeLo_Wg";
	//generate OAUTH_TOKEN manually
	//https://developer.spotify.com/console/get-artist-albums/?id=0TnOYISbd1XYRBk9myaseg&include_groups=single%2Cappears_on&market=ES&limit=10&offset=5
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://api.spotify.com";
		RestAssured.basePath = "/v1";
	}
	

	// 1) Verify if the number of items is equal to 10
	@Test
	public void test001() {
		given()
		.header("Accept", "application/json")
		.header("Content-Type","application/json")
		.auth()
		.oauth2(OAUTH_TOKEN)
		.queryParam("market", "ES")
		.queryParam("limit", "10")
		.queryParam("offset", "5")
		.when()
		.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
		.then()
		.body("items.size()", equalTo(10));
		
	}

	
	// 2) Verify Query
		@Test
		public void test002() {
			given()
			.header("Accept", "application/json")
			.header("Content-Type","application/json")
			.auth()
			.oauth2(OAUTH_TOKEN)
			.queryParam("market", "ES")
			.queryParam("limit", "10")
			.queryParam("offset", "5")
			.when()
			.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
			.then()
			.body("href", equalToIgnoringCase("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?offset=5&limit=10&market=ES"));
		}


		// 3) Check Single Name in ArrayList
		@Test
		public void test003() {
			given()
			.header("Accept", "application/json")
			.header("Content-Type","application/json")
			.auth()
			.oauth2(OAUTH_TOKEN)
			.queryParam("market", "ES")
			.queryParam("limit", "10")
			.queryParam("offset", "5")
			.when()
			.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
			.then()
			.body("items.name",hasItem("Party Ain't Over"));
		}

		// 4) Check Multiple Names in ArrayList
		@Test
		public void test004() {
			given()
			.header("Accept", "application/json")
			.header("Content-Type","application/json")
			.auth()
			.oauth2(OAUTH_TOKEN)
			.queryParam("market", "ES")
			.queryParam("limit", "10")
			.queryParam("offset", "5")
			.when()
			.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
			.then()
			.body("items.name",hasItems("Party Ain't Over","Drinks for You (Ladies Anthem)"));
		}
		
		// 5) Verify the gift options for the first product (Checking Values inside Map using hasValue())
			@Test
			public void test005() {
				given()
				.header("Accept", "application/json")
				.header("Content-Type","application/json")
				.auth()
				.oauth2(OAUTH_TOKEN)
				.queryParam("market", "ES")
				.queryParam("limit", "10")
				.queryParam("offset", "5")
				.when()
				.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
				.then()
				.body("items[0].artists[0]", hasKey("uri"));
				}

		// 6) Check hashmap values inside a list
		@Test
		public void test006() {
			given()
			.header("Accept", "application/json")
			.header("Content-Type","application/json")
			.auth()
			.oauth2(OAUTH_TOKEN)
			.queryParam("market", "ES")
			.queryParam("limit", "10")
			.queryParam("offset", "5")
			.when()
			.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
			.then()
			.body("items.findAll{it.name=='Get It Started'}", hasItems(hasEntry("name","Get It Started")));
					
		}
		

		// 7) Checking multiple values in the same statement
		@Test
		public void test007() {
			given()
			.header("Accept", "application/json")
			.header("Content-Type","application/json")
			.auth()
			.oauth2(OAUTH_TOKEN)
			.queryParam("market", "ES")
			.queryParam("limit", "10")
			.queryParam("offset", "5")
			.when()
			.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
			.then()
			.body("items.findAll{it.name=='Get It Started'}", hasItems(hasEntry("name", "Get It Started")))
			.body("items.name",hasItem("Get It Started"))
			.statusCode(200);
		}

		// 8) Logical Assertions
		@Test
		public void test008() {
			given()
			.header("Accept", "application/json")
			.header("Content-Type","application/json")
			.auth()
			.oauth2(OAUTH_TOKEN)
			.queryParam("market", "ES")
			.queryParam("limit", "10")
			.queryParam("offset", "5")
			.when()
			.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
			.then()
			.body("items.size()",equalTo(10))
			.body("items.size()",greaterThan(5))
			.body("items.size()",lessThan(11))
			.body("items.size()",greaterThanOrEqualTo(10))
			.body("items.size()",lessThanOrEqualTo(10));
				
		}

	}

