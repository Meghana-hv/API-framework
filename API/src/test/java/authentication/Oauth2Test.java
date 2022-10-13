package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Test {

	@Test
	public void oauth() {
		
		Response res = given()
		.formParam("client_id","hi")
		.formParam("client_secret", "f4b3b12b61e8e645ee9fb496b73afffa")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		.formParam("code", "3935")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		res.then().log().all();
		String token=res.jsonPath().get("access_token");
		
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", 3935)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log().all();
				
				
	}
}
