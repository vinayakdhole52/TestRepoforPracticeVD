package TestNG.TestNG;
import org.testng.annotations.*;
public class TestCase1 {

	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite...");
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("After Suite...");
	}
	
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before test...");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After test...");
	}
	
	@BeforeClass
	public void BeforeClass()
	{
		System.out.println("Before class...");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before method...");
	}
	
	@Test
	public void test1()
	{
		System.out.println("This is test1...");
	}

	@Test
	public void test2()
	{
		System.out.println("This is test2...");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After method...\n");
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After Class...");
	}





}
