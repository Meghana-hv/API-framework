package crudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetAllProjects {
	
	@Test
	public void getAllProjects() {
		
		RequestSpecification ra = RestAssured.given();
		
		Response va = ra.get("http://localhost:8084/projects");
		
		System.out.println(va.getContentType());
		System.out.println(va.getStatusCode());
	    System.out.println(va.getTime());
		System.out.println(va.getBody());
		
		ValidatableResponse vr = va.then();
		
		vr.log().all();
		
		
		
		
		
		
	}

}
