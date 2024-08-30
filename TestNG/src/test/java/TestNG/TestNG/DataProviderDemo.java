package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {

	@Test(dataProvider = "searchDataSet", dataProviderClass = DataProviderMethod.class)
	public void googleSearch(String country, String monument ) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchbox.sendKeys(country + " " + monument);
		
		driver.findElement(By.xpath("//div[@class='lJ9FBc']//center//input[@value='Google Search' and @role='button']")).click();
	
}
}