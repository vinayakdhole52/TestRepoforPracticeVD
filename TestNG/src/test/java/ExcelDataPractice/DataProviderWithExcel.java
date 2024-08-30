package ExcelDataPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderWithExcel {

	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}
	
	@Test(dataProvider = "SearchDataProvider")
	public void searchkeyword(String keyword)
	{
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchbox.sendKeys(keyword);
		searchbox.sendKeys(Keys.ENTER);
	}
	
	@DataProvider(name="SearchDataProvider")
	public Object[][] SearchDataProviderMethod() throws IOException
	{
		String filename="C:\\Users\\vinay\\Desktop\\SearchData.xlsx";
		Object[][] data=GetExcelData(filename, "sheet1");
		return data;
	}
	
	public Object [][] GetExcelData(String filename, String sheetname) throws IOException 
	{
		Object[][] data=null;
		FileInputStream file = new FileInputStream(filename);
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheet(sheetname);
		
		int RowSize = sh.getLastRowNum()+1;
		int ColSize=sh.getRow(0).getLastCellNum();
		data=new String [RowSize-1][ColSize];
		
		for(int i=1; i<RowSize; i++)
		{
			for(int j=0; j<ColSize; j++)
			{
				data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		wb.close();
		return data;
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
