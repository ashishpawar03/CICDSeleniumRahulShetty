package RahulShettySeleniumFramework.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import RahulShettySeleniumFramework.pageobjects.LandingPage;

public class TestReusable {
	
	   public WebDriver driver;
	   public LandingPage landingPage;
	
	   public WebDriver initializeDriver() throws IOException
	   {
		   
		   Properties prop = new Properties();
		   FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\RahulShettySeleniumFramework\\resources\\GlobalData.properties");
		   prop.load(fis);
		   
		   String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		   // We have used java ternary operators above
		   // It first checks if any browser name comes from mvn command.
		   // If yes then execute this -> ? System.getProperty("browser") // browser name from cmd prompt mvn command
		   // If no then execute this -> : prop.getProperty("browser");  // browser name from property file
		  
		   
		   // prop.getProperty("browser");
		   
		   if(browserName.equals("chrome"))
		   {
			   driver = new ChromeDriver();
			   
		   }
			   else if(browserName.equals("firefox"))
			   {
				   driver = new FirefoxDriver();
				   
			   }
				   else if(browserName.equals("edge"))
				   {
					   driver = new EdgeDriver();
					   
				   }
		   
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
	   }
	   
	   
	   
	   public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	   {
		 String jsonContent =  FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		 
		 ObjectMapper mapper = new ObjectMapper();
		 
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
		 return data;
	   }
	   
	   
	   public String getScreenshot(String testcasename, WebDriver driver) throws IOException
	   {
	   // Take screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save screenshot to desired location
        // This need "commons-io" dependency
        FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"//Screenshots//"+testcasename+".png"));
        return System.getProperty("user.dir")+"//Screenshots//"+testcasename+".png";
      
	   }
	   
	   
	   
	   @BeforeMethod(alwaysRun=true) // We driver from "initializeDriver()" method and then This driver is passed to TestCase
	   public LandingPage launchApplication() throws IOException
	   {
		    driver = initializeDriver();
		    landingPage = new LandingPage(driver);
			landingPage.goTo();
			
			return landingPage;
	   }

	   @AfterMethod(alwaysRun=true)
	   public void tearDown()
	   {
		   driver.close();
	   }
}
