package EncodingDemo;

import org.apache.hc.client5.http.utils.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EncodePaswordExample {

	public static void main(String[] args) throws InterruptedException {
		
		//Encode password
//		String password="secret_sauce";
//		byte[] encodedpassword=Base64.encodeBase64(password.getBytes());
//		System.out.println(new String(encodedpassword));
				
		//launch browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		//open url
		driver.get("https://www.saucedemo.com/");
		
		//enter username
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		
		//decode password
		byte[] decodedpassword=Base64.decodeBase64("c2VjcmV0X3NhdWNl");
		//enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(new String(decodedpassword));
		
		//click login btn
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Thread.sleep(2000);
		
		//close broswer
		driver.close();
		

	}

}
