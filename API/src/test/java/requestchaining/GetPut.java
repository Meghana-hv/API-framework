package requestchaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import com.pojo.AddProject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetPut {
	@Test
	public void getPut() {
		
		baseURI="http://localhost";
		port=8084;
		
				  Response res = when()
				   .get("projects");
				   
				   ArrayList jsonData= res.jsonPath().get("projectId");
					String pId="";
					Iterator it=jsonData.iterator();
					while(it.hasNext()) {	
						String pname=it.next().toString();
					   if(pname.contains("1005")) {
			         	pId=pId+pname;
			       	break;
					 }
				   }
				  		
			   AddProject ap=new AddProject("me", "me", "created by", 11);	
			   
			   given()
			   .body(ap)
			   .pathParam("Id", pId)
			   .contentType(ContentType.JSON)
			   .when()
			   .put("projects/{Id}")
			   .then()
			   .log().all();
			  	 	
	}
}
