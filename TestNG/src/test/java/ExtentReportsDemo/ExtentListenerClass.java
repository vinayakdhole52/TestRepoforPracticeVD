
package ExtentReportsDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add Environment Info to reports
		reports.setSystemInfo("Machine", "TestPC1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("username", "Vinayak");

		// configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	public void onStart(ITestContext Result) {
		System.out.println("On Start Method Invoked");
		configureReport();

	}

	public void onFinish(ITestContext Result) {
		System.out.println("On finished method Invoked");
		reports.flush();

	}

	public void onTestFailure(ITestResult Result) {

		System.out.println("name of the test method failed" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of the skipped method " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is: " + Result.getName(), ExtentColor.YELLOW));
	}

	public void onTestStart(ITestResult Result) {
		System.out.println("name of the test method started" + Result.getName());

	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("name of the test method successfully executed" + Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
