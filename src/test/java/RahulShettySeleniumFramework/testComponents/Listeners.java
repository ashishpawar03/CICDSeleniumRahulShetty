package RahulShettySeleniumFramework.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import RahulShettySeleniumFramework.resources.ExtentReporterNG;

public class Listeners extends TestReusable implements ITestListener{

	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test; // It gives test entry
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	// If we run tests paralally(using thredcount ='x') then we face issue.
	// The failed TC screenshot is attached to any TC.
	// To avoid this we are making all test are Thread safe and save each TC thread.
	
			@Override
			public void onTestStart(ITestResult result) {
				
				test =extent.createTest(result.getMethod().getMethodName());
				extentTest.set(test);// setting test thread into extentTest
			}
		
			@Override
			public void onTestSuccess(ITestResult result) {
				
				extentTest.get().log(Status.PASS, "Test is Pass");// getting test thread from extentTest
			}
		
			@Override
			public void onTestFailure(ITestResult result) {
				extentTest.get().fail(result.getThrowable());
				String filePath = null;
				
				Object testClass = result.getInstance();
		        WebDriver driver = ((TestReusable) testClass).driver;
		        // From @BeforeTest driver goes to @Test and from there 
		        // it reflects in ITestResult result and from ITestResult result
		        // we get driver and pass it to getScreenshot() method
				
				try {
					filePath = getScreenshot(result.getMethod().getMethodName(),driver);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
			}
		
			@Override
			public void onTestSkipped(ITestResult result) {
				// TODO Auto-generated method stub
				ITestListener.super.onTestSkipped(result);
			}
		
			@Override
			public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
				// TODO Auto-generated method stub
				ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
			}
		
			@Override
			public void onTestFailedWithTimeout(ITestResult result) {
				// TODO Auto-generated method stub
				ITestListener.super.onTestFailedWithTimeout(result);
			}
		
			@Override
			public void onStart(ITestContext context) {
				// TODO Auto-generated method stub
				ITestListener.super.onStart(context);
			}
		
			@Override
			public void onFinish(ITestContext context) {
				extent.flush();
			}

}
