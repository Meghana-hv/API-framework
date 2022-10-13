package practice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.generic.DataBaseUtility;
import com.generic.EndPoints;
import com.generic.IConstants;
import com.objectRepo.HomePage;
import com.objectRepo.LoginPage;
import com.objectRepo.ProjectListPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static io.restassured.RestAssured.*;

public class AddDBDeleteApiVerifyGui extends BaseClass{
DataBaseUtility dLib=new DataBaseUtility();
	@Test
	public void addDB() throws SQLException, InterruptedException {
		String Query= "Insert into project values ('TY_PROJ_412', 'Meghana', '11-10-2022', 'abc6', 'created', '10')";		
		 dLib.executeUpdate(Query);
		 String Query1="select * from project where project_id='TY_PROJ_412';";
		ResultSet result = dLib.executeQuery(Query1);
		
		String pid="";
		if(result.next()) {
		 pid=pid+result.getString(1);
		}
		System.out.println(pid);
		
		
		given()
		.pathParam("pid", pid)
		.delete(EndPoints.deleteProjects+"{pid}")
		.then().assertThat().statusCode(204);
		
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
		
		System.out.println(proname);
		

	}
}
