package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.IConstants;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="usernmae")
	private WebElement usernametb;
	
	@FindBy(id="inputPassword")
	private WebElement passwordtb;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signin;

	public WebElement getUsernametb() {
		return usernametb;
	}

	public WebElement getPasswordtb() {
		return passwordtb;
	}

	public WebElement getSignin() {
		return signin;
	}
	
	public void loginToApp() {
		usernametb.sendKeys(IConstants.username);
		passwordtb.sendKeys(IConstants.password);
		signin.click();
	}
	

}
