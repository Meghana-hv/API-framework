package differentformofObjects;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class JSONFileTest {
	
	@Test
	public void jsonFile() {
		File file=new File(".\\src\\test\\resources\\JSONFile.json");
		
		System.out.println(file);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201);
	}

}
