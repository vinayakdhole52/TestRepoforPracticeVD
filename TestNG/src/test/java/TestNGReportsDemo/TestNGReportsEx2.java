package TestNGReportsDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestNGReportsEx2 {

	@Test
	public void googleSearch()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Reporter.log("Chrome Browser Opened");
		driver.manage().window().maximize();
		
		driver.get("http://www.google.com");
		Reporter.log("google URL Opened");

		WebElement searchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchbox.sendKeys("India gate");
		Reporter.log("India gate keyword Entered");
		searchbox.sendKeys(Keys.ENTER);
		Reporter.log("enter key pressed");
		
		driver.close();
		Reporter.log(" Browser closed");


	}
	
}

