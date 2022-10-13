package crudwithBDD;



import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class DeleteProject {
	@Test
	public void del() {
		baseURI="http://localhost";
		port=8084;
		
		Response rep = delete("/projects/TY_PROJ_003");
		
		rep.getStatusCode();
		rep.then().assertThat().log().all();
		

		
		

	}

}
