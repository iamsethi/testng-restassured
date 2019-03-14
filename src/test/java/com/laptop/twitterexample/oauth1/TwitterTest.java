package com.laptop.twitterexample.oauth1;


import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TwitterTest {
	//https://apps.twitter.com/
	String consumerKey = "pkjHuEnmszBkDQeQiKQCa6mM3";
	String consumerSecret = "Q2VncvJguqhwAdJtL0m5179A9lWE085VHqsqRSjmqxL8U1wyr6";
	String accessTokenSecret = "149037788-Kksp0VfC3B157PAxL7901OF1QDkuLEnM2EQANvmF";
	String secretToken = "dNrWU3IhO5vBKKMY7JuUkmQ2p2EPgUZ8udFea6a5yu1dY";
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses";
	}
	

	@Test
	public void createTweet(){
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessTokenSecret, secretToken)
		.queryParam("status","Love u @msdhoni!!")
		.when()
		.post("/update.json")
		.then()
		.statusCode(200);
	}
	
	@Test
	public void getTweets(){
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessTokenSecret, secretToken)
		.queryParam("screen_name","iam_sethi")
		.when()
		.get("/user_timeline.json")
		.then()
		.statusCode(200);
	}

}
