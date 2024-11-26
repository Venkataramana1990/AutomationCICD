package Steaphenrahul.TestComponents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Steaphenrahul.resources.ExtentReportsNG;

public class Listeners extends baseTest implements ITestListener {
	
	ExtentReports extent = ExtentReportsNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// Thread safe - if tests are run in parallel and series
	
	

	public void OnTestStart(ITestResult result) {
	
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); //Stores sets in the test - Unique ID
	}
	
	public void OnTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	
	public void OnTestFailure(ITestResult result) throws IOException {
		//extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		String filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	
	public void OnFinish(ITestContext context) {
		extent.flush();
	}
	
}
