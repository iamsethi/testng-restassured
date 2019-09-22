package com.api.rough;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JamesWillet {
	//C:\Users\ketan.sethi\Downloads\VideoGameDB-master\VideoGameDB-master>gradlew bootrun
	//https://github.com/james-willett/VideoGameDB
	//http://localhost:8080/swagger-ui/index.html#/
	//https://www.football-data.org/documentation/quickstart
	//http://jsonviewer.stack.hu/
	//http://pojo.sodhanalibrary.com/ Serialization - payload to POJO
	public static RequestSpecification videoGame_requestSpec;
	public static RequestSpecification football_requestSpec;
	public static ResponseSpecification videoGame_resonseSpec;
	
	
	@BeforeClass
	public static void setupMain()
	{  
		RestAssured.proxy("localhost",8888);  //run fiddler,fiddler runs at port 8888
		
		videoGame_requestSpec = new RequestSpecBuilder().
				setBaseUri("http://localhost:8080").
				setPort(8080).
				setBasePath("/app").
				addHeader("Content-Type", "application/json").
				addHeader("Accept", "application/json").
				build();
		
		football_requestSpec= new RequestSpecBuilder().
				setBaseUri("http://api.football-data.org").
				setBasePath("/v2").
				addHeader("X-Auth-Token", "d1a162ed80ca41b39065a0a2666344fa").
				addHeader("X-Response-Control", "minified").
				build();
		
		videoGame_resonseSpec= new ResponseSpecBuilder().
				expectStatusCode(200).
				build();
	}
	
	
	 
	 
	 @Test(priority=0)
	    public void getAllGames() {

		 given()
		 .spec(videoGame_requestSpec)
		 .when()
		 .get(Endpoint.VIDEOGAMES)
		 .then()
		 .spec(videoGame_resonseSpec);
		 
	    }
	 
	 @Test(priority=1)
	    public void createNewGameByJson() {

		
		 VideoGame  videoGame = new VideoGame("40","shooter","2014-05-16","Halo 5","Mature","89");
		 given()
		 .spec(videoGame_requestSpec)
		 .body(videoGame)
		 .when()
		 .post(Endpoint.VIDEOGAMES)
		 .then()
		 .spec(videoGame_resonseSpec);
		 
	    }
	 
	 @Test(priority=2)
	    public void updateGame() {
		 VideoGame  videoGame = new VideoGame("37","shooter","2014-05-16","Halo 5","Mature","89");

		 given()
		 .spec(videoGame_requestSpec)
		 .when()
		 .body(videoGame)
		 .put(Endpoint.VIDEOGAMES+"/37")
		 .then()
		 .spec(videoGame_resonseSpec);
		 
	    }
	 

	 @Test(priority=3)
	    public void getSingleGame() {

		 given()
		 .spec(videoGame_requestSpec)
		 .pathParam("videoGameId", 24)
		 .when()
		 .get(Endpoint.SINGLE_VIDEOGAME)
		 .then()
		 .spec(videoGame_resonseSpec)
		 .time(lessThan(4000L));
		 

	Response response=	 given()
		 .spec(videoGame_requestSpec)
		 .pathParam("videoGameId", 24)
		 .when()
		 .get(Endpoint.SINGLE_VIDEOGAME);
		
	VideoGame videoGame=response.getBody().as(VideoGame.class);
	System.out.println(videoGame.toString());
	    }
	 
	 @Test
	    public void getDetailsOfOneArea() {
	        given().
	                spec(football_requestSpec).
	                queryParam("areas", 2072).
	        when().
	                get("areas/");
	    }

	    @Test
	    public void getDateFounded() {
	        given().
	                spec(football_requestSpec).
	        when().
	                get("teams/57").
	        then().
	                body("founded", equalTo(1886));
	    }

	    @Test
	    public void getFirstTeamName() {
	        given().
	                spec(football_requestSpec).
	        when().
	                get("competitions/2021/teams").
	        then().
	                body("teams.name[0]", equalTo("Arsenal FC"));
	    }

	    @Test
	    public void getAllTeamData() {
	        String responseBody = given().spec(football_requestSpec).when().get("teams/57").asString();
	        System.out.println(responseBody);
	    }

	    @Test
	    public void getAllTeamData_DoCheckFirst() {
	        Response response =
	                given().
	                        spec(football_requestSpec).
	                when().
	                        get("teams/57").
	                then().
	                        contentType(ContentType.JSON).
	                        extract().response();

	        String jsonResponseAsString = response.asString();

	    }

	    @Test
	    public void extractHeaders() {

	        Response response =
	                given().
	                        spec(football_requestSpec).
	                        when().
	                        get("teams/57").
	                        then().
	                        contentType(ContentType.JSON).
	                        extract().response();

	        Headers headers = response.getHeaders();

	        String contentType = response.getHeader("Content-Type");

	        System.out.println(contentType);
	    }


	    @Test
	    public void extractFirstTeamName() {

	        String firstTeamName = given().spec(football_requestSpec).when().
	                get("competitions/2021/teams").jsonPath().getString("teams.name[0]");

	        System.out.println(firstTeamName);
	    }

	    @Test
	    public void extractAllTeamNames() {

	        Response response = given().
	                spec(football_requestSpec).
	                when().
	                get("competitions/2021/teams").
	                then().
	                contentType(ContentType.JSON).
	                extract().response();

	        List<String> teamNames = response.path("teams.name");

	        for(String teamName: teamNames) {
	            System.out.println(teamName);
	        }
	    }
	 
	
	 
	 
	 
	   

}
