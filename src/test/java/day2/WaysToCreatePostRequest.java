package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class WaysToCreatePostRequest {
	
	//Approach 1-using HashMap
	
	//@Test(priority=1)
	void testPostUsingHashMap()
	{
		HashMap data=new HashMap();
		
		data.put("firstName", "Joe");
	    data.put("lastName","Jackson");
	    data.put("gender","male");
	    data.put("age", 28);
	   
		
		
		
		given()
		   .contentType("application/json")
		   .body(data.toString())
		
		.when()
		   .post("http://localhost:3000/people")
		
		.then()
		    .statusCode(500)
		    .body("firstName",equalTo("Joe"))
		    .body("lastName",equalTo("Jackson"))
		    .body("gender",equalTo("male"))
		    .body("age",equalTo(28))
		    
		    .header("Content-Type","application/json, Charset=utf-8")
		    .log().all();
	}
	
	
	//Approach 2-using org.json library
	
	//@Test(priority=1)
	void testPostUsingJsonlibrary()
	{
		JSONObject data=new JSONObject();
		
		data.put("firstName", "Joe");
	    data.put("lastName","Jackson");
	    data.put("gender","male");
	    data.put("age", 28);
	   
		
		
		given()
		   .contentType("application/json")
		   .body(data.toString())
		
		.when()
		   .post("http://localhost:3000/people")
		
		.then()
		    .statusCode(500)
		    .body("firstName",equalTo("Joe"))
		    .body("lastName",equalTo("Jackson"))
		    .body("gender",equalTo("male"))
		    .body("age",equalTo(28))
		    
		    .header("Content-Type","application/json, Charset=utf-8")
		    .log().all();
	}
	
	
	//Approach 3-using POJO class
	
		//@Test(priority=1)
		void testPostUsingPOJO()
		{
			POJO_POSTRequest data=new POJO_POSTRequest();
			data.setFirstName("Joe");
			data.setLastName("Jackson");
			data.setGender("female");
			data.setAge("28");
			
			
			given()
			   .contentType("application/json")
			   .body(data.toString())
			
			.when()
			   .post("http://localhost:3000/people")
			
			.then()
			    .statusCode(500)
			    .body("firstName",equalTo("Joe"))
			    .body("lastName",equalTo("Jackson"))
			    .body("gender",equalTo("male"))
			    .body("age",equalTo(28))
			    
			    .header("Content-Type","application/json, Charset=utf-8")
			    .log().all();
		}
		
		
		//Approach 4-using external json file
		
		@Test(priority=1)
		void testPostUsingExternalJson() throws FileNotFoundException
		{
			File f=new File(".\\body.json"); // '.' represents current project location ,, 'f' represents the file
			
			FileReader fr=new FileReader(f);
			
			JSONTokener j=new JSONTokener(fr);
			
			JSONObject data=new JSONObject(j);
			
			
			given()
			   .contentType("application/json")
			   .body(data.toString())
			
			.when()
			   .post("http://localhost:3000/people")
			
			.then()
			    .statusCode(500)
			    .body("firstName",equalTo("Joe"))
			    .body("lastName",equalTo("Jackson"))
			    .body("gender",equalTo("male"))
			    .body("age",equalTo(28))
			    
			    .header("Content-Type","application/json, Charset=utf-8")
			    .log().all();
		}
		
	
		
	
	//delete sample
	
	@Test(priority=2)
	void testDelete()
	{
		given()
		
		.when()
		   .delete("http://localhost:3000/people/")
		
		.then()
		   .statusCode(200);
		
	}
}


