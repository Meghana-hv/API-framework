package questions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.navigate().refresh();
//		driver.switchTo().frame(0);
//		driver.findElement(By.xpath("//button[contains(text(), 'No thanks')]")).click();
//		driver.switchTo().defaultContent();
		
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement web = driver.findElement(By.xpath("//div[@class='RNNXgb']/descendant::div[@class='a4bIc']"));
		
		Actions a= new Actions(driver);
		a.moveToElement(web).click().sendKeys("Meghana").perform();
		
		 List<WebElement> ele = driver.findElements(By.xpath("//ul[@class='G43f7e']/li/div/descendant::div[@role='option']/div[1]/span"));
		 
		for(WebElement s: ele) {
			System.out.println(s.getText());
		}
	}

}
