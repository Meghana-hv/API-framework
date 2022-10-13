package parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryTest {
	@Test
	public void queryParameterTest() {
		
		baseURI="https://reqres.in/";
		
		given()
		.queryParam("page", "2")
		.when()
		.get("api/users")
		.then().log().all();
	}

}
