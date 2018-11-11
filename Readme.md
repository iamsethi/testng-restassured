http://jsonviewer.stack.hu/
https://any-api.com/
https://reqres.in/

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

############################OAUTH2######################################
GET access_token-
https://api.sandbox.paypal.com/v1/oauth2/token
params - grant_type:client_credentials
USE Access Token in below POST request
https://api.sandbox.paypal.com/v1/payments/payment
body - ""		
############################PATH######################################		
http://api.walmartlabs.com/v1/search?query=ipod&apiKey=s7wv3tu7h8snrjz5de29uq8v&format=json
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
		
############################ GET RESPONSE TIME ######################################
http://localhost:8085/student/list
long respTime = .get("/list")
					.timeIn(TimeUnit.MILLISECONDS);	
############################VERIFY RESONSE TIME ######################################
http://localhost:8085/student/list
static ResponseSpecBuilder responsebuilder;
static ResponseSpecification responseSpec;

responsebuilder= new ResponseSpecBuilder();
responsebuilder.expectResponseTime(lessThan(5L),TimeUnit.SECONDS);		
responseSpec= responsebuilder.build();

.get("/list")
	.then()
	.spec(responseSpec);	


