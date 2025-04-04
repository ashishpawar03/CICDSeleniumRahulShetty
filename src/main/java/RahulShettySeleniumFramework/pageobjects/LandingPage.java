package RahulShettySeleniumFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettySeleniumFramework.reusables.PageObjectReusable;

public class LandingPage extends PageObjectReusable {

	WebDriver driver;
	
		public LandingPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
	
	   
		@FindBy(css="#userEmail")
		WebElement userEmail; // It contains driver.findElement / driver.findElements
		
		@FindBy(css="#userPassword")
		WebElement userPassword;
		
		@FindBy(css="#login")
		WebElement submitButton;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		public ProductCatalogue loginAppication(String username, String userpass)
		{
			userEmail.sendKeys(username);
			userPassword.sendKeys(userpass);
			submitButton.click();
			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			return productCatalogue;
		}
		
		public String getErrorMessage()
		{
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText(); 
			 
		}
		
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client/"); 
		}

}
