http://jsonviewer.stack.hu/
https://any-api.com/
https://reqres.in/

200 - SC_OK
302 code means successful redirection

############################JAVADOC#######################################

http://www.javadoc.io/doc/io.rest-assured/rest-assured/3.0.0
https://developer.paypal.com/developer/applications/create
https://apps.twitter.com/

###################################################################
LETSKODEIT - 

java -jar rest.jar --server.port=8085
jsoupExampleSpringSecurity.war credentials are : user and user

###################################################################
LAPTOP - 

docker run -d -p 8888:8080 cloudesire/tomcat:8-jre8


Mange->Service->Apache Tomcat->start

localhost:8888 -> Go to Manage App ->

############################ GET http://localhost:8085/student ######################################
Response response=  .when()
						.get("/list");
							
System.out.println(response.body().prettyPrint());
System.out.println(response.body().prettyPeek());	
############################ PUT http://localhost:8085/student  ######################################	
Using Postman GET http://localhost:8085/student/50 
Copy the response
Go to http://jsonviewer.stack.hu/
Remove white spaces like this
{"firstName":"Mark","lastName":"Taylor","email":"xyzqw@gmail.com","programme":"Computer Science","courses":["Java","C++","C#"]}

 given()
 .contentType(ContentType.JSON)
 .when()
		.body(myBody)
		.put("/50")
############################ POST http://localhost:8085/student ######################################
String body = "{\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"unique@gmail.com\",\"programme\":\"Computer Science\",\"courses\":[\"Java\",\"C++\"]}";
	
 given()
 .contentType(ContentType.JSON)
 .when()
		.body(myBody)
		.post()		
############################ DELETE http://localhost:8085/student ######################################	
given()
		.when()
		.delete("/101")
############################ PATCH http://localhost:8085/student/50 ######################################
given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.patch("/50")

########BASIC AUTH POST - https://api.sandbox.paypal.com/v1/oauth2/token ######################################
BODY -  grant_type:client_credentials [check radio button x-www-form-urlencoded]

clientId="AVOTONjTN6MpB3La6q1Kp_Csuwbn5xJA3QVDSJTO0-U8mF5mOaZ2uSyY7hs5mkB-wjz-8eQ3wU9iRx_7";
clientSecret="EBDZTgp9LD7Te3wz3ysl1PD8HPBjVFkCl9XupTDpDZful06rotwc_EcqKbyDH971QoH_r__8eUMtoMHs";

 accessToken=		given()
					.params("grant_type","client_credentials")
					.auth()
					.preemptive()
					.basic(clientId, clientSecret)			//IMP
					.when()
					.post("/oauth2/token")
					.then()
					.extract()
					.path("access_token");
					
System.out.println(accessToken);
################## OAUTH2 https://api.sandbox.paypal.com/v1/payments/payment ######################################
USE Access Token obtained from BASIC AUTH in below POST request
		given()
		.contentType(ContentType.JSON)
		.auth()
		.oauth2(accessToken)								// IMP
		.when()
		.body(body)													
		.post("/payments/payment")
		.then()
		.statusCode(HttpStatus.SC_CREATED);	
			
###### Assertions http://api.walmartlabs.com/v1/search?query=ipod&apiKey=s7wv3tu7h8snrjz5de29uq8v&format=json ######	

.then()
        .body("numItems", equalTo(10));
        .body("query", equalToIgnoringCase("IPOD"));
		.body("items.name",hasItems("Apple iPod touch 128GB"));
		.body("items.name",hasItem("Apple iPod touch 128GB"));
		.body("items[0].imageEntities[0]", hasKey("entityType"));
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GB")));
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GB")))
		.body("items.name",hasItem("Apple iPod touch 128GB"))
		.body("items.size()",equalTo(10))
		
############################ GET RESPONSE TIME http://localhost:8085/student/list ######################################

long respTime = .get("/list")
					.timeIn(TimeUnit.MILLISECONDS);	
############################VERIFY RESONSE TIME http://localhost:8085/student/list######################################
static ResponseSpecBuilder responsebuilder;
static ResponseSpecification responseSpec;

responsebuilder= new ResponseSpecBuilder();
responsebuilder.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);		
responseSpec= responsebuilder.build();

.get("/list")
	.then()
	.spec(responseSpec);
	
############################Difference Between PUT and PATCH Requests ######################################	
Suppose we have a resource that holds the first name and last name of a person.
If we want to change the first name then we send a put request for Update
{ "first": "Michael", "last": "Angelo" }
Here, although we are only changing the first name, with PUT request we have to send both parameters first and last.
In other words, it is mandatory to send all values again, the full payload.
When we send a PATCH request, however, we only send the data which we want to update. In other words, 
we only send the first name to update, no need to send the last name.
For this reason, PATCH request requires less bandwidth.


#####File Download  https://github.com/mozilla/geckodriver/releases/download/v0.11.1/geckodriver-v0.11.1-arm7hf.tar.gz ###########

byte[] actualValue=given()
		.when()
		.get(endpoint)
		 .then()
		 .extract()
		 .asByteArray();

####################### File Upload/Conversion https://sandbox.zamzar.com/v1/jobs####################################
String apiKey="5eaa67710bfd39000409ebf618b0a7d949867b62";
given()
		.auth()
		.basic(apiKey,"")
		.multiPart("source_file",new File(System.getProperty("user.dir")+File.separator+"dancing_banana.gif"))
		.multiPart("target_format","png")
		.when()
		.post(endpoint)
		
##############RLF RC WOS PS #Filters http://localhost:8085/student ##################################

public static StringWriter requestWriter;
public static PrintStream requestCapture;

requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);

given()
	.filter(new RequestLoggingFilter(requestCapture))  //RLF RC new PS WOS PS
	.when()
	.get("/list");
	
System.err.println(requestWriter.toString());

###############JSONAssert  http://localhost:8085/student  ##org.skyscreamer.jsonassert.JSONAssert;###
String expectedValue = new String(
				Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "file.txt")));
String actualValue = given()
						.when()
						.get("/list").asString();

JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.STRICT);  //  "file.txt"	
JSONAssert.assertEquals(expectedValue, actualValue, JSONCompareMode.LENIENT); //  "difforder.txt"

#########JSONPath http://api.walmartlabs.com/v1/search?query=ipod&apiKey=s7wv3tu7h8snrjz5de29uq8v&format=json #########

given()
												.queryParam("query","ipod")
												.queryParam("apiKey",APIKEY)
												.queryParam("format","json")
												.when()
												.get("/search")
int numItems=									.then().extract().path("numItems");
String queryValue=								.then().extract().path("query");
String productName=								.then().extract().path("items[0].name");
HashMap<String,String> giftOptions=				.then().extract().path("items[0].giftOptions");  
int size=										.then().extract().path("items.size()");
List<String> names=								.then().extract().path("items.name");
List<HashMap<String,Object>> x=					.then().extract().path("items.findAll{it.name=='Apple 													iPod touch 32GB'}");
												.then().extract().path("items.findAll{it.name=='Apple 													iPod touch 32GB'}.salePrice");
		


