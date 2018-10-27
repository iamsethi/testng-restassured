package com.api.rough;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static org.hamcrest.Matchers.hasItems;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class Rough {
	static RequestSpecBuilder builder;
	static RequestSpecification requestSpec;
	
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;

	public static StringWriter responseWriter;
	public static PrintStream responseCapture;

	public static StringWriter errorWriter;
	public static PrintStream errorCapture;

	@BeforeClass
	public static void init() {
		baseURI = "http://localhost";
		port=8080;
		basePath = "/v1/public";
//		rootPath="query.results.rate";
		
	}

	@BeforeTest
	public void beforeEachTest() {
		requestWriter = new StringWriter();
		responseWriter = new StringWriter();
		errorWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter), true);
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter), true);
		
		
		
		builder = new RequestSpecBuilder();											// BUILDER
		ProxySpecification ps = new ProxySpecification("localhost", 5555, "http");  // PROXY CLASS		
		builder.setProxy(ps);														// BUILDER + SET PROXY
		builder.addQueryParam("query","ipod");										// BUILDER										
		builder.addQueryParam("apiKey", "123456");									// BUILDER
		builder.addQueryParam("format", "json");									// BUILDER
		builder.addHeader("Accept", "*/*");											// BUILDER
		requestSpec = builder.build();												// BUILDER.build()
	}

	@Test
	public void getStudent() throws Exception {
		
		RestAssured
		.given()
//		.contentType(ContentType.JSON)	
//		.contentType("text/xml")		
		.filter(new RequestLoggingFilter(requestCapture))       //RLF RC  PS WOS
		.filter(new ResponseLoggingFilter(responseCapture))
//		.multiPart("source_file",inputFile)   					//FILE UPLOAD
//		.multiPart("target_format","png")	  					//FILE UPLOAD	
//		.log()
//		.headers()							  					//LOG REQUEST HEADERS
//		.log()
//		.params()							  					//LOG REQUEST PARAMS
//		.log()
//		.body()		                          					//LOG REQUEST BODY
//		.log()
//		.ifValidationFails()				  					//LOG IF VALIDATION FAILS	
//		.log()
//		.all()								  					//LOG ALL THE DETAILS
		.when()
		.get("/list")
//	    .timeIn(TimeUnit.SECONDS);  							// VERIFYING TIME	
//  	.asString();                							// JSON ASSERT actual value	
		.then()     
//		.log()
//		.headers()	
//		.log()
//		.status()	
//		.log()
//		.body()
//		.log()
//		.ifError()		
//		.extract()		            							// FILE DOWNLOAD SIZE			
//		.asByteArray();             							// FILE DOWNLOAD SIZE
//		.extract()												// SEARCH JSON PATH
//		.path("numItems");		    							// SEARCH JSON PATH  	
		.body("id",hasItems(10));								// HAMCREST MATCHER
//		.body("[0].firstName",equalTo("Verno"))					// HARD ASSERT
//		.body("[0].lastName",equalTo("Harper"))	    			// HARD ASSERT
//		.body("[0].firstName",equalTo("Vernonw"),   			// SOFT ASSERT
//				"[0].lastName",equalTo("Harper"));				// SOFT ASSERT	
		
		
		
		System.err.println(requestWriter.toString());	
		System.err.println(responseWriter.toString());
		
//		String expectedValue = new String(
//				Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "file.txt")));
//		JSONAssert.assertEquals(expectedValue, "actualValue", JSONCompareMode.LENIENT);

	}
}
