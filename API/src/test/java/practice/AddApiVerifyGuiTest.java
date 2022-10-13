package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.DataBaseUtility;
import com.generic.EndPoints;
import com.generic.ExcelUtility;
import com.generic.IConstants;
import com.generic.JavaUtility;
import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;
import com.objectRepo.ProjectListPage;
import com.pojo.AddProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddApiVerifyGuiTest extends BaseClass{
	
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	DataBaseUtility dLib=new DataBaseUtility();
	
	@Test(dataProvider = "addData")
	public void addApi(String createdBy, String projectName, String status, int teamSize) throws SQLException, InterruptedException {
		AddProject ap=new AddProject(createdBy, projectName, status, teamSize);
		
		baseURI=IConstants.baseUri;
		port=IConstants.port;
		Response res = given()
		.body(ap)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPoints.createProject);
		String pid=res.jsonPath().get("projectId");
		
		res.then().assertThat().statusCode(201);
		
		String Query= "select * from project where project_id="+"'"+pid+"'";
		dLib.readDataFromDBandValidate(pid, Query, 1);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(IConstants.baseUri+":"+IConstants.port);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp();
		Thread.sleep(3000);
		HomePage hp= new HomePage(driver);
		hp.getProjectLink().click();
		
		ProjectListPage pp=new ProjectListPage(driver);
		String proname=pp.getProjectName(driver,pid);
		Thread.sleep(3000);
		
		driver.close();
		
		if(proname.equalsIgnoreCase(projectName)) {
			System.out.println("project present in GUI, verified");
		}
		else {
			System.out.println("project not present in GUI");
		}

		
		
	}
	
	@DataProvider
	public Object[][] addData() throws EncryptedDocumentException, IOException {
		Object[][] obj=new Object[1][4];
		obj[0][0]=eLib.getDataFromExcel("api", 0, 0);
		obj[0][1]=eLib.getDataFromExcel("api", 0, 1)+jLib.getRandomNum();
		obj[0][2]=eLib.getDataFromExcel("api", 0, 2);
		obj[0][3]=eLib.getIntDataFromExcel("api", 0, 3);
		
		return obj;
	}

}
