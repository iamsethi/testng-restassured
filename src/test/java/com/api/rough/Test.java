package com.api.rough;

//Static Imports
import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test {
	
	private String accessToken;

	@BeforeClass
	public void init() {
		RestAssured.baseURI = "https://api.sandbox.paypal.com";
		RestAssured.basePath = "/v1";
	
		
 accessToken=		given()
		.params("grant_type","client_credentials")
		.auth()
		.preemptive()
		.basic("AVOTONjTN6MpB3La6q1Kp_Csuwbn5xJA3QVDSJTO0-U8mF5mOaZ2uSyY7hs5mkB-wjz-8eQ3wU9iRx_7", "EBDZTgp9LD7Te3wz3ysl1PD8HPBjVFkCl9XupTDpDZful06rotwc_EcqKbyDH971QoH_r__8eUMtoMHs")
		.when()
		.post("/oauth2/token")
		.then()
		.extract()
		.path("access_token");
System.out.println(accessToken);

		
	}
	
	@org.testng.annotations.Test(description = "https://api.sandbox.paypal.com/v1/oauth2/token")
	public void test()
	{
		String body="{\"intent\":\"sale\",\"payer\":{\"payment_method\":\"paypal\"}"
				+ ",\"transactions\":[{\"amount\":{\"total\":\"30.11\",\""
				+ "currency\":\"USD\",\"details\":{\"subtotal\":\"30.00\",\"tax\":\"0.07\",\"shipp"
				+ "ing\":\"0.03\",\"handling_fee\":\"1.00\",\"shipping_discount\":\"-1.00\",\"insurance\":\"0.01\"}},\"description\":\"The payment transaction description.\",\"custom\":\"EBAY_EMS_90048630024435\",\"invoice_number\":\"48787589673\",\"payment_options\":{\"allowed_payment_method\":\"INSTANT_FUNDING_SOURCE\"},\"soft_descriptor\":\"ECHI5786786\",\"item_list\":{\"items\":[{\"name\":\"hat\",\"description\":\"Brown hat.\",\"quantity\":\"5"
				+ "\",\"price\":\"3\",\"tax\":\"0.01\",\"sku\":\"1\",\"currency\":\"USD\"},{\"name\":\"handbag\",\"description\":\"Black handbag.\",\"quantity\":\"1\",\"price\":\"15\",\"tax\":\"0.02\",\"sku\":\"product34\",\"currency\":\"USD\"}],\"shipping_address\":{\"recipient_name\":\"Brian Robinson\",\"line1\":\"4th Floor\",\"line2\":\"Unit #34\",\"city\":\"San Jose\",\"country_code\":\"US\",\"postal_code\":\"95131\",\"phone\":\"011862212345678\",\"state\":\"CA\"}}}],\"note_to_payer\":\"Contact us for any questions on your order.\",\"redirect_urls\":{\"return_url\":\"http://www.amazon.com\",\"ca"
				+ "ncel_url\":\"http://www.hawaii.com\"}}";

		given()
		.contentType(ContentType.JSON)
		.auth()
		.oauth2(accessToken)
		.when()
		.body(body)			
		.post("/payments/payment")
		.then()
		.statusCode(HttpStatus.SC_CREATED);
		

	}
	
	

}
