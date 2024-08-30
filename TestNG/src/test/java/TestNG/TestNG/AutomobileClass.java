package TestNG.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomobileClass {

	@Test
	@Parameters({"AutomobileName"})
	public void testCase1(String name)
	{
		System.out.println(name);
	}
	
	
}
