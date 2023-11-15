package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo {
	
	@Test(priority=1)
	void testCookies()
	{
		
		given()
		
		
		.when()
		   .get("https://google.com/")
		
		
		.then()
		   .cookie("AEC","Ackid1QsAn43asTbteMLGTQ-oi6j9k2ZLesITeB6HMCf1FHm9WymtnTPYfI")
		   .log().all();
	}



@Test(priority=2)
void getCookiesInfo()
{
	
	Response res=given()
	
	
	.when()
	   .get("https://google.com/");
	
	//get single info
	//String cookie_value = res.getCookie("AEC"); // this will give you the value of this 'SINGLE' cookie
	//System.out.println("value of cookie--->"+cookie_value);
	
	
	//get all cookie if
	Map<String, String> cookies_values = res.getCookies();  // this will give you the value of this 'MULTIPLE' cookie
	
	//System.out.println(cookies_values.keySet()); //this will give you 'only keys' NOT Values
	
	for(String k:cookies_values.keySet()) //from the 'ketSet' we are extracting the first key
	{
		String cookie_value = res.getCookie(k); // and we are passing the key(k)and getting the value of it
		
		System.out.println(k+"===>"+cookie_value);
		
	}
}
}
	

