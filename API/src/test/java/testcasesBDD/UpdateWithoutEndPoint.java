package testcasesBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateWithoutEndPoint {
	@Test
	public void updateWithoutEndPoint() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Megha");
	jobj.put("projectName", "mno");
	jobj.put("status", "Created By");
	jobj.put("teamSize", 8);
	baseURI="http://localhost";
	port=8084;
	
    Response response = given().body(jobj).contentType(ContentType.JSON).put(" ");
	response.getContentType();
	response.then().assertThat().contentType(ContentType.JSON).statusCode(201).log().all();
	
	}
	

}
