package com.api.filters;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FilterExamples {

	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	
	
	public static StringWriter errorWriter;
	public static PrintStream errorCapture;
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI ="http://localhost:8085";
		RestAssured.basePath="/student";
	}
	
	@BeforeTest
	public  void beforeEachTest(){
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);
		
		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter),true);
		
		errorWriter = new StringWriter();
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter),true);
	}
	
	
	@Test
	public void getStudent(){
	
	RestAssured
	.given()
	.filter(new RequestLoggingFilter(requestCapture))
	.filter(new ResponseLoggingFilter(responseCapture))
	.when()
	.get("/list");
	
	System.err.println(requestWriter.toString());
	
	System.err.println(responseWriter.toString());
	
	
	RestAssured
	.given()
	.filter(new ErrorLoggingFilter(errorCapture))
	.when()
	.get("/listsww");
	
	System.err.println(errorWriter.toString().toUpperCase());
	}
}
