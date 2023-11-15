package day5;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {
	
	//@Test
	void singleFileUpload()
	{
		//Upload single-file
		
		File myfile=new File("file-location");
		
		given()
		   .multiPart("file",myfile)
		   .contentType("multipart/form-data")
		   
		.when()
		    .post("http://localhost/uploadfile")
		      
		 .then()
		     .statusCode(200)
		     .body("fileName",equalTo("abc"))
		     .log().all();
	}
	
	
	@Test
	void multipleFileUpload()
	{
		//Upload single-file
		
		File myfile1=new File("file-location");
		File myfile2=new File("file-location");
		
		given()
		   .multiPart("file",myfile1)
		   .multiPart("file",myfile2)
		   .contentType("multipart/form-data")
		   
		.when()
		    .post("http://localhost/uploadfile")
		      
		 .then()
		     .statusCode(200)
		     .body("[0].fileName",equalTo("abc1.text"))
		     .body("[1].fileName",equalTo("abc2.text"))
		     
		     .log().all();
	}
	
	@Test
	void fileDownload()
	{
		given()
		
		.when()
		   .get("the POST url")
		   
		   .then()
		      .statusCode(200)
		      .log().body();
	}

}
