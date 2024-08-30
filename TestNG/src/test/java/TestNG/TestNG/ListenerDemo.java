package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

//@Listeners(TestNG.TestNG.ListenerClass.class)
public class ListenerDemo {

	@Test
	public void login() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	@Test
	public void testfail()
	{
		System.out.println("Failed test case");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testSkipped()
	{
		System.out.println("Skipped test case");
		throw new SkipException("skip exception thrown");
	}
	
	
	
}
