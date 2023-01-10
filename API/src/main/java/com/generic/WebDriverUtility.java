package com.generic;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	
	
	
	public void getDropDown(WebDriver driver,WebElement ele, String value) {
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	

}
