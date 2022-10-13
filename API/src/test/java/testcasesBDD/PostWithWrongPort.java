package testcasesBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostWithWrongPort {
	
	@Test
	public void withWrongPort() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("projectName", "abc7");
		jobj.put("status", "Created By");
		jobj.put("teamSize", "11");
		baseURI="http://localhost";
		port=8084;
		
	    given()
	    .body(jobj)
	    .contentType(ContentType.JSON)
	    .when()
	    .post("/addProject")
	    .then().log().all();
	}

}
