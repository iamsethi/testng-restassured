package com.api.jsonassert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssertCompleteJsonResponse {

	@Test
	public void getStudents() throws IOException, JSONException {
		String expectedValue = new String(
				Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "file.txt")));

		String actualValue = RestAssured.given().when().get("http://localhost:8085/student/list").asString();

		System.out.println(expectedValue);
		System.out.println(actualValue);

		JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.STRICT);

	}

	@Test
	public void getStudentsStrict() throws IOException, JSONException {
		String expectedValue = new String(
				Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "difforder.txt")));

		String actualValue = RestAssured.given().when().get("http://localhost:8085/student/list").asString();

		System.out.println(expectedValue);
		System.out.println(actualValue);

		JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT);

	}
}
