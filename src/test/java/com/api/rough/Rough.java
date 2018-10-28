package com.api.rough;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
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
import io.restassured.http.ContentType;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class Rough {
	public	static String accessToken;
	static RequestSpecBuilder builder;
	static RequestSpecification requestSpec;
	
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;

	public static StringWriter responseWriter;
	public static PrintStream responseCapture;

	public static StringWriter errorWriter;
	public static PrintStream errorCapture;
	
	//PUT YOUR CLIENT ID & CLIENT SECRET HERE  https://developer.paypal.com/developer/applications/create
	public static final String  clientId="AVOTONjTN6MpB3La6q1Kp_Csuwbn5xJA3QVDSJTO0-U8mF5mOaZ2uSyY7hs5mkB-wjz-8eQ3wU9iRx_7";
	public static  final String  clientSecret="EBDZTgp9LD7Te3wz3ysl1PD8HPBjVFkCl9XupTDpDZful06rotwc_EcqKbyDH971QoH_r__8eUMtoMHs";


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
	public void getStudent() throws Exception {
		
		RestAssured
		.given()
//		.header("Authorization","Basic utyRewndfH") 			//Auth using header key=Authorization & value = encrypted value of user and pass 
//		.auth()													// BASIC Auth
//		.preemptive()                                          //  BASIC Auth it'll always send the u/p along with req
//		.basic("username", "password")							// BASIC Auth
//		.auth()													// OAuth 1						
//		.oauth(consumerKey, consumerSecret, accessTokenSecret, secretToken)	//OAuth 1	
//		.auth()													// OAuth 2
//		.oauth2(accessToken) 									// OAuth 2
//      .auth()													// Bypass SSL		
//		.relaxedHTTPSValidation()  								// Bypass SSL
//      .auth()													// supply valid certificate for SSL 		
//		.certificate("mykey.store","password")					// supply valid certificate for SSL
//		.accept(ContentType.XML)								// accept the response in XML
//		.contentType(ContentType.JSON)							// send the request body in JSON format
//		.contentType("text/xml")
//		.queryParam("key", "value")
//		.pathParam("key", "value")		
		.filter(new RequestLoggingFilter(requestCapture))       //RLF RC  PS WOS
		.filter(new ResponseLoggingFilter(responseCapture))
//		.multiPart("source_file",inputFile)   					//FILE UPLOAD
//		.multiPart("target_format","png")	  					//FILE UPLOAD	
//		.log()													//LOG REQUEST HEADERS
//		.headers()							  					//LOG REQUEST HEADERS
//		.log()													//LOG REQUEST PARAMS
//		.params()							  					//LOG REQUEST PARAMS
//		.log()													//LOG REQUEST BODY
//		.body()		                          					//LOG REQUEST BODY
//		.log()													//LOG IF VALIDATION FAILS
//		.ifValidationFails()				  					//LOG IF VALIDATION FAILS	
//		.log()													//LOG ALL THE DETAILS
//		.all()								  					//LOG ALL THE DETAILS
		.when()
		.get("/list")											// GET
//		.body(student)											// POST
//		.post()													// POST
//		.body(student)											// PUT
//		.put("/"+studentId)		                                // PUT
//		.body(student)											// PATCH
//		.patch("/"+studentId)									// PATCH	
//		.delete("/"+studentId)									// DELETE	
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
//		.body("query", equalToIgnoringCase("IPOD"));			// HAMCREST MATCHER			
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
