package ExtentReportsDemo;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class BasicExtentReportClass {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add Environment details
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("User", "Vinayak");
		reports.setSystemInfo("Browser", "chrome");

		// configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMMM, dd, yyyy, hh:mm a '('zzz')'");
	}

	@Test
	public void LaunchBrowserAndOpenURL() {
		// create test
		test = reports.createTest("Launch Browser and open url");
		Assert.assertTrue(true);
	}

	@Test
	public void VerifyTitle() {
		// create test
		test = reports.createTest("Verify Title");
		Assert.assertTrue(false);
	}

	@Test
	public void VerifyLogo() {
		// create test
		test = reports.createTest("Verify Logo");
		Assert.assertTrue(true);
	}

	@Test
	public void VerifyEmail() {
		// create test
		test = reports.createTest("Verify Email");
		throw new SkipException("Skipping this test case with exception...");
	}

	@Test
	public void VerifyUsername() {
		// create test
		test = reports.createTest("Verify Username");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void getTestResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAIL", ExtentColor.RED));
		    test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASS", ExtentColor.GREEN));

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIP", ExtentColor.YELLOW));

		}
	}
	
	@AfterTest
	public void tearDown()
	{
		reports.flush();
	}

}
