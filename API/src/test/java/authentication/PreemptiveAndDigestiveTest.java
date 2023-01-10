package authentication;

import org.testng.annotations.Test;

import com.generic.IConstants;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PreemptiveAndDigestiveTest {
	
	@Test
	public void preemptiveTest() {
	
		baseURI= IConstants.baseUri;
		port=IConstants.port;
		
		given()
		.auth().preemptive().basic(IConstants.username, IConstants.password)
		.when()
		.get("/login")
		.then()
		.contentType(ContentType.JSON)
		.log().all();
	}
		
	@Test
	public void digestiveTest() {
	
		baseURI= IConstants.baseUri;
		port=IConstants.port;
		
		given()
		.auth().digest(IConstants.username, IConstants.password)
		.when()
		.get("/login")
		.then()
		.contentType(ContentType.JSON)
		.log().all();
	}


}
