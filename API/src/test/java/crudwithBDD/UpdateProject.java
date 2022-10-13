package crudwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UpdateProject {

	@Test
	public void update() {
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "mno");
		jobj.put("status", "Created By");
		jobj.put("teamSize", 8);
		baseURI="http://localhost";
		port=8084;
		
	    Response response = given().body(jobj).contentType(ContentType.JSON).put("projects/TY_PROJ_003");
	    
	  
	
		response.getContentType();
		response.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
		
		
		
	 
}

}
