package testcasesBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.post;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PostWithoutBody {
	
	@Test
	public void withoutBody() {
	
		baseURI="http://localhost";
		port=8084;
		
	    Response response = post("/addProject");
	    
	    response.getStatusCode();
	    
	    response.then().log().all();
	    
	 
	
	}

}
