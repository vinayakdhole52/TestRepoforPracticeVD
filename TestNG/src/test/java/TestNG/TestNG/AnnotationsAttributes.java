package TestNG.TestNG;
import org.testng.annotations.*;

import junit.framework.Assert;
public class AnnotationsAttributes {

//	@Test(description="this is testcase1")
//	@Test(priority=1)
//	@Test(dependsOnMethods= {"testcase2"})
	@Test(enabled=false)
	public void testcase1()
	{
		System.out.println("Mobile login TestCase");
	}
	
//	@Test(description="this is testcase2")
//	@Test(timeOut=200)
//	@Test(priority=2)
	@Test
	public void testcase2() 
	{
		System.out.println("Web login TestCase");
		//Assert.assertTrue(false);
	}
	
	//@Test(description="this is testcase3")
	@Test
	public void testcase3()
	{
		System.out.println("API login TestCase");
	}
}
