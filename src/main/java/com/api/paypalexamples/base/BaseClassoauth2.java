package com.api.paypalexamples.base;

//Static Imports
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BaseClassoauth2 {
	
	public	static String accessToken;
	
	//PUT YOUR CLIENT ID & CLIENT SECRET HERE  https://developer.paypal.com/developer/applications/create
	public static final String  clientId="AVOTONjTN6MpB3La6q1Kp_Csuwbn5xJA3QVDSJTO0-U8mF5mOaZ2uSyY7hs5mkB-wjz-8eQ3wU9iRx_7";
	public static  final String  clientSecret="EBDZTgp9LD7Te3wz3ysl1PD8HPBjVFkCl9XupTDpDZful06rotwc_EcqKbyDH971QoH_r__8eUMtoMHs";

	//https://api.sandbox.paypal.com/v1/oauth2/token
	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI="https://api.sandbox.paypal.com";
		RestAssured.basePath="/v1";
	
		accessToken=	given()
				.params("grant_type","client_credentials")
				.auth()
				.preemptive()
				.basic(clientId, clientSecret)
				.when()
				.post("/oauth2/token")
				.then()
				.extract()
				.path("access_token");
		 System.out.println("The token is: "+accessToken);
	}
	
	@Test
	public void test()
	{
		System.out.println("Test");
	}
	
}
