package com.api.jsoup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.filter.session.SessionFilter;

public class JsoupExamples {
	public static SessionFilter filter;

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8085";
		filter = new SessionFilter();//session ID will be captured in this filter

		RestAssured.given()
					.auth()
					.form("user", "user", new FormAuthConfig("/login", "uname", "pwd")).filter(filter) 
					.post()
					.then();

	}

	@Test
	public void extractTitle() {
		String response = RestAssured.given()
									.when()
									.get("http://localhost:8085/")
									.asString();

		Document document = Jsoup.parse(response);

		System.err.println("The title of the page is: " + document.title().toUpperCase());

	}

	@Test
	public void extractingElementsByTag() {
		String response = RestAssured.given().when().get("http://localhost:8085/").asString();
		Document document = Jsoup.parse(response);

		Elements element = document.getElementsByTag("form");

		System.out.println("The number of form elements is: " + element.size());

		for (Element e : element) {
			System.err.println(e);
		}

	}

	@Test
	public void extractingElementsById() {
		String response = RestAssured.given().when().get("http://localhost:8085/").asString();
		Document document = Jsoup.parse(response);

		Element element = document.getElementById("command");

		System.err.println("The Element contents are :" + element.text());

	}

	@Test
	public void extractingLinks() {
		String response = RestAssured.given().when().get("http://localhost:8085/").asString();
		Document document = Jsoup.parse(response);

		Elements links = document.select("a[href]");

		for (Element e : links) {
			System.err.println(e.text());
		}

	}

	@Test
	public void extractingEmailInformation() {
		String response = RestAssured.given().sessionId(filter.getSessionId()).when().get("/student/list").asString();
		Document document = Jsoup.parse(response);

		Elements emailId = document.select("table tbody tr td:nth-child(4)");

		System.out.println("The size of the table is: " + emailId.size());

		ArrayList<String> actualVal = new ArrayList<String>();
		for (Element e : emailId) {
			// System.out.println(e.text());
			actualVal.add(e.text());
		}

		assertThat(actualVal, hasItem("tincidunt.dui@ultricessit.co.uk"));

	}

}
