package testcasesBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DeleteProjectWithoutEndPoint {
	
	@Test
	public void deleteWithoutEndPoint() {
		baseURI="http://localhost";
		port=8084;
		
		Response rep = delete(" ");
		
		rep.getStatusCode();
		rep.then().assertThat().log().all();
		
		
		
		

	

	}


}
