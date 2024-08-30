package PropertiesFileDemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseExample {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		ReadConfigFile configfile=new ReadConfigFile();
		//driver.get("https://www.saucedemo.com/");
		driver.get(configfile.getURL());
		
		//driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(configfile.getusername());

		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(configfile.getpassword());

		driver.findElement(By.xpath("//input[@id='login-button']")).click();

	}

}
