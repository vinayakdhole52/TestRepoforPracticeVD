

package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertDemo {

	@Test
	public void TestMethod() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		SoftAssert softverify=new SoftAssert();

		driver.get("https://testautomationpractice.blogspot.com/");
         
		System.out.println("verifying title of the webpage");
		String ExpectedTitle = "Automation Testing Practice";

		//softverify.assertEquals(driver.getTitle(), ExpectedTitle);
		softverify.assertEquals(driver.getTitle(), ExpectedTitle, "Title verification failed");

		System.out.println("verify presence of wikipedia icon");
		WebElement icon = driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
		softverify.assertTrue(icon.isDisplayed());
		
		System.out.println("verify presence of wikipedia search btn");
		WebElement searchBtn = driver.findElement(By.xpath("//input[@class='wikipedia-search-button']"));
		softverify.assertTrue(searchBtn.isDisplayed());

		driver.close();
		
		//report all failure messages
		softverify.assertAll();
	}

}
