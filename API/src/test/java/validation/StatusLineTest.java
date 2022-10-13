package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StatusLineTest {

	@Test
	public void statusLine() {
		baseURI="http://localhost";
		port=8084;
		
		String statusLine="HTTP/1.1 200 ";
		boolean flag = false;
		
		Response res = when().get("/projects");
		//String list = res.jsonPath().get("projectId").toString();
		//System.out.println(list);
		
		res.then().log().all();
		
		String act = res.getStatusLine();
		if(act.equals(statusLine)) {
			flag=true;
			System.out.println("status line found");
		}
		
		Assert.assertTrue(flag);
		
	}
}
