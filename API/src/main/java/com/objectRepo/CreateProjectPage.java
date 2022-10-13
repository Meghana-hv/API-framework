package com.objectRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.ExcelUtility;
import com.generic.JavaUtility;
import com.generic.WebDriverUtility;

public class CreateProjectPage {
	
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	WebDriver driver;
	
	public CreateProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="projectName")
	private WebElement projectnametb;
	
	@FindBy(name="teamSize")
	private WebElement teamsizehiddentb;
	
	@FindBy(name="createdBy")
	private WebElement projectmanagertb;
	
	@FindBy(xpath="//label[text()='Project Status ']/../select[@name='status']")
	private WebElement statusdd;
	
	@FindBy(xpath="//input[@value='Add Project']")
	private WebElement addprojectbtn;

	@FindBy(xpath="//input[@value='Save']")
	private WebElement savebtn;
	
	@FindBy(xpath="//select[@name='status']")
	private WebElement editstatusdd;
	
	public WebElement getProjectnametb() {
		return projectnametb;
	}

	public WebElement getTeamsizehiddentb() {
		return teamsizehiddentb;
	}

	public WebElement getProjectmanagertb() {
		return projectmanagertb;
	}

	public WebElement getStatusdd() {
		return statusdd;
	}
	
	public WebElement getAddprojectbtn() {
		return addprojectbtn;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	

	public WebElement getEditstatusdd() {
		return editstatusdd;
	}

	public String createProject() throws EncryptedDocumentException, IOException {
		String pname= eLib.getDataFromExcel("Sheet2", 0, 0)+jLib.getRandomNum();
		//int team= eLib.getIntDataFromExcel("Sheet2", 0, 1);
		String man= eLib.getDataFromExcel("Sheet2", 0, 2);
		
		projectnametb.sendKeys(pname);
		//RemoteWebDriver js=(RemoteWebDriver) driver;
		//js.executeScript("document.getElementsByClassName('form-control __web-inspector-hide-shortcut__').teamSize.setAttribute('value','10')");
		projectmanagertb.sendKeys(man);
		wLib.getDropDown(driver,statusdd, "Created");	
		addprojectbtn.click();
		return pname;
		
	}
	
	public void editProject() {
		wLib.getDropDown(driver, editstatusdd, "Completed");
		savebtn.click();
	}
	
	

}
