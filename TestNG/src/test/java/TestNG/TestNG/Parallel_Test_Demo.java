package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parallel_Test_Demo {

	WebDriver driver;
	
	@Test
	public void verifyTitle()
	{
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

	
	@Test
	public void verifyLogo()
	{
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		 WebElement logo = driver.findElement(By.xpath("//div[@class='login_logo']"));
		
		 logo.isDisplayed();
		 
		 Assert.assertTrue(logo.isDisplayed());
		 
		driver.quit();
	}
	
}
