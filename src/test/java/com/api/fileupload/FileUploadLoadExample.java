package com.api.fileupload;


import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadLoadExample {

	/**
	 * Upload a gif file to zamzar.com and convert it into a png file
	 */
	@Test
	public void uploadFileExample(){

	//PUT YOU API KEY HERE
	String apiKey="5eaa67710bfd39000409ebf618b0a7d949867b62";
	
		File inputFile = new File(System.getProperty("user.dir")+File.separator+"dancing_banana.gif");
		System.out.println(inputFile.length());
		String endpoint = "https://sandbox.zamzar.com/v1/jobs";
		
		given()
		.auth()
		.basic(apiKey,"")
		.multiPart("source_file",inputFile)
		.multiPart("target_format","png")
		.when()
		.post(endpoint)
		.then()
		.log()
		.all();
	}
}
