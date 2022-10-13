package parameter;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Path {
@Test
public void pathParameterTest() {
	String proId="TY_PROJ_1002";
	
	baseURI="http://localhost";
	port=8084;
	
	Response res = given()
	.pathParam("projectID", proId)
	.when()
	.get("/projects/{projectID}");
	
	res.getStatusCode();
	
	res.then().assertThat().log().all();

}
}
