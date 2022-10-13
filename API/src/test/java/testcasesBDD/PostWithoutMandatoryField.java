package testcasesBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PostWithoutMandatoryField {
	
	@Test
	public void withoutMandatoryField() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Megha");
		jobj.put("status", "On going");
		jobj.put("teamSize", 11);
		
		baseURI="http://localhost";
		port=8084;
		
		Response res = given().
		body(jobj).contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		System.out.println(res.getBody());
		System.out.println(res.getContentType());
		res.then()
		.log().all();
		
		
	}

}
