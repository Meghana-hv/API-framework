package crudwithBDD;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetProject {
@Test
public void getProject() {
	baseURI="http://localhost";
	port=8084;
	
	Response rep = get("/projects/TY_PROJ_003");
	System.out.println(rep.getStatusCode());
	

}
}
