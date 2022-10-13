package crudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProject() {
		//"createdBy": "string",
//		  "projectName": "string",
//		  "status": "string",
//		  "teamSize": 0
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "Me");
		obj.put("projectName", "abc");
		obj.put("status", "On going");
		obj.put("teamSize", 10);
		
		RequestSpecification rs = RestAssured.given();
		Response re = rs.put("http://localhost:8084/projects/TY_PROJ_001");
		
		re.prettyPeek();
		re.prettyPrint();
		
	}

}
