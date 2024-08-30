package TestNG.TestNG;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TestNGParameterGoogleSearch {

	@Parameters({"keyword"})
	@Test
	public void googleSearch(String searchdata) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchbox.sendKeys(searchdata);
		
		Assert.assertEquals(searchdata, searchbox.getAttribute("value"));
		
		driver.quit();
	}
	
	
}
