package testcasesBDD;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteProjectWithEndPointMismatch {

	@Test
	public void deleteMismatch() {
		baseURI="http://localhost";
		port=8084;
		Response res = delete("/addProject");
		
		res.getStatusCode();
		
		res.then().log().all();
	}

}
