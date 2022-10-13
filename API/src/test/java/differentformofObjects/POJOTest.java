package differentformofObjects;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import com.pojo.AddProject;

import io.restassured.http.ContentType;

public class POJOTest {
	@Test
	public void pojo() {
		AddProject ap=new AddProject("Megha", "tyss4", "on going", 5);
		
		System.out.println(ap);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(ap)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201);
		
	}
	

}
