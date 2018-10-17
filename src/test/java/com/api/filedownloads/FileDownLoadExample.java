package com.api.filedownloads;


import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class FileDownLoadExample {

	//Download a file &Compare it with an Expected File
	//Check the size of the file
	@Test
	public void verifyDownloadedFile(){
		//Read the input file
		
		File inputFile = new File(System.getProperty("user.dir")+File.separator+"geckodriver-v0.11.1-arm7hf.tar.gz");
		
		//Length of input file
		int expectedSize = (int) inputFile.length();
		
		
		System.out.println("The size of the expected file is: "+expectedSize+" bytes");
		
		// https://github.com/mozilla/geckodriver/releases/download/v0.11.1/geckodriver-v0.11.1-arm7hf.tar.gz
		
		//Read the downloaded File
	byte[] actualValue=	given()
		 .when()
		 .get("https://github.com/mozilla/geckodriver/releases/download/v0.11.1/geckodriver-v0.11.1-arm7hf.tar.gz")
		 .then()
		 .extract()
		 .asByteArray();
	System.out.println("The size of the actual file is: "+actualValue.length+" bytes");
	
	
	
	}
}
