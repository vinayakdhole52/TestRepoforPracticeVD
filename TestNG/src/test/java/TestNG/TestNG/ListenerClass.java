package TestNG.TestNG;

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

public class ListenerClass implements ITestListener {

	public void onStart(ITestContext Result) {
		System.out.println("On Start Method Invoked");
	}

	public void onFinish(ITestContext Result) {
		System.out.println("On finished method Invoked");
	}

	public void onTestFailure(ITestResult Result) {

		System.out.println("name of the test method failed" + Result.getName());

	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of the skipped method " + Result.getName());

	}

	public void onTestStart(ITestResult Result) {
		System.out.println("name of the test method started" + Result.getName());

	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("name of the test method successfully executed" + Result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
