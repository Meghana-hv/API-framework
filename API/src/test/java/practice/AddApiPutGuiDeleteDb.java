package practice;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.DataBaseUtility;
import com.generic.EndPoints;
import com.generic.ExcelUtility;
import com.generic.IConstants;
import com.generic.JavaUtility;
import com.objectRepo.CreateProjectPage;
import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;
import com.objectRepo.ProjectListPage;
import com.pojo.AddProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddApiPutGuiDeleteDb extends BaseClass {
	ExcelUtility eLib= new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	DataBaseUtility dLib= new DataBaseUtility();
	@Test
	public void add() throws EncryptedDocumentException, IOException, InterruptedException, SQLException {
		String createdBy=eLib.getDataFromExcel("api", 0, 0);
		String projectName=eLib.getDataFromExcel("api", 0, 1)+jLib.getRandomNum();
		String status=eLib.getDataFromExcel("api", 0, 2);
		int teamSize=eLib.getIntDataFromExcel("api", 0, 3);
		AddProject ap= new AddProject(createdBy, projectName, status, teamSize);
		
		Response res = given()
		.body(ap)
		.contentType(ContentType.JSON)
		.when()
		.post(EndPoints.createProject);
		
		String pid=res.jsonPath().get("projectId");
		
		res.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.assertThat()
		.statusCode(201);
		
		System.out.println("project created");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(IConstants.baseUri+":"+IConstants.port);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp();
		Thread.sleep(3000);
		HomePage hp= new HomePage(driver);
		hp.getProjectLink().click();
		
		ProjectListPage pp=new ProjectListPage(driver);
		pp.editProjectIcon(driver, pid);
		Thread.sleep(3000);
		
		CreateProjectPage cp=new CreateProjectPage(driver);
		cp.editProject();
		Thread.sleep(3000);
		
		driver.close();
		
		System.out.println("Project edited successfully");
		
		String Query="delete from project where project_id='"+pid+"'";
		int row=dLib.executeUpdate(Query);
		
		if(row==1) {
			System.out.println("project deleted successfully");
		}
		
		
		

		
		
	}

}
