package crudwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddProject {
	
	@Test
	public void addProject() {
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "abc4");
		jobj.put("status", "Created By");
		jobj.put("teamSize", 9);
		baseURI="https://localhost";
		port=8084;
		
	    Response response = given().body(jobj).contentType(ContentType.JSON).post("/addProject");
	
		response.getContentType();
		response.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
		
		
		
		
		
		
		
		
		
	}

}
