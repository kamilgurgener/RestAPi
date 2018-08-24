package RestAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class RestApiTesting {
	
	@BeforeClass
	public void setUp() {
		
		RestAssured.baseURI = "https://www.batch8-api-site.dev.cc/wp-json/wp/v2";
		RestAssured.basePath= "";
		
	}
	
	@Test
	public void simpleGetRequest() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.get("/post")
		.then()
		.log().ifValidationFails()
		.statusCode(200)
		.body("id", equalTo(8))
		.and().body("title.rendered", is("Shodil"));
		
		
	}
	
	@Test
	public void simplePOst() {
		
		given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("admin", "Melek32.32")
		.contentType(ContentType.JSON)
		.when()
		.body("{\n" + 
				"	\"title\" : \"My first Day at Work\",\n" + 
				"	\"content\" : \"super content\",\n" + 
				"	\"status\" : \"publish\"\n" + 
				"	\n" + 
				"}")
		.log().all()
		.post("/posts")
		.then().statusCode(201);
		
	}
	
	@Test
	public void simplePut() {
		
		given()
		.relaxedHTTPSValidation()
		.auth().preemptive().basic("admin", "Melek32.32")
		.contentType(ContentType.JSON)
		.when()
		.body("{\n" + 
				"	\"title\" : \"My first Automated Updated Day at Work\",\n" + 
				"}")
		.log().all()
		.pathParam("newID", 13)
		.put("/posts/{newID}")
		.then().statusCode(200)
		.body("title.raw", is("My first Automated Updated Day at Work"));

	}





















}
