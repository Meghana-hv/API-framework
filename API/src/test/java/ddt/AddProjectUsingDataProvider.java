package ddt;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.JavaUtility;
import com.pojo.AddProject;

import io.restassured.http.ContentType;

public class AddProjectUsingDataProvider {
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib= new JavaUtility();
	
	@Test(dataProvider = "getData")
	public void addProject(String createdBy, String projectName, String status, int teamSize) {
		AddProject ap= new AddProject(createdBy, projectName, status, teamSize);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.contentType(ContentType.JSON).body(ap)
		.when()
		.post("/addProject")
		.then()
		.statusCode(201);
		
	}
	
	@DataProvider
	public  Object[][] getData() throws EncryptedDocumentException, IOException {
		Object[][] obj=new Object [2][4];
		obj[0][0]=eLib.getDataFromExcel("Sheet2", 0, 0);
		obj[0][1]=eLib.getDataFromExcel("Sheet2", 0, 1)+jLib.getRandomNum();
		obj[0][2]=eLib.getDataFromExcel("Sheet2", 0, 2);
		obj[0][3]=eLib.getIntDataFromExcel("Sheet2", 0, 3);
		obj[1][0]=eLib.getDataFromExcel("Sheet2", 1, 0);
		obj[1][1]=eLib.getDataFromExcel("Sheet2", 1, 1)+jLib.getRandomNum();
		obj[1][2]=eLib.getDataFromExcel("Sheet2", 1, 2);
		obj[1][3]=eLib.getIntDataFromExcel("Sheet2", 1, 3);
		return obj;
	}

}

