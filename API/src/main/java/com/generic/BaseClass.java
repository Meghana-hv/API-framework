package com.generic;

import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseClass {
	WebDriver driver;
	DataBaseUtility dLib=new DataBaseUtility();
	
	@BeforeSuite
	public void connectDB() throws SQLException {
		dLib.connectToDataBase();
		
		baseURI=IConstants.baseUri;
		port=IConstants.port;
	}
	
	
	@AfterSuite
	public void closeDB() throws SQLException {
		dLib.closeDB();
	}

}
