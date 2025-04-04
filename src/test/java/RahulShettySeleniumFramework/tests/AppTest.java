package RahulShettySeleniumFramework.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class AppTest {
	
	ExtentReports extent;
	
	@BeforeTest()
	public void abc()
	{
	// ExtentSparkReporter, ExtentReports
	
	   String path =  System.getProperty("user.dir")+"\\reports\\index.html";
	   ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	   reporter.config().setReportName("Web Automation Result");
	   reporter.config().setDocumentTitle("Test Results");
	   
	   extent = new ExtentReports();
	   extent.attachReporter(reporter);
	   extent.setSystemInfo("Tester", "Ashish Pawar");
	   
	
	}
	

   // @Test
    public void shouldAnswerWithTrue() {
    	
    	ExtentTest test = extent.createTest("First Test");
    	WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client/");
        System.out.println("ashishpawar1@gmail.lcl / @Shishpawar1");
        extent.flush();
    }
}
