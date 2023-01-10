package questions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TutorialNinja {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/");
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("your store")) {
			System.out.println("title verified");
		}
		else {
			System.out.println("title not verified");
		}
		WebElement ele = driver.findElement(By.xpath("//a[text()='Components']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.xpath("//li[@class='dropdown']/descendant::li/a[contains(text(),'Monitors')]")).click();
		 String price = driver.findElement(By.xpath("//div[@class='product-thumb']/descendant::div[@class='caption']/p[@class='price']/span[@class='price-new']")).getText();
		 driver.findElement(By.xpath("//img[@title='Apple Cinema 30\"']")).click();
		String actprice = driver.findElement(By.xpath("//div[@class='col-sm-4']/ul[@class='list-unstyled'][2]/li[2]/h2")).getText();
		if(actprice.equals(price)) {
			System.out.println("price verified");
		}
		else {
			System.out.println("price not verified");
		}
		WebElement btn = driver.findElement(By.xpath("//div[@class='form-group required ']/descendant::div[@class='radio']/label/input"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Point loc = btn.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
		btn.click();
		driver.findElement(By.xpath("//div[@id='input-option223']/div[@class='checkbox']/label[contains(.,'Checkbox 3')]/input")).click();
		driver.findElement(By.xpath("//input[@id='input-option208']")).sendKeys("Selenium 4");
		WebElement dd = driver.findElement(By.xpath("//select[@id='input-option217']"));
		Select s=new Select(dd);
		s.selectByIndex(3);
		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		String msg = driver.findElement(By.xpath("//div[@class='form-group required has-error']/div[text()='File required!']")).getText();
		//System.out.println(msg);
		if(msg.contains("File required!")) {
			System.out.println("file required msg verified");
		}
		else {
			System.out.println("file required msg not verified");
		}
		driver.close();
	}
	
	
	
	

}
