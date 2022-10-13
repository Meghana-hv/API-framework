package com.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.WebDriverUtility;

public class ProjectListPage {
	
	WebDriver driver;
	WebDriverUtility wLib=new WebDriverUtility();
	
	public ProjectListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement createprojectbtn;

	public WebElement getCreateprojectbtn() {
		return createprojectbtn;
	}
	
	public String getProjectName(WebDriver driver, String projectid) {
		try {
		String pname=driver.findElement(By.xpath("//tbody/tr/td[text()='"+projectid+"']/following-sibling::td[1]")).getText();
		return pname;
		}
		catch(Exception e) {
			
			return "project is deleted sucessfully through business layer";
		}
	}
	
	public void editProjectIcon(WebDriver driver, String projectid) {
		
		driver.findElement(By.xpath("//tbody/tr/td[text()='"+projectid+"']/following-sibling::td[6]/a/i[@title='Edit']")).click();
		
	}
	
	
	
	

}
