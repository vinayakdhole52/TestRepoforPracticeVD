package ExtentReportsDemo;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TestCaseExample {

	@Test
	public void TestMehtod1() {
		System.out.println("This is test method 1");
		Assert.assertTrue(true);
	}

	@Test
	public void TestMehtod2() {
		System.out.println("This is test method 2");
		Assert.assertTrue(false);
	}

	@Test
	public void TestMehtod3() {
		System.out.println("This is test method 3");
		Assert.assertTrue(false);
	}

	@Test
	public void TestMehtod4() {
		System.out.println("This is test method 4");
		Assert.assertTrue(true);
	}

	@Test
	public void TestMehtod5() {
		System.out.println("This is test method 5");
		throw new SkipException("This test method is Skipped ");
	}

}
