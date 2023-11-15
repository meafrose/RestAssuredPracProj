package day3;

import org.testng.annotations.Test;

//import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;



public class PathAndQueryParameters {
	
	//http://reqres.in/api/users?page=2&id=5
	
	@Test
	void testQueryAndPathParameters()
	{
		given()
		   .pathParam("mypath", "user") // path parameters
		   .queryParam("page", 2) // query parameters
		   .queryParam("id", 5) // query parameters
		
		
		.when()
		   .get("http://reqres.in/api/{mypath}")
		
		
		.then()
		   .statusCode(200)
		   .log().all();
	}

}
