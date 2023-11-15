package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;


public class HeadersDemo {
	
	//@Test(priority=1)
	void testHeaders()
	{
		
		given()
		
		
		.when()
		   .get("https://google.com/")
		
		
		.then()
		   .header("Content-Type","text/html; charset=ISO-8859-1")
		   .and()
		   .header("Content-Encoding","gzip")
		   .and()
		   .header("Server","gws");
	}
	
	
	@Test(priority=2)
	void getHeaders()
	{
		
		Response res=given()
		
		
		.when()
		   .get("https://google.com/");
		
		//get single header value
		//String header_value=res.getHeader("Content-Type");
		//System.out.println("the value od Content-type is=>"+header_value);
		
		
		//get all header values
		Headers myheaders = res.getHeaders();
		
		for(Header hd:myheaders)
		{
			System.out.println(hd.getName()+"   "+hd.getValue());
			
		}
		
		
		
	}
	

}
