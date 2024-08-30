package TestNG.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SoftwareClass {

	@Parameters("SoftwareCompanyName")
	@Test
	public void testCase1(String name )
	{
		System.out.println(name);
	}
}
