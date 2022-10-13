package crudwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	
	@Test
	public void getAllProjects() {
	
		baseURI="http://localhost";
		port=8084;
		
		 Response rep = get("/projects");
		rep.getStatusCode();
		
		rep.then()
		.log().all();
		
	}

}
