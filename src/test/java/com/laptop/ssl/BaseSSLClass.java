package com.laptop.ssl;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.certificate;
import static io.restassured.RestAssured.port;

import org.testng.annotations.BeforeClass;

public class BaseSSLClass {
	
	@BeforeClass
	public static void setUp() {
		baseURI = "https://localhost";
		port = 9999;
		basePath = "/laptop-bag/webapi/sslres";
		authentication = certificate("./src/test/resources/laptop/SSL/mykey.keystore", "password");
	}


}
