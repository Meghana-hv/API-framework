package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddTest {
	
	static Connection con;
	static Driver dbdriver;
	
	String pnamefromapi;
	String pnamefromGUI;
	
	WebDriverUtility wLib=new WebDriverUtility();
	@Test(priority = -1)
	public void addTest() throws SQLException {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Meghana");
		jobj.put("projectName", "Ty");
		jobj.put("status", "created By");
		jobj.put("teamSize", 5);		
		//System.out.println(jobj);
		
		//System.out.println("ty"+wLib.randomNum());
		baseURI="http://localhost";
		port=8084;
		
		Response res = given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject");
	
		String s = res.getBody().asPrettyString();
		String[] s1=s.split(",");
		String requiredProject="";
		
		for(int i=0;i<s1.length;i++) {
			if(s1[i].contains("TY")) {
			requiredProject=requiredProject+s1[i];
			//System.out.println(s1[i]);
		}
		}
		
		String[] project = requiredProject.split(":");
		String prfromapi="";
		
		for(int i=0;i<project.length;i++) {
			if(project[i].contains("TY")) {
				prfromapi=prfromapi+project[i];
				//System.out.println(project[i]);
			}
		}
		pnamefromapi=prfromapi;
		//System.out.println(prfromapi);
		System.out.println(pnamefromapi+" created through rest");
	}
	@Test(enabled = true, priority = 0)
	public void gui() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8084/");
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(5000);
		WebElement web = driver.findElement(By.xpath("//li[2]/a[text()='Projects']"));
		Actions a=new Actions(driver);
		a.moveToElement(web).click().perform();
		//wait.until(ExpectedConditions.elementToBeClickable()));
		//driver.findElement().click();	
		List<WebElement> proj = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[*]/td[1]"));
		//Thread.sleep(5000);
		
		//driver.close();
             String ele="";
		for(WebElement we:proj) {	
			ele=ele+we.getText()+" ";
		}
		//System.out.println(ele);
		String[] na = ele.split(" ");
		String pname="";
		for(int i=0;i<na.length;i++) {
			if(pnamefromapi.contains(na[i])) {
				pname=pname+na[i];
				System.out.println(pname+" is present in GUI ");
			}
		}
		pnamefromGUI=pname;
		//System.out.println(pnamefromGUI);
	}

	@BeforeTest
	public  Connection connectDB() throws SQLException {
		 dbdriver=new Driver();
		DriverManager.registerDriver(dbdriver);
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Projects", "root", "root");	
		return con;
	}
		
		@Test(priority=1)
		public void dataBaseTest() throws SQLException {
			
			//System.out.println(pnamefromapi);
			//System.out.println(pnamefromGUI);
			Statement st = con.createStatement();
		String Query="Select * from project where project_id="+"'"+pnamefromGUI+"'";
		//System.out.println(Query);
		ResultSet set = st.executeQuery(Query);
		if(set.next()) {
		String pnamefromdb = set.getString(1);
		System.out.println(pnamefromdb+" is present in db");
		}
		else {
			System.out.println("empty set");
		}	
	}

}
