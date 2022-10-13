package testcasesBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostWithoutBaseURI {
	
	@Test
	public void withoutBaseURI() {

	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Megha");
	jobj.put("projectName", "abc6");
	jobj.put("status", "Created By");
	jobj.put("teamSize", 9);
	baseURI="http://localhost";
	port=8084;
	
    Response response = given().body(jobj).contentType(ContentType.JSON).post("/addProject");

    
    response.getStatusCode();
    
    response.then().assertThat().log().all();
    
	}

}
