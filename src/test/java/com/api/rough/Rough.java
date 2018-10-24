package com.api.rough;

import static org.hamcrest.Matchers.hasItems;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Rough {

	public static StringWriter requestWriter;
	public static PrintStream requestCapture;

	public static StringWriter responseWriter;
	public static PrintStream responseCapture;

	public static StringWriter errorWriter;
	public static PrintStream errorCapture;

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8085";
		RestAssured.basePath = "/student";
	}

	@BeforeTest
	public void beforeEachTest() {
		requestWriter = new StringWriter();
		responseWriter = new StringWriter();
		errorWriter = new StringWriter();

		requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter), true);
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter), true);
	}

	@Test
	public void getStudent() throws Exception {
		
		RestAssured
		.given()
		.filter(new RequestLoggingFilter(requestCapture))
		.filter(new ResponseLoggingFilter(responseCapture))
//		.multiPart("source_file",inputFile)   //FILE UPLOAD
//		.multiPart("target_format","png")	  //FILE UPLOAD	
//		.log()
//		.headers()							  //LOG REQUEST HEADERS
//		.log()
//		.params()							  //LOG REQUEST PARAMS
//		.log()
//		.body()		                          //LOG REQUEST BODY
//		.log()
//		.ifValidationFails()				  //LOG IF VALIDATION FAILS	
//		.log()
//		.all()								  //LOG ALL THE DETAILS
		.when()
		.get("/list")
//	    .timeIn(TimeUnit.SECONDS);  		// VERIFYING TIME	
//  	.asString();                		// JSON ASSERT actual value	
		.then()        
//		.extract()		            		// FILE DOWNLOAD SIZE			
//		.asByteArray();             		// FILE DOWNLOAD SIZE
//		.extract()							// SEARCH JSON PATH
//		.path("numItems");		    		// SEARCH JSON PATH  	
		.body("id",hasItems(10));			// HAMCREST MATCHER
		
		
		
		System.err.println(requestWriter.toString());	
		System.err.println(responseWriter.toString());
		
//		String expectedValue = new String(
//				Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "file.txt")));
//		JSONAssert.assertEquals(expectedValue, "actualValue", JSONCompareMode.LENIENT);

	}
}
