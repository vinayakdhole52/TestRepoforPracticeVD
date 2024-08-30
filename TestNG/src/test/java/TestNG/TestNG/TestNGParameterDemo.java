package TestNG.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterDemo {

	@Test
	@Parameters({"i", "j"})
	public void add(int a, int b)
	{
		System.out.println(a+b);
	}
	
	@Test
	@Parameters({"i", "j"})
	public void substract(int a, int b)
	{
		System.out.println(a-b);
	}
	
	@Test
	@Parameters({"i", "j"})
	public void multiply(int a, int b)
	{
		System.out.println(a*b);
	}
	
	

}
