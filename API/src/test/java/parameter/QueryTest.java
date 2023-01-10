package parameter;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class QueryTest {
	@Test
	public void queryParameterTest() {
		
		baseURI="https://reqres.in/";
		
		Response res = given()
		.queryParam("page", "2")
		.when()
		.get("api/users")
		.then().log().all()
		.extract().response();
		
		res.asString();
	}

}
