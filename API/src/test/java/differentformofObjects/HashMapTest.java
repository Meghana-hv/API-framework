package differentformofObjects;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class HashMapTest {
	@Test
	public void hashMap() {
		HashMap hp=new HashMap();
		hp.put("createdBy", "Meghana");
		hp.put("projectName", "Tyss1");
		hp.put("status", "going");
		hp.put("teamSize", 5);
		
		System.out.println(hp);
		

		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(hp)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201);
		
		
		
	}

}
