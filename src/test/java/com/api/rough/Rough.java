package com.api.rough;

import static io.restassured.RestAssured.given;

import java.io.File;

public class Rough {

	public static void main(String args[]) {
		File f1 = new File(System.getProperty("user.dir") + File.separator + "geckodriver-v0.11.1-arm7hf.tar.gz");
		int l = (int) f1.length();
		String endpoint = "https://github.com/mozilla/geckodriver/releases/download/v0.11.1/geckodriver-v0.11.1-arm7hf.tar.gz";
		byte[] b = given().when().get(endpoint).then().extract().asByteArray();
		System.out.println(l + "  &&&&&&&&&&^%$%^&*" + b.length);
	}

}
