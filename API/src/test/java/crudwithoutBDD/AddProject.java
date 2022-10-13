package crudwithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProject {
@Test
public void createProjectTest() {
	//create json body
	
	Random ran=new Random();
	int random=ran.nextInt(100);
	
	JSONObject jobj=new JSONObject();
	
	jobj.put("createdBy", "Meghana");
	jobj.put("projectName", "VTi"+random);
	jobj.put("status","created");
	jobj.put("teamSize", 5);
	
	//precondition (body and content type)
	
	RequestSpecification ra = RestAssured.given();
	ra.body(jobj);
	ra.contentType(ContentType.JSON);
	
	Response resp = ra.post("http://localhost:8084/addProject");
	
	ValidatableResponse val = resp.then();
	val.log().all();
	val.assertThat().statusCode(201);
	val.assertThat().contentType(ContentType.JSON);

	resp.then().contentType(ContentType.JSON);
	resp.then().statusCode(201);
		
}
}
