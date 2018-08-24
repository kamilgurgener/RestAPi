package RestAPI;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.*;

import org.hamcrest.Matcher;

import org.testng.annotations.Test;

public class RestTest {
	
	@Test
	public void firstTest() {
		
		when().get("http://73.166.37.2:1000/ords/hr/employees/")
		.then().statusCode(200);
	}
	@Test
	public void secondTest() {
		
		when().get("http://73.166.37.2:1000/ords/hr/job_history/")
		.then().statusCode(200);
	}
	@Test
	public void thirdTest() {
		
		given().relaxedHTTPSValidation()
		.when().get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/")
		
		.then().statusCode(200);
	}
	@Test
	public void idTest() {
		
		given().relaxedHTTPSValidation()
		.when().get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/10")
		.then().statusCode(200)
		.log().all()
		.and().body("id", equalTo(10))
		.assertThat()
							.body("status",  equalTo("publish"));
	}
	@Test
	public void logTest() {
		
		given().relaxedHTTPSValidation()
		.when().get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/{id}", 10)
		.then().statusCode(200)
		.and().body("id", equalTo(10));
		
	}
	
	@Test
	public void baseURITest()  {
		
		given().relaxedHTTPSValidation()
		.when().get("https://www.batch8-api-site.dev.cc/wp-json/wp/v2/posts/10")
		.then().statusCode(400);
	}
	

	
		
	
	
	
	}
	
	
	
	
	

