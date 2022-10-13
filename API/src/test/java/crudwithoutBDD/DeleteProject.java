package crudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProject {
@Test
public void deleteProject() {
	Response re = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_001");
	
	ValidatableResponse va = re.then();
	
	va.assertThat().statusCode(204);
	
	
}
}
