package crudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetProject {
	@Test
	public void getProject() {
		Response ra = RestAssured.get("http://localhost:8084/projects/TY_PROJ_207 & TY_PROJ_208");
		
		ValidatableResponse vr = ra.then();
		
		vr.log().all();
		vr.assertThat().statusCode(200);
		//vr.assertThat().statusLine("OK");
		vr.assertThat().contentType(ContentType.JSON);
		
		
	}

}
