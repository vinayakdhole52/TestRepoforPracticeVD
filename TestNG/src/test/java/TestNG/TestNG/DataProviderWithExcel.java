package TestNG.TestNG;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
	
	@AfterMethod
	public void teardown()
	{
	    driver.quit();
	}
	
	@Test(dataProvider = "searchDataProvider")
	public void searchKeyword(String keyword)
	{
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchbox.sendKeys(keyword);
		searchbox.sendKeys(Keys.ENTER);
	}
	
	@DataProvider(name="searchDataProvider")
	public Object[][] searchDataProviderMethod() throws IOException
	{
		String filename="C:\\Users\\vinay\\Desktop\\SearchData.xlsx";
		Object[][] searchdata=getExcelData(filename, "sheet1");
//		Object[][] searchdata=new Object[2][1];
//		searchdata[0][0]="Taj Mahal";
//		searchdata[1][0]="India Gate";
		return searchdata;
	}
	
	
	public String[][] getExcelData(String filename, String sheetname) throws IOException
	{
		//declare array
		String[][]  data=null;
		
		//open file in read open
		FileInputStream inputstream=new FileInputStream(filename);
		
		//create XSSFWorkbook class object for excel file
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sh = wb.getSheet("sheet1");
		
		//get total no. of rows
		int ttlRows = sh.getLastRowNum()+1;
		
		//get total no. of cols
		int ttlcell = sh.getRow(0).getLastCellNum();
		
		//initialize array
		data=new String[ttlRows-1][ttlcell];
		
		for(int currentRow=1; currentRow<ttlRows; currentRow++)
		{
			for(int currentCell=0; currentCell<ttlcell; currentCell++ )
			{
				data[currentRow-1][currentCell] = sh.getRow(currentRow).getCell(currentCell).getStringCellValue();
			}
		}
		
		wb.close();
		return data;
	}
}
