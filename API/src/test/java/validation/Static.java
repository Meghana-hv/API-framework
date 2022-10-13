package validation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.JavaUtility;
import com.pojo.AddProject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Static {
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	@Test(dataProvider = "data")
	public void staticTest(String createdBy, String projectName, String status, int teamSize) {
		
		AddProject ap= new AddProject(createdBy, projectName, status, teamSize);
		
		String exp=projectName;
		
		System.out.println(exp);
		baseURI="http://localhost";
		port=8084;
		
		boolean flag = false;
	  Response res = given()
	 .contentType(ContentType.JSON)
	 .body(ap)
	 .when()
	 .post("/addProject");
	  
	   String rs = res.jsonPath().get("projectName");
	  
	  System.out.println(rs);

	 res.then().log().all();
	 
	 if(exp.equalsIgnoreCase(rs)) {
		 flag=true;
	 }
	 
	 Assert.assertTrue(flag);	
	}
	
	
	
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException {
		Object[][] obj=new Object[1][4];
		obj[0][0]=eLib.getDataFromExcel("Sheet2", 0, 0);
		obj[0][1]=eLib.getDataFromExcel("Sheet2", 0, 1)+jLib.getRandomNum();
		obj[0][2]=eLib.getDataFromExcel("Sheet2", 0, 2);
		obj[0][3]=eLib.getIntDataFromExcel("Sheet2", 0, 3);
		return obj;
		
	}

}
