package requestchaining;

import org.testng.annotations.Test;

import com.pojo.AddProject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostDelete {
	@Test
	public void postDelete() {
		
		AddProject ap=new AddProject("me", "yt3", "created By", 7);
		baseURI="http://localhost";
		port=8084;
		
		Object pid = given()
		.contentType(ContentType.JSON)
		.body(ap)
		.post("addProject")
		.jsonPath().get("projectId");
		
		given()
		.pathParam("Id", pid)
		.delete("projects/{Id}")
		.then().assertThat().statusCode(204);
				
	}

}
