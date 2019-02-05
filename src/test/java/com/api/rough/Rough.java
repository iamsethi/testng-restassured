package com.api.rough;

import org.testng.annotations.Test;

public class Rough {

<<<<<<< HEAD
	@Test(groups = { "cars", "bikes" })
	public void b() {
		System.out.println("cars and bikes ");
=======
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
		port=8085;
		basePath = "/v1/public";
//		rootPath="query.results.rate";
		
>>>>>>> branch 'master' of https://github.com/iamsethi/testng-restassured.git
	}

	@Test(groups = { "cars" })
	public void a() {
		System.out.println("cars ");
	}

	@Test(groups = { "bikes" })
	public void c() {
		System.out.println("bikes ");
	}
}
