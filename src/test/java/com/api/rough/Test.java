package com.api.rough;

//Static Imports
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class Test {

	@BeforeClass
	public void init() {
		RestAssured.baseURI = "https://sandbox.zamzar.com";
	}

	@org.testng.annotations.Test()
	public void test()
	{
		
		
	given()
	.auth()
	.basic("5eaa67710bfd39000409ebf618b0a7d949867b62", "")	
	.multiPart("source_file",new File(System.getProperty("user.dir")+File.separator+"dancing_banana.gif"))
	.multiPart("target_format","png")
	.when()
	.post("/v1/jobs")
	.then()
	.log()
	.all();
	

	}

}
