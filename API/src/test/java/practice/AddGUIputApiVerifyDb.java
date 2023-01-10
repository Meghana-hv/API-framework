package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.DataBaseUtility;
import com.generic.EndPoints;
import com.generic.IConstants;
import com.objectRepo.CreateProjectPage;
import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;
import com.objectRepo.ProjectListPage;
import com.pojo.AddProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddGUIputApiVerifyDb extends BaseClass {
	DataBaseUtility dLib=new DataBaseUtility();
	
	@Test
	public void addProjectGUI() throws EncryptedDocumentException, IOException, InterruptedException, SQLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(IConstants.baseUri+":"+IConstants.port);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp();
		Thread.sleep(3000);
		HomePage hp= new HomePage(driver);
		hp.getProjectLink().click();
		
		ProjectListPage pp=new ProjectListPage(driver);
		pp.getCreateprojectbtn().click();
		
		CreateProjectPage cp=new CreateProjectPage(driver);
		String pname=cp.createProject();
		Thread.sleep(5000);
		String pid=  driver.findElement(By.xpath("//td[text()='"+pname+"']/preceding-sibling::td")).getText();
		Thread.sleep(3000);
		driver.close();
		
		System.out.println(pid);
		
		baseURI=IConstants.baseUri;
		port=IConstants.port;
		
		AddProject ap=new AddProject("Pr", "xyz", "created", 11);
		Response res = given()
		.pathParam("pid", pid)
		.body(ap)
		.contentType(ContentType.JSON)
		.when()
		.put(EndPoints.updateProject+"{pid}");
		res.prettyPrint();
		
		String proname=res.jsonPath().get("projectName");
		
		String Query="select * from project where project_name="+"'"+proname+"'";
		System.out.println(Query);
		dLib.readDataFromDBandValidate(proname, Query, 4);
		
		
		
	}

}
