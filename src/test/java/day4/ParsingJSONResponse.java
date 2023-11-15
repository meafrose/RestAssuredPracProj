package day4;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;

//import org.hamcrest.Matcher;


public class ParsingJSONResponse {   //by using "JSONObject" class
	
	//@Test(priority=1)
	void testJSONResponse()
	{
		//Approach1
		
		/*given()
		   .contentType("ContentType.JSON")
		
		
		.when()
		    .get("http://localhost:3000/people")
		
		
		.then()
		    .statusCode(200)
		    .header("Content-Type", "application/json; charset=utf-8")
		    .body("[2].gender",equalTo("female"));*/
		
		
		//Approach2***
		Response res=given()
		   .contentType(ContentType.JSON)
		
		
		.when()
		    .get("http://localhost:3000/people");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-type"),"application/json; charset=utf-8");
		
		String s=res.jsonPath().get("[2].gender").toString();
		Assert.assertEquals(s,"female");
	}
	
	
	
	@Test(priority=2)
	void testJSONResponseBodyData()
	{
		
		Response res=given()
		   .contentType(ContentType.JSON)
		
		
		    .get("http://localhost:3000/people");
		
		/*Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-type"),"application/json; charset=utf-8");
		
		String s=res.jsonPath().get("[2].gender").toString();
		Assert.assertEquals(s,"female");*/
		
		
		//STEP_1:Read all the 'number' from each object from 'sample4.json' || using "JSONObject class" *******
		JSONObject jo=new JSONObject(res.toString()); //converting 'Response' to json object type
		boolean status=false;
		for(int i=0; i<jo.getJSONArray("people").length(); i++)
		{
			String num=jo.getJSONArray("people").getJSONObject(i).get("number").toString();
			if(num.equals("456754675"));
			{
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
		{
			
		}
}
}
		
		
	

