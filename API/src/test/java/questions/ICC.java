package questions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/");
		
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'ICC RANKINGS')]"));
		Actions a=new Actions(driver);
		
		a.moveToElement(ele).perform();
		
	
		
		


	}

}
