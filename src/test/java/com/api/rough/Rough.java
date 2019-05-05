package com.api.rough;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
public class Rough {

	public static String OAUTH_TOKEN = "BQBKvDm3KhxLXmBgbDfWwNGX8RNHY_OUrtoJR_NyCct1wIe38cIXDLCkB8x1Qluq3B93bhudT8CJaL5SQCly7yF8PjFQkQTXBoGpknW6MH9wKFK_ZhFhUX_uFoXtBxrXXQ6LFTqnTgPMG5mEqWoVgjplhBBnKI52yw";

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://api.spotify.com";
		RestAssured.basePath = "/v1";

	}

	
	@org.testng.annotations.Test
	public void equalToTest() {
		
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
		.log()
		.all()
		.body("items.size()",equalTo(10));
				
	}

	
	@org.testng.annotations.Test
	public void equalToIgnoringCaseTest() {
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.auth()
		.oauth2(OAUTH_TOKEN)
		.queryParam("offset", "5")
		.queryParam("limit", "10")
		.queryParam("market", "ES")
		.when()
		.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
		.then()
		.statusCode(200)
		.body("href", equalToIgnoringCase("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?offset=5&limit=10&market=ES"));
		
				
	}
	
	@org.testng.annotations.Test
	public void hasItemTest() {
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.auth()
		.oauth2(OAUTH_TOKEN)
		.queryParam("offset", "5")
		.queryParam("limit", "10")
		.queryParam("market", "ES")
		.when()
		.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
		.then()
		.statusCode(200)
		.body("items.name", hasItem("Party Ain't Over"));
		
				
	}
	
	@org.testng.annotations.Test
	public void hasItemsTest() {
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.auth()
		.oauth2(OAUTH_TOKEN)
		.queryParam("offset", "5")
		.queryParam("limit", "10")
		.queryParam("market", "ES")
		.when()
		.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
		.then()
		.statusCode(200)
		.body("items.name", hasItems("Party Ain't Over","Drinks for You (Ladies Anthem)"));
					
	}
	
	@org.testng.annotations.Test
	public void hasKeyTest() {
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.auth()
		.oauth2(OAUTH_TOKEN)
		.queryParam("offset", "5")
		.queryParam("limit", "10")
		.queryParam("market", "ES")
		.when()
		.get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
		.then()
		.statusCode(200)
		.body("items[0].artists[0]", hasKey("uri"));
					
	}
	
}
