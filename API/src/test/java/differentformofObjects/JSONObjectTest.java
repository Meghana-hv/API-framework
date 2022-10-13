package differentformofObjects;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class JSONObjectTest {
	@Test
	public void jsonObject() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Meghana");
		jobj.put("projectName", "Tyss");
		jobj.put("status", "created By");
		jobj.put("teamSize", 5);
		
		System.out.println(jobj);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201);
		
		
		
	}

}
