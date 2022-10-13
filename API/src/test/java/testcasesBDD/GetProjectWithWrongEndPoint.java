package testcasesBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetProjectWithWrongEndPoint {
	@Test
	public void withWrongEndPoint() {
		baseURI="http://localhost";
		port=8084;
		
		 Response rep = get("/project");
		rep.getStatusCode();
		
		rep.then()
		.log().all();
		
	}


}
