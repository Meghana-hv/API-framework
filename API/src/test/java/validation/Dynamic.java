package validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Dynamic {

	@Test
	public void dynamicTest() {
		baseURI="http://localhost";
		port=8084;
		
		String epname="TY_PROJ_006";
		boolean flag = false;
		
		Response res = when().get("/projects");
		res.then().log().all();
	
		String list = res.jsonPath().get("projectId").toString();
		//System.out.println(list);
		
		if(list.contains(epname)) {
			flag=true;
			System.out.println("project found");
		}
		
		Assert.assertTrue(flag);
		
		
	}
}
