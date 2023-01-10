package questions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utube {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("singara siriye");
		driver.findElement(By.id("search-icon-legacy")).click();
		
		driver.findElement(By.xpath("//div[@id='contents']/ytd-video-renderer/div/*[2]/*/div/*/a")).click();
		
		
	}	
	

}
